package com.choudou5.javasaasx.framework.dao;

import com.choudou5.javasaasx.framework.bean.QueryParam;
import com.choudou5.javasaasx.framework.bean.BasePo;

import java.io.Serializable;
import java.util.List;

/**
 * @Name：增删改查 Dao
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 19:37
 * @Site：http://solrhome.com
 * @License：MIT
 */
public interface CrudDao<T extends BasePo, K extends Serializable> extends BaseDao{

    void insert(T t);

    void update(T t);

    void updateStatus(K id, String status);

    void batchUpdate(List<T> list);

    void delete(Serializable id);

    void batchDelete(List<String> idList);


    T get(K id);

    T findOne(QueryParam queryParam);

    long count(QueryParam queryParam);

    List<T> findList(QueryParam queryParam);

}
