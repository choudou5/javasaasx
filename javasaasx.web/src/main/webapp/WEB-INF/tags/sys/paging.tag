<%@ tag language="java" pageEncoding="UTF-8" description="分页标签，传入page对象， 翻页默认触发searchForm函数" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="page" type="com.choudou5.base.page.PageResult" required="true" description="page对象"%>

<%@ attribute name="searchFormId" type="java.lang.String" required="false" description="searchForm ID， 默认：searchForm"%>
<%@ attribute name="searchFormFunName" type="java.lang.String" required="false" description="自定义搜索函数名， 默认：FormUtil.searchForm"%>
<%@ attribute name="algin" type="java.lang.String" required="false" description="分页条方向: left/right/center 默认：center"%>

<c:set var="algin" value="${empty algin?'center':algin}" />
<c:set var="searchFormId" value="${empty searchFormId?'searchForm':searchFormId}" />
<c:set var="searchFormFunName" value="${empty searchFormFunName?'FormUtil.searchForm':searchFormFunName}" />


<div class="row text-${algin }">
	<ul class="pagination pagination-primary">
		<%--首页--%>
		<c:if test="${page.pageNo ne 1 }">
			<li class="first"><a href="javascript:void(0);" onclick="javascript:${searchFormFunName}('${searchFormId }', 1, '${page.pageSize }');">首页</a></li>
		</c:if>
		<c:if test="${page.pageNo eq 1 }">
			<li class="first disabled"><a href="javascript:void(0);">首页</a></li>
		</c:if>

		<%--上一页 --%>
		<c:if test="${page.hasPre }">
			<li class="previous"><a href="javascript:void(0);" onclick="javascript:${searchFormFunName}('${searchFormId }', '${page.prePage}', '${page.pageSize }');">上一页</a></li>
		</c:if>
		<c:if test="${!page.hasPre }">
			<li class="previous disabled"><a href="javascript:void(0);">上一页</a></li>
		</c:if>


		<c:forEach items="${page.pageRange }" var="pageNum" varStatus="status">
			<c:if test="${pageNum eq page.pageNo}">
				<li class="active"><a href="javascript:void(0);">${page.pageNo }</a></li>
			</c:if>
			<c:if test="${pageNum ne page.pageNo}">
				<li><a href="javascript:void(0);" onclick="javascript:${searchFormFunName}('${searchFormId }','${pageNum}', '${page.pageSize }');">${pageNum }</a></li>
			</c:if>
		</c:forEach>
		<c:if test="${(page.totalPages-page.rangeEnd) > 1}">
			<li><a href="javascript:void(0);">...</a></li>
		</c:if>


		<%--下一页 --%>
		<c:if test="${page.hasNext }">
			<li class="next"><a href="javascript:void(0);" onclick="javascript:${searchFormFunName}('${searchFormId }', '${page.nextPage}', '${page.pageSize }');">下一页</a></li>
		</c:if>
		<c:if test="${!page.hasNext }">
			<li class="next disabled"><a href="javascript:void(0);">下一页</a></li>
		</c:if>

		<%--尾页--%>
		<c:if test="${page.pageNo ne page.totalPages }">
			<li class="last"><a href="javascript:void(0);" onclick="javascript:${searchFormFunName}('${searchFormId }', '${page.totalPages}', '${page.pageSize }');">尾页</a></li>
		</c:if>
		<c:if test="${page.pageNo eq page.totalPages }">
			<li class="last disabled"><a href="javascript:void(0);">尾页</a></li>
		</c:if>

		<li><a href="javascript:void(0);">共&nbsp;${page.totalCount }&nbsp;条</a></li>
	</ul>
</div>