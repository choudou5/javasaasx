/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.log;

import com.choudou5.javasaasx.dao.log.SysExceptionDao;
import com.choudou5.javasaasx.dao.log.po.SysExceptionPo;
import com.choudou5.javasaasx.service.log.bo.SysExceptionBo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.log.SysExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：系统异常 接口实现类
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
@Service("sysExceptionService")
public class SysExceptionServiceImpl extends BaseServiceImpl<SysExceptionPo, SysExceptionBo> implements SysExceptionService {

    @Autowired
    private SysExceptionDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
