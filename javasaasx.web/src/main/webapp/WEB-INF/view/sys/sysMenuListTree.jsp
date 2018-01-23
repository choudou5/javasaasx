<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>admin-菜单管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
    <link rel="stylesheet" href="${ctxStatic }/jstree/3.3.5/dist/themes/default/style.min.css" />
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <div class="card card-profile" style="height: 80vh">
                <div class="card-content text-left">
                    <%--<h6 class="category text-gray">CEO / Co-Founder</h6>
                    <h4 class="card-title">Alec Thompson</h4>--%>
                    <input type="text" id="leftTree_q" value="" class="form-control input" placeholder="搜索菜单">
                    <div id="leftTree" class="demo">
                        <%--<ul>
                            <li data-jstree='{"opened":true }'>Root node
                                <ul>
                                    <li data-jstree='{ "selected" : true }'>Child node 1</li>
                                    <li>Child node 2</li>
                                </ul>
                            </li>
                        </ul>--%>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-9">
            <div class="card">
                <div class="card-content">
                    <h4 class="card-title">DataTables.net</h4>
                    <div class="toolbar">
                        <!--        Here you can write extra buttons/actions for the toolbar              -->
                    </div>
                    <div class="material-datatables">
                        <table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Position</th>
                                <th>Office</th>
                                <th>Age</th>
                                <th>Date</th>
                                <th class="disabled-sorting text-right">Actions</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Name</th>
                                <th>Position</th>
                                <th>Office</th>
                                <th>Age</th>
                                <th>Start date</th>
                                <th class="text-right">Actions</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach begin="10" end="25" var="varDex">
                                <tr>
                                    <td>Airi Satou</td>
                                    <td>Accountant</td>
                                    <td>Tokyo</td>
                                    <td>33</td>
                                    <td>2008/11/28</td>
                                    <td class="text-right">
                                        <a href="#" class="btn btn-success btn-sm edit"><i class="material-icons">edit</i></a>
                                        <a href="#" class="btn btn-danger btn-sm remove"><i class="material-icons">close</i></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Brielle Williamson</td>
                                    <td>Integration Specialist</td>
                                    <td>New York</td>
                                    <td>61</td>
                                    <td>2012/12/02</td>
                                    <td class="text-right">
                                        <a href="#" class="btn btn-simple btn-info btn-icon like"><i class="material-icons">favorite</i></a>
                                        <a href="#" class="btn btn-simple btn-warning btn-icon edit"><i class="material-icons">dvr</i></a>
                                        <a href="#" class="btn btn-simple btn-danger btn-icon remove"><i class="material-icons">close</i></a>
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
</div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<script src="${ctxStatic }/jstree/3.3.5/dist/jstree.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#leftTree").jstree({
            "core" : {
                "check_callback" : true,
                "multiple": false,
                "data" : {
                    url : ctx+'/sys/sysMenu/ajaxParentTree',
                    dataType : "json"
                }
            },
            "contextmenu" : {
                "items" : {
                    "create" : {
                        "separator_before"	: false,
                        "separator_after"	: false,
                        "_disabled"			: false,
                        "label"				: "创建子菜单",
                        "action"			: function (data) {
                            var inst = $.jstree.reference(data.reference);
                            var obj = inst.get_node(data.reference);
                            var pid = obj.id;
                            var iframeId = "sysMenuFormIFrame";
                            dialogOpenPage(iframeId, "新增菜单", "/sys/sysMenu/form?pid="+pid, 500, 550, function(){
                                var iframe = dialogGetIFrame(iframeId);
                                iframe.contentWindow.ajaxSubmitIframeForm(function(){
                                    log("start refresh tree");
                                    //创建菜单，成功后 刷新节点
                                    inst.refresh();
                                });
                            });
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
        $('#leftTree_q').keyup(function () {
            if(to) { clearTimeout(to); }
            to = setTimeout(function () {
                var v = $('#leftTree_q').val();
                $('#leftTree').jstree(true).search(v);
            }, 250);
        });



        $('#datatables').DataTable({
            "pagingType": "full_numbers",
            "lengthMenu": [
                [10, 25, 50, -1],
                [10, 25, 50, "All"]
            ],
            responsive: true,
            language: {
                search: "_INPUT_",
                searchPlaceholder: "Search records",
            }

        });


        var table = $('#datatables').DataTable();

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
    });

</script>

</html>