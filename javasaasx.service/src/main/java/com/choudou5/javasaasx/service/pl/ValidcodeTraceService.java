/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.pl;

import com.choudou5.javasaasx.dao.pl.ValidcodeTraceDao;
import com.choudou5.javasaasx.dao.pl.po.ValidcodeTracePo;
import com.choudou5.javasaasx.service.pl.vo.ValidcodeTraceVo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：验证码记录 接口实现类
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
@Service("validcodeTraceService")
public class ValidcodeTraceService extends BaseService<ValidcodeTracePo, ValidcodeTraceVo>{

    @Autowired
    private ValidcodeTraceDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
