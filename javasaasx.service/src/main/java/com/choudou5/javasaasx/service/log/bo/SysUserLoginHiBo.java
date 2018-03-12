/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.log.bo;

import org.hibernate.validator.constraints.Length;
import com.choudou5.javasaasx.base.bean.BaseBo;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Name：系统用户登录记录 业务对象
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
public class SysUserLoginHiBo implements BaseBo<String> {

    /**  id */
	private String id;
    /**  账号 */
	private String account;
    /**  密码 */
	private String password;
    /**  用户id */
	private String userId;
    /**  ip地址 */
	private String ip;
    /**  客户端来源 */
	private String clientSource;
    /**  系统code */
	private String sysCode;
    /**  失败原因 */
	private String failReason;
    /**  创建时间 */
	private java.util.Date createTime;
    /**  状态: 0=失败，1=成功 */
	private String status;

	public SysUserLoginHiBo(){
	}

	public SysUserLoginHiBo( String id ){
			setId(id);
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@NotBlank(message="账号不能为空")
	@Length(min=1, max=32, message="账号长度必须介于 1 和 32 之间")
	public String getAccount() {
		return this.account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	@NotBlank(message="客户端来源不能为空")
	@Length(min=1, max=16, message="客户端来源长度必须介于 1 和 16 之间")
	public String getClientSource() {
		return this.clientSource;
	}
	public void setClientSource(String clientSource) {
		this.clientSource = clientSource;
	}

	@NotBlank(message="系统code不能为空")
	@Length(min=1, max=32, message="系统code长度必须介于 1 和 32 之间")
	public String getSysCode() {
		return this.sysCode;
	}
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public String getFailReason() {
		return this.failReason;
	}
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}

