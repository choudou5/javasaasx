/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.log.bo;

import com.choudou5.base.bean.QueryParam;
import com.choudou5.javasaasx.service.log.bo.SysUserLoginHiBo;

/**
 * @Name：系统用户登录记录 查询对象
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
public class SysUserLoginHiQueryParam extends QueryParam {

	private SysUserLoginHiBo sysUserLoginHiBo;

	public SysUserLoginHiBo getSysUserLoginHiBo() {
		return sysUserLoginHiBo;
	}

	public SysUserLoginHiQueryParam() {
	}

	public SysUserLoginHiQueryParam(SysUserLoginHiBo sysUserLoginHiBo) {
		this.sysUserLoginHiBo = sysUserLoginHiBo;
		setParamBean(sysUserLoginHiBo);
	}

	public void setSysUserLoginHiBo(SysUserLoginHiBo sysUserLoginHiBo) {
		this.sysUserLoginHiBo = sysUserLoginHiBo;
		setParamBean(sysUserLoginHiBo);
	}

	public SysUserLoginHiBo setDefBo() {
		return this.sysUserLoginHiBo==null?new SysUserLoginHiBo():this.sysUserLoginHiBo;
	}

}
