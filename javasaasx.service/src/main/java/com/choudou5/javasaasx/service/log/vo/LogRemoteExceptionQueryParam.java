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
import com.choudou5.javasaasx.dao.log.po.LogRemoteExceptionPo;

/**
 * @Name：系统远程异常 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class LogRemoteExceptionQueryParam extends QueryParam {

	private LogRemoteExceptionVo logRemoteExceptionVo;

	public LogRemoteExceptionVo getLogRemoteExceptionVo() {
		return logRemoteExceptionVo;
	}

	public LogRemoteExceptionQueryParam() {
	}

	public LogRemoteExceptionQueryParam(LogRemoteExceptionVo logRemoteExceptionVo) {
		setLogRemoteExceptionVo(logRemoteExceptionVo);
	}

	public void setLogRemoteExceptionVo(LogRemoteExceptionVo logRemoteExceptionVo) {
		this.logRemoteExceptionVo = logRemoteExceptionVo;
		LogRemoteExceptionPo po = BeanMapper.map(logRemoteExceptionVo, LogRemoteExceptionPo.class);
		setParamBean(po);
	}


}
