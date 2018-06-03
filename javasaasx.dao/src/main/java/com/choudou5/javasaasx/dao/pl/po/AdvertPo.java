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
 * @Name：广告 Po
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class AdvertPo extends AbstractBasePo{

    /**
     * 数据库字段：client_type 客户端类型: web/app
     */
    private String clientType;
    /**
     * 数据库字段：img_url 显示图片路径
     */
    private String imgUrl;
    /**
     * 数据库字段：to_url 点击转向的url
     */
    private String toUrl;
    /**
     * 数据库字段：ad_desc 描述
     */
    private String adDesc;
    /**
     * 数据库字段：ad_type 广告类型: home=首页
     */
    private String adType;
    /**
     * 数据库字段：def 是否默认: 0=否，1=是
     */
    private String def;
    /**
     * 数据库字段：start_time 开始时间
     */
    private java.util.Date startTime;
    /**
     * 数据库字段：end_time 结束时间
     */
    private java.util.Date endTime;
    /**
     * 数据库字段：ad_order 排序号
     */
    private Integer adOrder;
    /**
     * 数据库字段：status 状态: 0=禁用，1=启用
     */
    private String status;
    /**
     * 数据库字段：ext_param1 扩展参数1
     */
    private String extParam1;
    /**
     * 数据库字段：ext_param2 扩展参数2
     */
    private String extParam2;
    /**
     * 数据库字段：ext_param3 扩展参数3
     */
    private String extParam3;

	public AdvertPo(){
	}

	public AdvertPo( String id ){
			setId(id);
	}

    public String getClientType() {
        return this.clientType;
    }
    public void setClientType(String clientType) {
        this.clientType = clientType;
    }
    public String getImgUrl() {
        return this.imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getToUrl() {
        return this.toUrl;
    }
    public void setToUrl(String toUrl) {
        this.toUrl = toUrl;
    }
    public String getAdDesc() {
        return this.adDesc;
    }
    public void setAdDesc(String adDesc) {
        this.adDesc = adDesc;
    }
    public String getAdType() {
        return this.adType;
    }
    public void setAdType(String adType) {
        this.adType = adType;
    }
    public String getDef() {
        return this.def;
    }
    public void setDef(String def) {
        this.def = def;
    }
    public java.util.Date getStartTime() {
        return this.startTime;
    }
    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }
    public java.util.Date getEndTime() {
        return this.endTime;
    }
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }
    public Integer getAdOrder() {
        return this.adOrder;
    }
    public void setAdOrder(Integer adOrder) {
        this.adOrder = adOrder;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getExtParam1() {
        return this.extParam1;
    }
    public void setExtParam1(String extParam1) {
        this.extParam1 = extParam1;
    }
    public String getExtParam2() {
        return this.extParam2;
    }
    public void setExtParam2(String extParam2) {
        this.extParam2 = extParam2;
    }
    public String getExtParam3() {
        return this.extParam3;
    }
    public void setExtParam3(String extParam3) {
        this.extParam3 = extParam3;
    }
}
