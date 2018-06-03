/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.dao.pl.po;

import com.choudou5.javasaasx.base.bean.AbstractBasePo;

/**
 * @Name：平台非法访问记录 Po
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class IllegalAccessTracePo extends AbstractBasePo{

    /**
     * 数据库字段：ip ip
     */
    private String ip;
    /**
     * 数据库字段：url 请求地址
     */
    private String url;
    /**
     * 数据库字段：danger_str 危险字符
     */
    private String dangerStr;
    /**
     * 数据库字段：sys_key 系统标识
     */
    private String sysKey;

	public IllegalAccessTracePo(){
	}

	public IllegalAccessTracePo( String id ){
			setId(id);
	}

    public String getIp() {
        return this.ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDangerStr() {
        return this.dangerStr;
    }
    public void setDangerStr(String dangerStr) {
        this.dangerStr = dangerStr;
    }
    public String getSysKey() {
        return this.sysKey;
    }
    public void setSysKey(String sysKey) {
        this.sysKey = sysKey;
    }
}
