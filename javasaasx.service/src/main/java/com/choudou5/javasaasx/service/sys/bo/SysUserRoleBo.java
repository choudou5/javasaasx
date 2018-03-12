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
 * @Name：系统用户角色 业务对象
 * @Author：xuhaowen
 * @Date：2018-02-22
 */
public class SysUserRoleBo implements BaseBo<String> {

    /**  id */
	private String id;
    /**  用户ID */
	private String userId;
    /**  角色ID */
	private String roleId;
    /**  创建者 */
	private String createBy;
    /**  创建时间 */
	private java.util.Date createTime;

	public SysUserRoleBo(){
	}

	public SysUserRoleBo( String id ){
			setId(id);
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}
	public SysUserRoleBo setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	@Length(min=0, max=32, message="角色ID长度必须介于 0 和 32 之间")
	public String getRoleId() {
		return this.roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
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

	
}

