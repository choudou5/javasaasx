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
 * @Name：系统数据变更日志 查询对象
 * @Author：xuhaowen
 * @Date：2018-03-11
 */
public class SysDataChangeLogQueryParam extends QueryParam {

	private SysDataChangeLogBo sysDataChangeLogBo;

	public SysDataChangeLogBo getSysDataChangeLogBo() {
		return sysDataChangeLogBo;
	}

	public SysDataChangeLogQueryParam() {
	}

	public SysDataChangeLogQueryParam(SysDataChangeLogBo sysDataChangeLogBo) {
		this.sysDataChangeLogBo = sysDataChangeLogBo;
		setParamBean(sysDataChangeLogBo);
	}

	public void setSysDataChangeLogBo(SysDataChangeLogBo sysDataChangeLogBo) {
		this.sysDataChangeLogBo = sysDataChangeLogBo;
		setParamBean(sysDataChangeLogBo);
	}

	public SysDataChangeLogBo setDefBo() {
		return this.sysDataChangeLogBo==null?new SysDataChangeLogBo():this.sysDataChangeLogBo;
	}

}
