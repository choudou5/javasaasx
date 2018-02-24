/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.dao.sys.po;

import com.choudou5.javasaasx.base.bean.AbstractBasePo;

/**
 * @Name：系统用户角色 Po
 * @Author：xuhaowen
 * @Date：2018-02-22
 */
public class SysUserRolePo extends AbstractBasePo{

    /**
     * 数据库字段：user_id 用户ID
     */
    private String userId;
    /**
     * 数据库字段：role_id 角色ID
     */
    private String roleId;

	public SysUserRolePo(){
	}

	public SysUserRolePo( String id ){
			setId(id);
	}

    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getRoleId() {
        return this.roleId;
    }
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
