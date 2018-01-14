package com.choudou5.javasaasx.dao.gen.po;

import com.choudou5.javasaasx.framework.bean.AbstractBasePo;

/**
 * @Name：生成表字段样式 Po
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-14
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public class GenTableColumnStylePo extends AbstractBasePo{

    /**
     * 数据库字段：table 表
     */
    private String table;
    /**
     * 数据库字段：table_name 表描述
     */
    private String tableName;
    /**
     * 数据库字段：column 字段
     */
    private String column;
    /**
     * 数据库字段：column_name 字段描述
     */
    private String columnName;
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
     * 数据库字段：show_type 字段生成方案: （input、textarea、select、checkbox、radio、dialog）
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

	public GenTableColumnStylePo(){
	}

	public GenTableColumnStylePo( String id ){
			setId(id);
	}

    public String getTable() {
        return this.table;
    }
    public void setTable(String table) {
        this.table = table;
    }
    public String getTableName() {
        return this.tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getColumn() {
        return this.column;
    }
    public void setColumn(String column) {
        this.column = column;
    }
    public String getColumnName() {
        return this.columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
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
    public Integer getSort() {
        return this.sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
