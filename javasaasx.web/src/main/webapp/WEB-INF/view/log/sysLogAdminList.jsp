<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统日志[管理]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="card">
            <div class="card-content">
                <div class="toolbar">
                    <a href="javascript:;" onclick="top.addTabToFrame('日志Console', '${ctx}/viewPage/log/sysLogAdminConsole')" class="btn btn-success btn-sm">查看Console</a>
                </div>
                <div id="content">
                    <div id="logging" class="clearfix">
                        <div id="frame"></div>
                    </div>
                </div>
            </div>
            <!-- end content-->
        </div>
        <!--  end card  -->
    </div>
</div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<link rel="stylesheet" type="text/css" href="${ctxStatic }/logging/logging.css">
<script type="text/javascript" src="${ctxStatic }/logging/logging-level.js"></script>
<script type="text/javascript">
    $(function () {
        loadData();
    });
    function loadData(){
        var content_element = $( '#content' );
        var url = ctx+"/log/sysLogAdmin/ajaxList";
        $.ajax({
            url : url,
            dataType : 'json',
            context : $( '#frame', content_element ),
            beforeSend : function( xhr, settings ){
                this.html( '<div class="loader">Loading ...</div>' );
            },
            success : logging_handler
        });
    }
</script>
</html>