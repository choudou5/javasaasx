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
                    <input type="text" id="leftTree_q" value="" class="form-control input clearable" placeholder="搜索菜单">
                    <div id="leftTree" class="demo"></div>
                </div>
            </div>
        </div>

        <div class="col-md-9">
            <div class="card">
                <div class="card-content">
                    <h4 class="card-title">功能权限</h4>
                    <div class="material-datatables">
                        <table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                            <thead>
                            <tr>
                                <th>名称</th>
                                <th class="disabled-sorting">权限标识</th>
                                <th class="disabled-sorting">手机端显示</th>
                                <th class="disabled-sorting">系统数据</th>
                                <th class="disabled-sorting">状态</th>
                                <th class="disabled-sorting">备注</th>
                            </tr>
                            </thead>
                            <tbody></tbody>
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
<script src="${ctxStatic }/js/biz/sys/SysMenu.js"></script>
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
                        "label"				: "创建菜单",
                        "action"			: function (data) {
                            var inst = $.jstree.reference(data.reference);
                            var obj = inst.get_node(data.reference);
                            var pid = obj.id;
                            var iframeId = "sysMenuFormIFrame";
                            dialogOpenPage(iframeId, "新增菜单", "/sys/sysMenu/form?pid="+pid, 500, 550, function(){
                                var iframe = dialogGetIFrame(iframeId);
                                iframe.contentWindow.ajaxSubmitIframeForm(function(){
                                    inst.refresh(); //创建菜单，成功后 刷新节点
                                    setTimeout(function(){
                                        dialogCloseIFrame(iframeId);
                                    }, 1000);
                                });
                            });
                        }
                    },
                    "delete" : {
                        "label"	: "删除菜单",
                        "action"	: function (data) {
                            var inst = $.jstree.reference(data.reference);
                            var obj = inst.get_node(data.reference);
                            var id = obj.id;
                            if (id == 1){
                                dialogTipText("根菜单不能删除");
                                return;
                            }
                            dialogConfirm("确认删除该菜单？", function(){
                                var url = "/sys/sysMenu/delete?id="+id;
                                HttpUtil.ajaxAsyncJsonPost(url, {}, function(){
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
             ajaxRightDataTable(data.node.id);
        });
        var to = false;
        $('#leftTree_q').keyup(function () {
            if(to) { clearTimeout(to); }
            to = setTimeout(function () {
                var v = $('#leftTree_q').val();
                $('#leftTree').jstree(true).search(v);
            }, 250);
        });

        /*
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
        });*/

        $('.card .material-datatables label').addClass('form-group');
    });

</script>

</html>