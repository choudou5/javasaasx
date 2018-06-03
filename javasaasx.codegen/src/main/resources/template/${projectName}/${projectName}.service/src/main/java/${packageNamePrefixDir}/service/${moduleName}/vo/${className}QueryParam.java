<#include "/java_copyright.include"/>
<#include "/macro.include"/>
<#assign className = table.className> 
<#assign classVOName = table.className + 'Vo'>
<#assign classPOName = table.className + 'Po'>
<#assign classNameLowerVo = classVOName?uncap_first>
package ${packageNamePrefix}.service.${moduleName}.vo;

import com.choudou5.base.bean.QueryParam;
import com.choudou5.base.mapper.BeanMapper;
import ${packageNamePrefix}.dao.${moduleName}.po.${classPOName};

/**
 * @Name：${table.remarks} 查询对象
 * @Author：${author}
 * @Date：${createTime}
 */
public class ${className}QueryParam extends QueryParam {

	private ${classVOName} ${classNameLowerVo};

	public ${classVOName} get${classVOName}() {
		return ${classNameLowerVo};
	}

	public ${className}QueryParam() {
	}

	public ${className}QueryParam(${classVOName} ${classNameLowerVo}) {
		set${classVOName}(${classNameLowerVo});
	}

	public void set${classVOName}(${classVOName} ${classNameLowerVo}) {
		this.${classNameLowerVo} = ${classNameLowerVo};
		${classPOName} po = BeanMapper.map(${classNameLowerVo}, ${classPOName}.class);
		setParamBean(po);
	}

	public ${classVOName} setDefVo() {
		if(${classNameLowerVo} == null)
			${classNameLowerVo} = new ${classVOName}();
		return ${classNameLowerVo};
	}


}
