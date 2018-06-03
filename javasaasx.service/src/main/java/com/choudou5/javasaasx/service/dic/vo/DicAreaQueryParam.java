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
import com.choudou5.javasaasx.dao.dic.po.DicAreaPo;

/**
 * @Name：字典地区 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class DicAreaQueryParam extends QueryParam {

	private DicAreaVo dicAreaVo;

	public DicAreaVo getDicAreaVo() {
		return dicAreaVo;
	}

	public DicAreaQueryParam() {
	}

	public DicAreaQueryParam(DicAreaVo dicAreaVo) {
		setDicAreaVo(dicAreaVo);
	}

	public void setDicAreaVo(DicAreaVo dicAreaVo) {
		this.dicAreaVo = dicAreaVo;
		DicAreaPo po = BeanMapper.map(dicAreaVo, DicAreaPo.class);
		setParamBean(po);
	}


}
