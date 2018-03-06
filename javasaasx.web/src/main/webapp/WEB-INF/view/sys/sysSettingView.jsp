<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统设置[详情]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <label class="col-sm-2">id</label>
        <div class="col-sm-10">${sysSettingBo.id} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">类型code</label>
        <div class="col-sm-10">${sysSettingBo.typeCode} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">code</label>
        <div class="col-sm-10">${sysSettingBo.code} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">名称</label>
        <div class="col-sm-10">${sysSettingBo.name} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">值</label>
        <div class="col-sm-10">${sysSettingBo.value} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">备注</label>
        <div class="col-sm-10">${sysSettingBo.remark} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">预留字段1</label>
        <div class="col-sm-10">${sysSettingBo.ext1} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">预留字段2</label>
        <div class="col-sm-10">${sysSettingBo.ext2} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">预留字段3</label>
        <div class="col-sm-10">${sysSettingBo.ext3} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">创建者</label>
        <div class="col-sm-10">${sysSettingBo.createBy} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">创建时间</label>
        <div class="col-sm-10">${fns:formatDateTime(sysSettingBo.createTime)} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">更新者</label>
        <div class="col-sm-10">${sysSettingBo.updateBy} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">更新时间</label>
        <div class="col-sm-10">${fns:formatDateTime(sysSettingBo.updateTime)} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">状态: 0=禁用，1=正常</label>
        <div class="col-sm-10">${sysSettingBo.status} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">删除标记：0=已删除,1=正常</label>
        <div class="col-sm-10">${sysSettingBo.delFlag} </div>
    </div>
</div>
</body>
</html>