/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.dic.vo;

import java.io.Serializable;

/**
 * @Name：敏感词库 Vo
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class DicSensitiveWordListVo implements Serializable {

    /** id */
    private Long id;
    /** 敏感词 */
    private String word;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    private java.util.Date createTime;

	public DicSensitiveWordListVo(){
	}

	public DicSensitiveWordListVo( Long id ){
			setId(id);
	}

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

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
