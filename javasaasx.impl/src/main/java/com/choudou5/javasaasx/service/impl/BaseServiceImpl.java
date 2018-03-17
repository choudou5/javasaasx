/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl;

import com.choudou5.base.bean.OrderBean;
import com.choudou5.base.bean.QueryParam;
import com.choudou5.base.exception.BizException;
import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.base.page.PageResult;
import com.choudou5.base.util.*;
import com.choudou5.javasaasx.base.bean.AbstractBasePo;
import com.choudou5.javasaasx.base.bean.BaseBo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.base.service.BaseService;
import com.choudou5.javasaasx.base.util.SysDataChangeUtil;
import com.choudou5.javasaasx.base.util.SysSeqUtil;
import com.choudou5.javasaasx.common.util.SysUtil;
import com.choudou5.javasaasx.service.impl.util.SysExceptionUtil;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Name：基础接口 实现
 * @Author：xuhaowende
 * @Date：2018-01-13
 */
public abstract class BaseServiceImpl<P extends AbstractBasePo, B extends BaseBo> implements BaseService<B> {

    protected abstract BaseDao<P, String> getDao();

    @Transactional(readOnly = false)
    @Override
    public void save(B bo) throws BizException {
        P po = BeanMapper.map(bo, getPoClazz());
        try {
            if (po.isNew()){
                po.preInsert();
                getDao().insert(po);
            }else{
                if(SysUtil.isDebug())
                    po.setId(IdSeqUtil.depthDecryptId(po.getId()));
                //记录 变更信息
                P oldObj = null;
                if(po.isRecordDataChange()) {
                    oldObj = getDao().findById(po.getId());
                    SysDataChangeUtil.saveEdit(po, oldObj);
                }
                po.preUpdate();
                getDao().update(po);
            }
        } catch (Exception e) {
            SysExceptionUtil.error("BaseServiceImpl.save fail", e);
            if(e instanceof DuplicateKeyException){
                throw new BizException("已存在，请勿重复添加！", e);
            }
            else{
                throw new BizException("保存失败！", e);
            }
        }
    }

    @Transactional(readOnly = false)
    @Override
    public int batchInsert(List<B> list) throws BizException {
        try {
            if (CollUtil.isEmpty(list))
                return 0;
            List<P> poList = BeanMapper.mapList(list, getPoClazz());
            preBatchInsert(poList);
            getDao().batchInsert(poList);
            return poList.size();
        } catch (Exception e) {
            SysExceptionUtil.error("BaseServiceImpl.batchUpdate fail", e);
            throw new BizException("批量更新失败", e);
        }
    }

    protected void preBatchInsert(List<P> list){
        for (P po : list) {
            String id = SysSeqUtil.getIdStr();
            po.setId(id);
        }
    }


    @Transactional(readOnly = false)
    @Override
    public void batchUpdate(List<B> list) throws BizException {
        try {
            if (CollUtil.isEmpty(list))
                return;
            if(SysUtil.isDebug())
                list.forEach(bo -> {bo.setId(IdSeqUtil.depthDecryptId(bo.getId().toString()));});
            List<P> poList = BeanMapper.mapList(list, getPoClazz());
            for (P po : poList) {
                getDao().update(po);
            }
        } catch (Exception e) {
            SysExceptionUtil.error("BaseServiceImpl.batchUpdate fail", e);
            throw new BizException("批量更新失败", e);
        }
    }

    @Override
    public void logicDeleteById(String id) throws BizException {
        try {
            if(SysUtil.isDebug())
                id = IdSeqUtil.depthDecryptId(id);
            //记录 变更信息
            SysDataChangeUtil.saveDel(getDao().findById(id));
            getDao().logicDeleteById(id);
        } catch (Exception e) {
            SysExceptionUtil.error("BaseServiceImpl.logicDeleteById fail", e);
            throw new BizException("删除失败", e);
        }
    }

    @Override
    public void logicDeleteByIds(List<String> idList) throws BizException {
        try {
            if(SysUtil.isDebug())
                idList = idList.stream().map(str -> IdSeqUtil.depthDecryptId(str)).collect(Collectors.toList());
            getDao().logicDeleteByIds(idList);
        } catch (Exception e) {
            SysExceptionUtil.error("BaseServiceImpl.logicDeleteByIds fail", e);
            throw new BizException("批量删除失败", e);
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(String id) throws BizException {
        try {
            if(SysUtil.isDebug())
                id = IdSeqUtil.depthDecryptId(id);
            SysDataChangeUtil.saveDel(getDao().findById(id));
            getDao().deleteById(id);
        } catch (Exception e) {
            SysExceptionUtil.error("BaseServiceImpl.delete fail", e);
            throw new BizException("删除失败", e);
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteByIds(List<String> idList) throws BizException {
        try {
            if(SysUtil.isDebug())
                idList = idList.stream().map(str -> IdSeqUtil.depthDecryptId(str)).collect(Collectors.toList());
            getDao().deleteByIds(idList);
        } catch (Exception e) {
            SysExceptionUtil.error("BaseServiceImpl.deleteByIds fail", e);
            throw new BizException("批量删除失败", e);
        }
    }

    @Override
    public B get(Serializable id) {
        AssertUtil.isNotEmpty(id, "请求ID为空");
        if(SysUtil.isDebug())
            id = IdSeqUtil.depthDecryptId(id.toString());
        P po = getDao().findById(id);
        return po==null?null:BeanMapper.map(po, getBoClazz());
    }

    @Override
    public B findOne(QueryParam queryBean) throws BizException {
        P po = getDao().findUniqueBy(queryBean);
        return po==null?null:BeanMapper.map(po, getBoClazz());
    }

    @Override
    public long count(QueryParam queryBean) {
        return getDao().count(queryBean);
    }

    @Override
    public List<B> findList(QueryParam queryBean) throws BizException {
        List<P> list = getDao().findList(queryBean);
        if(CollUtil.isNotEmpty(list) && SysUtil.isDebug())
            list.forEach(po -> {po.setId(IdSeqUtil.depthEncryptId(po.getId()));});
        return BeanMapper.mapList(list, getBoClazz());
    }

    @Override
    public List<B> findAll(OrderBean orderBean) throws BizException {
        List<P> list = getDao().findAll(orderBean);
        if(CollUtil.isNotEmpty(list) && SysUtil.isDebug())
            list.forEach(po -> {po.setId(IdSeqUtil.depthEncryptId(po.getId()));});
        return BeanMapper.mapList(list, getBoClazz());
    }

    @Override
    public List<B> findAll() throws BizException {
        List<P> list = getDao().findAll(null);
        if(CollUtil.isNotEmpty(list) && SysUtil.isDebug())
            list.forEach(po -> {po.setId(IdSeqUtil.depthEncryptId(po.getId()));});
        return BeanMapper.mapList(list, getBoClazz());
    }


    @Override
    public PageResult<B> findPage(QueryParam queryBean) throws BizException {
        queryBean.setDefPage();
        PageResult<B> pageResult = new PageResult<>(queryBean.getPageBean().getPageSize(), queryBean.getPageBean().getPageNo());
        long count = count(queryBean);
        pageResult.setTotalCount(count);
        if(count > 0 && count > queryBean.getPageBean().getStart()){
            pageResult.setResult(findList(queryBean));
        }
        return pageResult;
    }

    protected Class<P> getPoClazz() {
        return ReflectionUtil.getClassGenricType(this.getClass(), 0);
    }

    protected Class<B> getBoClazz() {
        return ReflectionUtil.getClassGenricType(this.getClass(), 1);
    }

}
