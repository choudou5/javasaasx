<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统用户登录记录[列表]</title>
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
                        <form:form id="searchForm" modelAttribute="sysUserLoginHiQueryParam" action="${ctx}/log/sysUserLoginHi/list" method="post">
                            <div class="col-md-2">
                                <form:input type="text" path="sysUserLoginHiBo.account" class="form-control clearable" placeholder=" 账号"/>
                            </div>
                            <div class="col-md-2">
                                <form:input type="text" path="sysUserLoginHiBo.ip" class="form-control clearable" placeholder=" ip地址"/>
                            </div>
                            <div class="col-md-2">
                                <form:select path="sysUserLoginHiBo.clientSource" title="客户端来源" class="selectpicker" data-style="select-with-transition" data-live-search="false">
                                    <form:option value="">客户端来源</form:option>
                                </form:select>
                            </div>
                            <div class="col-md-2">
                                <form:input type="text" path="sysUserLoginHiBo.sysCode" class="form-control clearable" placeholder=" 系统code"/>
                            </div>
                            <div class="col-md-2">
                                <input type="text" id="rangeCreateTime" name="rangeCreateTime" class="form-control" placeholder=" 创建时间范围查询"/>
                            </div>
                            <div class="col-md-2">
                            </div>
                            <div class="col-md-1">
                                <button type="submit" class="btn btn-twitter"><i class="fa fa-search"></i></button>
                                <input type="hidden" id="pageNo" name="pageBean.pageNo"/>
                                <input type="hidden" id="pageSize" name="pageBean.pageSize" />
                                <input type="hidden" id="orderBy" name="orderBean.orderBy" value="${sysUserLoginHiQueryParam.orderBean.orderBy}"/>
                                <input type="hidden" id="order" name="orderBean.order" value="${sysUserLoginHiQueryParam.orderBean.order}"/>
                            </div>
                        </form:form>
                    </div>
                </div>

                <div class="material-datatables table-responsive">
                    <table id="datatables" class="table table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>账号</th>
                            <th>用户id</th>
                            <th>ip地址</th>
                            <th>客户端来源</th>
                            <th>系统code</th>
                            <th>失败原因</th>
                            <th>创建时间</th>
                            <th>状态: 0=失败，1=成功</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageResult.result}" var="item">
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.account}</td>
                                <td>${item.userId}</td>
                                <td>${item.ip}</td>
                                <td>${item.clientSource}</td>
                                <td>${item.sysCode}</td>
                                <td>${item.failReason}</td>
                                <td>${fns:formatDateTime(item.createTime)}</td>
                                <td>${item.status}</td>
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
<script src="${ctxStatic }/js/biz/log/sysUserLoginHi.js"></script>
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