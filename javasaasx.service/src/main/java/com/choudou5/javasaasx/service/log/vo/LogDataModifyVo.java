/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.log.vo;

import com.choudou5.javasaasx.base.bean.BaseVo;

/**
 * @Name：数据修改日志 Vo
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class LogDataModifyVo implements BaseVo<String> {

    /** id */
    private String id;
    /** 业务key */
    private String bizKey;
    /** 业务ID */
    private String bizId;
    /** 操作类型，update、del */
    private String optType;
    /** 字段(多个___隔开) */
    private String fieldList;
    /** 旧值(多个___隔开) */
    private String oldValList;
    /** 新值(多个___隔开) */
    private String newValList;
    /** 创建人 */
    private String createBy;
    /** 创建时间 */
    private java.util.Date createDate;

	public LogDataModifyVo(){
	}

	public LogDataModifyVo( String id ){
			setId(id);
	}

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
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

    public String getCreateBy() {
        return this.createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public java.util.Date getCreateDate() {
        return this.createDate;
    }
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

}
