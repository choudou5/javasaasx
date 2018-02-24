<#assign className = table.className>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${"$"}{siteName}-${table.remarks}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
    <style type="text/css">
        .checkbox .checkbox-material{top: -5px;}
        .checkbox .checkbox-material:before {bottom: 5px;}
        .table .form-group{margin-top: 10px;}
    </style>
</head>

<body>
<div class="wrapper">
    <%@include file="/include/sidebar.jsp" %>
    <div class="main-panel">
        <%@include file="/include/sidebarHead.jsp" %>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header card-header-text" data-background-color="blue">
                                <h4 class="card-title">${table.remarks}</h4>
                            </div>
                            <div class="card-content">
                                <div class="row">
                                    <!-- left -->
                                    <div class="col-sm-2">
                                        <div class="card-content bd-grey pd-10">
                                            <h4 class="card-title">${table.remarks}</h4>
                                            <div class="material-datatables">
                                                <input type="text" class="form-control input-sm" id="filter" placeholder="搜索...">
                                                <div class="form-group scroll-y h-max-580 h-min-450">
                                                    <table id="leftDatatables" class="table table-bordered table-hover"  data-filter="#filter" data-page-size="100" cellspacing="0" width="100%" style="width:100%">
                                                        <tbody>
                                                        <c:forEach items="${'$'}{leftDataList}" var="dataItem">
                                                            <tr>
                                                                <td onclick="ajaxRightDataTable('${'$'}{dataItem.value}')" title="${'$'}{dataItem.text}"><a href="javascript:;">${'$'}{dataItem.value}</a></td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- left end -->

                                    <!-- right -->
                                    <div class="col-sm-10">
                                        <div class="card-content">
                                            <h4 class="card-title">${table.remarks}-编辑</h4>
                                            <form id="inputForm" class="form-horizontal" onsubmit="return ajaxSubmitForm()">
                                                <div class="material-datatables">
                                                    <table id="datatables" class="table table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%; max-height: 600px;">
                                                        <thead>
                                                            <tr>
                                                            <#list table.columns as column>
                                                                <#if !column.abstractField>
                                                                <th>${column.columnAlias!}<#if !column.nullable><small class="red">*</small></#if></th>
                                                                </#if>
                                                            </#list>
                                                            </tr>
                                                        </thead>
                                                        <tbody></tbody>
                                                    </table>
                                                </div>
                                                <div class="row bg-grey">
                                                    <label class="col-sm-4 label-on-left"></label>
                                                    <div class="col-sm-8 pull-right">
                                                        <div class="col-md-2">
                                                            <div class="form-group label-floating is-empty">
                                                                <button id="submitBtn" class="btn btn-twitter mgt-f8" disabled >保存</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>

                                        </div>
                                    </div>
                                    <!-- right end -->

                                </div>
                            </div>

                        </div>
                    </div>


                </div>
            </div>
        </div>
        <%@include file="/include/footer.jsp" %>
    </div>
</div>
<%@include file="/include/sidebarRight.jsp" %>
</body>
<%@include file="/include/scriptLib.jsp" %>
<%@include file="/include/validScriptLib.jsp" %>
<script src="${'$'}{ctxStatic }/jquery-plugs/footable.all.min.js"></script>
<script src="${'$'}{ctxStatic }/js/biz/${moduleName}/${lowerClassName}.js"></script>
<script type="text/javascript">
    $(function () {
        ${'$'}('.card .material-datatables label').addClass('form-group');
        ${'$'}("#leftDatatables").footable();
        tbl.bingdTrMenuActive("#leftDatatables");
    });
</script>
</html>