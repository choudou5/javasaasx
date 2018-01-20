package com.choudou5.javasaasx.common.util;

import java.util.ResourceBundle;

public class PropertiesUtil {

	private static ResourceBundle resource = null;
	
	private PropertiesUtil() {}
	
	/** 
     * 通过key值获取文件的String类型数据 
     * @param key 
     * @return 
     */  
    public static String getStringFrom(String propFilePath, String key){  
    	if(resource == null)
    		resource = ResourceBundle.getBundle(propFilePath);
        return resource.getString(key);  
    }
    
    /** 
     * 通过key值获取文件的String类型数据 
     * @param key 
     * @return 
     */  
    public static String getString(String key){  
    	if(resource == null)
    		resource = ResourceBundle.getBundle("system");
        return resource.getString(key);  
    }
    
    /** 
     * 通过key值获取文件的String类型数据 
     * @param key 
     * @return 
     */  
    public static String getString(String key, String def){  
    	String value = getString(key);
        return value==null?def:value;  
    }
    
    /** 
     * 通过key值获取文件的int类型数据 
     * @param key 
     * @return 
     */  
    public static Integer getInteger(String key){  
        return Integer.parseInt(getString(key));  
    }
    
    /** 
     * 通过key值获取文件的int类型数据 
     * @param key 
     * @return 
     */  
    public static Integer getInteger(String key, int def){  
        try {
			return Integer.parseInt(getString(key));
		} catch (Exception e) {
			return def;
		}  
    }
    
    
    /** 
     * 通过key值获取文件的double类型数据 
     * @param key 
     * @return 
     */  
    public static Double getDouble(String key){  
        return Double.parseDouble(getString(key));  
    }
    
    /** 
     * 通过key值获取文件的boolean类型数据 
     * @param key 
     * @return 
     */  
    public static Boolean getBoolean(String key){  
        return Boolean.parseBoolean(getString(key));  
    }  
    
    public static Boolean getBoolean(String key, boolean def){  
        try {
			return Boolean.parseBoolean(getString(key));
		} catch (Exception e) {
			return def;
		}
    }  

}
