/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.pl.vo;

import java.io.Serializable;

/**
 * @Name：验证码记录 Vo
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class ValidcodeTraceListVo implements Serializable {

    /** ID */
    private String id;
    /** 业务类型：reg=注册、login=登录、forgetpwd=忘记密码 */
    private String bizType;
    /** 业务ID */
    private String bizId;
    /** 验证方式：phone/email */
    private String validMethod;
    /** 验证方式内容 */
    private String validMethodContent;
    /** 验证码 */
    private String validCode;
    /** 失效时间 */
    private java.util.Date invalidTime;
    /** 创建时间 */
    private java.util.Date createTime;
    /** 验证时间 */
    private java.util.Date updateTime;
    /** ip */
    private String ip;
    /** 处理状态:0=未验证; 1=已验证 */
    private String status;

	public ValidcodeTraceListVo(){
	}

	public ValidcodeTraceListVo( String id ){
			setId(id);
	}

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getBizType() {
        return this.bizType;
    }
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizId() {
        return this.bizId;
    }
    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getValidMethod() {
        return this.validMethod;
    }
    public void setValidMethod(String validMethod) {
        this.validMethod = validMethod;
    }

    public String getValidMethodContent() {
        return this.validMethodContent;
    }
    public void setValidMethodContent(String validMethodContent) {
        this.validMethodContent = validMethodContent;
    }

    public String getValidCode() {
        return this.validCode;
    }
    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    public java.util.Date getInvalidTime() {
        return this.invalidTime;
    }
    public void setInvalidTime(java.util.Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIp() {
        return this.ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
