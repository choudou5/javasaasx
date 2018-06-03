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
import com.choudou5.javasaasx.dao.sys.po.SysOfficePo;

/**
 * @Name：系统机构 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class SysOfficeQueryParam extends QueryParam {

	private SysOfficeVo sysOfficeVo;

	public SysOfficeVo getSysOfficeVo() {
		return sysOfficeVo;
	}

	public SysOfficeQueryParam() {
	}

	public SysOfficeQueryParam(SysOfficeVo sysOfficeVo) {
		setSysOfficeVo(sysOfficeVo);
	}

	public void setSysOfficeVo(SysOfficeVo sysOfficeVo) {
		this.sysOfficeVo = sysOfficeVo;
		SysOfficePo po = BeanMapper.map(sysOfficeVo, SysOfficePo.class);
		setParamBean(po);
	}

	public SysOfficeVo setDefVo() {
		if(sysOfficeVo == null)
			sysOfficeVo = new SysOfficeVo();
		return sysOfficeVo;
	}


}
