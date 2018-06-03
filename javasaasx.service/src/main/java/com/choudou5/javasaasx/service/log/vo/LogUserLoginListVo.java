/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.log.vo;

import java.io.Serializable;

/**
 * @Name：用户登录记录 Vo
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class LogUserLoginListVo implements Serializable {

    /** id */
    private String id;
    /** 账号 */
    private String account;
    /** 密码 */
    private String password;
    /** 用户id */
    private String userId;
    /** ip地址 */
    private String ip;
    /** 客户端来源 */
    private String clientSource;
    /** 系统code */
    private String sysCode;
    /** 失败原因 */
    private String failReason;
    /** 创建时间 */
    private java.util.Date createTime;
    /** 状态: 0=失败，1=成功 */
    private String status;

	public LogUserLoginListVo(){
	}

	public LogUserLoginListVo( String id ){
			setId(id);
	}

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
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
