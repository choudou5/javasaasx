<%@ tag language="java" pageEncoding="UTF-8" description="分页标签，传入page对象， 翻页默认触发searchForm函数" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="page" type="com.choudoufu.codegen.common.page.Page" required="true" description="page对象"%>
<%@ attribute name="searchFormId" type="java.lang.String" required="false" description="searchForm ID"%>
<%@ attribute name="algin" type="java.lang.String" required="false" description="分页条方向: left/right"%>

<c:set var="algin" value="${empty algin?'left':algin}" />
<c:set var="searchFormId" value="${empty searchFormId?'searchForm':searchFormId}" />

<div class="ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix" style="padding: 10px 0px;">
	<div id="" class="dataTables_paginate fg-buttonset ui-buttonset fg-buttonset-multi ui-buttonset-multi paging_full_numbers text-${algin }">
		
		<%--首页--%>
		<c:if test="${page.pageNo ne 1 }">
			<a tabindex="0" id="DataTables_Table_0_first" onclick="javascript:searchForm('${searchFormId }', 1, '${page.pageSize }');" class="first fg-button ui-button ui-state-default">首页</a>
		</c:if>
		<c:if test="${page.pageNo eq 1 }">
			<a tabindex="0" id="DataTables_Table_0_first" class="first fg-button ui-button ui-state-default ui-state-disabled">首页</a>
		</c:if>
		
		<%--上一页 --%>
		<c:if test="${page.hasPre }">
			<a tabindex="0" id="DataTables_Table_0_previous" onclick="javascript:searchForm('${searchFormId }','${page.prePage}', '${page.pageSize }');" class="previous fg-button ui-button ui-state-default">上一页</a>
		</c:if>
		<c:if test="${!page.hasPre }">
			<a tabindex="0" id="DataTables_Table_0_previous" class="previous fg-button ui-button ui-state-default ui-state-disabled">上一页</a>
		</c:if>
		
		<span>
			<c:forEach items="${page.pageRange }" var="pageNum" varStatus="status">
				<c:if test="${pageNum eq page.pageNo}">
					<a tabindex="0" class="fg-button ui-button ui-state-default ui-state-disabled">${page.pageNo }</a>
				</c:if>
				<c:if test="${pageNum ne page.pageNo}">
					<a tabindex="0" onclick="javascript:searchForm('${searchFormId }','${pageNum}', '${page.pageSize }');" class="fg-button ui-button ui-state-default">${pageNum }</a>
				</c:if>
			</c:forEach>
			<c:if test="${(page.totalPages-page.rangeEnd) > 1}">
				<span class="fg-button ui-button ui-state-default">...</span>
			</c:if>
		</span>
		

		<%--下一页 --%>
		<c:if test="${page.hasNext }">
			<a tabindex="0" id="DataTables_Table_0_next" onclick="javascript:searchForm('${searchFormId }','${page.nextPage}', '${page.pageSize }');" class="next fg-button ui-button ui-state-default">下一页</a>
		</c:if>
		<c:if test="${!page.hasNext }">
			<a tabindex="0" id="DataTables_Table_0_next" class="next fg-button ui-button ui-state-default ui-state-disabled">下一页</a>
		</c:if>
		
		<%--尾页--%>
		<c:if test="${page.pageNo ne page.totalPages }">
			<a tabindex="0" id="DataTables_Table_0_last" onclick="javascript:searchForm('${searchFormId }','${page.totalPages}', '${page.pageSize }');" class="last fg-button ui-button ui-state-default">尾页</a>
		</c:if>
		<c:if test="${page.pageNo eq page.totalPages }">
			<a tabindex="0" id="DataTables_Table_0_last" class="last fg-button ui-button ui-state-default ui-state-disabled">尾页</a>
		</c:if>
		
		<span>
			&nbsp;&nbsp;共&nbsp;${page.totalCount }&nbsp;条
		</span>
	</div>
</div>