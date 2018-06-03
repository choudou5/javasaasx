/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.dao.pl.po;

import com.choudou5.javasaasx.base.bean.AbstractBasePo;

/**
 * @Name：验证码记录 Po
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class ValidcodeTracePo extends AbstractBasePo{

    /**
     * 数据库字段：biz_type 业务类型：reg=注册、login=登录、forgetpwd=忘记密码
     */
    private String bizType;
    /**
     * 数据库字段：biz_id 业务ID
     */
    private String bizId;
    /**
     * 数据库字段：valid_method 验证方式：phone/email
     */
    private String validMethod;
    /**
     * 数据库字段：valid_method_content 验证方式内容
     */
    private String validMethodContent;
    /**
     * 数据库字段：valid_code 验证码
     */
    private String validCode;
    /**
     * 数据库字段：invalid_time 失效时间
     */
    private java.util.Date invalidTime;
    /**
     * 数据库字段：ip ip
     */
    private String ip;
    /**
     * 数据库字段：status 处理状态:0=未验证; 1=已验证
     */
    private String status;

	public ValidcodeTracePo(){
	}

	public ValidcodeTracePo( String id ){
			setId(id);
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
