/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
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
 * @Name：系统远程异常 业务对象
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
public class SysRemoteExceptionBo implements BaseBo<String> {

    /**  编号 */
	private String id;
    /**  业务模块 */
	private String bizModule;
    /**  业务id */
	private String bizId;
    /**  spring 实例名 */
	private String beanName;
    /**  方法名 */
	private String methodName;
    /**  备注 */
	private String remark;
    /**  参数值，多个###隔开 */
	private String paramsVals;
    /**  参数类型，多个###隔开 */
	private String paramsTypes;
    /**  状态：1=待修复, 2=已修复, 3=已忽略 */
	private String status;
    /**  异常消息 */
	private String exception;
    /**  创建时间 */
	private java.util.Date createTime;
    /**  更新人 */
	private String updateBy;
    /**  更新时间 */
	private java.util.Date updateTime;

	public SysRemoteExceptionBo(){
	}

	public SysRemoteExceptionBo( String id ){
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

	@NotBlank(message="业务id不能为空")
	@Length(min=1, max=64, message="业务id长度必须介于 1 和 64 之间")
	public String getBizId() {
		return this.bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	@NotBlank(message="spring 实例名不能为空")
	@Length(min=1, max=36, message="spring 实例名长度必须介于 1 和 36 之间")
	public String getBeanName() {
		return this.beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	@NotBlank(message="方法名不能为空")
	@Length(min=1, max=36, message="方法名长度必须介于 1 和 36 之间")
	public String getMethodName() {
		return this.methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getParamsVals() {
		return this.paramsVals;
	}
	public void setParamsVals(String paramsVals) {
		this.paramsVals = paramsVals;
	}

	public String getParamsTypes() {
		return this.paramsTypes;
	}
	public void setParamsTypes(String paramsTypes) {
		this.paramsTypes = paramsTypes;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getException() {
		return this.exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	
}

