package com.choudou5.javasaasx.dao.sys;

import com.choudou5.javasaasx.dao.orm.mybatis.MyBatisDao;
import com.choudou5.javasaasx.dao.sys.po.SysMenuPo;
import com.choudou5.javasaasx.framework.dao.BaseDao;

/**
 * @Name：菜单表 Dao
 * @Author：xuhaowen
 * @Date：2018-01-18
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
@MyBatisDao
public interface SysMenuDao extends BaseDao<SysMenuPo, String> {

}
