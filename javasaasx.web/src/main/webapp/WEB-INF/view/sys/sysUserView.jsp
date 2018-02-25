<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统用户[详情]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>
<body>
<div class="container-fluid page-detail">
    <div class="row">
        <label class="col-sm-2">用户id</label>
        <div class="col-sm-10">${sysUserBo.id} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">归属公司</label>
        <div class="col-sm-10">${sysUserBo.companyId} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">部门</label>
        <div class="col-sm-10">${sysUserBo.officeId} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">工号</label>
        <div class="col-sm-10">${sysUserBo.jobNumber} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">姓名</label>
        <div class="col-sm-10">${sysUserBo.name} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">密码</label>
        <div class="col-sm-10 word-break">${sysUserBo.password} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">英文名</label>
        <div class="col-sm-10">${sysUserBo.englishName} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">管理员</label>
        <div class="col-sm-10"><sys:flagLabel value="${sysUserBo.isAdmin}"/> </div>
    </div>
    <div class="row">
        <label class="col-sm-2">老板</label>
        <div class="col-sm-10"><sys:flagLabel value="${sysUserBo.isBoss}"/> </div>
    </div>
    <div class="row">
        <label class="col-sm-2">邮箱</label>
        <div class="col-sm-10">${sysUserBo.email} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">电话</label>
        <div class="col-sm-10">${sysUserBo.phone} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">手机</label>
        <div class="col-sm-10">${sysUserBo.mobile} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">性别</label>
        <div class="col-sm-10"><sys:sex value="${sysUserBo.gender}"/> </div>
    </div>
    <div class="row">
        <label class="col-sm-2">头像</label>
        <div class="col-sm-10"><sys:image url="${sysUserBo.avatar}"/> </div>
    </div>
    <div class="row">
        <label class="col-sm-2">最后登陆ip</label>
        <div class="col-sm-10">${sysUserBo.loginIp} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">最后登陆时间</label>
        <div class="col-sm-10">${fns:formatDateTime(sysUserBo.loginTime)} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">职位信息</label>
        <div class="col-sm-10">${sysUserBo.position} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">备注信息</label>
        <div class="col-sm-10">${sysUserBo.remarks} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">来源</label>
        <div class="col-sm-10">${sysUserBo.source} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">创建者</label>
        <div class="col-sm-10">${sysUserBo.createBy} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">创建时间</label>
        <div class="col-sm-10">${fns:formatDateTime(sysUserBo.createTime)}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">更新者</label>
        <div class="col-sm-10">${sysUserBo.updateBy} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">更新时间</label>
        <div class="col-sm-10">${fns:formatDateTime(sysUserBo.updateTime)} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">状态: 0=禁用，1=正常, 2=离职</label>
        <div class="col-sm-10">${sysUserBo.status} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">系统数据</label>
        <div class="col-sm-10"><sys:flagLabel value="${sysUserBo.isSysData}"/> </div>
    </div>
</div>
</body>
</html>