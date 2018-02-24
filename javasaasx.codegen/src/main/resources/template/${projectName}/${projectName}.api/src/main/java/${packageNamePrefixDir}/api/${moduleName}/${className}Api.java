<#include "/java_copyright.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${packageNamePrefix}.api.${moduleName};

import ${packageNamePrefix}.base.bean.BaseBo;

import java.io.Serializable;



/**
 * @Name：${table.remarks} API
 * @Author：${author}
 * @Date：${createTime}
 */
public interface ${className}Api<B extends BaseBo> extends Serializable{

}
