<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统设置[编辑]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
<div class="wrapper">
    <div class="main-panel ${sysModel}">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card" style="margin: 10px 0;">
                        <form:form id="inputForm" cssClass="form-horizontal" modelAttribute="sysSettingVo" action="" method="POST">
                            <form:hidden path="id"/>
                            <div class="card-content">
                                <div class="form-group label-floating">
                                    <form:input type="text" path="typeCode" class="form-control" required="true" placeholder=" 类型code*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="code" class="form-control" required="true" placeholder=" code*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="name" class="form-control" required="true" placeholder=" 名称*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="value" class="form-control" required="true" placeholder=" 值*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="remark" class="form-control" required="true" placeholder=" 备注*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="ext1" class="form-control" required="true" placeholder=" 预留字段1*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="ext2" class="form-control" required="true" placeholder=" 预留字段2*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="ext3" class="form-control" required="true" placeholder=" 预留字段3*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <div class="togglebutton">
                                        <span>状态: 0=禁用，1=正常:</span>
                                        <label>
                                            <form:checkbox path="status" value="1" />
                                        </label>
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
            HttpUtil.ajaxAsyncJsonPost("/sys/sysSetting/save", paramArr, function(message){
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