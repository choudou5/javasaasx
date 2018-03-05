<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classBOName = classNameLower + 'Bo'>
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
                <div class="toolbar">
                    <div class="row">
                        <form:form id="searchForm" modelAttribute="${classNameLower}QueryParam" action="${"$"}{ctx}/${moduleName}/${classNameLower}/list" method="post">
                            <#list columnStyles as column>
                                <#if column.isQuery=="1">
                            <div class="col-md-2">
                                <#if column.showType=="input">
                                    <#if column.fieldType=="Date">
                                <input type="text" id="range${column.javaColumn?cap_first}" name="range${column.javaColumn?cap_first}" class="form-control" placeholder=" ${column.desc}范围查询"/>
                                    <#else>
                                <form:input type="text" path="${classBOName}.${column.javaColumn}" class="form-control clearable" placeholder=" ${column.desc}"/>
                                    </#if>
                                <#elseif column.showType=="select">
                                <form:select path="${classBOName}.${column.javaColumn}" title="${column.desc}" class="selectpicker" data-style="select-with-transition" data-live-search="false">
                                    <form:option value="">${column.desc}</form:option>
                                </form:select>
                                </#if>
                            </div>
                                </#if>
                            </#list>
                            <div class="col-md-1">
                                <button type="submit" class="btn btn-twitter"><i class="fa fa-search"></i></button>
                                <input type="hidden" id="pageNo" name="pageBean.pageNo"/>
                                <input type="hidden" id="pageSize" name="pageBean.pageSize" />
                                <input type="hidden" id="orderBy" name="orderBean.orderBy" value="${"${"}${classNameLower}QueryParam.orderBean.orderBy}"/>
                                <input type="hidden" id="order" name="orderBean.order" value="${"${"}${classNameLower}QueryParam.orderBean.order}"/>
                            </div>
                        </form:form>
                        <div class="col-md-12">
                            <button id="addBtn" onclick="FormUtil.bindFormAddBtn('添加${table.remarks}')" data-href="${"$"}{ctx}/${moduleName}/${classNameLower}/form" class="btn btn-success btn-sm"><i class="fa fa-plus"></i>&nbsp;添加</button>
                        </div>
                    </div>
                </div>

                <div class="material-datatables table-responsive">
                    <table id="datatables" class="table table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr>
                            <#list columnStyles as column>
                                <#if column.isList=="1">
                            <th>${column.desc}</th>
                                </#if>
                            </#list>
                            <th class="disabled-sorting">操作</th>
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
                                        ${"$"}{item.name}
                                    </shiro:lacksPermission>
                                </td>
                                        <#else>
                                <td><#if column.fieldType=="Date"><@jspEl 'fns:formatDateTime(item.${column.javaColumn})'/><#else><@jspEl 'item.${column.javaColumn}'/></#if></td>
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
                <%-- <sys:paging page="${"$"}{pageResult}"/> --%>
            </div>
            <!-- end content-->
        </div>
        <!--  end card  -->
    </div>
</div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<script src="${'$'}{ctxStatic }/js/biz/${moduleName}/${lowerClassName}.js"></script>
<script type="text/javascript">
    ${"$"}(function () {
        //构建数据表格
        //buildDataTable();

        /* 纯列表
        //绑定排序
        FormUtil.bindOrder();
        //日期时间范围
        laydate.render({
            elem: '#rangeCreateDate'
            ,type: 'datetime'
            ,max: 0
            ,range: true
        });
        */

    });
</script>
</html>