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
    <div class="wrapper">
        <%@include file="/include/sidebar.jsp" %>
        <div class="main-panel">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card" style="margin: 10px 0;">
                            <form:form id="inputForm" cssClass="form-horizontal" modelAttribute="sysMenuBo" action="" method="POST">
                                <form:hidden path="id"/>
                                <form:hidden path="type"/>
                                <div class="card-content">
                                    <div class="form-group label-floating ${isShowParent?'':'hide'}">
                                        <form:hidden path="pid" value="${pid}"/>
                                        <label class="control-label">父节点</label>
                                        <div id="parentTree" class="demo">
                                            <ul>
                                                <li data-jstree='{"opened":true}'>Root node
                                                    <ul>
                                                        <li data-jstree='{ "selected" : true }'>Child node 1</li>
                                                        <li>Child node 2</li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="form-group label-floating">
                                        <form:input path="name" class="form-control" required="true" placeholder="名称*"/>
                                    </div>
                                    <div class="form-group label-floating">
                                        <form:input path="permission" required="true" class="form-control" placeholder="权限标识*"/>
                                    </div>
                                    <div class="form-group label-floating">
                                        <ul class="nav nav-tabs" data-tabs="tabs">
                                            <li class="active">
                                                <a href="#typeMenu" data-toggle="tab" onclick="FormUtil.setInputVal('#type', 'menu')">菜单</a>
                                            </li>
                                            <li class="">
                                                <a href="#typeButton" data-toggle="tab" onclick="FormUtil.setInputVal('#type', 'buttom')">按钮</a>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="tab-content">
                                        <div class="tab-pane active" id="typeMenu">
                                            <div class="form-group label-floating">
                                                <form:input path="href" class="form-control" required="true" placeholder="链接*"/>
                                            </div>
                                            <div class="form-group label-floating">
                                                <form:input path="icon" class="form-control" placeholder="请使用 fa fa- "/>
                                            </div>
                                            <div class="form-group label-floating">
                                                <form:textarea path="remarks" class="form-control" rows="1" placeholder="备注"/>
                                            </div>
                                            <div class="form-group label-floating">
                                                <div class="checkbox checkbox-inline">
                                                    <label class="text-success">权限：</label>
                                                </div>
                                                <input type="text" name="perms" value="查看,新增,修改,删除" class="tagsinput" data-role="tagsinput" data-color="rose" />
                                            </div>
                                        </div>
                                        <div class="tab-pane" id="typeButton"></div>
                                    </div>
                                    <div class="form-group label-floating">
                                        <div class="togglebutton">
                                          <span>手机端显示:</span>
                                          <label>
                                              <form:checkbox path="isMobileShow" value="1" />
                                          </label>
                                          <span>状态:</span>
                                          <label>
                                              <form:checkbox path="status" checked="checked" value="1" />
                                          </label>
                                        </div>
                                    </div>
                                </div>
                            </form:form>
                            <!-- end content-->
                        </div>
                        <!--  end card  -->
                    </div>

                </div>
            </div>
        </div>
    </div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<%@include file="/include/validScriptLib.jsp" %>
<script src="${ctxStatic }/jstree/3.3.5/dist/jstree.min.js"></script>
<script type="text/javascript">

    //初始化
    FormUtil.setInputVal('#type', 'menu');

    // html demo
    $(function () {
        $("#parentTree").jstree({
            "core" : {
                "check_callback" : true,
                "multiple": false,
            },
            //https://www.jstree.com/plugins/   state=记录打开行为， types=扩展图标
            plugins : ["search", "checkbox"],
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
            checkbox: {
                three_state: false,
                cascade: "none"
            },
        })
        .on('select_node.jstree', function (e, data) {
                    log(e);
                    log(data);
        });

        $('.card .material-datatables label').addClass('form-group');

        setFormValidation('#inputForm');
    });

    function ajaxSubmitIframeForm(success){
        var form = $("#inputForm");
        if(form.valid()){
            FormUtil.tryLockSubmit();
            var paramArr = form.serializeArray();
            paramArr = FormUtil.filterNullParam(paramArr);
            HttpUtil.ajaxAsyncJsonPost("/sys/sysMenu/save", paramArr, function(message){
                dialogTip(message);
                if(typeof success == 'function'){
                       success();
                }
            });
        }
        return false;
    }
</script>

</html>