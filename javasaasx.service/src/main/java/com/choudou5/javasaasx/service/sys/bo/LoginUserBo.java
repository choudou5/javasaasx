package com.choudou5.javasaasx.service.sys.bo;

import java.io.Serializable;

/**
 * @Name：说明
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 19:47
 * @Site：http://www.javasaas.top
 * @License：MIT
 */
public class LoginUserBo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String account;		// 用户名
    private String password;		// 密码

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
