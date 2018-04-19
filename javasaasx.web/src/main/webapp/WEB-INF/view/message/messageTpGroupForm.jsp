<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-第三方消息群[编辑]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
<div class="wrapper">
    <div class="main-panel">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card" style="margin: 10px 0;">
                        <form:form id="inputForm" cssClass="form-horizontal" modelAttribute="messageTpGroupBo" action="" method="POST">
                            <form:hidden path="id"/>
                            <div class="card-content">
                                <div class="form-group label-floating">
                                    <form:select path="tpType" title="第三方类型" class="selectpicker" required="true" data-style="btn btn-twitter" data-live-search="false">
                                        <form:option value="">第三方类型</form:option>
                                        <form:option value="dingtalk" selected="selected">钉钉</form:option>
                                    </form:select>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="bizType" class="form-control" required="true" placeholder=" 业务key*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="name" class="form-control" required="true" placeholder=" 群组名*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <%--<form:input type="text" path="ownerId" class="form-control input-required" required="true" placeholder=" 群主*"/>--%>
                                    <sys:choose name="ownerId" value="" labelValue="" dialogTitle="选择群主" ajaxJsonUrl="/sys/sysMenu/ajaxParentTree"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="memberIds" class="form-control "  placeholder=" 成员"/>
                                </div>
                                <div class="form-group label-floating">
                                    <div class="togglebutton">
                                        <span>状态:</span><label><form:checkbox path="status" checked="checked" value="1" /></label>
                                    </div>
                                </div>
                            </div>
                        </form:form>
                        <!-- end content-->
                    </div>
                    <!--  end card  -->
                </div>

            </div>
        </div>
    </div>
</div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<%@include file="/include/validScriptLib.jsp" %>
<script type="text/javascript">
    $(function () {
        setFormValidation('#inputForm');
    });

    function ajaxSubmitIframeForm(success){
        var form = $("#inputForm");
        if(form.valid()){
            FormUtil.tryLockSubmit();
            var paramArr = form.serializeArray();
            paramArr = FormUtil.filterNullParam(paramArr);
            HttpUtil.ajaxAsyncJsonPost("/message/messageTpGroup/save", paramArr, function(message){
                dialogTip(message);
                if(typeof success == 'function'){
                    success();
                }
            });
        }
        return false;
    }
</script>

</html>