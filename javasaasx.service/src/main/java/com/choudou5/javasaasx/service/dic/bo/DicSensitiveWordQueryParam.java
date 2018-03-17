/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.dic.bo;

import com.choudou5.base.bean.QueryParam;

/**
 * @Name：敏感词库 查询对象
 * @Author：xuhaowen
 * @Date：2018-03-04
 */
public class DicSensitiveWordQueryParam extends QueryParam {

	private DicSensitiveWordBo dicSensitiveWordBo;

	public DicSensitiveWordBo getDicSensitiveWordBo() {
		return dicSensitiveWordBo;
	}

	public DicSensitiveWordQueryParam() {
	}

	public DicSensitiveWordQueryParam(DicSensitiveWordBo dicSensitiveWordBo) {
		this.dicSensitiveWordBo = dicSensitiveWordBo;
		setParamBean(dicSensitiveWordBo);
	}

	public void setDicSensitiveWordBo(DicSensitiveWordBo dicSensitiveWordBo) {
		this.dicSensitiveWordBo = dicSensitiveWordBo;
		setParamBean(dicSensitiveWordBo);
	}

	public DicSensitiveWordBo setDefBo() {
		return this.dicSensitiveWordBo==null?new DicSensitiveWordBo():this.dicSensitiveWordBo;
	}

}
