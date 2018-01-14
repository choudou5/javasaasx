<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>

<%@ attribute name="content" type="java.lang.String" required="true" description="消息内容"%>
<%@ attribute name="errorMsg" type="java.lang.String" description="错误消息"%>
<%@ attribute name="type" type="java.lang.String" description="消息类型：info、success、warning、error、loading"%>

<script src="/static/console/js/jquery.min.js"></script>
<c:if test="${not empty content}">
	<c:set var="isError" value="false"/>
	<c:if test="${not empty type}">
		<c:set var="ctype" value="${type}"/>
	</c:if>
	<c:if test="${empty type}">
		<c:set var="isError" value="${fn:indexOf(content,'禁用') ne -1 || fn:indexOf(content,'失败') ne -1 || fn:indexOf(content,'对不起') ne -1 || fn:indexOf(content,'错误') ne -1 || fn:indexOf(content,'有误') ne -1 }"/>
		<c:set var="ctype" value="${isError?'error':'success'}"/>
	</c:if>
	
	<div id="messageBox" class="alert alert-${ctype} alert-block hide">
		<a class="close" data-dismiss="alert" href="#">×</a>
        <h4 class="alert-heading text-center">${content}</h4>
        ${errorMsg }
	</div>
	<script type="text/javascript">
		if("${ctype}" != ""){
			$("#messageBox").show();
			if("${isError}" == "false"){
				//5秒后 自动移除
				setTimeout(function(){
					$("#messageBox").remove();
				}, 5000);
			}
		}
	</script>
</c:if>