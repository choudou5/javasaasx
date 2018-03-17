/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.log;

import com.choudou5.javasaasx.base.dao.SysDataChangeLogDao;
import com.choudou5.javasaasx.base.dao.po.SysDataChangeLogPo;
import com.choudou5.javasaasx.service.log.bo.SysDataChangeLogBo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.log.SysDataChangeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：系统数据变更日志 接口实现类
 * @Author：xuhaowen
 * @Date：2018-03-11
 */
@Service("sysDataChangeLogService")
public class SysDataChangeLogServiceImpl extends BaseServiceImpl<SysDataChangeLogPo, SysDataChangeLogBo> implements SysDataChangeLogService {

    @Autowired
    private SysDataChangeLogDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
