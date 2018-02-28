/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.sys;

import com.choudou5.javasaasx.dao.sys.SysOperationLogDao;
import com.choudou5.javasaasx.dao.sys.po.SysOperationLogPo;
import com.choudou5.javasaasx.service.sys.bo.SysOperationLogBo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.sys.SysOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：系统操作日志 接口实现类
 * @Author：xuhaowen
 * @Date：2018-02-28
 */
@Service("sysOperationLogService")
public class SysOperationLogServiceImpl extends BaseServiceImpl<SysOperationLogPo, SysOperationLogBo> implements SysOperationLogService {

    @Autowired
    private SysOperationLogDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
