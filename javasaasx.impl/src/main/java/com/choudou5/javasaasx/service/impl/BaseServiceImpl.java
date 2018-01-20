package com.choudou5.javasaasx.service.impl;

import com.choudou5.javasaasx.common.mapper.BeanMapper;
import com.choudou5.javasaasx.framework.bean.*;
import com.choudou5.javasaasx.framework.dao.BaseDao;
import com.choudou5.javasaasx.framework.exception.BizException;
import com.choudou5.javasaasx.framework.page.PageResult;
import com.choudou5.javasaasx.framework.service.BaseService;
import com.choudou5.javasaasx.framework.util.ReflectionUtil;
import com.choudou5.javasaasx.framework.util.SysSeqUtil;
import com.choudou5.javasaasx.service.impl.util.SysExceptionUtil;
import com.xiaoleilu.hutool.util.CollectionUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @Name：基础接口 实现
 * @Author：xuhaowende
 * @Date：2018-01-13 17:15
 * @Site：http://solrhome.com
 * @License：MIT
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
                po.preUpdate();
                getDao().update(po);
            }
        } catch (Exception e) {
            SysExceptionUtil.error("BaseServiceImpl.save fail", e);
            throw new BizException("保存失败！", e);
        }
    }

    @Transactional(readOnly = false)
    @Override
    public int batchInsert(List<B> list) throws BizException {
        try {
            if (CollectionUtil.isEmpty(list))
                return 0;
            List<P> poList = BeanMapper.mapList(list, getPoClazz());
            preBatchInsert(poList);
            getDao().batchInsert(poList);
            return poList.size();
        } catch (Exception e) {
            SysExceptionUtil.error("BaseServiceImpl.batchUpdate fail", e);
            throw new BizException("批量更新失败！", e);
        }
    }

    protected void preBatchInsert(List<P> list){
        for (P po : list) {
            String id = SysSeqUtil.getNextId();
            po.setId(id);
        }
    }


    @Transactional(readOnly = false)
    @Override
    public void batchUpdate(List<B> list) throws BizException {
        try {
            if (CollectionUtil.isEmpty(list))
                return;
            List<P> poList = BeanMapper.mapList(list, getPoClazz());
            for (P po : poList) {
                getDao().update(po);
            }
        } catch (Exception e) {
            SysExceptionUtil.error("BaseServiceImpl.batchUpdate fail", e);
            throw new BizException("批量更新失败！", e);
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(String id) throws BizException {
        try {
            getDao().deleteById(id);
        } catch (Exception e) {
            SysExceptionUtil.error("BaseServiceImpl.delete fail", e);
            throw new BizException("删除失败！", e);
        }
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteByIds(List<String> idList) throws BizException {
        try {
            getDao().deleteByIds(idList);
        } catch (Exception e) {
            SysExceptionUtil.error("BaseServiceImpl.deleteByIds fail", e);
            throw new BizException("批量删除失败！", e);
        }
    }



    @Override
    public B get(Serializable id) {
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
        return BeanMapper.mapList(list, getBoClazz());
    }

    @Override
    public List<B> findAll(OrderBean orderBean) throws BizException {
        List<P> list = getDao().findAll();
        return BeanMapper.mapList(list, getBoClazz());
    }

    @Override
    public PageResult<B> findPage(QueryParam queryBean) throws BizException {
        PageResult<B> pageResult = new PageResult<>();
        long count = count(queryBean);
        pageResult.setTotalCount(count);
        if(count > queryBean.getPageBean().getStart()){
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
