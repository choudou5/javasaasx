package com.choudou5.javasaasx.common.constants;

public interface CommConsts {
	
	String ENCODING = "UTF-8";

	String PROJECT_NAME = "JavaSaasX";

	String GEN_CODE_OUT = "/data/code_out";

	String SYS_DEF_PWD = "123456";

	String SYS_USER_SOURCE_DD = "dingtalk";

	/** 系统超级管理员*/
	String SYS_SUPER_ADMIN_ID = "999999999";
	/** 系统管理员角色*/
	String SYS_ADMIN_ROLE_ID = "000000000";
	/** 系统 临时角色*/
	String SYS_TEMP_ROLE_ID = "888888888";
	
	String USER_SESSION = "user_session";
	
	
	String CHAR_UNDERLINE = "_";
	String CHAR_COMMA = ",";
	String CHAR_NEW_LINE = "\r\n";
	
	/**
	 * 状态: true/false
	 */
	enum FlagEnum{
		YES(true, "可用"),
		NO(false, "禁用");
		
		private boolean value;
		private String name;
		
		private FlagEnum(boolean value, String name){
			this.value = value;
			this.name = name;
		}

		public boolean getValue() {
			return value;
		}
		public String getName() {
			return name;
		}
	}

}
