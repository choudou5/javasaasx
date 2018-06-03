/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.message;

import com.choudou5.javasaasx.common.cache.GlobalCacheHelper;
import com.choudou5.javasaasx.dao.message.MessageTpGroupDao;
import com.choudou5.javasaasx.dao.message.po.MessageTpGroupPo;
import com.choudou5.javasaasx.service.message.vo.MessageTpGroupQueryParam;
import com.choudou5.javasaasx.service.message.vo.MessageTpGroupVo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：第三方消息群 Service实现类
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
@Service("messageTpGroupService")
public class MessageTpGroupService extends BaseService<MessageTpGroupPo, MessageTpGroupVo>{

    @Autowired
    private MessageTpGroupDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

    public String getCode(String bizType) {
        String tpType = "dingtalk";
        String cacheKey = tpType+"_msg_group";
        String code = GlobalCacheHelper.getGlobalInstance().get(cacheKey);
//        if(StrUtil.isNotBlank(code))
//            return code.replace("\"", "");
        MessageTpGroupVo groupVo = new MessageTpGroupVo(tpType, bizType);
        MessageTpGroupVo bo = findOne(new MessageTpGroupQueryParam(groupVo));
        if(bo != null)
            code = bo.getCode();
        GlobalCacheHelper.getGlobalInstance().put(cacheKey, code);
        return code;
    }
}
