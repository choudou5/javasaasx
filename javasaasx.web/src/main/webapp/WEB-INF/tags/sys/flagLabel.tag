<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="value" type="java.lang.String" required="true" description="值"%>
<%@ attribute name="field" type="java.lang.String" description="字段"%>
<%@ attribute name="yesText" type="java.lang.String" description="是"%>
<%@ attribute name="noText" type="java.lang.String" description="否"%>

<c:if test="${field eq 'status'}">
	<c:set var="yesText" value="正常"/>
	<c:set var="noText" value="禁用"/>
</c:if>

<c:if test="${empty yesText}">
	<c:set var="yesText" value="是"/>
</c:if>
<c:if test="${empty noText}">
	<c:set var="noText" value="否"/>
</c:if>

<c:if test="${value eq '1'}">
	<span class="label label-success">${yesText}</span>
</c:if>
<c:if test="${value ne '1'}">
	<span class="label label-danger">${noText}</span>
</c:if>
