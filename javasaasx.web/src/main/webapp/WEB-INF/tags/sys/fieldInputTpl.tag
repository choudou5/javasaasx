<%@ tag language="java" pageEncoding="UTF-8" description="字段 输入模板" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>

<%@ attribute name="fieldIndex" type="java.lang.Integer" required="true" description="字段 下标"%>
<%@ attribute name="schemaField" type="com.choudoufu.codegen.console.schema.entity.SolrField" required="false" description="字段对象"%>
<%@ attribute name="fieldName" type="java.lang.String" required="false" description="字段名"%>
<%@ attribute name="fieldLabel" type="java.lang.String" required="false" description="字段描述"%>
<%@ attribute name="fieldDefType" type="java.lang.String" required="false" description="字段默认类型"%>

<%@ attribute name="fieldIndexed" type="java.lang.Boolean" required="false" description="字段 是否被索引"%>
<%@ attribute name="fieldStored" type="java.lang.Boolean" required="false" description="字段 是否被存储"%>
<%@ attribute name="fieldRequired" type="java.lang.Boolean" required="false" description="字段 是否必填"%>
<%@ attribute name="fieldIsListShow" type="java.lang.Boolean" required="false" description="字段 是否列表展示"%>

<%@ attribute name="canDel" type="java.lang.Boolean" required="false" description="是否能删除"%>

<c:set var="isNew" value="${empty schemaField}" />
<c:set var="schemaFieldType" value="${schemaField.type}" />
<c:set var="fieldTypes" value="${fns:getFieldTypeArray()}" />

<td>${fieldIndex+1}</td>
<td>
  <input class="required isVariable" value="${fieldName }" type="text" attrname="fields.name" name="fields[${fieldIndex }].name" placeholder="字母 或 下划线 组成" maxlength="30" /></td>
<td>
  <input class="span10" type="text" value="${fieldLabel }" attrname="fields.label" name="fields[${fieldIndex }].label" placeholder="简单描述" name=""  maxlength="20" /></td>
<td>
  <select id="selectType" attrname="fields.type.name" name="fields[${fieldIndex }].type.name"  onchange="changeSelectType(${fieldIndex })">
      <c:forEach var="fieldType" items="${fieldTypes }">
      	<option type="${fieldType.type }" classz="${fieldType.classz }" value="${fieldType.value }" <c:if test="${fieldDefType eq fieldType.value || schemaField.type.name eq fieldType.value}">selected="selected"</c:if>>${fieldType.explain }</option>
      </c:forEach>
  </select>
</td>
<td>
  <div id="analyzerDiv">
    <input id="analyzer_tokenizerClass" type="hidden" attrname="fields.type.tokenizerClass" name="fields[${fieldIndex }].type.tokenizerClass" value="${schemaFieldType.tokenizerClass}"/>
	<input id="analyzer_index_useSmart" type="hidden" attrname="fields.type.index.useSmart" name="fields[${fieldIndex }].type.index.useSmart" value="${schemaFieldType.index.useSmart}"/>
	<input id="analyzer_index_code" type="hidden" attrname="fields.type.index.code" name="fields[${fieldIndex }].type.index.code" value="${schemaFieldType.index.code}"/>
	<input id="analyzer_index_separator" type="hidden" attrname="fields.type.index.separator" name="fields[${fieldIndex }].type.index.separator" value="${schemaFieldType.index.separator}"/>
	<input id="analyzer_index_sqlGroupSymbol" type="hidden" attrname="fields.type.index.sqlGroupSymbol" name="fields[${fieldIndex }].type.index.sqlGroupSymbol" value="${schemaFieldType.index.sqlGroupSymbol}"/>
	<input id="analyzer_index_filters" type="hidden" attrname="fields.type.index.filters" name="fields[${fieldIndex }].type.index.filters" value="${schemaFieldType.index.filters}"/>
	
	<input id="analyzer_query_useSmart" type="hidden" attrname="fields.type.query.useSmart" name="fields[${fieldIndex }].type.query.useSmart" value="${schemaFieldType.query.useSmart}"/>
	<input id="analyzer_query_code" type="hidden" attrname="fields.type.query.code" name="fields[${fieldIndex }].type.query.code" value="${schemaFieldType.query.code}"/>
	<input id="analyzer_query_separator" type="hidden" attrname="fields.type.query.separator" name="fields[${fieldIndex }].type.query.separator" value="${schemaFieldType.query.separator}"/>
	<input id="analyzer_query_sqlGroupSymbol" type="hidden" attrname="fields.type.query.sqlGroupSymbol" name="fields[${fieldIndex }].type.query.sqlGroupSymbol" value="${schemaFieldType.query.sqlGroupSymbol}"/>
	<input id="analyzer_query_filters" type="hidden" attrname="fields.type.query.filters" name="fields[${fieldIndex }].type.query.filters" value="${schemaFieldType.query.filters}"/>
	<a id="chooseAnalyzerBtn" href="javascript:chooseAnalyzerModal(${fieldIndex })" class="mgl-10 ${schemaFieldType.showChoosePlug?'':'hide' }">&nbsp;<i class="icon icon-plus"></i>&nbsp;</a>
	<span id="analyzerTag" class="mgl-10 label label-success"><c:if test="${schemaFieldType.showAssemblyTag }"><i class='icon-star'></i></c:if></span>
  </div>
</td>

<td><input type="checkbox" attrname="fields.indexed" name="fields[${fieldIndex }].indexed" <c:if test="${schemaField.indexed || fieldIndexed}">checked="checked"</c:if> value="true" /></td>
<td><input type="checkbox" attrname="fields.stored" name="fields[${fieldIndex }].stored"  <c:if test="${schemaField.stored || fieldStored }">checked="checked"</c:if> value="true" /></td>
<td><input type="checkbox" attrname="fields.required" name="fields[${fieldIndex }].required" <c:if test="${schemaField.required || fieldRequired}">checked="checked"</c:if> value="true" /></td>
<td><input type="checkbox" attrname="fields.multiValued" name="fields[${fieldIndex }].multiValued" <c:if test="${schemaField.multiValued }">checked="checked"</c:if> value="true" /></td>
<td><input type="checkbox" attrname="fields.isListShow" name="fields[${fieldIndex }].isListShow" <c:if test="${schemaField.isListShow || fieldIsListShow}">checked="checked"</c:if> value="true" /></td>
<td><input type="checkbox" attrname="fields.isListSearch" name="fields[${fieldIndex }].isListSearch" <c:if test="${schemaField.isListSearch }">checked="checked"</c:if> value="true" /></td>
<td><input type="radio" attrname="primaryNo" value="${fieldIndex }" name="primaryNo"  class="required" <c:if test="${schema.primaryNo eq fieldIndex}">checked="checked"</c:if> /></td>
	            
<td>
	<c:if test="${empty canDel || canDel || !isNew}">
		<a href="javascript:void(0);" onclick="removeFieldRow(this)">删除</a>&nbsp;&nbsp;
		<a href="javascript:void(0);" onclick="moveRowUp(this, 'tr')" title="上移"><i class="icon-caret-up icon-2x"></i></a>&nbsp;&nbsp;
		<a href="javascript:void(0);" onclick="moveRowDown(this, 'tr')" title="下移"><i class="icon-caret-down icon-2x"></i></a>
	</c:if>
</td>
            

