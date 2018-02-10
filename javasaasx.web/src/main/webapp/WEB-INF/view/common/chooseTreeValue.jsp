<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>挑选树值</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
    <link rel="stylesheet" href="${ctxStatic }/jstree/3.3.5/dist/themes/default/style.min.css" />
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-content">
                    <input type="text" id="chooseTree_q" value="" class="form-control input" placeholder="搜索菜单">
                    <div class="form-group label-floating">
                        <label class="control-label">根节点</label>
                        <div id="chooseTree" class="demo">
                            <ul>
                                <li data-jstree='{"opened":true}'>Root node
                                    <ul>
                                        <li>Child node 1</li>
                                        <li>Child node 2</li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
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
    var chooseMap = new Map();
    $(function () {

        $("#chooseTree").jstree({
            "core" : {
                "check_callback" : false,
                "multiple": ${multi},
                "data" : {
                    url : ctx + "${ajaxJsonUrl}",
                    dataType : "json"
                }
            },
            plugins : ["search", "checkbox"],
            checkbox: {
                three_state: false,
                cascade: "none"
            },
        })
        .on('select_node.jstree', function (node, selected, event) {
            var id = selected.node.id;
            var title = selected.node.text;
            if("${multi}" == "false")
                chooseMap.clear();
            chooseMap.put(""+id, {id: id, title: title});
        })
        .on('deselect_node.jstree', function (node, selected, event) {
            var id = selected.node.id;
            var title = selected.node.text;
            chooseMap.remove(""+id);
        });

        var to = false;
        $('#chooseTree_q').keyup(function () {
            if(to) { clearTimeout(to); }
            to = setTimeout(function () {
                var v = $('#chooseTree_q').val();
                $('#chooseTree').jstree(true).search(v);
            }, 250);
        });

    });

    function callChooseValueMap(){
      return chooseMap.toObject();
    }
</script>

</html>