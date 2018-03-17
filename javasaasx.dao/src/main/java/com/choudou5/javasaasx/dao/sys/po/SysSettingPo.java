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
 * @Name：系统设置 Po
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
public class SysSettingPo extends AbstractBasePo{

    /**
     * 数据库字段：type_code 类型code
     */
    private String typeCode;
    /**
     * 数据库字段：code code
     */
    private String code;
    /**
     * 数据库字段：name 名称
     */
    private String name;
    /**
     * 数据库字段：value 值
     */
    private String value;
    /**
     * 数据库字段：remark 备注
     */
    private String remark;
    /**
     * 数据库字段：ext_1 预留字段1
     */
    private String ext1;
    /**
     * 数据库字段：ext_2 预留字段2
     */
    private String ext2;
    /**
     * 数据库字段：ext_3 预留字段3
     */
    private String ext3;
    /**
     * 数据库字段：status 状态: 0=禁用，1=正常
     */
    private String status;

	public SysSettingPo(){
	}

	public SysSettingPo( String id ){
			setId(id);
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
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
