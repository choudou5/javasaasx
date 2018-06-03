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
import com.choudou5.javasaasx.dao.sys.po.SysUserRelThirdpartyPo;

/**
 * @Name：用户关联第三方 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class SysUserRelThirdpartyQueryParam extends QueryParam {

	private SysUserRelThirdpartyVo sysUserRelThirdpartyVo;

	public SysUserRelThirdpartyVo getSysUserRelThirdpartyVo() {
		return sysUserRelThirdpartyVo;
	}

	public SysUserRelThirdpartyQueryParam() {
	}

	public SysUserRelThirdpartyQueryParam(SysUserRelThirdpartyVo sysUserRelThirdpartyVo) {
		setSysUserRelThirdpartyVo(sysUserRelThirdpartyVo);
	}

	public void setSysUserRelThirdpartyVo(SysUserRelThirdpartyVo sysUserRelThirdpartyVo) {
		this.sysUserRelThirdpartyVo = sysUserRelThirdpartyVo;
		SysUserRelThirdpartyPo po = BeanMapper.map(sysUserRelThirdpartyVo, SysUserRelThirdpartyPo.class);
		setParamBean(po);
	}


}
