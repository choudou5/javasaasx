/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.log;

import com.choudou5.javasaasx.dao.log.LogRemoteExceptionDao;
import com.choudou5.javasaasx.dao.log.po.LogRemoteExceptionPo;
import com.choudou5.javasaasx.service.log.vo.LogRemoteExceptionVo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：系统远程异常 Service实现类
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
@Service("logRemoteExceptionService")
public class LogRemoteExceptionService extends BaseService<LogRemoteExceptionPo, LogRemoteExceptionVo>{

    @Autowired
    private LogRemoteExceptionDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
