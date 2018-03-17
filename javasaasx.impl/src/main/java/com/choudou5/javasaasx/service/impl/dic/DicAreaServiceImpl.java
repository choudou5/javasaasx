/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.dic;

import com.choudou5.javasaasx.dao.dic.DicAreaDao;
import com.choudou5.javasaasx.dao.dic.po.DicAreaPo;
import com.choudou5.javasaasx.service.dic.bo.DicAreaBo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.dic.DicAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name： 接口实现类
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
@Service("dicAreaService")
public class DicAreaServiceImpl extends BaseServiceImpl<DicAreaPo, DicAreaBo> implements DicAreaService {

    @Autowired
    private DicAreaDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
