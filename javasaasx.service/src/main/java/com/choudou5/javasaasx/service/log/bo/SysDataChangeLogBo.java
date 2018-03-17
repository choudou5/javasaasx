/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.log.bo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import com.choudou5.javasaasx.base.bean.BaseBo;

import java.io.Serializable;

/**
 * @Name：系统数据变更日志 业务对象
 * @Author：xuhaowen
 * @Date：2018-03-11
 */
public class SysDataChangeLogBo implements BaseBo<String> {

    /**  id */
	private String id;
    /**  业务key */
	private String bizKey;
    /**  业务ID */
	private String bizId;
    /**  操作类型，update、del */
	private String optType;
    /**  字段(多个___隔开) */
	private String fieldList;
    /**  旧值(多个___隔开) */
	private String oldValList;
    /**  新值(多个___隔开) */
	private String newValList;
    /**  创建人 */
	private String createBy;
    /**  创建时间 */
	private java.util.Date createDate;

	public SysDataChangeLogBo(){
	}

	public SysDataChangeLogBo( String id ){
			setId(id);
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@NotBlank(message="业务key不能为空")
	@Length(min=1, max=36, message="业务key长度必须介于 1 和 36 之间")
	public String getBizKey() {
		return this.bizKey;
	}
	public void setBizKey(String bizKey) {
		this.bizKey = bizKey;
	}

	@NotBlank(message="业务ID不能为空")
	@Length(min=1, max=32, message="业务ID长度必须介于 1 和 32 之间")
	public String getBizId() {
		return this.bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	@NotBlank(message="操作类型，update、del不能为空")
	@Length(min=1, max=6, message="操作类型，update、del长度必须介于 1 和 6 之间")
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

