package com.choudou5.javasaasx.service.sys.bo;

import com.choudou5.base.bean.QueryParam;

/**
 * @Name：菜单表 查询对象
 * @Author：xuhaowen
 * @Date：2018-01-18
 * @Site：http://www.javasaas.top
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public class SysMenuQueryParam extends QueryParam {

	private SysMenuBo sysMenuBo;

	public SysMenuBo getSysMenuBo() {
		return sysMenuBo;
	}

	public SysMenuQueryParam() {
	}

	public SysMenuQueryParam(SysMenuBo sysMenuBo) {
		this.sysMenuBo = sysMenuBo;
		setParamBean(sysMenuBo);
	}

	public void setSysMenuBo(SysMenuBo sysMenuBo) {
		this.sysMenuBo = sysMenuBo;
		setParamBean(sysMenuBo);
	}

	public SysMenuBo setDefBo() {
		return this.sysMenuBo==null?new SysMenuBo():this.sysMenuBo;
	}

}
