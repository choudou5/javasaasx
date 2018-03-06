/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.log.bo;

import com.choudou5.base.bean.QueryParam;

/**
 * @Name：系统远程异常 查询对象
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
public class SysRemoteExceptionQueryParam extends QueryParam {

	private SysRemoteExceptionBo sysRemoteExceptionBo;

	public SysRemoteExceptionBo getSysRemoteExceptionBo() {
		return sysRemoteExceptionBo;
	}

	public SysRemoteExceptionQueryParam() {
	}

	public SysRemoteExceptionQueryParam(SysRemoteExceptionBo sysRemoteExceptionBo) {
		this.sysRemoteExceptionBo = sysRemoteExceptionBo;
		setParamBean(sysRemoteExceptionBo);
	}

	public void setSysRemoteExceptionBo(SysRemoteExceptionBo sysRemoteExceptionBo) {
		this.sysRemoteExceptionBo = sysRemoteExceptionBo;
		setParamBean(sysRemoteExceptionBo);
	}

	public SysRemoteExceptionBo setDefBo() {
		return this.sysRemoteExceptionBo==null?new SysRemoteExceptionBo():this.sysRemoteExceptionBo;
	}

}
