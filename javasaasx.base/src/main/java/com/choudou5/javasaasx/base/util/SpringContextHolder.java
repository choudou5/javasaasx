package com.choudou5.javasaasx.base.util;

import com.choudou5.base.bean.MapBuilder;
import com.choudou5.base.exception.BizException;
import com.choudou5.base.util.AssertUtil;
import com.choudou5.base.util.StrUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

	private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

	private static ApplicationContext applicationContext = null;

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


	private String propsPath = "/conf/system.properties";
	public String getPropsPath() {
		return propsPath;
	}
	public void setPropsPath(String propsPath) {
		this.propsPath = propsPath;
	}

	/** 属性配置 map */
	private static Map<String, String> propsMap = new HashMap();
	/**
	 * 获得 属性配置
	 * @param key
	 * @return
	 */
	public static String getProp(String key) {
		if(StringUtils.isNotBlank(key)){
			return propsMap.get(key);
		}
		return null;
	}
	/**
	 * 获得 属性配置 （带断言 空判断）
	 * @param key
	 * @return
	 */
	public static String getPropByAssert(String key) {
		String value = null;
		if(StringUtils.isNotBlank(key)){
			value = propsMap.get(key);
			AssertUtil.isNotBlank(value, "未配置属性:"+key);
		}
		return value;
	}

	/**
	 * 初始化 属性配置
	 */
	public void initProps() {
		assertContextInjected();
		if(StringUtils.isNotBlank(propsPath)){
			//读取配置
			Resource resource = applicationContext.getResource(propsPath);
			if(resource != null && resource.exists()){
				try {
					Properties prop = PropertiesLoaderUtils.loadProperties(resource);
					if(prop != null && !prop.isEmpty()){
						for (String key : prop.stringPropertyNames()) {
							propsMap.put(key, prop.getProperty(key));
						}
					}
					prop = null;
					resource = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
