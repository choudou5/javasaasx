<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${"$"}{siteName}-${table.remarks}[列表]</title>
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
                    <table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr>
                            <#list columnStyles as column>
                                <#if column.isList=="1">
                            <th>${column.desc}</th>
                                </#if>
                            </#list>
                            <th class="disabled-sorting text-right">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="<@jspEl 'pageResult.result'/>" var="item">
                            <tr>
                                <#list columnStyles as column>
                                    <#if column.isList=="1">
                                        <#if column.column=="name">
                                <td>
                                    <shiro:hasPermission name="${moduleName}:${classNameLower}:view">
                                        <a href="javascript:;" onclick="dialogOpenPageView('详情', '${"$"}{ctx}/${moduleName}/${classNameLower}/view?id=${"$"}{item.id}');" class="btn btn-simple btn-facebook">${"$"}{item.name}</a>
                                    </shiro:hasPermission>
                                    <shiro:lacksPermission name="${moduleName}:${classNameLower}:view">
                                        <@jspEl 'item.name'/>
                                    </shiro:lacksPermission>
                                </td>
                                        <#else>
                                <td><@jspEl 'item.${column.javaColumn}'/></td>
                                        </#if>
                                    </#if>
                                </#list>
                                <td class="text-right">
                                    <shiro:hasPermission name="${moduleName}:${classNameLower}:edit">
                                        <a href="javascript:;" onclick="dialogOpenPage('${classNameLower}Edit', '编辑', '${"$"}{ctx}/${moduleName}/${classNameLower}/form?id=${"$"}{item.id}');" class="btn btn-simple btn-warning btn-icon"><i class="fa fa-edit"></i></a>
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="${moduleName}:${classNameLower}:delete">
                                        <a href="javascript:;" data-href="${"$"}{ctx}/${moduleName}/${classNameLower}/delete?id=${"$"}{item.id}" class="btn btn-simple btn-danger btn-icon remove"><i class="fa fa-remove"></i></a>
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
    ${"$"}(function () {
        var datatables = ${"$"}('#datatables').DataTable({
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
            var href = ${"$"}(this).data("href");
            tr = ${"$"}(this).closest('tr');
            dialogConfirmAjaxDel(href, datatables, tr);
            e.preventDefault();
        });
    });
</script>
</html>