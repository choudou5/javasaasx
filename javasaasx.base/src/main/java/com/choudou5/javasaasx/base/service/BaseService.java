package com.choudou5.javasaasx.base.service;

import com.choudou5.base.bean.OrderBean;
import com.choudou5.base.bean.QueryParam;
import com.choudou5.base.exception.BizException;
import com.choudou5.base.page.PageResult;
import com.choudou5.javasaasx.base.bean.BaseVo;

import java.io.Serializable;
import java.util.List;

/**
 * @Name：基础 接口
 * @Author：xuhaowende
 * @Date：2018-01-13 16:22
 * @Site：http://www.javasaas.top
 * @License：MIT
 */
public interface BaseService <V extends BaseVo>{

    /**
     * 保存
     * @param vo
     * @throws BizException
     */
    void save(V vo) throws BizException;

    /**
     * 批量新增
     * @param list 实体集合
     */
    int batchInsert(List<V> list);

    /**
     * 批量更新
     * @param list
     */
    void batchUpdate(List<V> list) throws BizException;


    /**
     * 逻辑 主键删除
     * @param id
     * @throws BizException
     */
    void logicDeleteById(String id) throws BizException;

    /**
     * 逻辑 批量删除
     * @param idList
     * @throws BizException
     */
    void logicDeleteByIds(List<String> idList) throws BizException;

    /**
     * 主键删除
     * @param id
     * @throws BizException
     */
    void delete(String id) throws BizException;

    /**
     * 批量删除
     * @param idList
     * @throws BizException
     */
    void deleteByIds(List<String> idList) throws BizException;


    /***********************查询*************************************/

    /**
     * 主键查询
     * @param id
     * @return
     */
    V get(Serializable id);

    /**
     * 查询 单条记录
     * @param queryBean
     * @return
     */
    V findOne(QueryParam queryBean) throws BizException;

    /**
     * 查询 数量
     * @param queryBean
     * @return
     */
    long count(QueryParam queryBean);

    /**
     * 查询列表
     * @param queryBean
     * @return
     * @throws BizException
     */
    List<V> findList(QueryParam queryBean) throws BizException;

    /**
     * 查询所有
     * @param orderBean
     * @return
     * @throws BizException
     */
    List<V> findAll(OrderBean orderBean) throws BizException;

    /**
     * 查询所有
     * @return
     * @throws BizException
     */
    List<V> findAll() throws BizException;

    /**
     * 分页查询
     * @param queryBean
     * @return
     */
    public PageResult<V> findPage(QueryParam queryBean) throws BizException;

}
