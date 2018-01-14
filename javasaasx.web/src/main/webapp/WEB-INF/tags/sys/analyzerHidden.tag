<%@ tag language="java" pageEncoding="UTF-8" description="分词 隐藏 输入框集合" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>

<%@ attribute name="fieldIndex" type="java.lang.Integer" required="true" description="字段 下标"%>
<%@ attribute name="fieldType" type="com.choudoufu.codegen.console.schema.entity.FieldType" required="false" description="字段类型"%>

<input id="analyzer_tokenizerClass" type="hidden" attrname="fields.type.tokenizerClass" name="fields[${fieldIndex }].type.tokenizerClass" value="${fieldType.tokenizerClass}"/>
<input id="analyzer_index_useSmart" type="hidden" attrname="fields.type.index.useSmart" name="fields[${fieldIndex }].type.index.useSmart" value="${fieldType.index.useSmart}"/>
<input id="analyzer_index_code" type="hidden" attrname="fields.type.index.code" name="fields[${fieldIndex }].type.index.code" value="${fieldType.index.code}"/>
<input id="analyzer_index_separator" type="hidden" attrname="fields.type.index.separator" name="fields[${fieldIndex }].type.index.separator" value="${fieldType.index.separator}"/>
<input id="analyzer_index_sqlGroupSymbol" type="hidden" attrname="fields.type.index.sqlGroupSymbol" name="fields[${fieldIndex }].type.index.sqlGroupSymbol" value="${fieldType.index.sqlGroupSymbol}"/>
<input id="analyzer_index_filters" type="hidden" attrname="fields.type.index.filters" name="fields[${fieldIndex }].type.index.filters" value="${fieldType.index.filters}"/>

<input id="analyzer_query_useSmart" type="hidden" attrname="fields.type.query.useSmart" name="fields[${fieldIndex }].type.query.useSmart" value="${fieldType.query.useSmart}"/>
<input id="analyzer_query_code" type="hidden" attrname="fields.type.query.code" name="fields[${fieldIndex }].type.query.code" value="${fieldType.query.code}"/>
<input id="analyzer_query_separator" type="hidden" attrname="fields.type.query.separator" name="fields[${fieldIndex }].type.query.separator" value="${fieldType.query.separator}"/>
<input id="analyzer_query_sqlGroupSymbol" type="hidden" attrname="fields.type.query.sqlGroupSymbol" name="fields[${fieldIndex }].type.query.sqlGroupSymbol" value="${fieldType.query.sqlGroupSymbol}"/>
<input id="analyzer_query_filters" type="hidden" attrname="fields.type.query.filters" name="fields[${fieldIndex }].type.query.filters" value="${fieldType.query.filters}"/>
<a id="chooseAnalyzerBtn" href="javascript:chooseAnalyzerModal(${fieldIndex })" class="mgl-10 ${fieldType.showChoosePlug?'':'hide' }">&nbsp;<i class="icon icon-plus"></i>&nbsp;</a>
<span id="analyzerTag" class="mgl-10 label label-success"><c:if test="${fieldType.showAssemblyTag }"><i class='icon-star'></i></c:if></span>

