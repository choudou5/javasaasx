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
                            <div class="card">
                                <div class="card-header card-header-icon" data-background-color="blue">
                                    <i class="material-icons">assignment</i>
                                </div>
                                <div class="card-content">
                                    <h4 class="card-title">数据库表</h4>
                                    <div>
                                        <select id="dbTableSelect" class="selectpicker" data-live-search="true" title="请选择表">

                                        </select>
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
                                    <h4 class="card-title">字段样式设计</h4>
                                    <div class="toolbar">
                                        <button class="btn btn-twitter">立即新建</button>
                                    </div>
                                    <div class="material-datatables">
                                        <table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                                            <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Position</th>
                                                <th class="disabled-sorting text-right">Actions</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Position</th>
                                                    <th class="text-right">Actions</th>
                                                </tr>
                                            </tfoot>
                                        </table>
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
<script type="text/javascript">
    // html demo
    $(function () {
        $("#html").jstree({
            "core" : {
                // so that create works
                "check_callback" : true,
                "multiple": false,
            },
            "contextmenu" : {
                "items" : {
                    "create" : {
                        "separator_before"	: false,
                        "separator_after"	: false,
                        "_disabled"			: false, //(this.check("create_node", data.reference, {}, "last")),
                        "label"				: "创建子菜单",
                        "action"			: function (data) {
                            var inst = $.jstree.reference(data.reference),
                            obj = inst.get_node(data.reference);
                            dialogOpenPage("test", "//www.baidu.com", 400, 500, function(){
                                log(111111);
                            })
                            //弹窗 创建菜单，成功后 创建节点

//                            inst.create_node(obj, {}, "last", function (new_node) {
//                                try {
//                                    inst.edit(new_node);
//                                } catch (ex) {
//                                    setTimeout(function () { inst.edit(new_node); },0);
//                                }
//                            });
                        }
                    },
                }
            },
            //https://www.jstree.com/plugins/   state=记录打开行为， types=扩展图标
            "plugins" : [
                "contextmenu", "search", "state", "types",
            ]
        })
        .on('select_node.jstree', function (e, data) {
                    log(e);
                    log(data);
        });

        var to = false;
        $('#html_q').keyup(function () {
            if(to) { clearTimeout(to); }
            to = setTimeout(function () {
                var v = $('#html_q').val();
                $('#html').jstree(true).search(v);
            }, 250);
        });


        //eg: http://www.gbtags.com/gb/rtwidget-replayerpreview/928.htm
        var table = $('#datatables').DataTable({
            responsive: true,   //响应式
            paging: false,
            ordering: false,
            searching: false,
            ajax: ctxStatic+'/jquery-plugs/table-example.txt',
            columns: [
                {
                    "data": "id"
                },
                {
                    "data": "title"
                },
                {
                    "data": "url"
                }],
                "columnDefs": [{
                    // "visible": false,
                    //"targets": 0
                },
                {
                    "render": function(data, type, row, meta) {
                        //渲染 把数据源中的标题和url组成超链接
                        return '<a href="' + data + '" target="_blank">' + row.title + '</a>';
                    },
                    //指定是第三列
                    "targets": 2
                }]
        });

        // Edit record
        table.on('click', '.edit', function() {
            $tr = $(this).closest('tr');

            var data = table.row($tr).data();
            alert('You press on Row: ' + data[0] + ' ' + data[1] + ' ' + data[2] + '\'s row.');
        });

        // Delete a record
        table.on('click', '.remove', function(e) {
            $tr = $(this).closest('tr');
            table.row($tr).remove().draw();
            e.preventDefault();
        });

        //Like record
        table.on('click', '.like', function() {
            alert('You clicked on Like button');
        });

        $('.card .material-datatables label').addClass('form-group');



        //初始化 下拉框值
        http.ajaxAsyncJsonPost("/gen/genTableColumnStyle/getTableList", {}, function(selectBos){
            var opts = select.buildSelectOptsHtml(selectBos);
            $('#dbTableSelect').html(opts);
            $('#dbTableSelect').selectpicker('refresh');
        });

        $('#dbTableSelect').on('changed.bs.select', function (e, index) {
            var table = e.target.value;
            log(index);
        });

    });

</script>

</html>