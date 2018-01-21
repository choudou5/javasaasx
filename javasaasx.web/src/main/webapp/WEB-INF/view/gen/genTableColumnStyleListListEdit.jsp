<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-代码生成方案</title>
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
                                    <h4 class="card-title">代码生成</h4>
                                </div>
                                <div class="card-content">
                                    <div class="row">
                                        <!-- left -->
                                        <div class="col-sm-2">
                                            <div class="card-content bd-grey pd-10">
                                                <h4 class="card-title">数据库表</h4>
                                                <div class="material-datatables">
                                                    <input type="text" class="form-control input-sm" id="filter" placeholder="搜索表...">
                                                    <div class="form-group scroll-y h-max-580 h-min-450">
                                                        <table id="leftDatatables" class="table table-bordered table-hover"  data-filter="#filter" data-page-size="100" cellspacing="0" width="100%" style="width:100%">
                                                            <tbody>
                                                            <c:forEach items="${leftDataList}" var="table">
                                                                <tr>
                                                                    <td onclick="ajaxRightDataTable('${table.value}')" title="${table.text}"><a href="javascript:;">${table.value}</a></td>
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
                                            <div class="card-content bd-grey">
                                                <h4 class="card-title">字段设计</h4>
                                                <form id="inputForm" class="form-horizontal" onsubmit="return ajaxSubmitForm()">
                                                <div class="material-datatables">
                                                    <table id="datatables" class="table table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%; max-height: 600px;">
                                                        <thead>
                                                        <tr>
                                                            <th width="130">列名</th>
                                                            <th>描述<small>*</small></th>
                                                            <th>字段<small>*</small></th>
                                                            <th>是否插入</th>
                                                            <th>是否编辑</th>
                                                            <th>是否列表</th>
                                                            <th>显示类型</th>
                                                            <th>是否查询</th>
                                                            <th>查询类型</th>
                                                            <th>字典类型</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody></tbody>
                                                    </table>
                                                </div>

                                                <div class="row">
                                                    <label class="col-sm-4 label-on-left"></label>
                                                    <div class="col-sm-8 pull-right">
                                                        <div class="col-md-6">
                                                            <div class="form-group label-floating is-empty">
                                                                <label class="control-label">代码生成地址：${genCodePath}</label>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group label-floating is-empty">
                                                                <label class="control-label">开发者<small>*</small></label>
                                                                <input type="text" required name="author" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group label-floating  is-empty">
                                                                <label class="control-label">模块(如sys)<small>*</small></label>
                                                                <input type="text" required name="moduleName" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="form-group label-floating is-empty">
                                                                <input type="hidden" id="table" name="table"/>
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
<script src="${ctxStatic }/jquery-plugs/footable.all.min.js"></script>
<script src="${ctxStatic }/js/biz/gen/GenTableColumnStyle.js"></script>
<script type="text/javascript">
    $(function () {
        $('.card .material-datatables label').addClass('form-group');
        $("#leftDatatables").footable();
        TableUtil.bingdTrMenuActive("#leftDatatables");
    });
</script>
</html>