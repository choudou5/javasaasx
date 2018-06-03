/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.log;

import com.choudou5.javasaasx.dao.log.LogUserLoginDao;
import com.choudou5.javasaasx.dao.log.po.LogUserLoginPo;
import com.choudou5.javasaasx.service.log.vo.LogUserLoginVo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：用户登录记录 Service实现类
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
@Service("logUserLoginService")
public class LogUserLoginService extends BaseService<LogUserLoginPo, LogUserLoginVo>{

    @Autowired
    private LogUserLoginDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
