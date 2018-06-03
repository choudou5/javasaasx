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
 * @Name：菜单表 Vo
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
public class SysMenuListVo implements Serializable {

    /** id */
    private String id;
    /** 父级编号 */
    private String pid;
    /** 父路径 */
    private String ppath;
    /** 层级深度 */
    private Integer depth;
    /** 名称 */
    private String name;
    /** 类型：menu=菜单，button=按钮 */
    private String type;
    /** 排序 */
    private Integer sort;
    /** 链接 */
    private String href;
    /** 图标 */
    private String icon;
    /** 权限标识 */
    private String permission;
    /** 创建者 */
    private String createBy;
    /** 创建时间 */
    private java.util.Date createTime;
    /** 更新者 */
    private String updateBy;
    /** 更新时间 */
    private java.util.Date updateTime;
    /** 备注信息 */
    private String remarks;
    /** 手机端显示 0=否，1=是 */
    private String isMobileShow;
    /** 状态: 0=禁用，1=正常 */
    private String status;
    /** 是否系统数据: 0=否，1=是 */
    private String isSysData;
    /** 删除标记：0=已删除,1=正常 */
    private String delFlag;

	public SysMenuListVo(){
	}

	public SysMenuListVo( String id ){
			setId(id);
	}

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
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

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Integer getSort() {
        return this.sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getHref() {
        return this.href;
    }
    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPermission() {
        return this.permission;
    }
    public void setPermission(String permission) {
        this.permission = permission;
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

    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getIsMobileShow() {
        return this.isMobileShow;
    }
    public void setIsMobileShow(String isMobileShow) {
        this.isMobileShow = isMobileShow;
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
