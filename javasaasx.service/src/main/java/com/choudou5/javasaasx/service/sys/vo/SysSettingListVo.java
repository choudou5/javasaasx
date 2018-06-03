/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.sys.vo;

import java.io.Serializable;

/**
 * @Name：系统设置 Vo
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class SysSettingListVo implements Serializable {

    /** id */
    private String id;
    /** 类型code */
    private String typeCode;
    /** code */
    private String code;
    /** 名称 */
    private String name;
    /** 值 */
    private String value;
    /** 备注 */
    private String remark;
    /** 预留字段1 */
    private String ext1;
    /** 预留字段2 */
    private String ext2;
    /** 预留字段3 */
    private String ext3;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    private java.util.Date createTime;
    /** 更新者 */
    private String updateBy;
    /** 更新时间 */
    private java.util.Date updateTime;
    /** 状态: 0=禁用，1=正常 */
    private String status;
    /** 删除标记：0=已删除,1=正常 */
    private String delFlag;

	public SysSettingListVo(){
	}

	public SysSettingListVo( String id ){
			setId(id);
	}

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTypeCode() {
        return this.typeCode;
    }
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return this.remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExt1() {
        return this.ext1;
    }
    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return this.ext2;
    }
    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return this.ext3;
    }
    public void setExt3(String ext3) {
        this.ext3 = ext3;
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

    public String getDelFlag() {
        return this.delFlag;
    }
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}
