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
import com.choudou5.javasaasx.dao.log.po.LogDataModifyPo;

/**
 * @Name：数据修改日志 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class LogDataModifyQueryParam extends QueryParam {

	private LogDataModifyVo logDataModifyVo;

	public LogDataModifyVo getLogDataModifyVo() {
		return logDataModifyVo;
	}

	public LogDataModifyQueryParam() {
	}

	public LogDataModifyQueryParam(LogDataModifyVo logDataModifyVo) {
		setLogDataModifyVo(logDataModifyVo);
	}

	public void setLogDataModifyVo(LogDataModifyVo logDataModifyVo) {
		this.logDataModifyVo = logDataModifyVo;
		LogDataModifyPo po = BeanMapper.map(logDataModifyVo, LogDataModifyPo.class);
		setParamBean(po);
	}

	public LogDataModifyVo setDefVo() {
		if(logDataModifyVo == null)
			logDataModifyVo = new LogDataModifyVo();
		return logDataModifyVo;
	}

}
