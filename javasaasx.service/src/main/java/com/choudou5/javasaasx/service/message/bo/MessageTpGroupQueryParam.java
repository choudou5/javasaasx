/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.message.bo;

import com.choudou5.base.bean.QueryParam;

/**
 * @Name：第三方消息群 查询对象
 * @Author：xuhaowen
 * @Date：2018-03-18
 */
public class MessageTpGroupQueryParam extends QueryParam {

	private MessageTpGroupBo messageTpGroupBo;

	public MessageTpGroupBo getMessageTpGroupBo() {
		return messageTpGroupBo;
	}

	public MessageTpGroupQueryParam() {
	}

	public MessageTpGroupQueryParam(MessageTpGroupBo messageTpGroupBo) {
		this.messageTpGroupBo = messageTpGroupBo;
		setParamBean(messageTpGroupBo);
	}

	public void setMessageTpGroupBo(MessageTpGroupBo messageTpGroupBo) {
		this.messageTpGroupBo = messageTpGroupBo;
		setParamBean(messageTpGroupBo);
	}

	public MessageTpGroupBo setDefBo() {
		return this.messageTpGroupBo==null?new MessageTpGroupBo():this.messageTpGroupBo;
	}

}
