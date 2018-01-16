<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>admin-菜单管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
    <div class="wrapper">
        <%@include file="/include/sidebar.jsp" %>
        <div class="main-panel">
            <%@include file="/include/sidebarHead.jsp" %>
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="card" style="height: 80vh">
                                <div class="card-header card-header-icon" data-background-color="blue">
                                    <i class="material-icons">assignment</i>
                                </div>
                                <div class="card-content">
                                    <h4 class="card-title">数据库表</h4>
                                    <div class="material-datatables">
                                        <input type="text" class="form-control input-sm m-b-xs" id="filter" placeholder="搜索表...">
                                        <table id="leftDatatables" class="table table-no-bordered table-hover"  data-filter="#filter" cellspacing="0" width="100%" style="width:100%">
                                            <thead>
                                            <tr>
                                                <th>表名</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${tableList}" var="table">
                                                    <tr>
                                                        <td onclick="ajaxDataTable('${table.value}')"><a href="javascript:;">${table.text}</a></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-9">
                            <div class="card">
                                <div class="card-header card-header-icon" data-background-color="blue">
                                    <i class="material-icons">assignment</i>
                                </div>
                                <div class="card-content">
                                    <h4 class="card-title">字段设计</h4>
                                    <div class="material-datatables">
                                        <form class="form-horizontal">
                                        <table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%; max-height: 800px;">
                                            <thead>
                                                <tr>
                                                    <th>列名</th>
                                                    <th>描述</th>
                                                    <th>是否插入</th>
                                                    <th>是否编辑</th>
                                                    <th>是否列表</th>
                                                    <th>显示类型</th>
                                                    <th>是否查询</th>
                                                    <th>查询类型</th>
                                                    <th>字典类型</th>
                                                    <th class="disabled-sorting">排序</th>
                                                </tr>
                                            </thead>
                                            <tbody></tbody>
                                        </table>
                                        </form>
                                    </div>
                                    <div class="toolbar text-right">
                                        <button id="submitBtn" class="btn btn-twitter" disabled>保存</button>
                                    </div>
                                </div>
                                <!-- end content-->
                            </div>
                            <!--  end card  -->
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
<script src="${ctxStatic }/jstree/3.3.5/dist/jstree.min.js"></script>
<script src="${ctxStatic }/jquery-plugs/footable.all.min.js"></script>
<script src="${ctxStatic }/form-plugs/addclear.min.js"></script>

<script type="text/javascript">
    // html demo
    $(function () {
        $('.card .material-datatables label').addClass('form-group');

        //初始化 下拉框值
//        http.ajaxAsyncJsonPost("/gen/genTableColumnStyle/getTableList", {}, function(selectBos){
//            var opts = select.buildSelectOptsHtml(selectBos);
//            $('#dbTableSelect').html(opts);
//            $('#dbTableSelect').selectpicker('refresh');
//        });

        $('#dbTableSelect').on('changed.bs.select', function (e, index) {
            var table = e.target.value;
            log(index);
        });

        $("#leftDatatables").footable();

        $("#globalSearch").addClear();
    });

    var __table = null;
    function ajaxDataTable(table){
        //eg: http://www.gbtags.com/gb/rtwidget-replayerpreview/928.htm
        if(__table != null)
            __table.destroy();
        $("#submitBtn").prop("disabled", false);
        __table = $('#datatables').DataTable({
            scrollY: "600px",
            responsive: true,   //响应式
            paging: false,
            ordering: false,
            searching: false,
            retrieve: true,
            ajax: {
                "url": ctx+'/gen/genTableColumnStyle/getGenTableColumnStyleList?table='+table,
                "type": "POST"
            },
            bInfo: false,//不显示信息
            language: {
                  "emptyTable": "暂无表字段数据，不科学！",
                  "loadingRecords": "请等待，数据正在加载中......",
            },
            columns: [
                {"data": "column"},
                {"data": "columnName"},
                {"data": "isInsert"},
                {"data": "isEdit"},
                {"data": "isList"},
                {"data": "isQuery"},
                {"data": "queryType"},
                {"data": "showType"},
                {"data": "dicType"},
                {"data": "sort"}
            ],
            "columnDefs": [
                {
                    "render": function(name, type, row, meta) {
                        return '<input name="column['+meta.row+']" class="form-control" type="text" value="' + row.column + '" />';
                    },"targets": 0 //指定列
                },
                {
                    "render": function(name, type, row, meta) {
                        return '<input name="columnName['+meta.row+']" class="form-control" type="text" value="' + row.columnName + '" />';
                    },"targets": 1 //指定列
                },
                {
                    "render": function(name, type, row, meta) {
                        return '<div class="checkbox"><label><input type="checkbox" name="isInsert['+meta.row+']" '+constants.bindCheckBoxStatus(row.isInsert)+'/><span class="checkbox-material"><span class="check"></span></span></label></div>';
                    },"targets": 2 //指定列
                },
                {
                    "render": function(name, type, row, meta) {
                        return '<div class="checkbox"><label><input type="checkbox" name="isEdit['+meta.row+']" '+constants.bindCheckBoxStatus(row.isEdit)+'/><span class="checkbox-material"><span class="check"></span></span></label></div>';
                    },"targets": 3 //指定列
                },
                {
                    "render": function(name, type, row, meta) {
                        return '<div class="checkbox"><label><input type="checkbox" name="isList['+meta.row+']" '+constants.bindCheckBoxStatus(row.isList)+'/><span class="checkbox-material"><span class="check"></span></span></label></div>';
                    },"targets": 4 //指定列
                },
                {
                    "render": function(name, type, row, meta) {
                        return constants.buildGenCodeShowTypeHtm(meta.row, row.showType);
                    },"targets": 5 //指定列
                },
                {
                    "render": function(name, type, row, meta) {
                        return '<div class="checkbox"><label><input type="checkbox" name="isQuery['+meta.row+']" '+constants.bindCheckBoxStatus(row.isQuery)+'/><span class="checkbox-material"><span class="check"></span></span></label></div>';
                    },"targets": 6//指定列
                },
                {
                    "render": function(name, type, row, meta) {
                        return constants.buildGenCodeQueryTypeHtm(meta.row, row.queryType);
                    },"targets": 7 //指定列
                },

                {
                    "render": function(name, type, row, meta) {
                        return '<input name="dicType['+meta.row+']" class="form-control" type="text" value="' + row.dicType + '" />';
                    },"targets": 8 //指定列
                },
                {
                    "render": function(name, type, row, meta) {
                        return '<input name="sort['+meta.row+']" class="form-control text-center" type="text" value="' + row.sort + '" style="width: 50px;" />';
                    },"targets": 9 //指定列
                },
            ]
        });

        // Edit record
        __table.on('click', '.edit', function() {
            $tr = $(this).closest('tr');

            var data = table.row($tr).data();
            alert('You press on Row: ' + data[0] + ' ' + data[1] + ' ' + data[2] + '\'s row.');
        });

        // Delete a record
        __table.on('click', '.remove', function(e) {
            $tr = $(this).closest('tr');
            table.row($tr).remove().draw();
            e.preventDefault();
        });

        //Like record
        __table.on('click', '.like', function() {
            alert('You clicked on Like button');
        });

    }

</script>

</html>