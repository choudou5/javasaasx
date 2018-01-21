<#include "/macro.include"/>
<#assign className = table.className> 
<#assign classBOName = table.className + 'Bo'>
<#assign classNameLowerBo = classBOName?uncap_first>
package ${packageNamePrefix}.service.${moduleName}.bo;

import ${packageNamePrefix}.framework.bean.BaseBo;
import ${packageNamePrefix}.framework.bean.QueryParam;

/**
 * @Name：${table.remarks} 查询对象
 * @Author：${author}
 * @Date：${createTime}
 * @Site：${site}
 * @License：${license}
 * @Copyright：${copyright}
 */
public class ${className}QueryParam extends QueryParam {

	private ${classBOName} ${classNameLowerBo};

	public ${classBOName} get${classBOName}() {
		return ${classNameLowerBo};
	}

	public ${className}QueryParam() {
	}

	public ${className}QueryParam(${classBOName} ${classNameLowerBo}) {
		this.${classNameLowerBo} = ${classNameLowerBo};
	}

	public void set${classBOName}(${classBOName} ${classNameLowerBo}) {
		this.${classNameLowerBo} = ${classNameLowerBo};
		setParamBean(${classNameLowerBo});
	}
}
