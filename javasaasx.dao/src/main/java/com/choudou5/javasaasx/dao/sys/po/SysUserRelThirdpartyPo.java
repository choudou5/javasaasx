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
 * @Name：用户关联第三方 Po
 * @Author：xuhaowen
 * @Date：2018-02-19
 */
public class SysUserRelThirdpartyPo extends AbstractBasePo{

    /**
     * 数据库字段：user_id 用户ID
     */
    private String userId;
    /**
     * 数据库字段：ding_user_id 钉钉用户ID
     */
    private String dingUserId;
    /**
     * 数据库字段：ding_union_id 钉钉唯一标识
     */
    private String dingUnionId;
    /**
     * 数据库字段：ding_global_id 钉钉全局标识
     */
    private String dingGlobalId;
    /**
     * 数据库字段：wwx_union_id 企业微信唯一标识
     */
    private String wwxUnionId;
    /**
     * 数据库字段：wwx_global_id 企业微信全局标识
     */
    private String wwxGlobalId;

	public SysUserRelThirdpartyPo(){
	}

	public SysUserRelThirdpartyPo( String userId ){
			setId(userId);
	}

    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getDingUserId() {
        return this.dingUserId;
    }
    public void setDingUserId(String dingUserId) {
        this.dingUserId = dingUserId;
    }
    public String getDingUnionId() {
        return this.dingUnionId;
    }
    public void setDingUnionId(String dingUnionId) {
        this.dingUnionId = dingUnionId;
    }
    public String getDingGlobalId() {
        return this.dingGlobalId;
    }
    public void setDingGlobalId(String dingGlobalId) {
        this.dingGlobalId = dingGlobalId;
    }
    public String getWwxUnionId() {
        return this.wwxUnionId;
    }
    public void setWwxUnionId(String wwxUnionId) {
        this.wwxUnionId = wwxUnionId;
    }
    public String getWwxGlobalId() {
        return this.wwxGlobalId;
    }
    public void setWwxGlobalId(String wwxGlobalId) {
        this.wwxGlobalId = wwxGlobalId;
    }
}
