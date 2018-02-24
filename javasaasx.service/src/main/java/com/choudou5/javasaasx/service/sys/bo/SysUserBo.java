/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.sys.bo;

import com.choudou5.javasaasx.base.bean.BaseBo;
import org.hibernate.validator.constraints.Length;

/**
 * @Name：系统用户 业务对象
 * @Author：菜单管理
 * @Date：2018-02-18
 */
public class SysUserBo implements BaseBo {

    /**  用户id */
	private String id;
    /**  归属公司 */
	private String companyId;
    /**  归属部门，多个逗号隔开 */
	private String officeId;
    /**  工号 */
	private String jobNumber;
    /**  姓名 */
	private String name;
    /**  密码 */
	private String password;
    /**  英文名 */
	private String englishName;
    /**  是否为管理员 0=否，1=是 */
	private String isAdmin;
    /**  是否为老板 0=否，1=是 */
	private String isBoss;
    /**  邮箱 */
	private String email;
    /**  电话 */
	private String phone;
    /**  手机 */
	private String mobile;
    /**  性别。0=未定义，1=男性，2=女性 */
	private String gender;
    /**  头像 */
	private String avatar;
    /**  最后登陆ip */
	private String loginIp;
    /**  最后登陆时间 */
	private java.util.Date loginTime;
    /**  职位信息 */
	private String position;
    /**  备注信息 */
	private String remarks;
    /**  来源 */
	private String source;
    /**  创建者 */
	private String createBy;
    /**  创建时间 */
	private java.util.Date createTime;
    /**  更新者 */
	private String updateBy;
    /**  更新时间 */
	private java.util.Date updateTime;
    /**  状态: 0=禁用，1=正常, 2=离职 */
	private String status;
    /**  是否系统数据: 0=否，1=是 */
	private String isSysData;
    /**  删除标记：0=已删除,1=正常 */
	private String delFlag;

	private SysUserRelThirdpartyBo tpBo;

	public SysUserBo(){
	}

	public SysUserBo( String id ){
			setId(id);
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Length(min=0, max=64, message="归属公司长度必须介于 0 和 64 之间")
	public String getCompanyId() {
		return this.companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Length(min=0, max=64, message="归属部门，多个逗号隔开长度必须介于 0 和 64 之间")
	public String getOfficeId() {
		return this.officeId;
	}
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getJobNumber() {
		return this.jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	@Length(min=0, max=32, message="姓名长度必须介于 0 和 32 之间")
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Length(min=0, max=100, message="密码长度必须介于 0 和 100 之间")
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnglishName() {
		return this.englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getIsAdmin() {
		return this.isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getIsBoss() {
		return this.isBoss;
	}
	public void setIsBoss(String isBoss) {
		this.isBoss = isBoss;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAvatar() {
		return this.avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getLoginIp() {
		return this.loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public java.util.Date getLoginTime() {
		return this.loginTime;
	}
	public void setLoginTime(java.util.Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getPosition() {
		return this.position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public String getRemarks() {
		return this.remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Length(min=0, max=16, message="来源长度必须介于 0 和 16 之间")
	public String getSource() {
		return this.source;
	}
	public void setSource(String source) {
		this.source = source;
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

	public String getUpdateBy() {
		return this.updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
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

	public String getDelFlag() {
		return this.delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public SysUserRelThirdpartyBo getTpBo() {
		return tpBo;
	}
	public void setTpBo(SysUserRelThirdpartyBo tpBo) {
		this.tpBo = tpBo;
	}
}