/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.sys.bo;

import com.choudou5.base.bean.QueryParam;

/**
 * @Name：系统设置 查询对象
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
public class SysSettingQueryParam extends QueryParam {

	private SysSettingBo sysSettingBo;

	public SysSettingBo getSysSettingBo() {
		return sysSettingBo;
	}

	public SysSettingQueryParam() {
	}

	public SysSettingQueryParam(SysSettingBo sysSettingBo) {
		this.sysSettingBo = sysSettingBo;
		setParamBean(sysSettingBo);
	}

	public void setSysSettingBo(SysSettingBo sysSettingBo) {
		this.sysSettingBo = sysSettingBo;
		setParamBean(sysSettingBo);
	}

	public SysSettingBo setDefBo() {
		return this.sysSettingBo==null?new SysSettingBo():this.sysSettingBo;
	}

}
