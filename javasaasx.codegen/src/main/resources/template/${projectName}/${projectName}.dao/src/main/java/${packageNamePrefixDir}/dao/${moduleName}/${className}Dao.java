<#include "/java_copyright.include"/>
<#include "/macro.include"/>
<#assign className = table.className>
<#assign classPOName = table.className + 'Po'>
<#assign pkJavaType = table.pkJavaType>
package ${packageNamePrefix}.dao.${moduleName};

import ${packageNamePrefix}.dao.orm.mybatis.MyBatisDao;
import ${packageNamePrefix}.dao.${moduleName}.po.${classPOName};
import ${packageNamePrefix}.framework.dao.BaseDao;

/**
 * @Name：${table.remarks} Dao
 * @Author：${author}
 * @Date：${createTime}
 */
@MyBatisDao
public interface ${className}Dao extends BaseDao<${classPOName}, ${pkJavaType}> {

}
