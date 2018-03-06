/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.dao.log.po;

import com.choudou5.javasaasx.base.bean.AbstractBasePo;

/**
 * @Name：系统远程异常 Po
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
public class SysRemoteExceptionPo extends AbstractBasePo{

    /**
     * 数据库字段：biz_module 业务模块
     */
    private String bizModule;
    /**
     * 数据库字段：biz_id 业务id
     */
    private String bizId;
    /**
     * 数据库字段：bean_name spring 实例名
     */
    private String beanName;
    /**
     * 数据库字段：method_name 方法名
     */
    private String methodName;
    /**
     * 数据库字段：remark 备注
     */
    private String remark;
    /**
     * 数据库字段：params_vals 参数值，多个###隔开
     */
    private String paramsVals;
    /**
     * 数据库字段：params_types 参数类型，多个###隔开
     */
    private String paramsTypes;
    /**
     * 数据库字段：status 状态：1=待修复, 2=已修复, 3=已忽略
     */
    private String status;
    /**
     * 数据库字段：exception 异常消息
     */
    private String exception;

	public SysRemoteExceptionPo(){
	}

	public SysRemoteExceptionPo( String id ){
			setId(id);
	}

    public String getBizModule() {
        return this.bizModule;
    }
    public void setBizModule(String bizModule) {
        this.bizModule = bizModule;
    }
    public String getBizId() {
        return this.bizId;
    }
    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
    public String getBeanName() {
        return this.beanName;
    }
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
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
}
