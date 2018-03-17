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
 * @Name：系统用户角色 查询对象
 * @Author：xuhaowen
 * @Date：2018-02-22
 */
public class SysUserRoleQueryParam extends QueryParam {

	private SysUserRoleBo sysUserRoleBo;

	public SysUserRoleBo getSysUserRoleBo() {
		return sysUserRoleBo;
	}

	public SysUserRoleQueryParam() {
	}

	public SysUserRoleQueryParam(SysUserRoleBo sysUserRoleBo) {
		this.sysUserRoleBo = sysUserRoleBo;
		setParamBean(sysUserRoleBo);
	}

	public void setSysUserRoleBo(SysUserRoleBo sysUserRoleBo) {
		this.sysUserRoleBo = sysUserRoleBo;
		setParamBean(sysUserRoleBo);
	}

	public SysUserRoleBo setDefBo() {
		return this.sysUserRoleBo==null?new SysUserRoleBo():this.sysUserRoleBo;
	}

}
