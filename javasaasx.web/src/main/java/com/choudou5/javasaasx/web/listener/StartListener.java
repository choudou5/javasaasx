package com.choudou5.javasaasx.web.listener;

import com.choudou5.javasaasx.common.constants.SysConsts;
import com.choudou5.javasaasx.common.constants.SysPropConsts;
import com.choudou5.javasaasx.common.util.SysUtil;
import com.choudou5.javasaasx.framework.bean.QueryParam;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * 启动 监听器
 * @author xuhaowende
 * @date 2017年12月23日
 */
public class StartListener extends ContextLoaderListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {

		String siteName = SysUtil.getSiteName();
		QueryParam.setDbName(SysPropConsts.JDBC_TPYE);

		System.out.println("正在启动 " + siteName + " 系统...");
		event.getServletContext().setAttribute("siteName", siteName);
		super.contextInitialized(event);
		System.out.println("启动 " + siteName + " 系统完毕...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		String siteName = SysUtil.getSiteName();
		System.out.println("正在停止 " + siteName + " 系统...");
		super.contextDestroyed(event);
	}

	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
		System.out.println("初始化Web应用...");
		return super.initWebApplicationContext(servletContext);
	}

	@Override
	public void closeWebApplicationContext(ServletContext servletContext) {
		System.out.println("关闭Web应用...");
		super.closeWebApplicationContext(servletContext);
	}

}
