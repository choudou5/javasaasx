/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.sys;

import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.dao.sys.SysUserRelThirdpartyDao;
import com.choudou5.javasaasx.dao.sys.po.SysUserRelThirdpartyPo;
import com.choudou5.javasaasx.service.BaseService;
import com.choudou5.javasaasx.service.sys.vo.SysUserRelThirdpartyQueryParam;
import com.choudou5.javasaasx.service.sys.vo.SysUserRelThirdpartyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：用户关联第三方 Service实现类
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
@Service("sysUserRelThirdpartyService")
public class SysUserRelThirdpartyService extends BaseService<SysUserRelThirdpartyPo, SysUserRelThirdpartyVo>{

    @Autowired
    private SysUserRelThirdpartyDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

    public SysUserRelThirdpartyVo findByDingTalkUserId(String dingUserId) {
        SysUserRelThirdpartyVo vo = new SysUserRelThirdpartyVo();
        vo.setDingUserId(dingUserId);
        SysUserRelThirdpartyPo po = dao.findUniqueBy(new SysUserRelThirdpartyQueryParam(vo));
        return po==null?null: BeanMapper.map(po, SysUserRelThirdpartyVo.class);
    }
}
