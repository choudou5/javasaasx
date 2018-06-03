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
import com.choudou5.javasaasx.dao.sys.po.SysRolePo;

/**
 * @Name：系统角色 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class SysRoleQueryParam extends QueryParam {

	private SysRoleVo sysRoleVo;

	public SysRoleVo getSysRoleVo() {
		return sysRoleVo;
	}

	public SysRoleQueryParam() {
	}

	public SysRoleQueryParam(SysRoleVo sysRoleVo) {
		setSysRoleVo(sysRoleVo);
	}

	public void setSysRoleVo(SysRoleVo sysRoleVo) {
		this.sysRoleVo = sysRoleVo;
		SysRolePo po = BeanMapper.map(sysRoleVo, SysRolePo.class);
		setParamBean(po);
	}


}
