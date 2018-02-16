/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.sys;

import com.choudou5.javasaasx.api.sys.SysUserApi;
import com.choudou5.javasaasx.framework.dao.BaseDao;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.sys.SysUserService;
import com.choudou5.javasaasx.service.sys.bo.SysUserBo;
import org.springframework.stereotype.Service;

/**
 * @Name：系统用户接口 实现类
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl implements SysUserService, SysUserApi {


    @Override
    protected BaseDao getDao() {
        return null;
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
