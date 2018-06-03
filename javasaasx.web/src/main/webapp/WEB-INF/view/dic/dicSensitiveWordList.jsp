<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-敏感词库[列表]</title>
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
                        <form:form id="searchForm" modelAttribute="dicSensitiveWordQueryParam" action="${ctx}/dic/dicSensitiveWord/list" method="post">
                            <div class="col-md-2">
                                <form:input type="text" path="dicSensitiveWordVo.word" name="rangeWord" class="form-control clearable" placeholder=" 敏感词"/>
                            </div>
                            <div class="col-md-1">
                                <button type="submit" class="btn btn-twitter"><i class="fa fa-search"></i></button>
                                <input type="hidden" id="pageNo" name="pageBean.pageNo"/>
                                <input type="hidden" id="pageSize" name="pageBean.pageSize" />
                                <input type="hidden" id="orderBy" name="orderBean.orderBy" value="${dicSensitiveWordQueryParam.orderBean.orderBy}"/>
                                <input type="hidden" id="order" name="orderBean.order" value="${dicSensitiveWordQueryParam.orderBean.order}"/>
                            </div>
                        </form:form>
                        <div class="col-md-12">
                            <button id="addBtn" onclick="FormUtil.bindPromptAddBtn('添加敏感词库')" data-href="${ctx}/dic/dicSensitiveWord/save" class="btn btn-success btn-simple btn-sm"><i class="fa fa-plus"></i>&nbsp;添加</button>
                            <button onclick="dialogOpenPageView('测试敏感词', '${ctx}/viewPage/dic/dicSensitiveWordTest')" class="btn btn-info btn-sm"><i class="fa fa-search-plus"></i>&nbsp;测试敏感词</button>
                        </div>
                    </div>
                </div>

                <div class="material-datatables table-responsive">
                    <table id="datatables" class="table table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th sort-field="word">敏感词</th>
                            <th>创建人</th>
                            <th sort-field="create_time">创建时间</th>
                            <th class="disabled-sorting">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageResult.result}" var="item">
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.word}</td>
                                <td>${item.createBy}</td>
                                <td>${fns:formatDateTime(item.createTime)}</td>
                                <td class="text-right">
                                    <shiro:hasPermission name="dic:dicSensitiveWord:delete">
                                        <a href="javascript:;" data-href="${ctx}/dic/dicSensitiveWord/delete?id=${item.id}" class="btn btn-simple btn-danger btn-icon remove"><i class="fa fa-remove"></i></a>
                                    </shiro:hasPermission>
                                </td>
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
    });
</script>
</html>