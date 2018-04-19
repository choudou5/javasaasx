<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统角色[列表]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="card">
            <div class="card-content">
                <div class="toolbar">
                    <button id="addBtn" onclick="FormUtil.bindFormAddBtn('添加角色')" data-href="${ctx}/sys/sysRole/form" class="btn btn-success btn-simple btn-sm"><i class="fa fa-plus"></i>&nbsp;添加</button>
                </div>
                <div class="material-datatables">
                    <table id="datatables" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr>
                            <th>角色名称</th>
                            <th>归属机构</th>
                            <th>分组名</th>
                            <th>数据范围</th>
                            <th>备注信息</th>
                            <th>创建者</th>
                            <th>创建时间</th>
                            <th>创建者</th>
                            <th>状态</th>
                            <th>系统数据</th>
                            <th class="disabled-sorting text-right">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageResult.result}" var="item">
                            <tr data-id="${item.id}">
                                <td>
                                    <shiro:hasPermission name="sys:sysRole:view">
                                        <a href="javascript:;" onclick="dialogOpenPageView('详情', '${ctx}/sys/sysRole/view?id=${item.id}');" class="btn btn-simple btn-facebook">${item.name}</a>
                                    </shiro:hasPermission>
                                    <shiro:lacksPermission name="sys:sysRole:view">
                                        ${item.name}                                    </shiro:lacksPermission>
                                </td>
                                <td>${item.officeId}</td>
                                <td>${item.groupName}</td>
                                <td>${item.dataScope}</td>
                                <td>${item.remarks}</td>
                                <td>${item.createBy}</td>
                                <td>${fns:formatDateTime(item.createTime)}</td>
                                <td>${item.updateBy}</td>
                                <td><sys:flagLabel value="${item.status}" yesText="有效" noText="无效"/></td>
                                <td><sys:flagLabel value="${item.isSysData}"/></td>
                                <td class="text-right">
                                    <shiro:hasPermission name="sys:sysRole:edit">
                                        <a href="javascript:;" onclick="dialogOpenPage('sysRoleEdit', '编辑', '${ctx}/sys/sysRole/form?id=${item.id}');" class="btn btn-simple btn-warning btn-icon"><i class="fa fa-edit"></i></a>
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="sys:sysRole:delete">
                                        <a href="javascript:;" data-href="${ctx}/sys/sysRole/delete?id=${item.id}" class="btn btn-simple btn-danger btn-icon remove"><i class="fa fa-remove"></i></a>
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
<script type="text/javascript">
    $(function () {
        var datatables = $('#datatables').DataTable({
            "pagingType": "full_numbers",
            "lengthMenu": [
                [10, 25, 50, -1],
                [10, 25, 50, "All"]
            ],
            order: [[ 6, "desc" ]],
            responsive: true,
            language: {
                search: "_INPUT_",
                searchPlaceholder: "Search",
            }
        });
        // Delete a record
        datatables.on('click', '.remove', function(e) {
            var href = $(this).data("href");
            tr = $(this).closest('tr');
            dialogConfirmAjaxDel(href, datatables, tr);
            e.preventDefault();
        });
    });
</script>
</html>