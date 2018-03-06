/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.dic.bo;

import com.choudou5.base.bean.QueryParam;

/**
 * @Name： 字典地区 查询对象
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
public class DicAreaQueryParam extends QueryParam {

	private DicAreaBo dicAreaBo;

	public DicAreaBo getDicAreaBo() {
		return dicAreaBo;
	}

	public DicAreaQueryParam() {
	}

	public DicAreaQueryParam(DicAreaBo dicAreaBo) {
		this.dicAreaBo = dicAreaBo;
		setParamBean(dicAreaBo);
	}

	public void setDicAreaBo(DicAreaBo dicAreaBo) {
		this.dicAreaBo = dicAreaBo;
		setParamBean(dicAreaBo);
	}

	public DicAreaBo setDefBo() {
		return this.dicAreaBo==null?new DicAreaBo():this.dicAreaBo;
	}

}
