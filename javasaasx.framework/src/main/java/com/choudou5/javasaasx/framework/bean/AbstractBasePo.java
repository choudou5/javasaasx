package com.choudou5.javasaasx.framework.bean;

import java.util.Date;

/**
 * @Name：抽象 基础Po类
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-14 13:30
 * @Site：http://solrhome.com
 * @License：MIT
 */
public class AbstractBasePo implements BasePo {

    private String id;
    /** 创建人 */
    private String createBy;
    /** 创建时间 */
    private java.util.Date createTime;
    /** 修改人 */
    private String updateBy;
    /** 修改时间 */
    private java.util.Date updateTime;
    /** 删除标记 0=已删除，1=正常 */
    private String delFlag;

    protected static final String DEL_FLAG_YES = "0";
    protected static final String DEL_FLAG_NO = "1";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
