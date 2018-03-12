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
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Name：系统异常 业务对象
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
public class SysExceptionBo implements BaseBo<String> {

    /**  编号 */
	private String id;
    /**  业务模块 */
	private String bizModule;
    /**  方法名 */
	private String methodName;
    /**  异常类型 */
	private String exceptionType;
    /**  异常消息 */
	private String exception;
    /**  ip地址 */
	private String ip;
    /**  创建者 */
	private String createBy;
    /**  创建时间 */
	private java.util.Date createTime;

	public SysExceptionBo(){
	}

	public SysExceptionBo( String id ){
			setId(id);
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@NotBlank(message="业务模块不能为空")
	@Length(min=1, max=64, message="业务模块长度必须介于 1 和 64 之间")
	public String getBizModule() {
		return this.bizModule;
	}
	public void setBizModule(String bizModule) {
		this.bizModule = bizModule;
	}

	@NotBlank(message="方法名不能为空")
	@Length(min=1, max=36, message="方法名长度必须介于 1 和 36 之间")
	public String getMethodName() {
		return this.methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	@NotBlank(message="异常类型不能为空")
	@Length(min=1, max=128, message="异常类型长度必须介于 1 和 128 之间")
	public String getExceptionType() {
		return this.exceptionType;
	}
	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	public String getException() {
		return this.exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}

	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
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

