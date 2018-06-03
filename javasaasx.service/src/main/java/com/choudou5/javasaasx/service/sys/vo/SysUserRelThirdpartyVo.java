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
 * @Name：用户关联第三方 Vo
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class SysUserRelThirdpartyVo implements BaseVo<String> {

    /** 用户ID */
    private String userId;
    /** 钉钉用户ID */
    private String dingUserId;
    /** 钉钉唯一标识 */
    private String dingUnionId;
    /** 钉钉全局标识 */
    private String dingGlobalId;
    /** 企业微信唯一标识 */
    private String wwxUnionId;
    /** 企业微信全局标识 */
    private String wwxGlobalId;

	public SysUserRelThirdpartyVo(){
	}

	public SysUserRelThirdpartyVo( String userId ){
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

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }
}
