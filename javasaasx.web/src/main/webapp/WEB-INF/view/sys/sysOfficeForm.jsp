<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统机构[编辑]</title>
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
                        <form:form id="inputForm" cssClass="form-horizontal" modelAttribute="sysOfficeBo" action="" method="POST">
                            <form:hidden path="id"/>
                            <div class="card-content">
                                <div class="form-group label-floating">
                                    <form:input type="text" path="name" class="form-control" required="true" placeholder=" 名称*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="pid" class="form-control" required="true" placeholder=" 上级id*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="ppath" class="form-control" required="true" placeholder=" 父路径*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="depth" class="form-control" required="true" placeholder=" 层级深度*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="sort" class="form-control" required="true" placeholder=" 排序*"/>
                                </div>
                                <div class="form-group label-floating">
                                </div>
                                <div class="form-group label-floating">
                                    <div class="col-sm-12">
                                        <div class="radio checkbox-inline"><span>机构类型：</span></div>
                                        <div class="radio checkbox-inline">
                                            <label><input type="radio" name="type" required="true" value="company"/>公司</label>
                                        </div>
                                        <div class="radio checkbox-inline">
                                            <label><input type="radio" name="type" required="true" value="dept"/>部门</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="address" class="form-control" required="true" placeholder=" 联系地址*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="master" class="form-control" required="true" placeholder=" 负责人*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="tel" class="form-control" required="true" placeholder=" 电话*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="remarks" class="form-control" required="true" placeholder=" 备注信息*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <div class="togglebutton">
                                        <span>状态:</span>
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
            HttpUtil.ajaxAsyncJsonPost("/sys/sysOffice/save", paramArr, function(message){
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