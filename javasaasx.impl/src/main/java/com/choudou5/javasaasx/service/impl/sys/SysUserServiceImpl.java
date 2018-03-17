/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.sys;

import com.choudou5.base.exception.BizException;
import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.api.sys.SysUserApi;
import com.choudou5.javasaasx.dao.sys.SysUserDao;
import com.choudou5.javasaasx.dao.sys.po.SysUserPo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.sys.SysUserRelThirdpartyService;
import com.choudou5.javasaasx.service.sys.SysUserService;
import com.choudou5.javasaasx.service.sys.bo.SysUserBo;
import com.choudou5.javasaasx.service.sys.bo.SysUserRelThirdpartyBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：系统用户接口 实现类
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserPo, SysUserBo> implements SysUserService, SysUserApi {

    @Autowired
    private SysUserRelThirdpartyService userRelThirdpartyService;

    @Autowired
    private SysUserDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

    @Override
    public void addByDingTalkUser(SysUserBo bo) {
        SysUserRelThirdpartyBo tpBo = userRelThirdpartyService.findByDingTalkUserId(bo.getTpBo().getDingUserId());
        SysUserPo userPo = null;
        if(tpBo != null){
            //更新 用户信息
            userPo = dao.findById(tpBo.getUserId());
            if(StrUtil.isNotBlank(bo.getPhone()) && !StrUtil.equals(bo.getPhone(), userPo.getPhone()))
                userPo.setPhone(bo.getPhone());
            if(StrUtil.isNotBlank(bo.getMobile()) && !StrUtil.equals(bo.getMobile(), userPo.getMobile()))
                userPo.setMobile(bo.getMobile());
            if(StrUtil.isNotBlank(bo.getPosition()) && !StrUtil.equals(bo.getPosition(), userPo.getPosition()))
                userPo.setPosition(bo.getPosition());
            dao.update(userPo);
        }else{
            userPo = BeanMapper.map(bo, SysUserPo.class);
            userPo.preInsert(false);
            dao.insert(userPo);
            userRelThirdpartyService.save(bo.getTpBo());
        }
    }

    @Override
    public SysUserBo getByEmail(String email) {
        return null;
    }

    @Override
    public SysUserBo getByMobile(String mobile) {
        return null;
    }

    @Override
    public void save(SysUserBo bo) throws BizException {

    }

}
