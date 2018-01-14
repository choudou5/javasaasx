package com.choudou5.javasaasx.common.constants;

/**
 * 操作类型 枚举
 * @author xuhaowen
 * @date 2017年2月26日
 */
public enum ActionTypeEnum {

	VIEW("view", "查看"),
	SELECT("select", "查询"),
	UPDATE("update", "更新");
	
	private String value;
	private String explain;
	
	ActionTypeEnum(String value, String explain){
		this.value = value;
		this.explain = explain;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}
}
