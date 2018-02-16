<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>admin-首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
    <link rel="stylesheet" href="${ctxStatic }/iframe/layui/css/layui.css" />
</head>
<body>
<div class="wrapper">
    <%@include file="/include/sidebar.jsp" %>
    <div class="main-panel">
        <%@include file="/include/sidebarHead.jsp" %>
        <div class="content">
            <!-- body -->
            <div class="layui-body my-body">
                <div class="layui-tab layui-tab-card my-tab" lay-filter="card" lay-allowClose="true">
                    <ul class="layui-tab-title">
                        <li class="layui-this" lay-id="0" style="margin-left: -42px;"><span>首页</span></li>
                    </ul>
                    <div class="layui-tab-content">
                        <div class="layui-tab-item layui-show">
                            <iframe id="iframe" src="${ctx}/index" frameborder="0"></iframe>
                        </div>
                    </div>
                </div>
            </div>
            <!-- body end  -->
        </div>
        <%@include file="/include/footer.jsp" %>
    </div>
</div>
<%@include file="/include/sidebarRight.jsp" %>
</body>
<%@include file="/include/scriptLib.jsp" %>
<script src="${ctxStatic }/iframe/layui/layui.js"></script>
<script src="${ctxStatic }/iframe/frame.js"></script>
<link rel="stylesheet" href="${ctxStatic }/iframe/frame.css" />

<script type="text/javascript">
    $(document).ready(function() {
//        dialogTip( '进入框架页面');
    });
</script>

</html>