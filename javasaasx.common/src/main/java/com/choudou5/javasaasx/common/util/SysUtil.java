package com.choudou5.javasaasx.common.util;

import com.choudou5.base.util.IpUtil;
import com.choudou5.base.util.PropUtil;
import com.choudou5.javasaasx.common.constants.SysConsts;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;


public class SysUtil {

	protected static Log logger = LogFactory.getLog(SysUtil.class);

	/** 本机端口 */
	private static volatile int LOCAL_PORT = 0;
	
	/**
	 * 获得 站点 名称
	 * @return
	 */
	public static String getSiteName(){
		String siteNameKey = "system.site.name";
		String siteName = null;
		try {
			siteName = PropUtil.getString(siteNameKey);
		} catch (Exception e) {
			logger.error(siteNameKey+" properties is undefined.", e);
		}
		return siteName==null? SysConsts.PROJECT_NAME:siteName;
	}
	
	
	/**
	 * 获得 系统模式
	 * @return
	 */
	public static String getModel(){
		String modelKey = "sys.model";
		String model = null;
		try {
			model = PropUtil.getString(modelKey);
		} catch (Exception e) {
			logger.error(modelKey+" properties is undefined.", e);
		}
		return model==null?"demo":model;
	}
	
	/**
	 * 获得 生成代码地址
	 * @return
	 */
	public static String getGenCodePath(){
		String GEN_CODE_PATH = "gen.code.path";
		String codePath = null;
		try {
			codePath = PropUtil.getString(GEN_CODE_PATH);
		} catch (Exception e) {
			logger.error(GEN_CODE_PATH+" properties is undefined.", e);
		}
		return codePath==null?SysConsts.GEN_CODE_OUT:codePath;
	}
	
	public static void setLocalPort(HttpServletRequest request){
		if(LOCAL_PORT == 0){
			LOCAL_PORT = IpUtil.getLocalPort(request);
		}
	}
	
	/**
	 * 获得 本机信息
	 * @return
	 */
	public static String getMac(){
		return IpUtil.getLocalHostIP()+":"+LOCAL_PORT;
	}

}
