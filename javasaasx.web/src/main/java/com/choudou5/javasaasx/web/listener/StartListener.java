package com.choudou5.javasaasx.web.listener;

import com.choudou5.javasaasx.common.util.SysUtil;
import org.springframework.web.context.ContextLoaderListener;

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
		System.out.println("正在启动 " + siteName + " 系统...");
		event.getServletContext().setAttribute("siteName", siteName);
		// TODO Auto-generated method stub
		super.contextInitialized(event);
		System.out.println("启动 " + siteName + " 系统完毕...");
	}

}
