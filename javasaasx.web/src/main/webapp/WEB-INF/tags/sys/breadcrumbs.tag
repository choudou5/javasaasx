<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="currLevel" type="java.lang.Integer" required="true" description="当前等级"%>
<%@ attribute name="secondLevelTitle" type="java.lang.String" required="false" description="二级标题"%>
<%@ attribute name="secondLevelView" type="java.lang.String" required="false" description="二级跳转视图"%>
<%@ attribute name="threeLevelTitle" type="java.lang.String" required="false" description="三级标题"%>
<%@ attribute name="threeLevelView" type="java.lang.String" required="false" description="三级跳转视图"%>

<!--breadcrumbs-->
<div id="content-header">
   <div id="breadcrumb">
   	<a href="${ctx }/console/page?path=/index" title="返回首页" class="tip-bottom"><i class="icon-home"></i> 首页</a>
   	<c:if test="${not empty secondLevelTitle}">
   		<a href="${empty secondLevelView ?'javascript:;':secondLevelView}" class="${currLevel eq 2?'current':'tip-bottom' }" data-original-title="">${secondLevelTitle }</a>
   	</c:if>
   	<c:if test="${not empty threeLevelTitle}">
   		<a href="${empty threeLevelView ?'javascript:;':threeLevelView}" class="${currLevel eq 3?'current':'tip-bottom' }" data-original-title="">${threeLevelTitle }</a>
   	</c:if>
   </div>
</div>
<!--End-breadcrumbs-->