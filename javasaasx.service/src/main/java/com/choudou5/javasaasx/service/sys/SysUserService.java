/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.sys;

import com.choudou5.base.exception.BizException;
import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.dao.sys.SysUserDao;
import com.choudou5.javasaasx.dao.sys.po.SysUserPo;
import com.choudou5.javasaasx.service.sys.vo.SysUserRelThirdpartyVo;
import com.choudou5.javasaasx.service.sys.vo.SysUserVo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：系统用户 Service实现类
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
@Service("sysUserService")
public class SysUserService extends BaseService<SysUserPo, SysUserVo>{

    @Autowired
    private SysUserRelThirdpartyService userRelThirdpartyService;
    @Autowired
    private SysUserDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

    public void addByDingTalkUser(SysUserVo vo) {
        SysUserRelThirdpartyVo tpVo = userRelThirdpartyService.findByDingTalkUserId(vo.getTpVo().getDingUserId());
        SysUserPo userPo = null;
        if(tpVo != null){
            //更新 用户信息
            userPo = dao.findById(tpVo.getUserId());
            if(StrUtil.isNotBlank(vo.getPhone()) && !StrUtil.equals(vo.getPhone(), userPo.getPhone()))
                userPo.setPhone(vo.getPhone());
            if(StrUtil.isNotBlank(vo.getMobile()) && !StrUtil.equals(vo.getMobile(), userPo.getMobile()))
                userPo.setMobile(vo.getMobile());
            if(StrUtil.isNotBlank(vo.getPosition()) && !StrUtil.equals(vo.getPosition(), userPo.getPosition()))
                userPo.setPosition(vo.getPosition());
            dao.update(userPo);
        }else{
            userPo = BeanMapper.map(vo, SysUserPo.class);
            userPo.preInsert(false);
            dao.insert(userPo);
            userRelThirdpartyService.save(vo.getTpVo());
        }
    }

    public SysUserVo getByEmail(String email) {
        return null;
    }

    public SysUserVo getByMobile(String mobile) {
        return null;
    }

    public void save(SysUserVo bo) throws BizException {

    }
}
