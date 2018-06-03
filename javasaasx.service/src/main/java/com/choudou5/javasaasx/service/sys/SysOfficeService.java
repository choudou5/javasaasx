/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.sys;

import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.base.util.ObjUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.dao.sys.SysOfficeDao;
import com.choudou5.javasaasx.dao.sys.po.SysOfficePo;
import com.choudou5.javasaasx.service.sys.vo.SysOfficeVo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：系统机构 Service实现类
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
@Service("sysOfficeService")
public class SysOfficeService extends BaseService<SysOfficePo, SysOfficeVo>{

    @Autowired
    private SysOfficeDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

    public void addDingTalkOffice(SysOfficeVo vo) {
        SysOfficePo po = dao.findById(vo.getId());
        if(ObjUtil.isNotNull(po)){
            //更新 机构信息
            if(!StrUtil.equals(vo.getName(), po.getName()))
                po.setName(vo.getName());
            if(StrUtil.isNotBlank(vo.getMaster()) && !StrUtil.equals(vo.getMaster(), po.getMaster()))
                po.setMaster(vo.getMaster());
            if(StrUtil.isNotBlank(vo.getTel()) && !StrUtil.equals(vo.getTel(), po.getTel()))
                po.setTel(vo.getTel());
            dao.update(po);
        }else{
            po = BeanMapper.map(vo, SysOfficePo.class);
            po.preInsert(false);
            dao.insert(po);
        }
    }
}
