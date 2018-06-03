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
import com.choudou5.javasaasx.dao.sys.po.SysUserPo;

/**
 * @Name：系统用户 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class SysUserQueryParam extends QueryParam {

	private SysUserVo sysUserVo;

	public SysUserVo getSysUserVo() {
		return sysUserVo;
	}

	public SysUserQueryParam() {
	}

	public SysUserQueryParam(SysUserVo sysUserVo) {
		setSysUserVo(sysUserVo);
	}

	public void setSysUserVo(SysUserVo sysUserVo) {
		this.sysUserVo = sysUserVo;
		SysUserPo po = BeanMapper.map(sysUserVo, SysUserPo.class);
		setParamBean(po);
	}

	public SysUserVo setDefVo() {
		if(sysUserVo == null)
			sysUserVo = new SysUserVo();
		return sysUserVo;
	}

}
