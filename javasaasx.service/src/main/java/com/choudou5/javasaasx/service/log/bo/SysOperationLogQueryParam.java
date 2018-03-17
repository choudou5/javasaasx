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
 * @Name：系统操作日志 查询对象
 * @Author：xuhaowen
 * @Date：2018-02-28
 */
public class SysOperationLogQueryParam extends QueryParam {

	private SysOperationLogBo sysOperationLogBo;

	public SysOperationLogBo getSysOperationLogBo() {
		return sysOperationLogBo;
	}

	public SysOperationLogQueryParam() {
	}

	public SysOperationLogQueryParam(SysOperationLogBo sysOperationLogBo) {
		this.sysOperationLogBo = sysOperationLogBo;
		setParamBean(sysOperationLogBo);
	}

	public void setSysOperationLogBo(SysOperationLogBo sysOperationLogBo) {
		this.sysOperationLogBo = sysOperationLogBo;
		setParamBean(sysOperationLogBo);
	}

	public SysOperationLogBo setDefBo() {
		return this.sysOperationLogBo==null?new SysOperationLogBo():this.sysOperationLogBo;
	}

}
