/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.message;

import com.choudou5.javasaasx.base.bean.BaseBo;
import com.choudou5.javasaasx.base.service.BaseService;
import com.choudou5.javasaasx.service.message.bo.MessageTpGroupBo;

/**
 * @Name：第三方消息群 接口
 * @Author：xuhaowen
 * @Date：2018-03-18
 */
public interface MessageTpGroupService extends BaseService<MessageTpGroupBo> {

    /**
     * 获得 code
     * @param bizType
     * @return
     */
    String getCode(String bizType);
}
