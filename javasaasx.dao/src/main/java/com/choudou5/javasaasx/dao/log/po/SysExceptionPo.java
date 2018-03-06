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
 * @Name：系统异常 Po
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
public class SysExceptionPo extends AbstractBasePo{

    /**
     * 数据库字段：biz_module 业务模块
     */
    private String bizModule;
    /**
     * 数据库字段：method_name 方法名
     */
    private String methodName;
    /**
     * 数据库字段：exception_type 异常类型
     */
    private String exceptionType;
    /**
     * 数据库字段：exception 异常消息
     */
    private String exception;
    /**
     * 数据库字段：ip ip地址
     */
    private String ip;

	public SysExceptionPo(){
	}

	public SysExceptionPo( String id ){
			setId(id);
	}

    public String getBizModule() {
        return this.bizModule;
    }
    public void setBizModule(String bizModule) {
        this.bizModule = bizModule;
    }
    public String getMethodName() {
        return this.methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
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
}
