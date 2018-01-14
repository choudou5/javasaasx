package com.choudou5.javasaasx.service.impl;

import com.choudou5.javasaasx.framework.bean.BaseBo;
import com.choudou5.javasaasx.framework.bean.OrderBean;
import com.choudou5.javasaasx.framework.bean.QueryParam;
import com.choudou5.javasaasx.framework.dao.BaseDao;
import com.choudou5.javasaasx.framework.bean.BasePo;
import com.choudou5.javasaasx.framework.exception.BizException;
import com.choudou5.javasaasx.framework.page.PageResult;
import com.choudou5.javasaasx.framework.service.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * @Name：基础接口 实现
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 17:15
 * @Site：http://solrhome.com
 * @License：MIT
 */
public abstract class BaseServiceImpl<T extends BaseBo> implements BaseService<T> {

    protected abstract BaseDao getDao();

    @Override
    public void save(T entity) throws BizException {

    }

    @Override
    public void updateStatus(Serializable id, String status) throws BizException {

    }

    @Override
    public void batchUpdate(List<T> list) throws BizException {

    }

    @Override
    public void delete(String id) throws BizException {

    }

    @Override
    public void batchDelete(List<String> idList) throws BizException {

    }

    @Override
    public T get(Serializable id) {
        return null;
    }

    @Override
    public T findOne(QueryParam queryBean) throws BizException {
        return null;
    }

    @Override
    public long count(QueryParam queryBean) {
        return 0;
    }

    @Override
    public List<T> findList(QueryParam queryBean) throws BizException {
        return null;
    }

    @Override
    public List<T> findAll(OrderBean orderBean) throws BizException {
        return null;
    }

    @Override
    public PageResult<T> findPage(QueryParam queryBean) throws BizException {
        return null;
    }

}
