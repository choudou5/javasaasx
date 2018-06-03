/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.pl.vo;

import com.choudou5.base.bean.QueryParam;
import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.javasaasx.dao.pl.po.ValidcodeTracePo;

/**
 * @Name：验证码记录 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class ValidcodeTraceQueryParam extends QueryParam {

	private ValidcodeTraceVo validcodeTraceVo;

	public ValidcodeTraceVo getValidcodeTraceVo() {
		return validcodeTraceVo;
	}

	public ValidcodeTraceQueryParam() {
	}

	public ValidcodeTraceQueryParam(ValidcodeTraceVo validcodeTraceVo) {
		setValidcodeTraceVo(validcodeTraceVo);
	}

	public void setValidcodeTraceVo(ValidcodeTraceVo validcodeTraceVo) {
		this.validcodeTraceVo = validcodeTraceVo;
		ValidcodeTracePo po = BeanMapper.map(validcodeTraceVo, ValidcodeTracePo.class);
		setParamBean(po);
	}


}
