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
 * @Name：系统角色 查询对象
 * @Author：xuhaowen
 * @Date：2018-02-22
 */
public class SysRoleQueryParam extends QueryParam {

	private SysRoleBo sysRoleBo;

	public SysRoleBo getSysRoleBo() {
		return sysRoleBo;
	}

	public SysRoleQueryParam() {
	}

	public SysRoleQueryParam(SysRoleBo sysRoleBo) {
		this.sysRoleBo = sysRoleBo;
		setParamBean(sysRoleBo);
	}

	public void setSysRoleBo(SysRoleBo sysRoleBo) {
		this.sysRoleBo = sysRoleBo;
		setParamBean(sysRoleBo);
	}

	public SysRoleBo setDefBo() {
		return this.sysRoleBo==null?new SysRoleBo():this.sysRoleBo;
	}

}
