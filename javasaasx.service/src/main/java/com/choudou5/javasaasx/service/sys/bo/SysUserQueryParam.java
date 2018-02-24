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
 * @Name：系统用户 查询对象
 * @Author：菜单管理
 * @Date：2018-02-18
 */
public class SysUserQueryParam extends QueryParam {

	private SysUserBo sysUserBo;

	public SysUserBo getSysUserBo() {
		return sysUserBo;
	}

	public SysUserQueryParam() {
	}

	public SysUserQueryParam(SysUserBo sysUserBo) {
		this.sysUserBo = sysUserBo;
		setParamBean(sysUserBo);
	}

	public void setSysUserBo(SysUserBo sysUserBo) {
		this.sysUserBo = sysUserBo;
		setParamBean(sysUserBo);
	}

	public SysUserBo setDefBo() {
		return this.sysUserBo==null?new SysUserBo():this.sysUserBo;
	}

}
