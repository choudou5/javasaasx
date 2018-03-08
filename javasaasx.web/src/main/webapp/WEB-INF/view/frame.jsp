<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}</title>
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
                        <li class="layui-this" lay-id="0" style="margin-left: -42px;" id="home"><span>首页</span></li>
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

        <!-- 右键菜单 -->
        <div class="my-dblclick-box hide">
            <table class="layui-tab dblclick-tab">
                <tbody>
                    <tr class="card-refresh">
                        <td><i class="fa fa-refresh"></i>刷新当前标签</td>
                    </tr>
                    <tr class="card-close-other">
                        <td><i class="fa fa-close"></i>关闭其他标签</td>
                    </tr>
                    <tr class="card-close-all">
                        <td><i class="fa fa-window-close"></i>关闭所有标签</td>
                    </tr>
                    <tr class="card-open-new">
                        <td><i class="fa fa-share"> </i>新页面打开</td>
                    </tr>
                </tbody>
            </table>
        </div>

    </div>
</div>
<%@include file="/include/sidebarRight.jsp" %>
</body>
<%@include file="/include/scriptLib.jsp" %>
<script src="${ctxStatic }/iframe/crypto.js"></script>
<script src="${ctxStatic }/iframe/frame.js"></script>
<link rel="stylesheet" href="${ctxStatic }/iframe/frame.css" />

<script type="text/javascript">
    $(document).ready(function() {
//        dialogTip( '进入框架页面');
        $("#home").on("click", function(){
            dialogPopupRight(ctx+'/viewPage/common/demo', 'test');
        });
    });
</script>

</html>