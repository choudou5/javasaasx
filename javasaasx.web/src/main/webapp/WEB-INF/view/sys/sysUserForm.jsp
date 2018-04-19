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
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card" style="margin: 10px 0;">
                    <form:form id="inputForm" cssClass="form-horizontal" modelAttribute="sysUserBo" action="" method="POST">
                        <form:hidden path="id"/>
                        <div class="card-content">
                            <div class="form-group label-floating">
                                <form:input path="name" class="form-control" required="true" placeholder="姓名 *"/>
                            </div>
                            <div class="form-group label-floating">
                                <form:input path="englishName" class="form-control" required="true" placeholder="英文名 *"/>
                            </div>
                            <div class="form-group label-floating">
                                <form:password path="password" required="true" class="form-control" placeholder="密码 *"/>
                            </div>
                            <div class="form-group label-floating">
                                <form:input path="mobile" class="form-control" placeholder="手机"/>
                            </div>
                            <div class="form-group label-floating">
                                <form:input path="phone" class="form-control" placeholder="电话"/>
                            </div>
                            <div class="form-group label-floating">
                                <form:input path="email" class="form-control" placeholder="邮箱"/>
                            </div>
                            <div class="form-group label-floating">
                                <form:input path="position" class="form-control" placeholder="职位"/>
                            </div>
                            <div class="form-group label-floating">
                                <form:input path="remarks" class="form-control" placeholder="备注"/>
                            </div>

                            <div class="form-group label-floating">
                                <div class="togglebutton">
                                    <span>管理员:</span>
                                    <label>
                                        <form:checkbox path="isAdmin" value="1" />
                                    </label>
                                    <span>老板:</span>
                                    <label>
                                        <form:checkbox path="isBoss" checked="checked" value="1" />
                                    </label>
                                </div>
                            </div>
                            <div class="form-group label-floating">
                                <span>性别:</span>
                                <div class="radio checkbox-inline">
                                    <label>
                                        <input type="radio" name="gender" value="1">男
                                    </label>
                                </div>
                                <div class="radio checkbox-inline">
                                    <label>
                                        <input type="radio" name="gender" value="2">女
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