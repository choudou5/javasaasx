/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.dic.vo;

import com.choudou5.base.bean.QueryParam;
import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.javasaasx.dao.dic.po.DicSensitiveWordPo;

/**
 * @Name：敏感词库 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class DicSensitiveWordQueryParam extends QueryParam {

	private DicSensitiveWordVo dicSensitiveWordVo;

	public DicSensitiveWordVo getDicSensitiveWordVo() {
		return dicSensitiveWordVo;
	}

	public DicSensitiveWordQueryParam() {
	}

	public DicSensitiveWordQueryParam(DicSensitiveWordVo dicSensitiveWordVo) {
		setDicSensitiveWordVo(dicSensitiveWordVo);
	}

	public void setDicSensitiveWordVo(DicSensitiveWordVo dicSensitiveWordVo) {
		this.dicSensitiveWordVo = dicSensitiveWordVo;
		DicSensitiveWordPo po = BeanMapper.map(dicSensitiveWordVo, DicSensitiveWordPo.class);
		setParamBean(po);
	}


}
