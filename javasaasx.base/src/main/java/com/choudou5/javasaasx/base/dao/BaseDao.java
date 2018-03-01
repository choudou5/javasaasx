package com.choudou5.javasaasx.base.dao;

import com.choudou5.base.bean.OrderBean;
import com.choudou5.base.bean.QueryParam;
import com.choudou5.javasaasx.base.bean.BasePo;

import java.io.Serializable;
import java.util.List;

/**
 * @Name：基础 Dao
 * @Author：xuhaowen
 * @Date：2018-01-13
 */
public interface BaseDao<P extends BasePo, K extends Serializable> {

    void insert(P po);

    void update(P po);

    void batchInsert(List<P> list);

    /**
     * 逻辑删除
     * @param id
     */
    void logicDeleteById(K id);

    /**
     * 逻辑批量删除
     * @param idList
     */
    void logicDeleteByIds(List<K> idList);

    void deleteById(K id);

    void deleteByIds(List<K> idList);

    void deleteBy(QueryParam queryBean);

    P findById(Serializable id);

    P findUniqueBy(QueryParam queryBean);

    long count(QueryParam queryBean);

    List<P> findList(QueryParam queryBean);

    List<P> findAll(OrderBean orderBean);

}
