/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.log.bo;

import com.choudou5.base.bean.QueryParam;

/**
 * @Name：系统异常 查询对象
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
public class SysExceptionQueryParam extends QueryParam {

	private SysExceptionBo sysExceptionBo;

	public SysExceptionBo getSysExceptionBo() {
		return sysExceptionBo;
	}

	public SysExceptionQueryParam() {
	}

	public SysExceptionQueryParam(SysExceptionBo sysExceptionBo) {
		this.sysExceptionBo = sysExceptionBo;
		setParamBean(sysExceptionBo);
	}

	public void setSysExceptionBo(SysExceptionBo sysExceptionBo) {
		this.sysExceptionBo = sysExceptionBo;
		setParamBean(sysExceptionBo);
	}

	public SysExceptionBo setDefBo() {
		return this.sysExceptionBo==null?new SysExceptionBo():this.sysExceptionBo;
	}

}
