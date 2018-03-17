package com.choudou5.javasaasx.common.constants;


import com.choudou5.base.util.PropUtil;

/**
 * @Name：系统属性配置 常量
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-14
 * @Site：http://www.javasaas.top
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public interface SysPropConsts {

	String PROP_KEY_SIG = PropUtil.getStr("system.sig.key");
	
	String KEY_ADMIN_EMAIL = "system.admin.email";
	String SESSION_KEY_USER = "sess_key";

	String JDBC_TPYE = PropUtil.getStr("jdbc.type");
	String JDBC_DRIVER = "jdbc.driver";
	String JDBC_URL = "jdbc.url";
	String JDBC_USERNAME = "jdbc.username";
	String JDBC_PASSWORD = "jdbc.password";

}
