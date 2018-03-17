/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.dao.dic.po;

import com.choudou5.javasaasx.base.bean.AbstractBasePo;

/**
 * @Name： 字典地区 Po
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
public class DicAreaPo extends AbstractBasePo{

    /**
     * 数据库字段：code 地区编码
     */
    private String code;
    /**
     * 数据库字段：name 地区名称
     */
    private String name;
    /**
     * 数据库字段：pcode 父级编码
     */
    private String pcode;
    /**
     * 数据库字段：pname 父级名称
     */
    private String pname;
    /**
     * 数据库字段：level 地区等级
     */
    private Integer level;
    /**
     * 数据库字段：geo 经纬度
     */
    private String geo;
    /**
     * 数据库字段：fullname 全名
     */
    private String fullname;
    /**
     * 数据库字段：pinyin 拼音
     */
    private String pinyin;
    /**
     * 数据库字段：pinyin_short 短拼音
     */
    private String pinyinShort;
    /**
     * 数据库字段：pinyin_first_letter 拼音首字母
     */
    private String pinyinFirstLetter;

	public DicAreaPo(){
	}

	public DicAreaPo( Integer id ){
			setId(id.toString());
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
    public String getPcode() {
        return this.pcode;
    }
    public void setPcode(String pcode) {
        this.pcode = pcode;
    }
    public String getPname() {
        return this.pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public Integer getLevel() {
        return this.level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public String getGeo() {
        return this.geo;
    }
    public void setGeo(String geo) {
        this.geo = geo;
    }
    public String getFullname() {
        return this.fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getPinyin() {
        return this.pinyin;
    }
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
    public String getPinyinShort() {
        return this.pinyinShort;
    }
    public void setPinyinShort(String pinyinShort) {
        this.pinyinShort = pinyinShort;
    }
    public String getPinyinFirstLetter() {
        return this.pinyinFirstLetter;
    }
    public void setPinyinFirstLetter(String pinyinFirstLetter) {
        this.pinyinFirstLetter = pinyinFirstLetter;
    }
}
