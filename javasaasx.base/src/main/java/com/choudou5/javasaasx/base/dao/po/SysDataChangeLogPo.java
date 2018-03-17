/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.base.dao.po;

import com.choudou5.javasaasx.base.bean.AbstractBasePo;

/**
 * @Name：系统数据变更日志 Po
 * @Author：xuhaowen
 * @Date：2018-03-11
 */
public class SysDataChangeLogPo extends AbstractBasePo{

    /**
     * 数据库字段：biz_key 业务key
     */
    private String bizKey;
    /**
     * 数据库字段：biz_id 业务ID
     */
    private String bizId;
    /**
     * 数据库字段：opt_type 操作类型，update、del
     */
    private String optType;
    /**
     * 数据库字段：field_list 字段(多个___隔开)
     */
    private String fieldList;
    /**
     * 数据库字段：old_val_list 旧值(多个___隔开)
     */
    private String oldValList;
    /**
     * 数据库字段：new_val_list 新值(多个___隔开)
     */
    private String newValList;
    /**
     * 数据库字段：create_date 创建时间
     */
    private java.util.Date createDate;

	public SysDataChangeLogPo(){
	}

	public SysDataChangeLogPo( String id ){
			setId(id);
	}

    public String getBizKey() {
        return this.bizKey;
    }
    public void setBizKey(String bizKey) {
        this.bizKey = bizKey;
    }
    public String getBizId() {
        return this.bizId;
    }
    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
    public String getOptType() {
        return this.optType;
    }
    public void setOptType(String optType) {
        this.optType = optType;
    }
    public String getFieldList() {
        return this.fieldList;
    }
    public void setFieldList(String fieldList) {
        this.fieldList = fieldList;
    }
    public String getOldValList() {
        return this.oldValList;
    }
    public void setOldValList(String oldValList) {
        this.oldValList = oldValList;
    }
    public String getNewValList() {
        return this.newValList;
    }
    public void setNewValList(String newValList) {
        this.newValList = newValList;
    }
    public java.util.Date getCreateDate() {
        return this.createDate;
    }
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }
}
