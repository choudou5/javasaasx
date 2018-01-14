package com.choudou5.javasaasx.service.impl.sys;

import com.choudou5.javasaasx.api.sys.SysUserApi;
import com.choudou5.javasaasx.dao.sys.SysUserDao;
import com.choudou5.javasaasx.framework.dao.BaseDao;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.sys.SysUserService;
import com.choudou5.javasaasx.service.sys.bo.SysUserBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：系统用户接口 实现类
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 16:11
 * @Site：http://www.javasaas.top
 * @License：MIT
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl implements SysUserService, SysUserApi {

    @Autowired
    private SysUserDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

    @Override
    public SysUserBo getByEmail(String email) {
        return null;
    }

    @Override
    public SysUserBo getByMobile(String mobile) {
        return null;
    }
}
