package com.choudou5.javasaasx.dao.sys.po;

import com.choudou5.javasaasx.framework.bean.AbstractBasePo;

/**
 * @Name：系统用户 Po
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-14
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public class SysUserPo extends AbstractBasePo{

    /**
     * 数据库字段：company_id 归属公司
     */
    private String companyId;
    /**
     * 数据库字段：office_id 归属部门，多个逗号隔开
     */
    private String officeId;
    /**
     * 数据库字段：job_number 工号
     */
    private String jobNumber;
    /**
     * 数据库字段：name 姓名
     */
    private String name;
    /**
     * 数据库字段：password 密码
     */
    private String password;
    /**
     * 数据库字段：english_name 英文名
     */
    private String englishName;
    /**
     * 数据库字段：is_admin 是否为管理员 0=否，1=是
     */
    private String isAdmin;
    /**
     * 数据库字段：is_boss 是否为老板 0=否，1=是
     */
    private String isBoss;
    /**
     * 数据库字段：email 邮箱
     */
    private String email;
    /**
     * 数据库字段：phone 电话
     */
    private String phone;
    /**
     * 数据库字段：mobile 手机
     */
    private String mobile;
    /**
     * 数据库字段：gender 性别。0=未定义，1=男性，2=女性
     */
    private String gender;
    /**
     * 数据库字段：avatar 头像
     */
    private String avatar;
    /**
     * 数据库字段：login_ip 最后登陆ip
     */
    private String loginIp;
    /**
     * 数据库字段：login_time 最后登陆时间
     */
    private java.util.Date loginTime;
    /**
     * 数据库字段：position 职位信息
     */
    private String position;
    /**
     * 数据库字段：remarks 备注信息
     */
    private String remarks;
    /**
     * 数据库字段：source 来源
     */
    private String source;
    /**
     * 数据库字段：status 状态: 0=禁用，1=正常, 2=离职
     */
    private String status;
    /**
     * 数据库字段：is_sys_data 是否系统数据: 0=否，1=是
     */
    private String isSysData;

	public SysUserPo(){
	}

	public SysUserPo( String id ){
		setId(id);
	}

    public String getCompanyId() {
        return this.companyId;
    }
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
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
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
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
    public String getSource() {
        return this.source;
    }
    public void setSource(String source) {
        this.source = source;
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
