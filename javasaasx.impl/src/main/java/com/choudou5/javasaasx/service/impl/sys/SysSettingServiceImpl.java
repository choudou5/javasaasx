/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.sys;

import com.choudou5.javasaasx.dao.sys.SysSettingDao;
import com.choudou5.javasaasx.dao.sys.po.SysSettingPo;
import com.choudou5.javasaasx.service.sys.bo.SysSettingBo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.sys.SysSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：系统设置 接口实现类
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
@Service("sysSettingService")
public class SysSettingServiceImpl extends BaseServiceImpl<SysSettingPo, SysSettingBo> implements SysSettingService {

    @Autowired
    private SysSettingDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
