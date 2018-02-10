<%@ tag language="java" pageEncoding="UTF-8" description="表格选值" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>

<%@ attribute name="id" type="java.lang.String" required="true" description="ID" %>
<%@ attribute name="name" type="java.lang.String" required="true" description="隐藏域名称" %>
<%@ attribute name="value" type="java.lang.String" required="false" description="隐藏域值" %>
<%@ attribute name="inputClass" type="java.lang.String" required="false" description="输入框样式" %>
<%@ attribute name="placeholder" type="java.lang.String" required="true" description="输入框名称提示" %>
<%@ attribute name="valueTitle" type="java.lang.String" required="false" description="输入框显示值" %>
<%@ attribute name="url" type="java.lang.String" required="true" description="数据地址" %>
<%@ attribute name="onlySetVal" type="java.lang.Boolean" required="false" description="仅仅设值" %>

<%@ attribute name="width" type="java.lang.Integer" required="false" description="弹出窗口宽，若未填写，则按默认显示" %>
<%@ attribute name="height" type="java.lang.Integer" required="false" description="弹出窗口高，若未填写，则按默认显示" %>

<!-- 仅仅设值-->
<c:if test="${onlySetVal}">
    <label id="${id}Label" class="btn-small btn btn-primary" style="vertical-align: bottom;">${placeholder}</label>
</c:if>

<c:if test="${!onlySetVal}">
    <input id="${id}" name="${name}" type="hidden" readonly="readonly" value="${value}" />
    <label id="${id}Label" class="${inputClass}" data-value="${value}">${not empty valueTitle?valueTitle:placeholder}</label>
</c:if>


<script type="text/javascript">

    $("#${id}Label").click(function () {
        var _width = isEmpty("${width}")?600:"${width}";
            _height = isEmpty("${height}")?450:"${height}";
        layerOpenPage('${placeholder}', ctx+'${url}', _width, _height, function(){
            log("init page success");
        });
    });

    function callChooseFun(vals, titles, ext){
        $("#${id}").val(vals);
        $("#${id}Label").text(titles);
        $("#${id}Ext").val(ext);
    }

    function callDictContentChooseFun(vals){
        $("#${id}").val(vals);
    }

    function callTableFieldChooseFun(vals, titles, exts){
        $("#${id}Title").val(titles);
        $("#${id}Ext").val(exts);
    }

</script>

<style type="text/css">
    .input-min-tag,.input-mini-tag,.input-small-tag,.input-medium-tag,.input-xlarge-tag,.input-xxlarge-tag{border:1px solid #ccc;vertical-align:middle;padding:4px 6px;font-size:14px;height:20px;line-height:20px;color:#777;-webkit-border-radius:4px;-moz-border-radius:4px;border-radius:4px}
    .input-min-tag{width:30px;}
    .input-mini-tag{width:90px;}
    .input-small-tag{width:120px;}
    .input-medium-tag {width:163px;}
    .input-xlarge-tag {width: 270px;}
    .input-xxlarge-tag {width:460px;}
</style>