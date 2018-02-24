/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.sys;

import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.javasaasx.dao.sys.SysUserRelThirdpartyDao;
import com.choudou5.javasaasx.dao.sys.po.SysUserRelThirdpartyPo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.sys.SysUserRelThirdpartyService;
import com.choudou5.javasaasx.service.sys.bo.SysUserRelThirdpartyBo;
import com.choudou5.javasaasx.service.sys.bo.SysUserRelThirdpartyQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：用户关联第三方 接口实现类
 * @Author：xuhaowen
 * @Date：2018-02-19
 */
@Service("sysUserRelThirdpartyService")
public class SysUserRelThirdpartyServiceImpl extends BaseServiceImpl<SysUserRelThirdpartyPo, SysUserRelThirdpartyBo> implements SysUserRelThirdpartyService {

    @Autowired
    private SysUserRelThirdpartyDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

    @Override
    public SysUserRelThirdpartyBo findByDingTalkUserId(String dingUserId) {
        SysUserRelThirdpartyBo bo = new SysUserRelThirdpartyBo();
        bo.setDingUserId(dingUserId);
        SysUserRelThirdpartyPo po = dao.findUniqueBy(new SysUserRelThirdpartyQueryParam(bo));
        return po==null?null: BeanMapper.map(po, SysUserRelThirdpartyBo.class);
    }
}
