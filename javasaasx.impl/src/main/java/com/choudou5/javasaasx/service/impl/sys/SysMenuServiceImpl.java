package com.choudou5.javasaasx.service.impl.sys;

import com.choudou5.base.exception.BizException;
import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.base.util.tree.TreeHelper;
import com.choudou5.javasaasx.dao.sys.SysMenuDao;
import com.choudou5.javasaasx.dao.sys.po.SysMenuPo;
import com.choudou5.javasaasx.framework.constant.CommonConstant;
import com.choudou5.javasaasx.framework.dao.BaseDao;
import com.choudou5.javasaasx.service.constants.SysConstants;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.choudou5.javasaasx.service.impl.util.SysExceptionUtil;
import com.choudou5.javasaasx.service.sys.SysMenuService;
import com.choudou5.javasaasx.service.sys.bo.SysMenuBo;
import com.choudou5.javasaasx.service.sys.bo.SysMenuQueryParam;
import com.xiaoleilu.hutool.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Name：菜单表 接口实现类
 * @Author：xuhaowen
 * @Date：2018-01-18
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuPo, SysMenuBo> implements SysMenuService {

    @Autowired
    private SysMenuDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

    @Override
    public void save(SysMenuBo bo) throws BizException {
        SysMenuPo po = BeanMapper.map(bo, SysMenuPo.class);
        try {
            if (po.isNew()){
                po.preInsert();
                formatParam(po);
                getDao().insert(po);
            }else{
                po.preUpdate();
                formatParam(po);
                getDao().update(po);
            }
        } catch (Exception e) {
            SysExceptionUtil.error("save fail", e);
            throw new BizException("保存失败！", e);
        }
    }

    /**
     * 格式化参数
     * @param po
     */
    private void formatParam(SysMenuPo po){
        if(StrUtil.isBlank(po.getPid())){
            po.setDepth(1);
            po.setPid(TreeHelper.ROOT_ID);
            po.setDepth(0);
        }else{
            SysMenuBo parent = get(po.getPid());
            po.setDepth(parent.getDepth() + 1);
            if(StrUtil.isBlank(parent.getPpath()))
                po.setPpath(parent.getId());
            else
                po.setPpath(parent.getPpath()+"."+parent.getId());
        }
        po.setIsMobileShow(CommonConstant.DataStatusEnum.getCodeByCheckBoxOrRadio(po.getIsMobileShow(), CommonConstant.STATUS_N));
        po.setIsSysData(CommonConstant.DataStatusEnum.getCodeByCheckBoxOrRadio(po.getIsSysData(), CommonConstant.STATUS_Y));
        po.setStatus(CommonConstant.DataStatusEnum.getCodeByCheckBoxOrRadio(po.getStatus(), CommonConstant.STATUS_Y));
    }

    @Override
    public Map<String, Object> getParentTree(Integer showLevel) {
        SysMenuBo bo = new SysMenuBo();
        bo.setType(SysConstants.MenuTypeEnum.MENU.getType());
        SysMenuQueryParam queryParam = new SysMenuQueryParam(bo);
        queryParam.addExtendParam("depth", " <= "+showLevel);
        List<SysMenuBo> list = findList(queryParam);
        Map<String, Object> tree = TreeHelper.buildTreeData(list);
        return tree;
    }


}
