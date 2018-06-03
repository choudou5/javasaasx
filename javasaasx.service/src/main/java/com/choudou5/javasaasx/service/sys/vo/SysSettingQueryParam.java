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
import com.choudou5.javasaasx.dao.sys.po.SysSettingPo;

/**
 * @Name：系统设置 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class SysSettingQueryParam extends QueryParam {

	private SysSettingVo sysSettingVo;

	public SysSettingVo getSysSettingVo() {
		return sysSettingVo;
	}

	public SysSettingQueryParam() {
	}

	public SysSettingQueryParam(SysSettingVo sysSettingVo) {
		setSysSettingVo(sysSettingVo);
	}

	public void setSysSettingVo(SysSettingVo sysSettingVo) {
		this.sysSettingVo = sysSettingVo;
		SysSettingPo po = BeanMapper.map(sysSettingVo, SysSettingPo.class);
		setParamBean(po);
	}


}
