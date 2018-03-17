/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.dao.sys.po;

import com.choudou5.javasaasx.base.bean.AbstractBasePo;

/**
 * @Name：系统角色 Po
 * @Author：xuhaowen
 * @Date：2018-02-22
 */
public class SysRolePo extends AbstractBasePo{

    /**
     * 数据库字段：office_id 归属机构
     */
    private String officeId;
    /**
     * 数据库字段：group_name 分组名
     */
    private String groupName;
    /**
     * 数据库字段：name 角色名称
     */
    private String name;
    /**
     * 数据库字段：data_scope 数据范围: 0=个人，1=本机构，2=所有
     */
    private String dataScope;
    /**
     * 数据库字段：remarks 备注信息
     */
    private String remarks;
    /**
     * 数据库字段：status 状态: 0=禁用，1=正常
     */
    private String status;
    /**
     * 数据库字段：is_sys_data 是否系统数据: 0=否，1=是
     */
    private String isSysData;

	public SysRolePo(){
	}

	public SysRolePo( String id ){
			setId(id);
	}

    public String getOfficeId() {
        return this.officeId;
    }
    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }
    public String getGroupName() {
        return this.groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDataScope() {
        return this.dataScope;
    }
    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }
    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getIsSysData() {
        return this.isSysData;
    }
    public void setIsSysData(String isSysData) {
        this.isSysData = isSysData;
    }
}
