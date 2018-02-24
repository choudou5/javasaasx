<#include "/java_copyright.include"/>
<#assign classPOName = table.className + 'Po'>
package ${packageNamePrefix}.dao.${moduleName}.po;

import ${packageNamePrefix}.base.bean.AbstractBasePo;

/**
 * @Name：${table.remarks} Po
 * @Author：${author}
 * @Date：${createTime}
 */
public class ${classPOName} extends AbstractBasePo{

    <#list table.columns as column>
    <#if !column.abstractField>
    /**
     * 数据库字段：${column.sqlName} ${column.columnAlias!}
     */
    private ${column.javaType} ${column.columnNameFirstLower};
    </#if>
    </#list>

    <@generateConstructor classPOName/>
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