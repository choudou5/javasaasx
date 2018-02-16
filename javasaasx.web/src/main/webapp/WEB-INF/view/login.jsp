<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>admin-</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
<%@include file="/include/normalHead.jsp" %>
<div class="wrapper wrapper-full-page">
    <div class="full-page login-page" filter-color="black" data-image="${ossImg }login.jpeg">
        <!--   you can change the color of the filter page using: data-color="blue | purple | green | orange | red | rose " -->
        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 col-sm-6 col-md-offset-4 col-sm-offset-3">
                        <form id="loginForm" method="post" action="#" onsubmit="return submitFun();">
                            <div class="card card-login card-hidden">
                                <div class="card-header text-center" data-background-color="rose">
                                    <h4 class="card-title">账号登录</h4>
                                    <div class="social-line">
                                        <a href="#qq" title="QQ" class="btn btn-just-icon btn-simple">
                                            <i class="fa fa-qq"></i>
                                        </a>
                                        <a href="#weixin" title="微信" class="btn btn-just-icon btn-simple">
                                            <i class="fa fa-weixin"></i>
                                        </a>
                                        <a href="#weibo" title="微博" class="btn btn-just-icon btn-simple">
                                            <i class="fa fa-weibo"></i>
                                        </a>
                                    </div>
                                </div>
                                <p class="category text-center"></p>
                                <div class="card-content">
                                    <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">person</i>
                                            </span>
                                        <div class="form-group label-floating">
                                            <label class="control-label">手机或邮箱<star>*</star></label>
                                            <input class="form-control" name="email" type="text" email="true" required="true" value="admin@qq.com" />
                                        </div>
                                    </div>
                                    <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">lock_outline</i>
                                            </span>
                                        <div class="form-group label-floating">
                                            <label class="control-label">密码<star>*</star></label>
                                            <input class="form-control" name="password" type="password" required="true" value="adminadmin" />
                                        </div>
                                    </div>
                                </div>
                                <div class="footer text-center">
                                    <button type="submit" class="btn btn-rose btn-simple btn-wd btn-lg">立即登录</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<%@include file="/include/validScriptLib.jsp" %>
<script type="text/javascript">
    $().ready(function() {
        setFormValidation('#loginForm');
        demo.checkFullPageBackgroundImage();

        setTimeout(function() {
            // after 1000 ms we add the class animated to the login/register card
            $('.card').removeClass('card-hidden');
        }, 700);

    });

    function submitFun(){
        var form = $("#loginForm");
        if(!form. valid()){
            return false;
        }
        var paramArr = $("#loginForm").serialize()
        HttpUtil.ajaxAsyncJsonPost("/dologin.do", paramArr, function(message){
            dialogTip(message);
            setTimeout(function() {
                window.location.href = ctx+"/sys/index";
            }, 500);
        });
        return false;
    }
</script>

</html>