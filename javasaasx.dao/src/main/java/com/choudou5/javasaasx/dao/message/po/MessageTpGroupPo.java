/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.dao.message.po;

import com.choudou5.javasaasx.base.bean.AbstractBasePo;

/**
 * @Name：第三方消息群 Po
 * @Author：xuhaowen
 * @Date：2018-03-18
 */
public class MessageTpGroupPo extends AbstractBasePo{

    /**
     * 数据库字段：code 编码
     */
    private String code;
    /**
     * 数据库字段：tp_type 第三方类型
     */
    private String tpType;
    /**
     * 数据库字段：biz_type 业务类型
     */
    private String bizType;
    /**
     * 数据库字段：name 群组名
     */
    private String name;
    /**
     * 数据库字段：owner_id 群主id
     */
    private String ownerId;
    /**
     * 数据库字段：member_ids 成员id,逗号隔开
     */
    private String memberIds;
    /**
     * 数据库字段：env 环境: test/product
     */
    private String env;
    /**
     * 数据库字段：status 状态: 0=禁用，1=正常
     */
    private String status;

	public MessageTpGroupPo(){
	}

	public MessageTpGroupPo( String id ){
			setId(id);
	}

    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getTpType() {
        return this.tpType;
    }
    public void setTpType(String tpType) {
        this.tpType = tpType;
    }
    public String getBizType() {
        return this.bizType;
    }
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOwnerId() {
        return this.ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public String getMemberIds() {
        return this.memberIds;
    }
    public void setMemberIds(String memberIds) {
        this.memberIds = memberIds;
    }
    public String getEnv() {
        return this.env;
    }
    public void setEnv(String env) {
        this.env = env;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
