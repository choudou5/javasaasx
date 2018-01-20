<#assign className = table.className>
<#assign classBOName = table.className + 'Bo'>
<#assign classNameLower = className?uncap_first>
package ${packageNamePrefix}.service.${moduleName};

import ${packageNamePrefix}.framework.bean.BaseBo;
import ${packageNamePrefix}.framework.service.BaseService;
import ${packageNamePrefix}.service.${moduleName}.bo.${classBOName};

/**
 * @Name：${table.remarks} 接口
 * @Author：${author}
 * @Date：${createTime}
 * @Site：${site}
 * @License：${license}
 * @Copyright：${copyright}
 */
public interface ${className}Service extends BaseService<${classBOName}> {


}
