<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="showType" type="java.lang.String" description="类型"%>
<%@ attribute name="value" type="java.lang.String" required="true" description="值"%>

<c:if test="${empty showType}">
	<c:set var="showType" value="label"/>
</c:if>

<c:if test="${showType eq 'label'}">
	<c:if test="${value eq '1'}">
		<span class="text-info">♂</span>
	</c:if>
	<c:if test="${value eq '2'}">
		<span class="text-rose">♀</span>
	</c:if>
</c:if>
