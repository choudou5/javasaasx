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
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">
            <div class="card">
                <div class="card-content">
                    <h4 class="card-title">更改密码</h4>
                    <form id="updatePwdValidation">
                        <div class="row">
                            <div class="form-group label-floating">
                                <label class="control-label">旧密码</label>
                                <input type="password" name="oldPwd" class="form-control" required="true">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group label-floating">
                                <label class="control-label">新密码</label>
                                <input type="password" name="password" id="newPwd" class="form-control" required="true">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group label-floating">
                                <label class="control-label">确认新密码</label>
                                <input type="password" name="passwordConfirm" class="form-control" required="true" equalTo="#newPwd">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-rose pull-right">更新</button>
                        <div class="clearfix"></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<%@include file="/include/validScriptLib.jsp" %>
<script type="text/javascript">
    $(document).ready(function() {
        setFormValidation('#updatePwdValidation');
    });
</script>
</html>