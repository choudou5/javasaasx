package com.choudou5.javasaasx.service.impl.gen;

import cn.org.rapid_framework.generator.provider.db.DataCollectionInfo;
import cn.org.rapid_framework.generator.provider.db.table.TableFactory;
import cn.org.rapid_framework.generator.provider.db.table.model.Column;
import cn.org.rapid_framework.generator.provider.db.table.model.Table;
import com.choudou5.javasaasx.common.constants.SysPropConsts;
import com.choudou5.javasaasx.common.properties.PropertiesUtil;
import com.choudou5.javasaasx.dao.gen.GenTableColumnStyleDao;
import com.choudou5.javasaasx.framework.bean.SelectBo;
import com.choudou5.javasaasx.framework.bean.TableDataBo;
import com.choudou5.javasaasx.framework.dao.BaseDao;
import com.choudou5.javasaasx.service.gen.GenTableColumnStyleService;
import com.choudou5.javasaasx.service.gen.bo.GenTableColumnStyleBo;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import com.xiaoleilu.hutool.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @Name：生成表字段样式 接口实现类
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-14
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
@Service("genTableColumnStyleService")
public class GenTableColumnStyleServiceImpl extends BaseServiceImpl<GenTableColumnStyleBo> implements GenTableColumnStyleService {

    @Autowired
    private GenTableColumnStyleDao dao;

    private static List<Table> tables = null;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

    private static DataCollectionInfo collectionInfo = null;
    static {
        collectionInfo = new DataCollectionInfo();
        collectionInfo.setUrl(PropertiesUtil.getString(SysPropConsts.JDBC_URL));
        collectionInfo.setUsername(PropertiesUtil.getString(SysPropConsts.JDBC_USERNAME));
        collectionInfo.setPassword(PropertiesUtil.getString(SysPropConsts.JDBC_PASSWORD));
        collectionInfo.setDriverClass(PropertiesUtil.getString(SysPropConsts.JDBC_DRIVER));
    }

    @Override
    public List<SelectBo> getTableList() {
        tables = TableFactory.getInstance().getAllTables(collectionInfo);
        List<SelectBo> list = new ArrayList<>();
        if(CollectionUtil.isNotEmpty(tables)){
            for (Table table : tables) {
                list.add(new SelectBo(table.getSqlName()+"  "+table.getRemarks(), table.getSqlName()));
            }
        }
        return list;
    }

    @Override
    public TableDataBo getGenTableColumnStyleList(String table) {
        List<GenTableColumnStyleBo> list = new ArrayList<>();
        for (Table tbl : tables) {
            if(tbl.getSqlName().equals(table)){
                LinkedHashSet<Column> columnLinkedHashMap = tbl.getColumns();
                for (Column column : columnLinkedHashMap) {
                    GenTableColumnStyleBo columnStyleBo = new GenTableColumnStyleBo();
                    columnStyleBo.setColumn(column.getSqlName());
                    columnStyleBo.setColumnName(column.getRemarks());
                    list.add(columnStyleBo);
                }
            }
        }
        return new TableDataBo(list);
    }
}