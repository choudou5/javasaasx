var logging_url = ctx + '/log/logAdmin/ajaxPrintLog';
var cookie_logging_timezone = 'logging_timezone';
var frame_element = $( '#frame' );


bindEvent();



function load_logging_viewer() {
    var table = $( 'table', frame_element );
    var state = $( '#state', frame_element );
    var since = table.data( 'latest' ) || 0;
    var sticky_mode = null;

    $.ajax({
        url : logging_url + '?wt=json&since=' + since,
        dataType : 'json',
        beforeSend : function( xhr, settings )
        {
            // initial request
            if( 0 === since ){
                sticky_mode = true;
            }
            // state element is in viewport
            else if( state.position().top <= $( window ).scrollTop() + $( window ).height() - ( $( 'body' ).height() - state.position().top ) ) {
                sticky_mode = true;
            }
            else{
                sticky_mode = false;
            }
        },
        success : function( response, text_status, xhr )
        {
            var docs = response.history;
            var docs_count = docs.length;
            var table = $( 'table', frame_element );
            $( 'h2 span', frame_element ).text( response.watcher.esc() );
            state.html( 'Last Check: ' + format_time() );
            setTimeout(
                load_logging_viewer,
                10000
            );

            if( 0 === docs_count ){
                table.trigger( 'update' );
                return false;
            }

            var content = '<tbody>';
            for( var i = 0; i < docs_count; i++ )
            {
                var doc = docs[i];
                if( 1 === doc.time.length ){
                    for( var key in doc ){
                        doc[key] = doc[key][0];
                    }
                }

                if( !doc.trace ){
                    var lines = doc.message.split( "\n" );
                    if( 1 < lines.length ){
                        doc.trace = doc.message;
                        doc.message = lines[0];
                        delete lines;
                    }
                }

                var has_trace = 'undefined' !== typeof( doc.trace );
                doc.logger = '<abbr title="' + doc.logger.esc() + '">' + doc.logger.split( '.' ).pop().esc() + '</abbr>';
                var classes = [ 'level-' + doc.level.toLowerCase().esc() ];
                if( has_trace ){
                    classes.push( 'has-trace' );
                }

                content += '<tr class="' + classes.join( ' ' ) + '" '+(has_trace?"onclick=\"toggleErrorTip(event)\"":"")+' >' + "\n";
                content += '<td class="span"><a><span>' + format_time( doc.time ) + '</span></a></td>' + "\n";
                content += '<td class="level span"><a><span>' + doc.level.esc() + '</span></span></a></td>' + "\n";
                content += '<td class="span"><a><span>' + doc.logger + '</span></a></td>' + "\n";
                content += '<td class="message span"><a><span>' + doc.message.replace( /,/g, ',&#8203;' ).esc() + '</span></a></td>' + "\n";
                content += '</tr>' + "\n";
                if( has_trace ){
                    content += '<tr class="trace">' + "\n";
                    content += '<td colspan="4"><pre>' + doc.trace.esc() + '</pre></td>' + "\n";
                    content += '</tr>' + "\n";
                }
            }
            content += '</tbody>';
            $( 'table', frame_element ).append( content );

            table.data( 'latest', response.info.last ).removeClass( 'has-data' ).trigger( 'update' );

            if( sticky_mode ){
                $( 'body' ).animate({ scrollTop: state.position().top }, 1000);
            }
        },
        error : function( xhr, text_status, error_thrown){
        },
        complete : function( xhr, text_status ) {
        }
    });
}

function toggleErrorTip(event){
    $( event.target ).closest( 'tr' ).toggleClass( 'open' ).next().toggle();
}

function bindEvent(){
    var table = $( 'table', frame_element );

    table.off( 'update' ) .on('update', function( event ) {
            var table = $( this );
            var tbody = $( 'tbody', table );

            0 !== tbody.length
                ? table.addClass( 'has-data' )
                : table.removeClass( 'has-data' );
            return false;
        }
    );

    load_logging_viewer();

    var date_format = $( '#date-format a', frame_element );

    date_format.off( 'click' ).on('click', function( event ) {
        var self = $( this );
        if( !self.hasClass( 'on' ) ){
            self.addClass( 'on' );
            $( 'table th.time span', frame_element ).text( 'UTC' );
            format_time_options.timeZone = 'UTC';
            CacheUtil.set( cookie_logging_timezone, 'UTC' );
        }
        else{
            self.removeClass( 'on' );
            $( 'table th.time span', frame_element ).text( 'Local' );
            delete format_time_options.timeZone;
            CacheUtil.set( cookie_logging_timezone, null );
        }

        $( 'time', frame_element ).each(function( index, element ){
            var self = $( element );
            self.text( format_time_content( new Date( self.attr( 'datetime' ) ) ) );
        });
        return false;
    });

    if( 'UTC' === CacheUtil.get( cookie_logging_timezone ) ) {
        date_format.trigger( 'click' );
    }
}



var format_time_options = {};

var format_time = function( time )
{
    time = time ? new Date( time ) : new Date();
    return '<time datetime="' + time.toISOString().esc() + '">' + format_time_content( time ) + '</abbr>';
}

var format_time_content = function( time )
{
    return time.toLocaleString( undefined, format_time_options ).esc();
}

Number.prototype.esc = function()
{
    return new String( this ).esc();
}

String.prototype.esc = function()
{
    return this.replace( /</g, '&lt;').replace( />/g, '&gt;');
}
