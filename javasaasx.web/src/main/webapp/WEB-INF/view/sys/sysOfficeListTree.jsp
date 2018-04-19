<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统机构</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-content">
                    <div class="row">
                        <!-- left -->
                        <div class="col-sm-2">
                            <div class="card-content pd-10">
                                <p><a href="javascript:;" onclick="synData()"><i class="fa fa-refresh"></i>&nbsp;同步通讯录</a></p>
                                <h4 class="card-title ">成员</h4>
                                <p><a href="" class="text-black"><i class="fa fa-user"></i>&nbsp;所有成员</a></p>
                                <p><a href="" class="text-black"><i class="fa fa-user"></i>&nbsp;停用的成员</a></p>
                                <h4 class="card-title">机构</h4>
                                <a href="javascript:;" onclick="FormUtil.bindFormAddBtn('添加成员')" data-href="${ctx}/sys/sysUser/form"><i class="fa fa-plus"></i>&nbsp;创建部门</a>



                                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                                    <c:forEach items="${leftDataList}" var="leftData" varStatus="vStatus">
                                        <c:set var="headingId" value="heading${vStatus.index}"/>
                                        <c:set var="collapseId" value="collapse${vStatus.index}"/>
                                        <c:if test="${leftData.key == 'text'}">
                                            <div class="panel panel-default">
                                                <div class="panel-heading" role="tab" id="${headingId}">
                                                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#${collapseId}" aria-expanded="false" aria-controls="${collapseId}">
                                                        <h4 class="panel-title">${leftData.value}<i class="fa fa-chevron-down"></i></h4>
                                                    </a>
                                                </div>
                                                <div id="${collapseId}" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="${headingId}">
                                                    <div class="panel-body">
                                                     <c:if test="${not empty leftDataList['children']}">
                                                         <sys:treePanelGroup leftDataList="${leftDataList['children']}" dex="${vStatus.index}"/>
                                                     </c:if>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </div>
                                <%--
                                <div class="material-datatables">
                                    <input type="text" class="form-control clearable input-sm" id="filter" placeholder="搜索...">
                                    <div class="form-group scroll-y h-max-580 h-min-450">
                                        <table id="leftDatatables" class="table table-bordered table-hover"  data-filter="#filter" data-page-size="100" cellspacing="0" width="100%" style="width:100%">
                                            <tbody>
                                            <c:forEach items="${leftDataList}" var="dataItem">
                                                <tr>
                                                    <td onclick="ajaxRightDataTable('${dataItem.value}')" title="${dataItem.text}"><a href="javascript:;">${dataItem.value}</a></td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                --%>
                            </div>
                        </div>
                        <!-- left end -->

                        <!-- right -->
                        <div class="col-sm-10">
                            <div class="row col-sm-12 card-title">
                                <div class="col-sm-3">
                                    xxx . 成员 <span>${fn}</span>
                                </div>
                                <div class="col-sm-3">
                                    <a href="javascript:;" class="text-link" id="addBtn" onclick="FormUtil.bindFormAddBtn('添加成员')" data-href="${ctx}/sys/sysUser/form"><i class="fa fa-plus"></i>&nbsp;添加成员</a>
                                </div>
                            </div>
                            <div class="row col-sm-12">
                                <form id="inputForm" class="form-horizontal" onsubmit="return ajaxSubmitForm()">
                                    <div class="material-datatables table-responsive">
                                        <table id="datatables" class="table table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%; max-height: 600px;">
                                            <thead>
                                            <tr>
                                                <th>姓名</th>
                                                <th>手机</th>
                                                <th>角色</th>
                                                <th>最后登陆ip</th>
                                                <th>最后登陆时间</th>
                                                <th>备注信息</th>
                                                <th>状态</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${list}" var="item">
                                                <tr>
                                                    <td>
                                                        <shiro:lacksPermission name="sys:sysUser:view">
                                                            <a href="javascript:;" onclick="dialogOpenPageView('详情', '${ctx}/sys/sysUser/view?id=${item.id}');" class="btn btn-simple btn-facebook">${item.name}</a>
                                                        </shiro:lacksPermission>
                                                        <shiro:hasPermission name="sys:sysUser:view">
                                                            ${item.name}
                                                        </shiro:hasPermission>
                                                    </td>
                                                    <td>${item.mobile} </td>
                                                    <td>${item.loginIp} </td>
                                                    <td>${item.loginTime} </td>
                                                    <td>${item.position} </td>
                                                    <td>${item.remarks} </td>
                                                    <td>
                                                        <c:if test="${item.status eq 0}">
                                                            <span class="label label-danger">禁用</span>
                                                        </c:if>
                                                        <c:if test="${item.status eq 1}">
                                                            <span class="label label-success">正常</span>
                                                        </c:if>
                                                        <c:if test="${item.status eq 2}">
                                                            <span class="label label-inverse">离职</span>
                                                        </c:if>
                                                    </td>
                                                    <td class="text-right">
                                                        <shiro:hasPermission name="sys:sysUser:edit">
                                                            <a href="javascript:;" onclick="dialogOpenPage('sysUserEdit', '编辑', '${ctx}/sys/sysUser/form?id=${item.id}');" class="btn btn-simple btn-warning btn-icon"><i class="fa fa-edit"></i></a>
                                                        </shiro:hasPermission>
                                                        <shiro:hasPermission name="sys:sysUser:delete">
                                                            <a href="javascript:;" data-href="${ctx}/sys/sysUser/delete?id=${item.id}" class="btn btn-simple btn-danger btn-icon remove"><i class="fa fa-remove"></i></a>
                                                        </shiro:hasPermission>
                                                    </td>
                                                </tr>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
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
</body>
<%@include file="/include/scriptLib.jsp" %>
<%@include file="/include/validScriptLib.jsp" %>
<script src="${ctxStatic }/jquery-plugs/footable.all.min.js"></script>
<script src="${ctxStatic }/js/biz/sys/sysOffice.js"></script>
<script type="text/javascript">
    $(function () {
        $('.card .material-datatables label').addClass('form-group');
        $("#leftDatatables").footable();
        tbl.bingdTrMenuActive("#leftDatatables");
    });
</script>

<script type="application/javascript">
    function synData(){
        var dex = dialogTipText("正在同步中...", 8000);
        var url = "/sys/data/synData";
        HttpUtil.ajaxAsyncJsonPost(url, {}, function(message){
            dialogClose(dex);
            dialogTip(message);
        });
    }

</script>

</html>