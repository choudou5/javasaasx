<#include "/java_copyright.include"/>
<#include "/macro.include"/>
<#assign className = table.className> 
<#assign classBOName = table.className + 'Bo'>
<#assign classNameLower = className?uncap_first>
package ${packageNamePrefix}.service.${moduleName}.bo;

<#if isAddValidAnnotationToBo=='true'>
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
</#if>
import ${packageNamePrefix}.base.bean.BaseBo;

import java.io.Serializable;

/**
 * @Name：${table.remarks} 业务对象
 * @Author：${author}
 * @Date：${createTime}
 */
public class ${classBOName} implements BaseBo {

	<#list table.columns as column>
    /**  ${column.columnAlias!} */
	private ${column.javaType} ${column.columnNameFirstLower};
	</#list>

<@generateConstructor classBOName/>
<@generateJavaColumns/>
<@generateJavaOneToMany/>
<@generateJavaManyToOne/>
	
}

<#macro generateJavaColumns>
	<#list table.columns as column>
	<#if isAddValidAnnotationToBo=='true'>
	<#list column.simpleAnnotationList as annotation>
	@${annotation}
	</#list>
	</#if>
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameFirstLower};
	}
	public void set${column.columnName}(${column.javaType} ${column.columnNameFirstLower}) {
		this.${column.columnNameFirstLower} = ${column.columnNameFirstLower};
	}

	</#list>
</#macro>

<#macro generateJavaOneToMany>
	<#list table.exportedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	private Set ${fkPojoClassVar}s = new HashSet(0);
	public void set${fkPojoClass}s(Set<${fkPojoClass}> ${fkPojoClassVar}){
		this.${fkPojoClassVar}s = ${fkPojoClassVar};
	}
	
	public Set<${fkPojoClass}> get${fkPojoClass}s() {
		return ${fkPojoClassVar}s;
	}
	</#list>
</#macro>

<#macro generateJavaManyToOne>
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	private ${fkPojoClass} ${fkPojoClassVar};
	
	public void set${fkPojoClass}(${fkPojoClass} ${fkPojoClassVar}){
		this.${fkPojoClassVar} = ${fkPojoClassVar};
	}
	
	public ${fkPojoClass} get${fkPojoClass}() {
		return ${fkPojoClassVar};
	}
	</#list>
</#macro>
