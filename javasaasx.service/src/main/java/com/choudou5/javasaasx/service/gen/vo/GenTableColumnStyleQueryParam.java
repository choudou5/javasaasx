/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.gen.vo;

import com.choudou5.base.bean.QueryParam;

/**
 * @Name：生成表字段样式 查询对象
 * @Author：xuhaowen
 * @Date：2018-01-14
 */
public class GenTableColumnStyleQueryParam extends QueryParam {

	private GenTableColumnStyleVo genTableColumnStyleVo;

	public GenTableColumnStyleVo getGenTableColumnStyleBo() {
		return genTableColumnStyleVo;
	}

	public void setGenTableColumnStyleVo(GenTableColumnStyleVo genTableColumnStyleVo) {
		this.genTableColumnStyleVo = genTableColumnStyleVo;
		setParamBean(genTableColumnStyleVo);
	}
}
