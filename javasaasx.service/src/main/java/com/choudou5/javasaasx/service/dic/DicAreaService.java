/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.dic;

import com.choudou5.javasaasx.dao.dic.DicAreaDao;
import com.choudou5.javasaasx.dao.dic.po.DicAreaPo;
import com.choudou5.javasaasx.service.dic.vo.DicAreaVo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：字典地区 Service实现类
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
@Service("dicAreaService")
public class DicAreaService extends BaseService<DicAreaPo, DicAreaVo>{

    @Autowired
    private DicAreaDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
