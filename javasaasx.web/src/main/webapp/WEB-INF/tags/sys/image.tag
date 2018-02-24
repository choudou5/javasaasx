<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="showType" type="java.lang.String" description="类型"%>
<%@ attribute name="url" type="java.lang.String" required="true" description="值"%>

<c:if test="${empty showType}">
	<c:set var="showType" value="small"/>
</c:if>

<c:if test="${not empty url and showType eq 'small'}">
	<img src="${url}" class="img-${showType}" />
</c:if>
