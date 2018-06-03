/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.sys.vo;

import com.choudou5.base.bean.QueryParam;
import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.javasaasx.dao.sys.po.SysUserRolePo;

/**
 * @Name：系统用户角色 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class SysUserRoleQueryParam extends QueryParam {

	private SysUserRoleVo sysUserRoleVo;

	public SysUserRoleVo getSysUserRoleVo() {
		return sysUserRoleVo;
	}

	public SysUserRoleQueryParam() {
	}

	public SysUserRoleQueryParam(SysUserRoleVo sysUserRoleVo) {
		setSysUserRoleVo(sysUserRoleVo);
	}

	public void setSysUserRoleVo(SysUserRoleVo sysUserRoleVo) {
		this.sysUserRoleVo = sysUserRoleVo;
		SysUserRolePo po = BeanMapper.map(sysUserRoleVo, SysUserRolePo.class);
		setParamBean(po);
	}


}
