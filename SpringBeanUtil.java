package com.liuxg.util.bean;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * 操作spring bean的工具类，主要用于想通过代码来获取bean，bean必须是spring 容器管理的bean
 * @author liuxg
 * @date 2016年4月16日 下午3:17:01
 */
public class SpringBeanUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext( ApplicationContext applicationContext) throws BeansException {
		SpringBeanUtil.applicationContext = applicationContext;
	}

	/**
	 * 通过bean id获取bean
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return  getApplicationContext().getBean(name);
	}

	/**
	 * 通过bean id还有bean 构造函数参数获取bean
	 * @param name
	 * @return
	 */
	public static Object getBean(String name, Object... args) {
		return getApplicationContext().getBean(name, args);
	}

	/**
	 * 通过指定具体的class来获取bean实例
	 * @param requiredType
	 * @return
	 */
	public static <T> T getBean(Class<T> requiredType) {
		return getApplicationContext().getBean(requiredType);
	}

	
	/**
	 * 通过获取具体的class还有bean的构造函数参数来获取bean
	 * @param requiredType
	 * @param args
	 * @return
	 */
	public static <T> T getBean(Class<T> requiredType, Object... args) {
		return getApplicationContext().getBean(requiredType, args);
	}
	
	/**
	 * 获取application
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		
		if (applicationContext == null) {
			applicationContext = getWebApplicationContext();
		}
		
		return applicationContext;
	}
	
	/**
	 * 获取webapplication
	 * @return
	 */
	public static WebApplicationContext getWebApplicationContext() {
		return ContextLoader.getCurrentWebApplicationContext();
	}
	
	/**
	 * 获取servletcontext
	 * @return
	 */
	public static ServletContext getServletContext(){
		return getWebApplicationContext().getServletContext();
	}

}
