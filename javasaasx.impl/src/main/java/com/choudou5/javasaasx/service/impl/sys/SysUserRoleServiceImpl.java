/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.sys;

import com.choudou5.javasaasx.dao.sys.SysUserRoleDao;
import com.choudou5.javasaasx.dao.sys.po.SysUserRolePo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.sys.SysUserRoleService;
import com.choudou5.javasaasx.service.sys.bo.SysUserRoleBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：系统用户角色 接口实现类
 * @Author：xuhaowen
 * @Date：2018-02-22
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRolePo, SysUserRoleBo> implements SysUserRoleService {

    @Autowired
    private SysUserRoleDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
