<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统角色[编辑]</title>
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
                        <form:form id="inputForm" cssClass="form-horizontal" modelAttribute="sysRoleVo" action="" method="POST">
                            <form:hidden path="id"/>
                            <div class="card-content">
                                <div class="form-group label-floating">
                                    <form:select path="officeId" title="归属机构" class="selectpicker" data-style="btn btn-twitter" data-live-search="false">
                                        <form:option value="">归属机构</form:option>
                                    </form:select>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="groupName" class="form-control" required="true" placeholder=" 分组名*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="name" class="form-control" required="true" placeholder=" 角色名称*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <div class="row">
                                        <div class="col-sm-10">
                                            <div class="col-sm-10">
                                                <div class="radio checkbox-inline"><span>数据范围*：</span></div>
                                                <div class="radio checkbox-inline">
                                                    <label><input type="radio" name="dataScope" required="true" value="0" checked/>个人</label>
                                                </div>
                                                <div class="radio checkbox-inline">
                                                    <label><input type="radio" name="dataScope" required="true" value="1"/>本机构</label>
                                                </div>
                                                <div class="radio checkbox-inline">
                                                    <label><input type="radio" name="dataScope" required="true" value="1"/>所有</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group label-floating">
                                    <form:input type="text" path="remarks" class="form-control" required="true" placeholder=" 备注信息*"/>
                                </div>
                                <div class="form-group label-floating">
                                    <form:checkbox path="status" class="bootstrap-switch" value="1" data-on-label="有效" data-off-label="禁用" data-tip-text="状态" data-tip-position="l" />
                                </div>
                                <div class="form-group label-floating">
                                    <form:checkbox path="isSysData" class="bootstrap-switch" value="1" data-on-label="是" data-off-label="否" data-tip-text="系统数据" data-tip-position="l" />
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
            HttpUtil.ajaxAsyncJsonPost("/sys/sysRole/save", paramArr, function(message){
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