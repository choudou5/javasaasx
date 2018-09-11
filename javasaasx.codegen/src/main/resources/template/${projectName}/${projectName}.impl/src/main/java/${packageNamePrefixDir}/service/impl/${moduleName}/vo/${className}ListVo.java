package template.$

<#include "/java_copyright.include"/>
<#assign classVOName = table.className + 'Vo'>
package ${packageNamePrefix}.service.impl.${moduleName}.vo;

import java.io.Serializable;

/**
 * @Name：${table.remarks} Vo
 * @Author：${author}
 * @Date：${createTime}
 */
public class ${classVOName} implements Serializable {

    <#list table.columns as column>
    <#if !column.abstractField>
    /** ${column.columnAlias!} */
    private ${column.javaType} ${column.columnNameFirstLower};
    </#if>
    </#list>

    <@generateConstructor classVOName/>
    <@generateJavaColumns/>
    <@generateJavaOneToMany/>
    <@generateJavaManyToOne/>
}
    <#macro generateJavaColumns>
    <#list table.columns as column>
    <#if !column.abstractField>
    public ${column.javaType} get${column.columnName}() {
        return this.${column.columnNameFirstLower};
    }
    public void set${column.columnName}(${column.javaType} ${column.columnNameFirstLower}) {
        this.${column.columnNameFirstLower} = ${column.columnNameFirstLower};
    }
    </#if>
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