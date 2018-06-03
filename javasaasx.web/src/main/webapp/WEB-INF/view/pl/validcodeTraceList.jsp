<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-验证码记录[列表]</title>
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
                        <form:form id="searchForm" modelAttribute="validcodeTraceQueryParam" action="${ctx}/pl/validcodeTrace/list" method="post">
                            <div class="col-md-1">
                                <button type="submit" class="btn btn-twitter"><i class="fa fa-search"></i></button>
                                <input type="hidden" id="pageNo" name="pageBean.pageNo"/>
                                <input type="hidden" id="pageSize" name="pageBean.pageSize" />
                                <input type="hidden" id="orderBy" name="orderBean.orderBy" value="${validcodeTraceQueryParam.orderBean.orderBy}"/>
                                <input type="hidden" id="order" name="orderBean.order" value="${validcodeTraceQueryParam.orderBean.order}"/>
                            </div>
                        </form:form>
                        <div class="col-md-12">
                            <button id="addBtn" onclick="FormUtil.bindFormAddBtn('添加验证码记录')" data-href="${ctx}/pl/validcodeTrace/form" class="btn btn-success btn-sm"><i class="fa fa-plus"></i>&nbsp;添加</button>
                        </div>
                    </div>
                </div>

                <div class="material-datatables table-responsive">
                    <table id="datatables" class="table table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr>
                            <th class="disabled-sorting">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageResult.result}" var="item">
                            <tr>
                                <td class="text-right">
                                    <shiro:hasPermission name="pl:validcodeTrace:edit">
                                        <a href="javascript:;" onclick="dialogOpenPage('validcodeTraceEdit', '编辑', '${ctx}/pl/validcodeTrace/form?id=${item.id}');" class="btn btn-simple btn-warning btn-icon"><i class="fa fa-edit"></i></a>
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="pl:validcodeTrace:delete">
                                        <a href="javascript:;" data-href="${ctx}/pl/validcodeTrace/delete?id=${item.id}" class="btn btn-simple btn-danger btn-icon remove"><i class="fa fa-remove"></i></a>
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
<script src="${ctxStatic }/js/biz/pl/validcodeTrace.js"></script>
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