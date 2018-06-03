<#include "/java_copyright.include"/>
<#assign className = table.className>
<#assign classPOName = table.className + 'Po'>
<#assign classVOName = table.className + 'Vo'>
<#assign classNameLower = className?uncap_first>
package ${packageNamePrefix}.service.${moduleName};

import ${packageNamePrefix}.dao.${moduleName}.${className}Dao;
import ${packageNamePrefix}.dao.${moduleName}.po.${classPOName};
import ${packageNamePrefix}.service.${moduleName}.vo.${classVOName};
import ${packageNamePrefix}.base.dao.BaseDao;
import ${packageNamePrefix}.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：${table.remarks} Service实现类
 * @Author：${author}
 * @Date：${createTime}
 */
@Service("${classNameLower}Service")
public class ${className}Service extends BaseService<${classPOName}, ${classVOName}>{

    @Autowired
    private ${className}Dao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

}
