package com.choudou5.javasaasx.dao.sys;

import com.choudou5.javasaasx.dao.orm.mybatis.MyBatisDao;
import com.choudou5.javasaasx.dao.sys.po.SysUserPo;
import com.choudou5.javasaasx.framework.dao.BaseDao;
import com.choudou5.javasaasx.framework.dao.CrudDao;

/**
 * @Name：系统用户 Dao
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-14
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
@MyBatisDao
public interface SysUserDao extends CrudDao<SysUserPo, String> {

}
