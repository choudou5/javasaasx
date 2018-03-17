/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.log;

import com.choudou5.javasaasx.dao.log.SysRemoteExceptionDao;
import com.choudou5.javasaasx.dao.log.po.SysRemoteExceptionPo;
import com.choudou5.javasaasx.service.log.bo.SysRemoteExceptionBo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.log.SysRemoteExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：系统远程异常 接口实现类
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
@Service("sysRemoteExceptionService")
public class SysRemoteExceptionServiceImpl extends BaseServiceImpl<SysRemoteExceptionPo, SysRemoteExceptionBo> implements SysRemoteExceptionService {

    @Autowired
    private SysRemoteExceptionDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
