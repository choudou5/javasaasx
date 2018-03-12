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

import java.io.Serializable;

/**
 * @Name：系统操作日志 业务对象
 * @Author：xuhaowen
 * @Date：2018-02-28
 */
public class SysOperationLogBo implements BaseBo<String> {

    /**  编号 */
	private String id;
    /**  操作类型 */
	private String optType;
    /**  说明 */
	private String desc;
    /**  ip地址 */
	private String ip;
    /**  用户代理 */
	private String userAgent;
    /**  请求uri */
	private String requestUri;
    /**  方法 */
	private String method;
    /**  请求参数 */
	private String params;
    /**  创建者 */
	private String createBy;
    /**  创建时间 */
	private java.util.Date createTime;

	public SysOperationLogBo(){
	}

	public SysOperationLogBo( String id ){
			setId(id);
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Length(min=0, max=32, message="操作类型长度必须介于 0 和 32 之间")
	public String getOptType() {
		return this.optType;
	}
	public void setOptType(String optType) {
		this.optType = optType;
	}

	@Length(min=0, max=128, message="说明长度必须介于 0 和 128 之间")
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

	@Length(min=0, max=8, message="方法长度必须介于 0 和 8 之间")
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

