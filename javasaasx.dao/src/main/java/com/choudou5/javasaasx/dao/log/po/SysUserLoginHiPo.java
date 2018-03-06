/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.dao.log.po;

import com.choudou5.javasaasx.base.bean.AbstractBasePo;

/**
 * @Name：系统用户登录记录 Po
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
public class SysUserLoginHiPo extends AbstractBasePo{

    /**
     * 数据库字段：account 账号
     */
    private String account;
    /**
     * 数据库字段：password 密码
     */
    private String password;
    /**
     * 数据库字段：user_id 用户id
     */
    private String userId;
    /**
     * 数据库字段：ip ip地址
     */
    private String ip;
    /**
     * 数据库字段：client_source 客户端来源
     */
    private String clientSource;
    /**
     * 数据库字段：sys_code 系统code
     */
    private String sysCode;
    /**
     * 数据库字段：fail_reason 失败原因
     */
    private String failReason;
    /**
     * 数据库字段：status 状态: 0=失败，1=成功
     */
    private String status;

	public SysUserLoginHiPo(){
	}

	public SysUserLoginHiPo( String id ){
			setId(id);
	}

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
    public String getClientSource() {
        return this.clientSource;
    }
    public void setClientSource(String clientSource) {
        this.clientSource = clientSource;
    }
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
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
