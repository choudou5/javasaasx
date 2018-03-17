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
 * @Name：用户关联第三方 查询对象
 * @Author：xuhaowen
 * @Date：2018-02-19
 */
public class SysUserRelThirdpartyQueryParam extends QueryParam {

	private SysUserRelThirdpartyBo sysUserRelThirdpartyBo;

	public SysUserRelThirdpartyBo getSysUserRelThirdpartyBo() {
		return sysUserRelThirdpartyBo;
	}

	public SysUserRelThirdpartyQueryParam() {
	}

	public SysUserRelThirdpartyQueryParam(SysUserRelThirdpartyBo sysUserRelThirdpartyBo) {
		this.sysUserRelThirdpartyBo = sysUserRelThirdpartyBo;
		setParamBean(sysUserRelThirdpartyBo);
	}

	public void setSysUserRelThirdpartyBo(SysUserRelThirdpartyBo sysUserRelThirdpartyBo) {
		this.sysUserRelThirdpartyBo = sysUserRelThirdpartyBo;
		setParamBean(sysUserRelThirdpartyBo);
	}

	public SysUserRelThirdpartyBo setDefBo() {
		return this.sysUserRelThirdpartyBo==null?new SysUserRelThirdpartyBo():this.sysUserRelThirdpartyBo;
	}

}
