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
        <div class="col-sm-10">${sysUserVo.id} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">归属公司</label>
        <div class="col-sm-10">${sysUserVo.companyId} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">部门</label>
        <div class="col-sm-10">${sysUserVo.officeId} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">工号</label>
        <div class="col-sm-10">${sysUserVo.jobNumber} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">姓名</label>
        <div class="col-sm-10">${sysUserVo.name} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">密码</label>
        <div class="col-sm-10 word-break">${sysUserVo.password} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">英文名</label>
        <div class="col-sm-10">${sysUserVo.englishName} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">管理员</label>
        <div class="col-sm-10"><sys:flagLabel value="${sysUserVo.isAdmin}"/> </div>
    </div>
    <div class="row">
        <label class="col-sm-2">老板</label>
        <div class="col-sm-10"><sys:flagLabel value="${sysUserVo.isBoss}"/> </div>
    </div>
    <div class="row">
        <label class="col-sm-2">邮箱</label>
        <div class="col-sm-10">${sysUserVo.email} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">电话</label>
        <div class="col-sm-10">${sysUserVo.phone} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">手机</label>
        <div class="col-sm-10">${sysUserVo.mobile} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">性别</label>
        <div class="col-sm-10"><sys:sex value="${sysUserVo.gender}"/> </div>
    </div>
    <div class="row">
        <label class="col-sm-2">头像</label>
        <div class="col-sm-10"><sys:image url="${sysUserVo.avatar}"/> </div>
    </div>
    <div class="row">
        <label class="col-sm-2">最后登陆ip</label>
        <div class="col-sm-10">${sysUserVo.loginIp} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">最后登陆时间</label>
        <div class="col-sm-10">${fns:formatDateTime(sysUserVo.loginTime)} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">职位信息</label>
        <div class="col-sm-10">${sysUserVo.position} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">备注信息</label>
        <div class="col-sm-10">${sysUserVo.remarks} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">来源</label>
        <div class="col-sm-10">${sysUserVo.source} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">创建者</label>
        <div class="col-sm-10">${sysUserVo.createBy} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">创建时间</label>
        <div class="col-sm-10">${fns:formatDateTime(sysUserVo.createTime)}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">更新者</label>
        <div class="col-sm-10">${sysUserVo.updateBy} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">更新时间</label>
        <div class="col-sm-10">${fns:formatDateTime(sysUserVo.updateTime)} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">状态: 0=禁用，1=正常, 2=离职</label>
        <div class="col-sm-10">${sysUserVo.status} </div>
    </div>
    <div class="row">
        <label class="col-sm-2">系统数据</label>
        <div class="col-sm-10"><sys:flagLabel value="${sysUserVo.isSysData}"/> </div>
    </div>
</div>
</body>
</html>