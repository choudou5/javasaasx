package com.choudou5.javasaasx.web.listener;

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
		System.out.println("正在启动系统...");
		// TODO Auto-generated method stub
		super.contextInitialized(event);
	}
	

}
