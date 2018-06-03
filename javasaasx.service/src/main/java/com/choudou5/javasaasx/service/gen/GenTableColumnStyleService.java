/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.gen;

import cn.hutool.cache.impl.LRUCache;
import cn.org.rapid_framework.generator.provider.db.DataCollectionInfo;
import cn.org.rapid_framework.generator.provider.db.table.TableFactory;
import cn.org.rapid_framework.generator.provider.db.table.model.Column;
import cn.org.rapid_framework.generator.provider.db.table.model.Table;
import com.choudou5.base.bean.SelectBean;
import com.choudou5.base.exception.BizException;
import com.choudou5.base.util.CacheUtil;
import com.choudou5.base.util.CollUtil;
import com.choudou5.base.util.PropUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.base.constant.CommonConstant;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.codegen.model.GenTableColumnStyle;
import com.choudou5.javasaasx.common.constants.CacheConsts;
import com.choudou5.javasaasx.common.constants.SysPropConsts;
import com.choudou5.javasaasx.dao.gen.GenTableColumnStyleDao;
import com.choudou5.javasaasx.service.BaseService;
import com.choudou5.javasaasx.service.gen.vo.GenTableColumnStyleQueryParam;
import com.choudou5.javasaasx.service.gen.vo.GenTableColumnStyleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @Name：生成表字段样式 接口实现类
 * @Author：xuhaowen
 * @Date：2018-01-14
 */
@Service("genTableColumnStyleService")
public class GenTableColumnStyleService extends BaseService<GenTableColumnStyle, GenTableColumnStyleVo>{

    @Autowired
    private GenTableColumnStyleDao dao;

    private static LRUCache<String, List<Table>> cache = CacheUtil.newLRUCache(1);

    @Override
    protected BaseDao getDao() {
        return dao;
    }

    static {
        init();
    }

    private static List<Table> init(){
        DataCollectionInfo collectionInfo = new DataCollectionInfo();
        collectionInfo.setUrl(PropUtil.getStr(SysPropConsts.JDBC_URL));
        collectionInfo.setUsername(PropUtil.getStr(SysPropConsts.JDBC_USERNAME));
        collectionInfo.setPassword(PropUtil.getStr(SysPropConsts.JDBC_PASSWORD));
        collectionInfo.setDriverClass(PropUtil.getStr(SysPropConsts.JDBC_DRIVER));
        List<Table> tables = TableFactory.getInstance().getAllTables(collectionInfo);
        cache.put(CacheConsts.CACHE_KEY_GEN_TABLE, tables);
        return tables;
    }

    private static List<Table> getCacheTableList(){
        List<Table> result = cache.get(CacheConsts.CACHE_KEY_GEN_TABLE);
        if(CollUtil.isEmpty(result)){
            result = init();
        }
        return result;
    }


    public void save(List<GenTableColumnStyleVo> columnStyleVoList) throws BizException {
        boolean isNew = StrUtil.isBlank(columnStyleVoList.get(0).getId());
        for (GenTableColumnStyleVo bo : columnStyleVoList) {
            if(StrUtil.isBlank(bo.getIsList()))
                bo.setIsList(CommonConstant.DataStatusEnum.N.getCode());
            if(StrUtil.isBlank(bo.getIsEdit()))
                bo.setIsEdit(CommonConstant.DataStatusEnum.N.getCode());
            if(StrUtil.isBlank(bo.getIsInsert()))
                bo.setIsInsert(CommonConstant.DataStatusEnum.N.getCode());
            if(StrUtil.isBlank(bo.getIsQuery()))
                bo.setIsQuery(CommonConstant.DataStatusEnum.N.getCode());
            if(StrUtil.isBlank(bo.getQueryType()))
                bo.setQueryType("eq");
            if(StrUtil.isBlank(bo.getShowType()))
                bo.setShowType("input");
        }
        if(isNew){
            batchInsert(columnStyleVoList);
        }else{
            batchUpdate(columnStyleVoList);
        }
    }

    public List<SelectBean> getTableList() {
        List<SelectBean> list = new ArrayList<>();
        List<Table> tables = getCacheTableList();
        if(CollUtil.isNotEmpty(tables)){
            for (Table table : tables) {
                list.add(new SelectBean(table.getRemarks(), table.getSqlName()));
            }
        }
        return list;
    }

    public List<GenTableColumnStyleVo> findByTable(String table) {
        GenTableColumnStyleQueryParam queryParam = new GenTableColumnStyleQueryParam();
        queryParam.setGenTableColumnStyleVo(new GenTableColumnStyleVo().setTable(table));
        return findList(queryParam);
    }

    public List<GenTableColumnStyleVo> getGenTableColumnStyleList(String table) {
        List<GenTableColumnStyleVo> list = findByTable(table);
        List<Table> tables = getCacheTableList();
        if(CollUtil.isEmpty(list)){
            for (Table tbl : tables) {
                if(tbl.getSqlName().equals(table)){
                    LinkedHashSet<Column> columnLinkedHashMap = tbl.getColumns();
                    for (Column column : columnLinkedHashMap) {
                        GenTableColumnStyleVo columnStyleVo = new GenTableColumnStyleVo();
                        columnStyleVo.setIsList(CommonConstant.DataStatusEnum.Y.getCode());
                        columnStyleVo.setColumn(column.getSqlName());
                        columnStyleVo.setDesc(column.getRemarks());
                        columnStyleVo.setFieldName(column.getColumnNameFirstLower());
                        columnStyleVo.setFieldType(column.getSimpleJavaType());
                        columnStyleVo.setTable(table);
                        list.add(columnStyleVo);
                    }
                }
            }
        }
        return list;
    }

    public void refreshCache() {
        cache.remove(CacheConsts.CACHE_KEY_GEN_TABLE);
        init();
    }

}
