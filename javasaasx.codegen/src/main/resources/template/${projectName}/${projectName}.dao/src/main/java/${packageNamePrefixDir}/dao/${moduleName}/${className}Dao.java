<#include "/java_copyright.include"/>
<#include "/macro.include"/>
<#assign className = table.className>
<#assign classPOName = table.className + 'Po'>
<#assign pkJavaType = table.pkJavaType>
package ${packageNamePrefix}.dao.${moduleName};

import ${packageNamePrefix}.dao.${moduleName}.po.${classPOName};
import ${packageNamePrefix}.base.dao.BaseDao;
import ${packageNamePrefix}.base.dao.orm.mybatis.MyBatisDao;

/**
 * @Name：${table.remarks} Dao
 * @Author：${author}
 * @Date：${createTime}
 */
@MyBatisDao
public interface ${className}Dao extends BaseDao<${classPOName}, ${pkJavaType}> {

}
