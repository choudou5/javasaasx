
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统机构[列表]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="card">
            <div class="card-content">
                <div class="toolbar">
                    <div class="row">
                        <div class="col-md-12">
                            <button id="addBtn" onclick="FormUtil.bindFormAddBtn('添加系统机构')" data-href="${ctx}/sys/sysOffice/form" class="btn btn-success btn-sm"><i class="fa fa-plus"></i>&nbsp;添加</button>
                        </div>
                    </div>
                </div>

                <div class="material-datatables table-responsive">
                    <table id="datatables" class="table table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr>
                            <th class="${fns:getDebugCss()}">编号</th>
                            <th>名称</th>
                            <th>上级id</th>
                            <th>区域编码</th>
                            <th>机构类型</th>
                            <th>联系地址</th>
                            <th>负责人</th>
                            <th>电话</th>
                            <th>备注</th>
                            <th>创建者</th>
                            <th>创建时间</th>
                            <th>状态</th>
                            <th>系统数据</th>
                            <th class="disabled-sorting">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageResult.result}" var="item">
                            <tr>
                                <td class="${fns:getDebugCss()}">${item.id}</td>
                                <td>
                                    <shiro:hasPermission name="sys:sysOffice:view">
                                        <a href="javascript:;" onclick="dialogOpenPageView('详情', '${ctx}/sys/sysOffice/view?id=${item.id}');" class="btn btn-simple btn-facebook">${item.name}</a>
                                    </shiro:hasPermission>
                                    <shiro:lacksPermission name="sys:sysOffice:view">
                                        ${item.name}
                                    </shiro:lacksPermission>
                                </td>
                                <td>${item.pid}</td>
                                <td>${item.areaCode}</td>
                                <td>${item.type}</td>
                                <td>${item.address}</td>
                                <td>${item.master}</td>
                                <td>${item.tel}</td>
                                <td>${item.remarks}</td>
                                <td>${item.createBy}</td>
                                <td>${fns:formatDateTime(item.createTime)}</td>
                                <td><sys:flagLabel value="${item.status}"/></td>
                                <td><sys:flagLabel value="${item.isSysData}"/></td>
                                <td class="text-right">
                                    <shiro:hasPermission name="sys:sysOffice:edit">
                                        <a href="javascript:;" onclick="dialogOpenPage('sysOfficeEdit', '编辑', '${ctx}/sys/sysOffice/form?id=${item.id}');" class="btn btn-simple btn-warning btn-icon"><i class="fa fa-edit"></i></a>
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="sys:sysOffice:delete">
                                        <a href="javascript:;" data-href="${ctx}/sys/sysOffice/delete?id=${item.id}" class="btn btn-simple btn-danger btn-icon remove"><i class="fa fa-remove"></i></a>
                                    </shiro:hasPermission>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- end content-->
        </div>
        <!--  end card  -->
    </div>
</div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<script src="${ctxStatic }/js/biz/sys/sysOffice.js"></script>
<script type="text/javascript">
    $(function () {
        //构建数据表格
        buildDataTable();
    });
</script>
</html>