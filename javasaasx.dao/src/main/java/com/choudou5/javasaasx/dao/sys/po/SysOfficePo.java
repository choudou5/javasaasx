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
 * @Name：系统机构 Po
 * @Author：xuhaowen
 * @Date：2018-02-18
 */
public class SysOfficePo extends AbstractBasePo{

    /**
     * 数据库字段：name 名称
     */
    private String name;
    /**
     * 数据库字段：p_id 上级id
     */
    private String pid;
    /**
     * 数据库字段：p_path 父路径
     */
    private String ppath;
    /**
     * 数据库字段：depth 层级深度
     */
    private Integer depth;
    /**
     * 数据库字段：sort 排序
     */
    private Integer sort;
    /**
     * 数据库字段：area_code 区域编码
     */
    private String areaCode;
    /**
     * 数据库字段：type 机构类型: company=公司、dept=部门
     */
    private String type;
    /**
     * 数据库字段：address 联系地址
     */
    private String address;
    /**
     * 数据库字段：master 负责人
     */
    private String master;
    /**
     * 数据库字段：tel 电话
     */
    private String tel;
    /**
     * 数据库字段：remarks 备注信息
     */
    private String remarks;
    /**
     * 数据库字段：code code标识
     */
    private String code;
    /**
     * 数据库字段：status 状态: 0=禁用，1=正常
     */
    private String status;
    /**
     * 数据库字段：is_sys_data 是否系统数据: 0=否，1=是
     */
    private String isSysData;

	public SysOfficePo(){
	}

	public SysOfficePo( String id ){
			setId(id);
	}

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPid() {
        return this.pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getPpath() {
        return this.ppath;
    }
    public void setPpath(String ppath) {
        this.ppath = ppath;
    }
    public Integer getDepth() {
        return this.depth;
    }
    public void setDepth(Integer depth) {
        this.depth = depth;
    }
    public Integer getSort() {
        return this.sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getAreaCode() {
        return this.areaCode;
    }
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMaster() {
        return this.master;
    }
    public void setMaster(String master) {
        this.master = master;
    }
    public String getTel() {
        return this.tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
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
