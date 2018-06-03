/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.log.vo;

import com.choudou5.javasaasx.base.bean.BaseVo;

/**
 * @Name：操作日志 Vo
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class LogOperationVo implements BaseVo<String> {

    /** 编号 */
    private String id;
    /** 操作类型 */
    private String optType;
    /** 说明 */
    private String desc;
    /** ip地址 */
    private String ip;
    /** 用户代理 */
    private String userAgent;
    /** 请求uri */
    private String requestUri;
    /** 方法 */
    private String method;
    /** 请求参数 */
    private String params;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    private java.util.Date createTime;

	public LogOperationVo(){
	}

	public LogOperationVo( String id ){
			setId(id);
	}

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getOptType() {
        return this.optType;
    }
    public void setOptType(String optType) {
        this.optType = optType;
    }

    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIp() {
        return this.ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserAgent() {
        return this.userAgent;
    }
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getRequestUri() {
        return this.requestUri;
    }
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getMethod() {
        return this.method;
    }
    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return this.params;
    }
    public void setParams(String params) {
        this.params = params;
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
