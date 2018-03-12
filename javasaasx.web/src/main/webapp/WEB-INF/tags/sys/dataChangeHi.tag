<%@ tag language="java" pageEncoding="UTF-8" description="数据变更历史" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/assets"/>

<%@ attribute name="bizKey" type="java.lang.String" required="true" description="业务Key"%>
<%@ attribute name="bizId" type="java.lang.String" required="true" description="业务Id"%>
<%@ attribute name="permission" type="java.lang.String" required="true" description="权限"%>

<shiro:hasPermission name="${permission}">
	<a href="javascript:;" title="查看变更记录" class="btn btn-success" onclick="dialogOpenPageView('查看历史', '${ctx}/log/sysDataChangeLog?bizKey=${bizKey}&bizId=${bizId}')">历史</a>
</shiro:hasPermission>


