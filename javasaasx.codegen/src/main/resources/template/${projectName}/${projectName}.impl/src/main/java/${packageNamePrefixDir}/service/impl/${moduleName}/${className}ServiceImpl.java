<#include "/java_copyright.include"/>
<#assign className = table.className>
<#assign classPOName = table.className + 'Po'>
<#assign classBOName = table.className + 'Bo'>
<#assign classNameLower = className?uncap_first>
package ${packageNamePrefix}.service.impl.${moduleName};

import ${packageNamePrefix}.dao.${moduleName}.${className}Dao;
import ${packageNamePrefix}.dao.${moduleName}.po.${classPOName};
import ${packageNamePrefix}.service.${moduleName}.bo.${classBOName};
import ${packageNamePrefix}.base.dao.BaseDao;
import ${packageNamePrefix}.service.impl.BaseServiceImpl;
import ${packageNamePrefix}.service.${moduleName}.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：${table.remarks} 接口实现类
 * @Author：${author}
 * @Date：${createTime}
 */
@Service("${classNameLower}Service")
public class ${className}ServiceImpl extends BaseServiceImpl<${classPOName}, ${classBOName}> implements ${className}Service {

    @Autowired
    private ${className}Dao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
