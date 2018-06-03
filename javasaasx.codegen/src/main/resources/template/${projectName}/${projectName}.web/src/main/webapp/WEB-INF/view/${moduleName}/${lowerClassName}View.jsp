<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classVOName = classNameLower + 'Vo'>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title><@jspEl 'siteName'/>-${table.remarks}[详情]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>
<body>
<div class="container-fluid">
<#list columnStyles as column>
    <div class="row">
        <label class="col-sm-2">${column.desc}</label>
        <#if column.fieldType=='Date'>
        <div class="col-sm-10"><@jspEl 'fns:formatDateTime(${classVOName}.${column.javaColumn})'/> </div>
        <#else>
        <div class="col-sm-10"><@jspEl '${classVOName}.${column.javaColumn}'/> </div>
        </#if>
    </div>
</#list>
</div>
</body>
</html>