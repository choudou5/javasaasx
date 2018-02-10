<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/assets"/>

<%@ attribute name="name" type="java.lang.String" required="true" description="隐藏域名称（ID）"%>
<%@ attribute name="value" type="java.lang.String" required="true" description="隐藏域值（ID）"%>
<%@ attribute name="labelValue" type="java.lang.String" required="true" description="输入框值（Name）"%>

<%@ attribute name="multi" type="java.lang.Boolean" required="false" description="选中类型：radio，checkbox"%>
<%@ attribute name="dialogTitle" type="java.lang.String" required="true" description="弹窗标题"%>
<%@ attribute name="ajaxJsonUrl" type="java.lang.String" required="true" description="异步数据地址"%>
<%@ attribute name="extId" type="java.lang.String" required="false" description="排除掉的编号（不能选择的编号）"%>
<%@ attribute name="notAllowSelectType" type="java.lang.String" required="false" description="不能选中的类型"%>
<%@ attribute name="disabledChoose" type="java.lang.Boolean" required="false" description="禁用选择"%>
<%@ attribute name="cssStyle" type="java.lang.String" required="false" description="style属性值"%>

<%-- 默认值 --%>
<c:set var="inputId" value="${name}Id"/>
<c:set var="labelId" value="${name}LabelName"/>

<div class="">
	<input id="${inputId}" name="${name}" class="${cssClass}" type="hidden" value="${value}"/>
	<input id="${labelId}" name="${labelId}" placeholder="${dialogTitle}" type="text" value="${labelValue}" ${disabledChoose?'disabled':''} class="form-control ${cssClass}" style="${cssStyle}"/>
</div>
<script type="text/javascript" src="${ctxStatic }/jquery-plugs/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$("#${labelId}").click(function(){
		// 是否限制选择，如果限制，设置为disabled
		if ($("#${labelId}").attr("disabled") == "disabled"){
			return true;
		}
		//弹出页面
		var iframeId = "iframeTree_${name}";
		var url = "/common/chooseTreeValue?ajaxJsonUrl=${ajaxJsonUrl}&multi=${multi}&extId=${extId}&notAllowSelectType=${notAllowSelectType}";
		dialogOpenPage(iframeId, "${dialogTitle}", url, 500, 450, function(){
			//获取 选择值
			var iframe = dialogGetIFrame(iframeId);
			var chooseValueMap = iframe.contentWindow.callChooseValueMap();
			log(chooseValueMap);
			//设值
			var ids = new Array();
			var titles = new Array();
			for(var key in chooseValueMap){
				var obj = chooseValueMap[key];
				ids.push(obj.id);
				titles.push(obj.title);
			}
			$("#${inputId}").val(ids.join(","));
			$("#${labelId}").val(titles.join(","));
			dialogCloseIFrame(iframeId);
		});
	});
</script>