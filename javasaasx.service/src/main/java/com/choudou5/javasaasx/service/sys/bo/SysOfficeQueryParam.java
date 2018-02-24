/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.sys.bo;

import com.choudou5.base.bean.QueryParam;

/**
 * @Name：系统机构 查询对象
 * @Author：xuhaowen
 * @Date：2018-02-18
 */
public class SysOfficeQueryParam extends QueryParam {

	private SysOfficeBo sysOfficeBo;

	public SysOfficeBo getSysOfficeBo() {
		return sysOfficeBo;
	}

	public SysOfficeQueryParam() {
	}

	public SysOfficeQueryParam(SysOfficeBo sysOfficeBo) {
		this.sysOfficeBo = sysOfficeBo;
		setParamBean(sysOfficeBo);
	}

	public void setSysOfficeBo(SysOfficeBo sysOfficeBo) {
		this.sysOfficeBo = sysOfficeBo;
		setParamBean(sysOfficeBo);
	}

	public SysOfficeBo setDefBo() {
		return this.sysOfficeBo==null?new SysOfficeBo():this.sysOfficeBo;
	}

}
