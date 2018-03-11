package com.choudou5.javasaasx.base.util;

import com.choudou5.base.bean.MapBuilder;
import com.choudou5.base.exception.BizException;
import com.choudou5.base.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Map;

public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

	private static ApplicationContext applicationContext = null;

	private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

	/**
	 * 取得存储在静态变量中的ApplicationContext.
	 */
	public static ApplicationContext getApplicationContext() {
		assertContextInjected();
		return applicationContext;
	}
	

	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		assertContextInjected();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	public static <T> T getBean(Class<T> requiredType) {
		assertContextInjected();
		return applicationContext.getBean(requiredType);
	}

	/**
	 * 清除SpringContextHolder中的ApplicationContext为Null.
	 */
	public static void clearHolder() {
		if (logger.isDebugEnabled()){
			logger.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
		}
		applicationContext = null;
	}

	public static void setContext(ApplicationContext context){
		if(applicationContext==null) {
			applicationContext = context;
		}
	}
	
	/**
	 * 实现ApplicationContextAware接口, 注入Context到静态变量中.
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		logger.debug("注入ApplicationContext到SpringContextHolder:{}", applicationContext);
//		if (SpringContextHolder.applicationContext != null) {
//			logger.info("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:" + SpringContextHolder.applicationContext);
//		}
		SpringContextHolder.applicationContext = applicationContext;
	}


	/**
	 * 发布事件
	 * @param event
	 */
	public static void pubEvent(ApplicationEvent event){
		assertContextInjected();
		if(event != null){
			applicationContext.publishEvent(event);
		}
	}

	/**
	 * 发布 异步事件
	 * @param event
	 */
	public static void pubAsyncEvent(final ApplicationEvent event){
		assertContextInjected();
		if(event != null){
			ThreadUtil.execute(new Runnable() {
				@Override
				public void run() {
					applicationContext.publishEvent(event);
				}
			});
		}
	}

	/**
	 * 实现DisposableBean接口, 在Context关闭时清理静态变量.
	 */
	@Override
	public void destroy() throws Exception {
		SpringContextHolder.clearHolder();
	}

	/**
	 * 检查ApplicationContext不为空.
	 */
	private static void assertContextInjected() {
		Assert.notNull(applicationContext, "applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.");
	}

	/**
	 * 反射 执行方法
	 * @param beanName Spring实例名
	 * @param methodName 方法名
	 * @param paramVals 参数值
	 * @param paramTypes 参数类型
	 * @return
	 */
	public static Map invokeMethod(String beanName, String methodName, Object[] paramVals, Class<?>[] paramTypes){
		//参数校验
		if(StrUtil.isBlank(beanName) || StrUtil.isBlank(methodName)){
			return MapBuilder.create().result(false, "参数为空");
		}
		//获得 bean
		Object bean = getBean(beanName);
		if(bean == null){
			return MapBuilder.create().result(false, "属性未注入"+beanName);
		}
		//获得方法
		Method method = null;
		if(paramTypes == null){
			method = ReflectionUtils.findMethod(bean.getClass(), methodName);
		}else{
			method = ReflectionUtils.findMethod(bean.getClass(), methodName, paramTypes);
		}
		if(method == null){
			return MapBuilder.create().result(false, beanName+"不存在方法:"+methodName);
		}
		//执行方法
		Object obj = null;
		try {
			if(paramVals == null){
				obj = ReflectionUtils.invokeMethod(method, bean);
			}else{
				obj = ReflectionUtils.invokeMethod(method, bean, paramVals);
			}
		} catch (Exception e) {
			if(e instanceof BizException){
				logger.error("", e);
				return MapBuilder.create().result(false, e.getMessage());
			}else{
				logger.error("beanName:"+beanName+" invokeMethod:"+methodName, e);
				return MapBuilder.create().result(false, "beanName:"+beanName+" 执行方法:"+methodName+"失败");
			}
		}
		return MapBuilder.create().result(true, "执行成功", obj);
	}

}
