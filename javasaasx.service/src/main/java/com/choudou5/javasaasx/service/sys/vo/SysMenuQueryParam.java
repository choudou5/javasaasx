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
import com.choudou5.javasaasx.dao.sys.po.SysMenuPo;

/**
 * @Name：菜单表 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class SysMenuQueryParam extends QueryParam {

	private SysMenuVo sysMenuVo;

	public SysMenuVo getSysMenuVo() {
		return sysMenuVo;
	}

	public SysMenuQueryParam() {
	}

	public SysMenuQueryParam(SysMenuVo sysMenuVo) {
		setSysMenuVo(sysMenuVo);
	}

	public void setSysMenuVo(SysMenuVo sysMenuVo) {
		this.sysMenuVo = sysMenuVo;
		SysMenuPo po = BeanMapper.map(sysMenuVo, SysMenuPo.class);
		setParamBean(po);
	}

	public SysMenuVo setDefVo() {
		if(sysMenuVo == null)
			sysMenuVo = new SysMenuVo();
		return sysMenuVo;
	}

}
