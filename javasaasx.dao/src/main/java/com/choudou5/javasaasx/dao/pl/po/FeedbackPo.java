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
 * @Name：反馈 Po
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class FeedbackPo extends AbstractBasePo{

    /**
     * 数据库字段：user_id 用户id
     */
    private String userId;
    /**
     * 数据库字段：content 反馈消息
     */
    private String content;
    /**
     * 数据库字段：contact_type 联系类型：none/phone/qq/weixin
     */
    private String contactType;
    /**
     * 数据库字段：contact 联系信息
     */
    private String contact;
    /**
     * 数据库字段：fb_att 附件
     */
    private String fbAtt;
    /**
     * 数据库字段：origin 来源：web/android/ios
     */
    private String origin;
    /**
     * 数据库字段：ip ip
     */
    private String ip;
    /**
     * 数据库字段：browser 浏览器
     */
    private String browser;
    /**
     * 数据库字段：deal_desc 处理说明
     */
    private String dealDesc;
    /**
     * 数据库字段：status 处理状态:0=未处理; 1=已处理
     */
    private String status;

	public FeedbackPo(){
	}

	public FeedbackPo( String id ){
			setId(id);
	}

    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContactType() {
        return this.contactType;
    }
    public void setContactType(String contactType) {
        this.contactType = contactType;
    }
    public String getContact() {
        return this.contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getFbAtt() {
        return this.fbAtt;
    }
    public void setFbAtt(String fbAtt) {
        this.fbAtt = fbAtt;
    }
    public String getOrigin() {
        return this.origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getIp() {
        return this.ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getBrowser() {
        return this.browser;
    }
    public void setBrowser(String browser) {
        this.browser = browser;
    }
    public String getDealDesc() {
        return this.dealDesc;
    }
    public void setDealDesc(String dealDesc) {
        this.dealDesc = dealDesc;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
