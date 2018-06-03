/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.message.vo;

import com.choudou5.javasaasx.base.bean.BaseVo;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Name：第三方消息群 Vo
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class MessageTpGroupVo implements BaseVo<String> {

    /** id */
    private String id;
    /** 编码 */
    private String code;
    /** 第三方类型 */
    private String tpType;
    /** 业务类型 */
    private String bizType;
    /** 群组名 */
    private String name;
    /** 群主id */
    private String ownerId;
    /** 成员id,逗号隔开 */
    private String memberIds;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    private java.util.Date createTime;
    /** 状态: 0=禁用，1=正常 */
    private String status;

	public MessageTpGroupVo(){
	}

	public MessageTpGroupVo( String id ){
			setId(id);
	}

    public MessageTpGroupVo(String tpType, String bizType) {
        this.tpType = tpType;
        this.bizType = bizType;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @NotBlank(message="第三方类型不能为空")
    @Length(min=1, max=32, message="第三方类型长度必须介于 1 和 32 之间")
    public String getTpType() {
        return this.tpType;
    }
    public void setTpType(String tpType) {
        this.tpType = tpType;
    }

    @NotBlank(message="业务类型不能为空")
    @Length(min=1, max=32, message="业务类型长度必须介于 1 和 32 之间")
    public String getBizType() {
        return this.bizType;
    }
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    @NotBlank(message="群组名不能为空")
    @Length(min=1, max=36, message="群组名长度必须介于 1 和 36 之间")
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message="群主id不能为空")
    @Length(min=1, max=32, message="群主id长度必须介于 1 和 32 之间")
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

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


}

