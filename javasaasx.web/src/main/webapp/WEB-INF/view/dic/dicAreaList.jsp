<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-[列表]</title>
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
                        <form:form id="searchForm" modelAttribute="dicAreaQueryParam" action="${ctx}/dic/dicArea/list" method="post">
                            <div class="row col-md-12">
                                <div class="col-md-2">
                                    <form:input type="text" path="dicAreaBo.code" class="form-control clearable" placeholder=" 编码"/>
                                </div>
                                <div class="col-md-2">
                                    <form:input type="text" path="dicAreaBo.name" class="form-control clearable" placeholder=" 地区"/>
                                </div>
                                <div class="col-md-2">
                                    <form:select path="dicAreaBo.level" class="form-control">
                                        <form:option value="" label="等级"/>
                                        <form:option value="1" label="省"/>
                                        <form:option value="2" label="市"/>
                                        <form:option value="3" label="区县"/>
                                        <form:option value="4" label="乡镇"/>
                                        <form:option value="5" label="村"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="row col-md-12">
                                <div class="col-md-2">
                                    <form:input type="text" path="dicAreaBo.pinyin" class="form-control clearable" placeholder=" 拼音"/>
                                </div>
                                <div class="col-md-2">
                                    <form:input type="text" path="dicAreaBo.pinyinShort" class="form-control clearable" placeholder=" 短拼音"/>
                                </div>
                                <div class="col-md-2">
                                    <form:input type="text" path="dicAreaBo.pinyinFirstLetter" class="form-control clearable" placeholder=" 拼音首字母"/>
                                </div>
                                <div class="col-md-1">
                                    <button type="submit" class="btn btn-twitter"><i class="fa fa-search"></i></button>
                                    <input type="hidden" id="pageNo" name="pageBean.pageNo"/>
                                    <input type="hidden" id="pageSize" name="pageBean.pageSize" />
                                    <input type="hidden" id="orderBy" name="orderBean.orderBy" value="${dicAreaQueryParam.orderBean.orderBy}"/>
                                    <input type="hidden" id="order" name="orderBean.order" value="${dicAreaQueryParam.orderBean.order}"/>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>

                <div class="material-datatables table-responsive">
                    <table id="datatables" class="table table-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th sort-field="code">地区编码</th>
                            <th>地区名称</th>
                            <th sort-field="level">等级</th>
                            <th>父级编码</th>
                            <th>父级名称</th>
                            <th>经纬度</th>
                            <th>全名</th>
                            <th>拼音</th>
                            <th>短拼音</th>
                            <th>拼音首字母</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageResult.result}" var="item">
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.code}</td>
                                <td>${item.name}</td>
                                <td>
                                    <c:if test="${item.level eq 1}">省</c:if>
                                    <c:if test="${item.level eq 2}">市</c:if>
                                    <c:if test="${item.level eq 3}">区县</c:if>
                                    <c:if test="${item.level eq 4}">乡镇</c:if>
                                    <c:if test="${item.level eq 5}">村</c:if>
                                </td>
                                <td>${item.pcode}</td>
                                <td>${item.pname}</td>
                                <td>${item.geo}</td>
                                <td>${item.fullname}</td>
                                <td>${item.pinyin}</td>
                                <td>${item.pinyinShort}</td>
                                <td>${item.pinyinFirstLetter}</td>
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
<script src="${ctxStatic }/js/biz/dic/dicArea.js"></script>
<script type="text/javascript">
    $(function () {
        //绑定排序
        FormUtil.bindOrder();
    });
</script>
</html>