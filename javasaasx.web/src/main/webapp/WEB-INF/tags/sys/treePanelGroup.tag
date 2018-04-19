<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<%@ attribute name="leftDataList" type="java.util.ArrayList" required="true" description=""%>
<%@ attribute name="dex" type="java.lang.String" required="true" description=""%>
<fmt:parseNumber var="dex" value="${dex}"/>
<c:set var="dex" value="${dex+1}"/>

<div class="panel-group" id="accordion_${dex}" role="tablist" aria-multiselectable="true" style="margin-left: ${dex*5}px;margin-bottom:10px;">
	<c:forEach items="${leftDataList}" var="leftData" varStatus="vStatus">
		<c:set var="headingId" value="heading${vStatus.index}_${dex}"/>
		<c:set var="collapseId" value="collapse${vStatus.index}_${dex}"/>
		<div class="panel panel-default">
			<div class="panel-heading" role="tab" id="${headingId}" style="padding-top: 8px;">
				<a role="button" data-toggle="collapse" data-parent="#accordion_${dex}" href="#${collapseId}" aria-expanded="false" aria-controls="${collapseId}">
					<h4 class="panel-title">.&nbsp;${leftData['text']}
						<c:if test="${not empty leftData['children']}">
							<i class="fa fa-chevron-down"></i>
						</c:if>
					</h4>
				</a>
			</div>
			<c:if test="${not empty leftData['children']}">
				<div id="${collapseId}" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="${headingId}">
					<div class="panel-body">
						<sys:treePanelGroup leftDataList="${leftData['children']}" dex="${dex}"/>
					</div>
				</div>
			</c:if>
		</div>
	</c:forEach>
</div>