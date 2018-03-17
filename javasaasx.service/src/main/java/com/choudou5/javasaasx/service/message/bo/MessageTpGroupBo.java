/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.message.bo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import com.choudou5.javasaasx.base.bean.BaseBo;

/**
 * @Name：第三方消息群 业务对象
 * @Author：xuhaowen
 * @Date：2018-03-18
 */
public class MessageTpGroupBo implements BaseBo<String> {

    /**  id */
	private String id;
    /**  编码 */
	private String code;
    /**  第三方类型 */
	private String tpType;
    /**  业务类型 */
	private String bizType;
    /**  群组名 */
	private String name;
    /**  群主id */
	private String ownerId;
    /**  成员id,逗号隔开 */
	private String memberIds;
    /**  创建者 */
	private String createBy;
    /**  创建时间 */
	private java.util.Date createTime;
    /**  环境: test/product */
	private String env;
    /**  状态: 0=禁用，1=正常 */
	private String status;

	public MessageTpGroupBo(){
	}

	public MessageTpGroupBo( String id ){
			setId(id);
	}

	public MessageTpGroupBo(String tpType, String bizType, String env) {
		this.tpType = tpType;
		this.bizType = bizType;
		this.env = env;
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@NotBlank(message="编码不能为空")
	@Length(min=1, max=64, message="编码长度必须介于 1 和 64 之间")
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

	@NotBlank(message="环境: test/product不能为空")
	@Length(min=1, max=10, message="环境: test/product长度必须介于 1 和 10 之间")
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

