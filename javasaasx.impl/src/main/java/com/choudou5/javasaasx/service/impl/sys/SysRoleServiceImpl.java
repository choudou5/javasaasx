/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.sys;

import com.choudou5.javasaasx.dao.sys.SysRoleDao;
import com.choudou5.javasaasx.dao.sys.po.SysRolePo;
import com.choudou5.javasaasx.service.sys.bo.SysRoleBo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.sys.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：系统角色 接口实现类
 * @Author：xuhaowen
 * @Date：2018-02-22
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRolePo, SysRoleBo> implements SysRoleService {

    @Autowired
    private SysRoleDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
