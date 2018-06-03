/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.log.vo;

import com.choudou5.base.bean.QueryParam;
import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.javasaasx.dao.log.po.LogUserLoginPo;

/**
 * @Name：用户登录记录 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class LogUserLoginQueryParam extends QueryParam {

	private LogUserLoginVo logUserLoginVo;

	public LogUserLoginVo getLogUserLoginVo() {
		return logUserLoginVo;
	}

	public LogUserLoginQueryParam() {
	}

	public LogUserLoginQueryParam(LogUserLoginVo logUserLoginVo) {
		setLogUserLoginVo(logUserLoginVo);
	}

	public void setLogUserLoginVo(LogUserLoginVo logUserLoginVo) {
		this.logUserLoginVo = logUserLoginVo;
		LogUserLoginPo po = BeanMapper.map(logUserLoginVo, LogUserLoginPo.class);
		setParamBean(po);
	}


}
