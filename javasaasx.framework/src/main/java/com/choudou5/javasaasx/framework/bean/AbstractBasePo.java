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

    public boolean isNew(){
        return id==null||id.length()==0;
    }


    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert(){
//        Long id = SysSeqUtil.generateId(SystemNames.SYSTEM, SystemNames.SUB_SYSTEM_ADMIN, TableNames.MODULE, getSqlTableName());
//        setId(id);
//        User user = UserUtils.getUser();
//        if (0 != user.getId()){
//            this.updateBy = user;
//            this.createBy = user;
//        }
//        this.updateDate = new Date();
//        this.createDate = this.updateDate;
//        setActonInfo(true, user.getId());
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate(){
//        User user = UserUtils.getUser();
//        //if (StringUtils.isNotBlank(user.getId())){
//        if (0!=user.getId()){
//            this.updateBy = user;
//        }
//        this.updateDate = new Date();
//        setActonInfo(false, user.getId());
//        if(this.recordModify){
//            Session session = UserUtils.getSession();
//            if(session != null)
//                this.ip = session.getHost();
//        }
    }


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
