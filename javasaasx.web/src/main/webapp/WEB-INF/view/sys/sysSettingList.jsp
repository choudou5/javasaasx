<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统设置[列表]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
<div class="container-fluid">

    <div class="row">
        <div class="col-md-123">
            <div class="card">
                <div class="card-content">
                    <div class="card-header">
                        <h4 class="card-title">快捷设置</h4>
                    </div>
                    <div class="card-content">
                        <div class="row">
                            <div class="col-md-4">
                                <ul class="nav nav-pills nav-pills-rose nav-stacked">
                                    <li class="active">
                                        <a href="#tab1" data-toggle="tab">开发者设置</a>
                                    </li>
                                    <li>
                                        <a href="#tab2" data-toggle="tab">阿里OSS</a>
                                    </li>
                                    <li>
                                        <a href="#tab3" data-toggle="tab">企业钉钉</a>
                                    </li>
                                    <li>
                                        <a href="#tab4" data-toggle="tab">阿里大鱼</a>
                                    </li>
                                    <li>
                                        <a href="#tab5" data-toggle="tab">邮箱</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="col-md-8">
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tab1">
                                        <div class="col-md-3">
                                            <div class="togglebutton">
                                                <label> <input type="checkbox" checked>调试模式</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="tab2">
                                        <div class="col-md-3">
                                            <input id="" type="text" placeholder="corpId"/>
                                            <input id="" type="text" placeholder="corpSecret"/>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="tab3">
                                        Completely synergize resource taxing relationships via premier niche markets. Professionally cultivate one-to-one customer service with robust ideas.
                                        <br />
                                        <br />Dynamically innovate resource-leveling customer service for state of the art customer service.
                                    </div>
                                    <div class="tab-pane" id="tab4">
                                        <div class="col-md-3">
                                            <input id="" type="text" placeholder="accessKeyId"/>
                                            <input id="" type="text" placeholder="accessKeySecret"/>
                                            <input id="" type="text" placeholder="signName"/>

                                        </div>
                                    </div>
                                    <div class="tab-pane" id="tab5">
                                        <div class="col-md-3">
                                            <input id="" type="text" placeholder=" 系统管理员邮箱"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="card">
            <div class="card-content">
                <div class="toolbar">
                    <div class="row">
                        <div class="col-md-12">
                            <button id="addBtn" onclick="FormUtil.bindFormAddBtn('添加系统设置')" data-href="${ctx}/sys/sysSetting/form" class="btn btn-success btn-sm"><i class="fa fa-plus"></i>&nbsp;添加</button>
                        </div>
                    </div>
                </div>

                <div class="material-datatables table-responsive">
                    <table id="datatables" class="table table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>类型code</th>
                            <th>code</th>
                            <th>名称</th>
                            <th>值</th>
                            <th>备注</th>
                            <th>预留字段1</th>
                            <th>预留字段2</th>
                            <th>预留字段3</th>
                            <th>创建者</th>
                            <th>创建时间</th>
                            <th>状态</th>
                            <th class="disabled-sorting">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageResult.result}" var="item">
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.typeCode}</td>
                                <td>${item.code}</td>
                                <td>
                                    <shiro:hasPermission name="sys:sysSetting:view">
                                        <a href="javascript:;" onclick="dialogOpenPageView('详情', '${ctx}/sys/sysSetting/view?id=${item.id}');" class="btn btn-simple btn-facebook">${item.name}</a>
                                    </shiro:hasPermission>
                                    <shiro:lacksPermission name="sys:sysSetting:view">
                                        ${item.name}
                                    </shiro:lacksPermission>
                                </td>
                                <td>${item.value}</td>
                                <td>${item.remark}</td>
                                <td>${item.ext1}</td>
                                <td>${item.ext2}</td>
                                <td>${item.ext3}</td>
                                <td>${item.createBy}</td>
                                <td>${fns:formatDateTime(item.createTime)}</td>
                                <td>
                                    ${item.status}<sys:flagLabel value="${item.status}"/>
                                </td>
                                <td class="text-right">
                                    <shiro:hasPermission name="sys:sysSetting:edit">
                                        <a href="javascript:;" onclick="dialogOpenPage('sysSettingEdit', '编辑', '${ctx}/sys/sysSetting/form?id=${item.id}');" class="btn btn-simple btn-warning btn-icon"><i class="fa fa-edit"></i></a>
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="sys:sysSetting:delete">
                                        <a href="javascript:;" data-href="${ctx}/sys/sysSetting/delete?id=${item.id}" class="btn btn-simple btn-danger btn-icon remove"><i class="fa fa-remove"></i></a>
                                    </shiro:hasPermission>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <%-- <sys:paging page="${pageResult}"/> --%>
            </div>
            <!-- end content-->
        </div>
        <!--  end card  -->
    </div>
</div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<script src="${ctxStatic }/js/biz/sys/sysSetting.js"></script>
<script type="text/javascript">
    $(function () {
        //构建数据表格
        buildDataTable();
    });
</script>
</html>