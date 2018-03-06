/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.codegen.model;


import cn.org.rapid_framework.generator.util.ArrayHelper;
import cn.org.rapid_framework.generator.util.StringHelper;
import cn.org.rapid_framework.generator.util.typemapping.DatabaseDataTypesUtils;
import com.choudou5.javasaasx.base.bean.AbstractBasePo;
import com.choudou5.javasaasx.codegen.GeneratorMain;

/**
 * @Name：生成表字段样式
 * @Author：xuhaowen
 * @Date：2018-01-18
 */
public class GenTableColumnStyle extends AbstractBasePo {

    /**
     * 数据库字段：table 表
     */
    private String table;
    /**
     * 数据库字段：column 字段
     */
    private String column;
    /**
     * 数据库字段：desc 字段描述
     */
    private String desc;
    /**
     * 数据库字段：field_name 字段名
     */
    private String fieldName;
    /**
     * 数据库字段：fieldType 字段类型
     */
    private String fieldType;
    /**
     * 数据库字段：is_insert 是否为插入字段
     */
    private String isInsert;
    /**
     * 数据库字段：is_edit 是否编辑字段: 0=否，1=是
     */
    private String isEdit;
    /**
     * 数据库字段：is_list 是否列表字段: 0=否，1=是
     */
    private String isList;
    /**
     * 数据库字段：is_query 是否查询字段: 0=否，1=是
     */
    private String isQuery;
    /**
     * 数据库字段：query_type 查询方式：（eq，neq，gt，lt，between，like）
     */
    private String queryType;
    /**
     * 数据库字段：show_type 字段生成方案: （input、textarea、select、checkbox、radio、switch、dialog）
     */
    private String showType;
    /**
     * 数据库字段：dic_type 字典类型
     */
    private String dicType;
    /**
     * 数据库字段：sort 排序
     */
    private Integer sort;

    private boolean notNull;

    public GenTableColumnStyle() {
    }

    public GenTableColumnStyle(String id) {
        setId(id);
    }

    public String getTable() {
        return this.table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getJavaColumn() {
        return StringHelper.toJavaVariableName(this.column);
    }

    public String getColumn() {
        return this.column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getIsInsert() {
        return this.isInsert;
    }

    public void setIsInsert(String isInsert) {
        this.isInsert = isInsert;
    }

    public String getIsEdit() {
        return this.isEdit;
    }

    public void setIsEdit(String isEdit) {
        this.isEdit = isEdit;
    }

    public String getIsList() {
        return this.isList;
    }

    public void setIsList(String isList) {
        this.isList = isList;
    }

    public String getIsQuery() {
        return this.isQuery;
    }

    public void setIsQuery(String isQuery) {
        this.isQuery = isQuery;
    }

    public String getQueryType() {
        return this.queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getShowType() {
        return this.showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getDicType() {
        return this.dicType;
    }

    public void setDicType(String dicType) {
        this.dicType = dicType;
    }

    /**
     * 获取 字段表达式
     *
     * @return
     */
    public String getDicExpr(Object value, String view) {
        if (StringHelper.isNotBlank(this.dicType)) {
            if ("list".equals(view)) {
                return "<label>${fns:getDicType('" + dicType + "', " + value + ")}</label>";
            }
        }
        return null;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    /** 列是否是String类型 */
    public boolean getIsStringColumn() {
        return DatabaseDataTypesUtils.isString(getFieldType());
    }

    /** 列是否是日期类型 */
    public boolean getIsDateTimeColumn() {
        return DatabaseDataTypesUtils.isDate(getFieldType());
    }

    /** 列是否是Number类型 */
    public boolean getIsNumberColumn() {
        return DatabaseDataTypesUtils.isFloatNumber(getFieldType())
                || DatabaseDataTypesUtils.isIntegerNumber(getFieldType());
    }

    /**
     * 是否为抽象继承字段
     * @return
     */
    public boolean isAbstractField() {
        return ArrayHelper.contains(GeneratorMain.ABSTRAC_TFIELDS, getJavaColumn());
    }

    /**
     * 新增 忽略字段
     * @return
     */
    public boolean getIsIgnoreFieldByCreate() {
        return ArrayHelper.contains(GeneratorMain.IGNORE_FIELD_BY_CREATE, getJavaColumn());
    }

    /**
     * 更新 忽略字段
     * @return
     */
    public boolean getIsIgnoreFieldByUpdate() {
        return ArrayHelper.contains(GeneratorMain.IGNORE_FIELD_BY_UPDATE, getJavaColumn());
    }

    /**
     * 忽略字段
     * @return
     */
    public boolean getIsIgnoreFieldByCreateAndUpdate() {
        return getIsIgnoreFieldByCreate() || getIsIgnoreFieldByUpdate();
    }
}
