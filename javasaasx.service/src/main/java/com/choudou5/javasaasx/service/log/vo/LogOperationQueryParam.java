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
import com.choudou5.javasaasx.dao.log.po.LogOperationPo;

/**
 * @Name：操作日志 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class LogOperationQueryParam extends QueryParam {

	private LogOperationVo logOperationVo;

	public LogOperationVo getLogOperationVo() {
		return logOperationVo;
	}

	public LogOperationQueryParam() {
	}

	public LogOperationQueryParam(LogOperationVo logOperationVo) {
		setLogOperationVo(logOperationVo);
	}

	public void setLogOperationVo(LogOperationVo logOperationVo) {
		this.logOperationVo = logOperationVo;
		LogOperationPo po = BeanMapper.map(logOperationVo, LogOperationPo.class);
		setParamBean(po);
	}


}
