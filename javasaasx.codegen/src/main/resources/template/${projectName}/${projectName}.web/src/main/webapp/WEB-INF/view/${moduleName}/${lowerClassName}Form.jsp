<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classVOName = classNameLower + 'Vo'>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${"$"}{siteName}-${table.remarks}[编辑]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
<div class="wrapper">
    <div class="main-panel ${"$"}{sysModel}">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card" style="margin: 10px 0;">
                        <form:form id="inputForm" cssClass="form-horizontal" modelAttribute="${classVOName}" action="" method="POST">
                            <form:hidden path="id"/>
                            <div class="card-content">
                                <#list columnStyles as column>
                                    <#if column.isInsert=="1" && !column.abstractField>
                                <div class="form-group label-floating">
                                        <#if column.showType=="input">
                                    <form:input type="text" path="${column.javaColumn}" class="form-control <#if column.notNull>input-required</#if>" <#if column.notNull>required="true"</#if> placeholder=" ${column.desc}<#if column.notNull>*</#if>"/>
                                        <#elseif column.showType=="textarea">
                                    <form:textarea path="${column.javaColumn}" class="form-control <#if column.notNull>input-required</#if>" <#if column.notNull>required="true"</#if> rows="1" placeholder=" ${column.desc}<#if column.notNull>*</#if>"/>
                                        <#elseif column.showType=="select">
                                    <form:select path="${column.javaColumn}" title="${column.desc}" class="selectpicker" <#if column.notNull>required="true"</#if> data-style="btn btn-twitter" data-live-search="false">
                                        <form:option value="">${column.desc}</form:option>
                                    </form:select>
                                        <#elseif column.showType=="checkbox" ||  column.showType=="radio">
                                    <div class="col-sm-12">
                                        <div class="${column.showType} checkbox-inline"><span>${column.desc}<#if column.notNull>*</#if>：</span></div>
                                        <div class="${column.showType} checkbox-inline">
                                            <label><input type="${column.showType}" name="${column.javaColumn}" <#if column.notNull>required="true"</#if> value="a"/>选项A</label>
                                        </div>
                                        <div class="${column.showType} checkbox-inline">
                                            <label><input type="${column.showType}" name="${column.javaColumn}" <#if column.notNull>required="true"</#if> value="b"/>选项B</label>
                                        </div>
                                    </div>
                                        <#elseif column.showType=="switch">
                                    <form:checkbox path="${column.javaColumn}" class="bootstrap-switch" value="1" data-on-label="是" data-off-label="否" data-tip-text="${column.desc}" />
                                        </#if>
                                </div>
                                    </#if>
                                </#list>
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
    ${"$"}(function () {
        setFormValidation('#inputForm');
    });

    function ajaxSubmitIframeForm(success){
        var form = ${"$"}("#inputForm");
        if(form.valid()){
            FormUtil.tryLockSubmit();
            var paramArr = form.serializeArray();
            paramArr = FormUtil.filterNullParam(paramArr);
            HttpUtil.ajaxAsyncJsonPost("/${moduleName}/${classNameLower}/save", paramArr, function(message){
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