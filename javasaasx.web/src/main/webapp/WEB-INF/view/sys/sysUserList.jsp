<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统用户[列表]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="card">
            <div class="card-content">
                <div class="toolbar"></div>
                <div class="material-datatables">
                    <table id="datatables" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr>
                            <th class="${fns:getDebugCss()}">用户id</th>
                            <th>公司</th>
                            <th>部门</th>
                            <th>工号</th>
                            <th>姓名</th>
                            <th>管理员</th>
                            <th>老板</th>
                            <th>邮箱</th>
                            <th>电话</th>
                            <th>手机</th>
                            <th>性别</th>
                            <th class="disabled-sorting">头像</th>
                            <th>最后登陆ip</th>
                            <th>最后登陆时间</th>
                            <th>职位信息</th>
                            <th>备注信息</th>
                            <th>状态: 0=禁用，1=正常, 2=离职</th>
                            <th>系统数据</th>
                            <th class="disabled-sorting text-right">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageResult.result}" var="item">
                            <tr>
                                <td class="${fns:getDebugCss()}">${item.id} </td>
                                <td>${item.companyId} </td>
                                <td>${item.officeId} </td>
                                <td>${item.jobNumber} </td>
                                <td>
                                    <shiro:lacksPermission name="sys:sysUser:view">
                                        <a href="javascript:;" onclick="dialogOpenPageView('详情', '${ctx}/sys/sysUser/view?id=${item.id}');" class="btn btn-simple btn-facebook">${item.name}</a>
                                    </shiro:lacksPermission>
                                    <shiro:hasPermission name="sys:sysUser:view">
                                        ${item.name}
                                    </shiro:hasPermission>
                                </td>
                                <td><sys:flagLabel value="${item.isAdmin}"/> </td>
                                <td><sys:flagLabel value="${item.isBoss}"/> </td>
                                <td>${item.email} </td>
                                <td>${item.phone} </td>
                                <td>${item.mobile} </td>
                                <td><sys:sex value="${item.gender}"/> </td>
                                <td><sys:image url="${item.avatar}"/> </td>
                                <td>${item.loginIp} </td>
                                <td>${item.loginTime} </td>
                                <td>${item.position} </td>
                                <td>${item.remarks} </td>
                                <td>${item.status} </td>
                                <td><sys:flagLabel value="${item.isSysData}"/> </td>
                                <td class="text-right">
                                    <shiro:hasPermission name="sys:sysUser:edit">
                                        <a href="javascript:;" onclick="dialogOpenPage('sysUserEdit', '编辑', '${ctx}/sys/sysUser/form?id=${item.id}');" class="btn btn-simple btn-warning btn-icon"><i class="fa fa-edit"></i></a>
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="sys:sysUser:delete">
                                        <a href="javascript:;" data-href="${ctx}/sys/sysUser/delete?id=${item.id}" class="btn btn-simple btn-danger btn-icon remove"><i class="fa fa-remove"></i></a>
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