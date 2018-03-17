/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.dao.sys;

import com.choudou5.javasaasx.base.orm.mybatis.MyBatisDao;
import com.choudou5.javasaasx.dao.sys.po.SysMenuPo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

/**
 * @Name：菜单表 Dao
 * @Author：xuhaowen
 * @Date：2018-02-15
 */
@MyBatisDao
public interface SysMenuDao extends BaseDao<SysMenuPo, String> {

    void updateField(@Param("id")String id, @Param("sqlField")String sqlField, @Param("value")Object value);

    void logicDeleteByPid(String pid);
}
