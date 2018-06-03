/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.sys.vo;

import com.choudou5.javasaasx.base.bean.BaseVo;

/**
 * @Name：系统用户角色 Vo
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class SysUserRoleVo implements BaseVo<String> {

    /** id */
    private String id;
    /** 用户ID */
    private String userId;
    /** 角色ID */
    private String roleId;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    private java.util.Date createTime;

	public SysUserRoleVo(){
	}

	public SysUserRoleVo( String id ){
			setId(id);
	}

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
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

    public String getCreateBy() {
        return this.createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

}
