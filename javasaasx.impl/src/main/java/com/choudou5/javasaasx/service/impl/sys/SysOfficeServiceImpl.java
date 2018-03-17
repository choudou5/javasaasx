/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.sys;

import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.base.util.ObjUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.dao.sys.SysOfficeDao;
import com.choudou5.javasaasx.dao.sys.po.SysOfficePo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.sys.SysOfficeService;
import com.choudou5.javasaasx.service.sys.bo.SysOfficeBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：系统机构 接口实现类
 * @Author：xuhaowen
 * @Date：2018-02-18
 */
@Service("sysOfficeService")
public class SysOfficeServiceImpl extends BaseServiceImpl<SysOfficePo, SysOfficeBo> implements SysOfficeService {

    @Autowired
    private SysOfficeDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

    @Override
    public void addDingTalkOffice(SysOfficeBo bo) {
        SysOfficePo po = dao.findById(bo.getId());
        if(ObjUtil.isNotNull(po)){
            //更新 机构信息
            if(!StrUtil.equals(bo.getName(), po.getName()))
                po.setName(bo.getName());
            if(StrUtil.isNotBlank(bo.getMaster()) && !StrUtil.equals(bo.getMaster(), po.getMaster()))
                po.setMaster(bo.getMaster());
            if(StrUtil.isNotBlank(bo.getTel()) && !StrUtil.equals(bo.getTel(), po.getTel()))
                po.setTel(bo.getTel());
            dao.update(po);
        }else{
            po = BeanMapper.map(bo, SysOfficePo.class);
            po.preInsert(false);
            dao.insert(po);
        }
    }
}
