package com.choudou5.javasaasx.service.sys.bo;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * @Name：说明
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 19:52
 * @Site：http://solrhome.com
 * @License：MIT
 */
public class SysUserBo {

    private String id;
    private String unionId;		// 唯一标识
    private String globalId;		// 全局标识
    private String companyId;		// 归属公司
    private String officeId;		// 归属部门，多个逗号隔开
    private String jobNumber;		// 工号
    private String name;		// 姓名
    private String password;		// 密码
    private String englishName;		// 英文名
    private String isAdmin;		// 是否为管理员 true/false
    private String isBoss;		// 是否为老板 true/false
    private String email;		// 邮箱
    private String phone;		// 电话
    private String mobile;		// 手机
    private String gender;		// 性别。0=未定义，1=男性，2=女性
    private String avatar;		// 头像
    private String loginIp;		// 最后登陆IP
    private Date loginDate;		// 最后登陆时间
    private String position;		// 职位信息
    private String status;		// 状态: 0=禁用，1=激活, 2=离职
    private String dataMd5;		// 数据md5码(检测是否有变更)

    private String[] roleIds;

    public SysUserBo() {
        super();
    }

    public SysUserBo baseLoginInfo() {
        this.unionId = null;
        this.globalId = null;
        this.dataMd5 = null;
        this.password = null;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Length(min=0, max=64, message="唯一标识长度必须介于 0 和 64 之间")
    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    @Length(min=0, max=64, message="全局标识长度必须介于 0 和 64 之间")
    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    @Length(min=1, max=64, message="归属公司长度必须介于 1 和 64 之间")
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Length(min=1, max=64, message="归属部门，多个逗号隔开长度必须介于 1 和 64 之间")
    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    @Length(min=0, max=32, message="工号长度必须介于 0 和 32 之间")
    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    @Length(min=1, max=32, message="姓名长度必须介于 1 和 32 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min=1, max=100, message="密码长度必须介于 1 和 100 之间")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Length(min=0, max=32, message="英文名长度必须介于 0 和 32 之间")
    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @Length(min=0, max=8, message="是否为管理员 true/false长度必须介于 0 和 8 之间")
    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Length(min=0, max=8, message="是否为老板 true/false长度必须介于 0 和 8 之间")
    public String getIsBoss() {
        return isBoss;
    }

    public void setIsBoss(String isBoss) {
        this.isBoss = isBoss;
    }

    @Length(min=0, max=64, message="邮箱长度必须介于 0 和 64 之间")
    public String getEmail() {
        return email;
    }

    public SysUserBo setEmail(String email) {
        this.email = email;
        return this;
    }

    @Length(min=0, max=11, message="电话长度必须介于 0 和 11 之间")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Length(min=0, max=11, message="手机长度必须介于 0 和 11 之间")
    public String getMobile() {
        return mobile;
    }

    public SysUserBo setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    @Length(min=0, max=1, message="性别。0=未定义，1=男性，2=女性长度必须介于 0 和 1 之间")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Length(min=0, max=128, message="头像长度必须介于 0 和 128 之间")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Length(min=0, max=18, message="最后登陆IP长度必须介于 0 和 18 之间")
    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Length(min=0, max=64, message="职位信息长度必须介于 0 和 64 之间")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Length(min=1, max=1, message="状态: 0=禁用，1=激活, 2=离职长度必须介于 1 和 1 之间")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SysUserBo setUsable(boolean usable) {
        this.status = usable?"0":"1"; // 状态: 0=禁用，1=激活, 2=离职
        return this;
    }

    @Length(min=0, max=32, message="数据md5码(检测是否有变更)长度必须介于 0 和 32 之间")
    public String getDataMd5() {
        return dataMd5;
    }

    public void setDataMd5(String dataMd5) {
        this.dataMd5 = dataMd5;
    }

    public String[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }

}
