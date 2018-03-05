<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统操作日志[列表]</title>
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
                        <form:form id="searchForm" modelAttribute="sysOperationLogQueryParam" action="${ctx}/sys/sysOperationLog/list" method="post">
                            <div class="col-md-1">
                                <form:select path="sysOperationLogBo.method" class="selectpicker" data-style="select-with-transition">
                                    <form:option value="">方法类型</form:option>
                                    <form:option value="GET">GET</form:option>
                                    <form:option value="POST">POST</form:option>
                                    <form:option value="DELETE">DELETE</form:option>
                                    <form:option value="PUT">PUT</form:option>
                                </form:select>
                            </div>
                            <div class="col-md-1">
                                <form:select path="sysOperationLogBo.optType" class="selectpicker" data-style="select-with-transition">
                                    <form:option value="">操作类型</form:option>
                                    <form:option value="view">查看</form:option>
                                    <form:option value="edit">编辑</form:option>
                                    <form:option value="save">保存</form:option>
                                    <form:option value="delete">删除</form:option>
                                </form:select>
                            </div>
                            <div class="col-md-1">
                                <form:select path="sysOperationLogBo.createBy" class="selectpicker" data-style="select-with-transition" data-live-search="true">
                                    <form:option value="">操作人</form:option>
                                    <c:forEach items="${fns:getUserSelectListData('${sysOperationLogBo.createBy}')}" var="selectBo">
                                        <form:option value="${selectBo.value}">${selectBo.text}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="col-md-2">

                                <form:input type="text" path="sysOperationLogBo.ip" class="form-control" placeholder=" ip地址"/>
                            </div>
                            <div class="col-md-2">
                                <form:input type="text" path="sysOperationLogBo.desc" class="form-control" placeholder=" 操作说明"/>
                            </div>
                            <div class="col-md-2">
                                <input type="text" id="rangeCreateDate" name="rangeCreateDate" value="${rangeCreateDate}" class="form-control" placeholder=" 范围时间"/>
                            </div>
                            <div class="col-md-1">
                                <button type="submit" class="btn btn-twitter"><i class="fa fa-search"></i></button>
                                <input type="hidden" id="pageNo" name="pageBean.pageNo"/>
                                <input type="hidden" id="pageSize" name="pageBean.pageSize" />
                                <input type="hidden" id="orderBy" name="orderBean.orderBy" value="${sysOperationLogQueryParam.orderBean.orderBy}"/>
                                <input type="hidden" id="order" name="orderBean.order" value="${sysOperationLogQueryParam.orderBean.order}"/>
                            </div>
                        </form:form>
                    </div>
                </div>
                <div class="material-datatables table-responsive">
                    <table id="datatables" class="table table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr>
                            <th>说明</th>
                            <th>ip地址</th>
                            <th>请求uri</th>
                            <th sort-field="method">方法</th>
                            <th>操作人</th>
                            <th sort-field="create_time">操作时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageResult.result}" var="item">
                            <tr>
                                <td>${item.desc}</td>
                                <td>${item.ip}</td>
                                <td>${item.requestUri}</td>
                                <td>${item.method}</td>
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