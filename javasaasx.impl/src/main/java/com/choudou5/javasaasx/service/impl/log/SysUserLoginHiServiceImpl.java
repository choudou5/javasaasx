/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.log;

import com.choudou5.javasaasx.dao.log.SysUserLoginHiDao;
import com.choudou5.javasaasx.dao.log.po.SysUserLoginHiPo;
import com.choudou5.javasaasx.service.log.bo.SysUserLoginHiBo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.log.SysUserLoginHiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：系统用户登录记录 接口实现类
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
@Service("sysUserLoginHiService")
public class SysUserLoginHiServiceImpl extends BaseServiceImpl<SysUserLoginHiPo, SysUserLoginHiBo> implements SysUserLoginHiService {

    @Autowired
    private SysUserLoginHiDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
