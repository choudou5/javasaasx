/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.sys.bo;

import org.hibernate.validator.constraints.Length;
import com.choudou5.javasaasx.base.bean.BaseBo;

/**
 * @Name：系统角色 业务对象
 * @Author：xuhaowen
 * @Date：2018-02-22
 */
public class SysRoleBo implements BaseBo {

    /**  id */
	private String id;
    /**  归属机构 */
	private String officeId;
    /**  分组名 */
	private String groupName;
    /**  角色名称 */
	private String name;
    /**  数据范围: 0=个人，1=本机构，2=所有 */
	private String dataScope;
    /**  备注信息 */
	private String remarks;
    /**  创建者 */
	private String createBy;
    /**  创建时间 */
	private java.util.Date createTime;
    /**  创建者 */
	private String updateBy;
    /**  更新时间 */
	private java.util.Date updateTime;
    /**  状态: 0=禁用，1=正常 */
	private String status;
    /**  是否系统数据: 0=否，1=是 */
	private String isSysData;
    /**  删除标记：0=已删除,1=正常 */
	private String delFlag;

	public SysRoleBo(){
	}

	public SysRoleBo( String id ){
			setId(id);
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getOfficeId() {
		return this.officeId;
	}
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	@Length(min=0, max=32, message="分组名长度必须介于 0 和 32 之间")
	public String getGroupName() {
		return this.groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Length(min=0, max=64, message="角色名称长度必须介于 0 和 64 之间")
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDataScope() {
		return this.dataScope;
	}
	public void setDataScope(String dataScope) {
		this.dataScope = dataScope;
	}

	public String getRemarks() {
		return this.remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreateBy() {
		return this.createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsSysData() {
		return this.isSysData;
	}
	public void setIsSysData(String isSysData) {
		this.isSysData = isSysData;
	}

	public String getDelFlag() {
		return this.delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	
}

