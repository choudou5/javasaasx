package com.choudou5.javasaasx.service.gen.bo;

import com.choudou5.javasaasx.framework.bean.BaseBo;
import com.choudou5.javasaasx.framework.bean.QueryParam;

/**
 * @Name：生成表字段样式 查询对象
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-14
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public class GenTableColumnStyleQueryParam extends QueryParam {

	private GenTableColumnStyleBo genTableColumnStyleBo;

	public GenTableColumnStyleBo getGenTableColumnStyleBo() {
		return genTableColumnStyleBo;
	}

	public void setGenTableColumnStyleBo(GenTableColumnStyleBo genTableColumnStyleBo) {
		this.genTableColumnStyleBo = genTableColumnStyleBo;
		setParamBean(genTableColumnStyleBo);
	}
}
