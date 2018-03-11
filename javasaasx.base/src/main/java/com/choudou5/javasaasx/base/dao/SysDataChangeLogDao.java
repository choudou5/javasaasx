/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.base.dao;

import com.choudou5.javasaasx.base.dao.po.SysDataChangeLogPo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.base.orm.mybatis.MyBatisDao;

/**
 * @Name：系统数据变更日志 Dao
 * @Author：xuhaowen
 * @Date：2018-03-11
 */
@MyBatisDao
public interface SysDataChangeLogDao extends BaseDao<SysDataChangeLogPo, String> {

}
