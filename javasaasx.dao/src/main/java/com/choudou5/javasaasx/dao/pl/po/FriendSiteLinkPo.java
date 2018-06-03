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
 * @Name：友情站点链接 Po
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class FriendSiteLinkPo extends AbstractBasePo{

    /**
     * 数据库字段：site_name 站点名称
     */
    private String siteName;
    /**
     * 数据库字段：site_link 链接
     */
    private String siteLink;
    /**
     * 数据库字段：site_logo logo
     */
    private String siteLogo;
    /**
     * 数据库字段：order_num 排序号
     */
    private Integer orderNum;
    /**
     * 数据库字段：status 状态: 0=禁用，1=正常
     */
    private String status;

	public FriendSiteLinkPo(){
	}

	public FriendSiteLinkPo( String id ){
			setId(id);
	}

    public String getSiteName() {
        return this.siteName;
    }
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
    public String getSiteLink() {
        return this.siteLink;
    }
    public void setSiteLink(String siteLink) {
        this.siteLink = siteLink;
    }
    public String getSiteLogo() {
        return this.siteLogo;
    }
    public void setSiteLogo(String siteLogo) {
        this.siteLogo = siteLogo;
    }
    public Integer getOrderNum() {
        return this.orderNum;
    }
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
