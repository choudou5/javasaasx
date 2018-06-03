/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.dao.log.po;

import com.choudou5.javasaasx.base.bean.AbstractBasePo;

/**
 * @Name：操作日志 Po
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class LogOperationPo extends AbstractBasePo{

    /**
     * 数据库字段：opt_type 操作类型
     */
    private String optType;
    /**
     * 数据库字段：desc 说明
     */
    private String desc;
    /**
     * 数据库字段：ip ip地址
     */
    private String ip;
    /**
     * 数据库字段：user_agent 用户代理
     */
    private String userAgent;
    /**
     * 数据库字段：request_uri 请求uri
     */
    private String requestUri;
    /**
     * 数据库字段：method 方法
     */
    private String method;
    /**
     * 数据库字段：params 请求参数
     */
    private String params;

	public LogOperationPo(){
	}

	public LogOperationPo( String id ){
			setId(id);
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
}
