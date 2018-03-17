/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.dic.bo;

import org.hibernate.validator.constraints.Length;
import com.choudou5.javasaasx.base.bean.BaseBo;

import java.io.Serializable;

/**
 * @Name： 字典地区 业务对象
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
public class DicAreaBo implements BaseBo<Integer> {

    /**  ID */
	private Integer id;
    /**  地区编码 */
	private String code;
    /**  地区名称 */
	private String name;
    /**  父级编码 */
	private String pcode;
    /**  父级名称 */
	private String pname;
    /**  地区等级 */
	private Integer level;
    /**  经纬度 */
	private String geo;
    /**  全名 */
	private String fullname;
    /**  拼音 */
	private String pinyin;
    /**  短拼音 */
	private String pinyinShort;
    /**  拼音首字母 */
	private String pinyinFirstLetter;

	public DicAreaBo(){
	}

	public DicAreaBo( Integer id ){
			setId(id);
	}

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
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

