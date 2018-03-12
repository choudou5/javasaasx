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
 * @Name：系统机构 业务对象
 * @Author：xuhaowen
 * @Date：2018-02-18
 */
public class SysOfficeBo implements BaseBo<String> {

    /**  编号 */
	private String id;
    /**  名称 */
	private String name;
    /**  上级id */
	private String pid;
    /**  父路径 */
	private String ppath;
    /**  层级深度 */
	private Integer depth;
    /**  排序 */
	private Integer sort;
    /**  区域编码 */
	private String areaCode;
    /**  机构类型: company=公司、dept=部门 */
	private String type;
    /**  联系地址 */
	private String address;
    /**  负责人 */
	private String master;
    /**  电话 */
	private String tel;
    /**  备注信息 */
	private String remarks;
    /**  code标识 */
	private String code;
    /**  创建者 */
	private String createBy;
    /**  创建时间 */
	private java.util.Date createTime;
    /**  创建者 */
	private String updateBy;
    /**  更新时间 */
	private java.util.Date updateTime;
    /**  状态: 0=禁用，1=正常 */
	private String status;
    /**  是否系统数据: 0=否，1=是 */
	private String isSysData;
    /**  删除标记：0=已删除,1=正常 */
	private String delFlag;

	public SysOfficeBo(){
	}

	public SysOfficeBo( String id ){
			setId(id);
	}

	public SysOfficeBo(String id, String name, String pid) {
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.type = "dept";
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Length(min=0, max=64, message="名称长度必须介于 0 和 64 之间")
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

	@Length(min=0, max=16, message="机构类型: company=公司、dept=部门长度必须介于 0 和 16 之间")
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

	
}

