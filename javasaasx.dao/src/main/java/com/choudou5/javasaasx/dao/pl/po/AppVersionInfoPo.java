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
 * @Name：客户端版本信息 Po
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class AppVersionInfoPo extends AbstractBasePo{

    /**
     * 数据库字段：client_type 客户端类型:android,ios
     */
    private String clientType;
    /**
     * 数据库字段：version_num 版本号
     */
    private String versionNum;
    /**
     * 数据库字段：build_num build号
     */
    private Integer buildNum;
    /**
     * 数据库字段：title 标题
     */
    private String title;
    /**
     * 数据库字段：version_type 版本类型:1=新版本;2=兼容版本
     */
    private String versionType;
    /**
     * 数据库字段：file_path 文件路径
     */
    private String filePath;
    /**
     * 数据库字段：file_size 文件大小
     */
    private Integer fileSize;
    /**
     * 数据库字段：push_time 发布时间
     */
    private java.util.Date pushTime;
    /**
     * 数据库字段：update_type 更新类型:1=可选更新;2=强制更新
     */
    private String updateType;
    /**
     * 数据库字段：remark 说明
     */
    private String remark;
    /**
     * 数据库字段：channel_code 渠道code
     */
    private String channelCode;
    /**
     * 数据库字段：channel_down_path 渠道包下载地址
     */
    private String channelDownPath;
    /**
     * 数据库字段：status 状态: 0=禁用，1=正常
     */
    private String status;

	public AppVersionInfoPo(){
	}

	public AppVersionInfoPo( String id ){
			setId(id);
	}

    public String getClientType() {
        return this.clientType;
    }
    public void setClientType(String clientType) {
        this.clientType = clientType;
    }
    public String getVersionNum() {
        return this.versionNum;
    }
    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }
    public Integer getBuildNum() {
        return this.buildNum;
    }
    public void setBuildNum(Integer buildNum) {
        this.buildNum = buildNum;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getVersionType() {
        return this.versionType;
    }
    public void setVersionType(String versionType) {
        this.versionType = versionType;
    }
    public String getFilePath() {
        return this.filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public Integer getFileSize() {
        return this.fileSize;
    }
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }
    public java.util.Date getPushTime() {
        return this.pushTime;
    }
    public void setPushTime(java.util.Date pushTime) {
        this.pushTime = pushTime;
    }
    public String getUpdateType() {
        return this.updateType;
    }
    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }
    public String getRemark() {
        return this.remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getChannelCode() {
        return this.channelCode;
    }
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }
    public String getChannelDownPath() {
        return this.channelDownPath;
    }
    public void setChannelDownPath(String channelDownPath) {
        this.channelDownPath = channelDownPath;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
