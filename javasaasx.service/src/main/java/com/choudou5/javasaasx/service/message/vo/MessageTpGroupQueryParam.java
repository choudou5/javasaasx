/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.message.vo;

import com.choudou5.base.bean.QueryParam;
import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.javasaasx.dao.message.po.MessageTpGroupPo;

/**
 * @Name：第三方消息群 查询对象
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class MessageTpGroupQueryParam extends QueryParam {

	private MessageTpGroupVo messageTpGroupVo;

	public MessageTpGroupVo getMessageTpGroupVo() {
		return messageTpGroupVo;
	}

	public MessageTpGroupQueryParam() {
	}

	public MessageTpGroupQueryParam(MessageTpGroupVo messageTpGroupVo) {
		setMessageTpGroupVo(messageTpGroupVo);
	}

	public void setMessageTpGroupVo(MessageTpGroupVo messageTpGroupVo) {
		this.messageTpGroupVo = messageTpGroupVo;
		MessageTpGroupPo po = BeanMapper.map(messageTpGroupVo, MessageTpGroupPo.class);
		setParamBean(po);
	}


}
