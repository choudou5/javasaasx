package com.choudou5.javasaasx.framework.service;

import com.choudou5.javasaasx.framework.bean.BaseBo;
import com.choudou5.javasaasx.framework.bean.OrderBean;
import com.choudou5.javasaasx.framework.bean.QueryParam;
import com.choudou5.javasaasx.framework.bean.BasePo;
import com.choudou5.javasaasx.framework.exception.BizException;
import com.choudou5.javasaasx.framework.page.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * @Name：基础 接口
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 16:22
 * @Site：http://solrhome.com
 * @License：MIT
 */
public interface BaseService <T extends BaseBo>{

    /**
     * 保存
     * @param bo
     * @throws BizException
     */
    void save(T bo) throws BizException;

    /**
     * 更新状态
     * @param id
     * @param status
     * @throws BizException
     */
    void updateStatus(Serializable id, String status) throws BizException;

    /**
     * 批量更新
     * @param list
     */
    void batchUpdate(List<T> list) throws BizException;

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
    void batchDelete(List<String> idList) throws BizException;


    /***********************查询*************************************/

    /**
     * 主键查询
     * @param id
     * @return
     */
    T get(Serializable id);

    /**
     * 查询 单条记录
     * @param queryBean
     * @return
     */
    T findOne(QueryParam queryBean) throws BizException;

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
    List<T> findList(QueryParam queryBean) throws BizException;

    /**
     * 查询所有
     * @param orderBean
     * @return
     * @throws BizException
     */
    List<T> findAll(OrderBean orderBean) throws BizException;

    /**
     * 分页查询
     * @param queryBean
     * @return
     */
    public PageResult<T> findPage(QueryParam queryBean) throws BizException;

}
