var logging_change_url = ctx + '/log/sysLogAdmin/setting';

var logging_handler = function( response, text_status, xhr )
{
  var self = this;
  var loggers = response.loggers;

  var levels = '<div class="selector-holder"><div class="selector">' + "\n"
             + '<a class="trigger"><span><em>null</em></span></a>' + "\n"
             + '<ul>' + "\n";

  var len = response.levels.length;
  for(var i = 0; i < len; i++)
  {
    var level = response.levels[i].esc();
    levels += '<li><a href="#" data-level="' + level + '">' + level + '</a></li>' + "\n";
  }

  levels += '<li class="unset"><a href="#" data-level="unset">UNSET</a></li>' + "\n"
         + '</ul>' + "\n"
         + '<a class="close"><span>[x]</span></a>' + "\n"
         + '</div></div>';

  var logger_tree = function( filter )
  {
    var logger_content = '';
    var filter_regex = new RegExp('^' + filter + '\\.\\w+$');


      var len = loggers.length;
    for(var i = 0; i < len; i++)
    {
      var logger = loggers[i];
      var continue_matcher = false;

      if( !filter )
      {
    	//log(logger.name);
        continue_matcher = logger.name.indexOf('.') !== -1;
      }
      else
      {
        continue_matcher = !logger.name.match( filter_regex );
      }

      if( continue_matcher )
      {
        continue;
      }

      var logger_class = '';

      if( logger.set )
      {
        logger_class = 'set';
      }
            
      if( !logger.level )
      {
        logger_class = 'null';
      }

      var logger_name = logger.name.split('.');
      var display_name = logger_name.pop();

      var leaf_class = 'jstree-leaf';
      if( logger.level )
      {
        leaf_class += ' level-' + logger.level.esc().toLowerCase();
      }

      logger_content += '<li class="' + leaf_class + '" data-logger="' + logger.name.esc() + '">';
      logger_content += '<ins class="trigger jstree-icon">&nbsp;</ins>' + "\n";
      logger_content += '<a href="javascript:;" class="trigger '+ logger_class + '"' ;

      if( logger.level )
      {
        logger_content += 'rel="' + logger.level.esc() + '" ';
      }
            
      logger_content += 'title="' + logger.name.esc() + '">' + "\n";

      if( 0 !== logger_name.length )
      {
        logger_content += '<span class="ns">' + logger_name.join('.').esc() + '.</span>';
      }

      logger_content += '<span class="name">' + ( display_name ? display_name.esc() : '<em>empty</em>') + '</span>' + "\n";
      logger_content += '</a>';

      logger_content += levels;

      if( !!logger.name )
      {
        var child_logger_content = logger_tree( logger.name );
        if( child_logger_content )
        {
          logger_content += '<ul>';
          logger_content += child_logger_content;
          logger_content += '</ul>';
        }
      }

      logger_content += '</li>';
    }

    return logger_content;
  };

  var logger_content = '<div class="block">' + "\n"
                     + '<h2><span>' + response.watcher.esc() + '</span></h2>' + "\n"
                     + '<ul class="tree jstree">' + logger_tree( null ) + '</ul>' + "\n"
                     + '</div>';

  self.html(logger_content);


  self.off('clear').on('clear',function( event ){
      $('.open', this ).removeClass('open');
  });

  $('li:last-child', this ).addClass('jstree-last');

  $('li.jstree-leaf > a', this )
    .each
    (
      function( index, element )
      {
        element = $( element );
        var level = element.attr('rel');

        if( level )
        {
          var selector = $('.selector-holder', element.closest('li') );
          var trigger = $('a.trigger', selector );
          trigger.text( level.esc() );
          if( element.hasClass('set') ){
        	  trigger.first().addClass('set');
          }
          $('ul a[data-level="' + level + '"]', selector ).first().addClass('level');
        }
      }
    )

  $('.trigger', this ).off('click').on('click', function( event ){
        self.trigger('clear');
        $('.selector-holder', $( this ).parents('li').first() ).first().trigger('toggle');
        return false;
      }
    );

  $('.selector .close', this ).off('click').on ('click', function( event ) {
        self.trigger('clear');
        return false;
      }
    );
    
  $('.selector-holder', this ).off('toggle').on('toggle', function( event ){
        var row = $( this ).closest('li');
        $('a:first', row ).toggleClass('open');
        $('.selector-holder:first', row ).toggleClass('open');
      }
    );

  $('.selector ul a', this ).off('click').on('click', function( event ){
        var element = $(this);
        var name = element.parents('li[data-logger]').data('logger');
        var level = element.data('level')
        $.ajax({
            url : logging_change_url,
            dataType : 'json',
            data : {
              'name': name,
              'level': level
            },
            type : 'POST',
            context : self,
            beforeSend : function( xhr, settings ){
              element.addClass('loader');
            },
            success : function(){
                $(".selector-holder.open .selector a.trigger").text(level);
                $(".selector-holder.open .selector .close").trigger('click');
                dialogTip("设置成功！");
            }
          }
        );
        return false;
      }
    );

};

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
