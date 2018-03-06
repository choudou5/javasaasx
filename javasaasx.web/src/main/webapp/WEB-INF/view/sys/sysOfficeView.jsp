<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统机构[详情]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <label class="col-sm-2">编号</label>
        <div class="col-sm-10">${sysOfficeBo.id} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">名称</label>
        <div class="col-sm-10">${sysOfficeBo.name} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">上级id</label>
        <div class="col-sm-10">${sysOfficeBo.pid} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">父路径</label>
        <div class="col-sm-10">${sysOfficeBo.ppath} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">层级深度</label>
        <div class="col-sm-10">${sysOfficeBo.depth} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">排序</label>
        <div class="col-sm-10">${sysOfficeBo.sort} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">区域编码</label>
        <div class="col-sm-10">${sysOfficeBo.areaCode} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">机构类型: company=公司、dept=部门</label>
        <div class="col-sm-10">${sysOfficeBo.type} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">联系地址</label>
        <div class="col-sm-10">${sysOfficeBo.address} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">负责人</label>
        <div class="col-sm-10">${sysOfficeBo.master} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">电话</label>
        <div class="col-sm-10">${sysOfficeBo.tel} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">备注信息</label>
        <div class="col-sm-10">${sysOfficeBo.remarks} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">数据md5码(检测是否有变更)</label>
        <div class="col-sm-10">${sysOfficeBo.dataMd5} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">code标识</label>
        <div class="col-sm-10">${sysOfficeBo.code} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">创建者</label>
        <div class="col-sm-10">${sysOfficeBo.createBy} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">创建时间</label>
        <div class="col-sm-10">${fns:formatDateTime(sysOfficeBo.createTime)} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">创建者</label>
        <div class="col-sm-10">${sysOfficeBo.updateBy} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">更新时间</label>
        <div class="col-sm-10">${fns:formatDateTime(sysOfficeBo.updateTime)} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">状态: 0=禁用，1=正常</label>
        <div class="col-sm-10">${sysOfficeBo.status} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">是否系统数据: 0=否，1=是</label>
        <div class="col-sm-10">${sysOfficeBo.isSysData} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">删除标记：0=已删除,1=正常</label>
        <div class="col-sm-10">${sysOfficeBo.delFlag} </div>
    </div>
</div>
</body>
</html>