<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统异常[列表]</title>
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
                        <form:form id="searchForm" modelAttribute="sysExceptionQueryParam" action="${ctx}/log/sysException/list" method="post">
                            <div class="col-md-2">
                                <form:select path="sysExceptionBo.bizModule" title="业务模块" class="selectpicker" data-style="select-with-transition" data-live-search="false">
                                    <form:option value="">业务模块</form:option>
                                </form:select>
                            </div>
                            <div class="col-md-2">
                                <form:input type="text" path="sysExceptionBo.methodName" class="form-control clearable" placeholder=" 方法名"/>
                            </div>
                            <div class="col-md-2">
                                <form:select path="sysExceptionBo.exceptionType" title="异常类型" class="selectpicker" data-style="select-with-transition" data-live-search="false">
                                    <form:option value="">异常类型</form:option>
                                </form:select>
                            </div>
                            <div class="col-md-2">
                                <form:input type="text" path="sysExceptionBo.ip" class="form-control clearable" placeholder=" ip地址"/>
                            </div>
                            <div class="col-md-1">
                                <button type="submit" class="btn btn-twitter"><i class="fa fa-search"></i></button>
                                <input type="hidden" id="pageNo" name="pageBean.pageNo"/>
                                <input type="hidden" id="pageSize" name="pageBean.pageSize" />
                                <input type="hidden" id="orderBy" name="orderBean.orderBy" value="${sysExceptionQueryParam.orderBean.orderBy}"/>
                                <input type="hidden" id="order" name="orderBean.order" value="${sysExceptionQueryParam.orderBean.order}"/>
                            </div>
                        </form:form>
                    </div>
                </div>

                <div class="material-datatables table-responsive">
                    <table id="datatables" class="table table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>业务模块</th>
                            <th>方法名</th>
                            <th>异常类型</th>
                            <th>异常消息</th>
                            <th>ip地址</th>
                            <th>创建者</th>
                            <th>创建时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageResult.result}" var="item">
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.bizModule}</td>
                                <td>${item.methodName}</td>
                                <td>${item.exceptionType}</td>
                                <td>${item.exception}</td>
                                <td>${item.ip}</td>
                                <td>${item.createBy}</td>
                                <td>${fns:formatDateTime(item.createTime)}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <sys:paging page="${pageResult}"/>
            </div>
            <!-- end content-->
        </div>
        <!--  end card  -->
    </div>
</div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<script src="${ctxStatic }/js/biz/log/sysException.js"></script>
<script type="text/javascript">
    $(function () {

        //绑定排序
        FormUtil.bindOrder();
        //日期时间范围
        laydate.render({
            elem: '#rangeCreateDate'
            ,type: 'datetime'
            ,max: 0
            ,range: true
        });

    });
</script>
</html>