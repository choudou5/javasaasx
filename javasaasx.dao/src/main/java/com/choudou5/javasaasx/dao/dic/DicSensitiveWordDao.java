/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.dao.dic;

import com.choudou5.javasaasx.base.orm.mybatis.MyBatisDao;
import com.choudou5.javasaasx.dao.dic.po.DicSensitiveWordPo;
import com.choudou5.javasaasx.base.dao.BaseDao;

import java.util.List;

/**
 * @Name：敏感词库 Dao
 * @Author：xuhaowen
 * @Date：2018-03-04
 */
@MyBatisDao
public interface DicSensitiveWordDao extends BaseDao<DicSensitiveWordPo, String> {

    List<String> findAllWord();
}
