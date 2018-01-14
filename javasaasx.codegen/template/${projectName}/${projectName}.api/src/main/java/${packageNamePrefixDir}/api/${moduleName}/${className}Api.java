<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${packageNamePrefix}.api.${moduleName};

import ${packageNamePrefix}.framework.bean.BaseBo;

import java.io.Serializable;



/**
 * @Name：${table.remarks} API
 * @Author：${author}
 * @Date：${createTime}
 * @Site：${site}
 * @License：${license}
 * @Copyright：${copyright}
 */
public interface ${className}Api<B extends BaseBo> extends Serializable{

}
