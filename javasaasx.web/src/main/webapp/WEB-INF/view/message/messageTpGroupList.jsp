<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-第三方消息群[列表]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="card">
            <div class="card-content">
                <div class="toolbar">
                    <div class="row">
                        <form:form id="searchForm" modelAttribute="messageTpGroupQueryParam" action="${ctx}/message/messageTpGroup/list" method="post">
                            <div class="col-md-2">
                                <form:select path="messageTpGroupVo.tpType" title="第三方类型" class="selectpicker" data-style="select-with-transition" data-live-search="false">
                                    <form:option value="">第三方类型</form:option>
                                    <form:option value="dingtalk">钉钉</form:option>
                                </form:select>
                            </div>
                            <div class="col-md-2">
                                <form:input type="text" path="messageTpGroupVo.bizType" class="form-control clearable" placeholder=" 业务key"/>
                            </div>
                            <div class="col-md-1">
                                <button type="submit" class="btn btn-twitter"><i class="fa fa-search"></i></button>
                                <input type="hidden" id="pageNo" name="pageBean.pageNo"/>
                                <input type="hidden" id="pageSize" name="pageBean.pageSize" />
                                <input type="hidden" id="orderBy" name="orderBean.orderBy" value="${messageTpGroupQueryParam.orderBean.orderBy}"/>
                                <input type="hidden" id="order" name="orderBean.order" value="${messageTpGroupQueryParam.orderBean.order}"/>
                            </div>
                        </form:form>
                        <div class="col-md-12">
                            <button id="addBtn" onclick="FormUtil.bindFormAddBtn('添加第三方消息群')" data-href="${ctx}/message/messageTpGroup/form" class="btn btn-success btn-simple btn-sm"><i class="fa fa-plus"></i>&nbsp;添加</button>
                            <button onclick="top.addTabToFrame('消息测试', '${ctx}/message/messageTpGroup/test')" class="btn btn-info btn-sm">&nbsp;消息测试</button>
                        </div>
                    </div>
                </div>

                <div class="material-datatables table-responsive">
                    <table id="datatables" class="table table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>第三方类型</th>
                            <th>业务key</th>
                            <th>群组名</th>
                            <th>群主</th>
                            <th>成员</th>
                            <th>创建者</th>
                            <th>创建时间</th>
                            <th>状态</th>
                            <th class="disabled-sorting">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageResult.result}" var="item">
                            <tr>
                                <td data-code="${item.code}">${item.id}</td>
                                <td>${item.tpType}</td>
                                <td>${item.bizType}</td>
                                <td>
                                    <shiro:hasPermission name="message:messageTpGroup:view">
                                        <a href="javascript:;" onclick="dialogOpenPageView('详情', '${ctx}/message/messageTpGroup/view?id=${item.id}');" class="btn btn-simple btn-facebook">${item.name}</a>
                                    </shiro:hasPermission>
                                    <shiro:lacksPermission name="message:messageTpGroup:view">
                                        ${item.name}
                                    </shiro:lacksPermission>
                                </td>
                                <td>${item.ownerId}</td>
                                <td>${item.memberIds}</td>
                                <td>${item.createBy}</td>
                                <td>${fns:formatDateTime(item.createTime)}</td>
                                <td><sys:flagLabel value="${item.status}" field="status"/></td>
                                <td class="text-right">
                                    <shiro:hasPermission name="message:messageTpGroup:delete">
                                        <a href="javascript:;" data-href="${ctx}/message/messageTpGroup/delete?id=${item.id}" class="btn btn-simple btn-danger btn-icon remove"><i class="fa fa-remove"></i></a>
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
<script src="${ctxStatic }/js/biz/message/messageTpGroup.js"></script>
<script type="text/javascript">
    $(function () {
        //构建数据表格
        //buildDataTable();

        /* 纯列表
        //绑定排序
        FormUtil.bindOrder();
        //日期时间范围
        laydate.render({
            elem: '#rangeCreateDate'
            ,type: 'datetime'
            ,max: 0
            ,range: true
        });
        */

    });
</script>
</html>