/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.dic.bo;

import com.choudou5.javasaasx.base.bean.BaseBo;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Name：敏感词库 业务对象
 * @Author：xuhaowen
 * @Date：2018-03-05
 */
public class DicSensitiveWordBo implements BaseBo {

    /**  id */
	private Long id;
    /**  敏感词 */
	private String word;
    /**  创建者 */
	private String createBy;
    /**  创建时间 */
	private java.util.Date createTime;

	public DicSensitiveWordBo(){
	}

	public DicSensitiveWordBo( Long id ){
			setId(id);
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@NotBlank(message = "敏感词不能为空")
	@Length(min=1, max=32, message="敏感词长度必须介于 1 和 32 之间")
	public String getWord() {
		return this.word;
	}
	public void setWord(String word) {
		this.word = word;
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

	
}

