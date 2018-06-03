package com.choudou5.javasaasx.base.service.vo;

import java.io.Serializable;

/**
 * @Name：系统用户 Vo
 * @Author：xuhaowen
 * @Date：2018-03-11
 */
public class SysUserSimpleVo implements Serializable{

    private String id;
    private String name;
    private String account;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
