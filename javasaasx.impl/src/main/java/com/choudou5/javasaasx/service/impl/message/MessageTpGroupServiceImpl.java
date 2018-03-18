/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.message;

import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.common.cache.GlobalCacheHelper;
import com.choudou5.javasaasx.dao.message.MessageTpGroupDao;
import com.choudou5.javasaasx.dao.message.po.MessageTpGroupPo;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.message.MessageTpGroupService;
import com.choudou5.javasaasx.service.message.bo.MessageTpGroupBo;
import com.choudou5.javasaasx.service.message.bo.MessageTpGroupQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：第三方消息群 接口实现类
 * @Author：xuhaowen
 * @Date：2018-03-18
 */
@Service("messageTpGroupService")
public class MessageTpGroupServiceImpl extends BaseServiceImpl<MessageTpGroupPo, MessageTpGroupBo> implements MessageTpGroupService {

    @Autowired
    private MessageTpGroupDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }



    @Override
    public String getCode(String bizType) {
        String tpType = "dingtalk";
        String cacheKey = tpType+"_msg_group";
        String code = GlobalCacheHelper.getGlobalInstance().get(cacheKey);
//        if(StrUtil.isNotBlank(code))
//            return code.replace("\"", "");
        MessageTpGroupBo groupBo = new MessageTpGroupBo(tpType, bizType);
        MessageTpGroupBo bo = findOne(new MessageTpGroupQueryParam(groupBo));
        if(bo != null)
            code = bo.getCode();
        GlobalCacheHelper.getGlobalInstance().put(cacheKey, code);
        return code;
    }
}
