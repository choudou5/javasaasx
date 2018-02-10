<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/assets"/>
<c:set var="ctxStaticCss" value="${pageContext.request.contextPath}/assets/css/"/>
<c:set var="ctxStaticImg" value="${pageContext.request.contextPath}/assets/img/"/>
<c:set var="ctxStaticPage" value="${pageContext.request.contextPath}/admin/"/>
<c:set var="ossImg" value="http://choudoufu-hd2.oss-cn-shanghai.aliyuncs.com/web-codegen/assets/img/"/>
