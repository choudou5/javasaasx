package com.choudou5.javasaasx.dao.sys.po;

import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.framework.bean.AbstractBasePo;

/**
 * @Name：菜单表 Po
 * @Author：xuhaowen
 * @Date：2018-01-21
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public class SysMenuPo extends AbstractBasePo{

    /**
     * 数据库字段：p_id 父级编号
     */
    private String pid;
    /**
     * 数据库字段：p_path 父路径
     */
    private String ppath;
    /**
     * 数据库字段：depth 层级深度
     */
    private Integer depth;
    /**
     * 数据库字段：name 名称
     */
    private String name;
    /**
     * 数据库字段：type 类型：menu=菜单，button=按钮
     */
    private String type;
    /**
     * 数据库字段：sort 排序
     */
    private Integer sort;
    /**
     * 数据库字段：href 链接
     */
    private String href;
    /**
     * 数据库字段：icon 图标
     */
    private String icon;
    /**
     * 数据库字段：permission 权限标识
     */
    private String permission;
    /**
     * 数据库字段：remarks 备注信息
     */
    private String remarks;
    /**
     * 数据库字段：is_mobile_show 是否在手机端显示
     */
    private String isMobileShow;
    /**
     * 数据库字段：status 状态: 0=禁用，1=正常
     */
    private String status;
    /**
     * 数据库字段：is_sys_data 是否系统数据: 0=否，1=是
     */
    private String isSysData;

	public SysMenuPo(){
	}

	public SysMenuPo( String id ){
			setId(id);
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


    public String getPermissionSuffix() {
        if(StrUtil.isNotBlank(this.permission)){
            return StrUtil.subBefore(this.permission, ":", true);
        }
        return "";
    }

    public void setPermission(String permission) {
        this.permission = permission;
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
}
