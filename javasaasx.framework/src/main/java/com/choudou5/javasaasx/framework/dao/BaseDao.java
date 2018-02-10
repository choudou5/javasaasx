package com.choudou5.javasaasx.framework.dao;

import com.choudou5.base.bean.QueryParam;
import com.choudou5.javasaasx.framework.bean.BasePo;

import java.io.Serializable;
import java.util.List;

/**
 * @Name：基础 Dao
 * @Author：xuhaowende
 * @Date：2018-01-13 17:51
 * @Site：http://solrhome.com
 * @License：MIT
 */
public interface BaseDao<P extends BasePo, K extends Serializable> {

    void insert(P po);

    void update(P po);

    void batchInsert(List<P> list);

    void deleteById(K id);

    void deleteByIds(List<K> idList);

    void deleteBy(QueryParam queryBean);

    P findById(Serializable id);

    P findUniqueBy(QueryParam queryBean);

    long count(QueryParam queryBean);

    List<P> findList(QueryParam queryBean);

    List<P> findAll();

}
