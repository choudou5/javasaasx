/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.log;

import com.choudou5.javasaasx.dao.log.LogOperationDao;
import com.choudou5.javasaasx.dao.log.po.LogOperationPo;
import com.choudou5.javasaasx.service.log.vo.LogOperationVo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：操作日志 Service实现类
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
@Service("logOperationService")
public class LogOperationService extends BaseService<LogOperationPo, LogOperationVo>{

    @Autowired
    private LogOperationDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
