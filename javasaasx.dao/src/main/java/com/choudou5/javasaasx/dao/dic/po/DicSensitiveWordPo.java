/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.dao.dic.po;

import com.choudou5.javasaasx.base.bean.AbstractBasePo;

/**
 * @Name：敏感词库 Po
 * @Author：xuhaowen
 * @Date：2018-03-05
 */
public class DicSensitiveWordPo extends AbstractBasePo{

    /**
     * 数据库字段：word 敏感词
     */
    private String word;

	public DicSensitiveWordPo(){
	}

	public DicSensitiveWordPo( Long id ){
			setId(id.toString());
	}

    public String getWord() {
        return this.word;
    }
    public void setWord(String word) {
        this.word = word;
    }
}
