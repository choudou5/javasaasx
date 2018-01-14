package com.choudou5.javasaasx.web.controller;

import com.alibaba.fastjson.JSON;
import com.choudou5.javasaasx.common.util.JsonUtil;
import com.choudou5.javasaasx.common.util.SysUtil;
import com.choudou5.javasaasx.framework.exception.BizException;
import com.choudou5.javasaasx.framework.util.ToolkitUtil;
import com.choudou5.javasaasx.web.beanvalidator.BeanValidators;
import com.xiaoleilu.hutool.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基础 Controller
 */
public abstract class BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected final int STATUS_OK = 200;
	protected final int STATUS_ERROR = 500;
	protected final int STATUS_UNVALID_PARAM = 403;

	public static final String NO_PERMISSION = "对不起，您无权操作！";
	public static final String DEMO_MODEL_NO_ACTION = "对不起，演示模式 不能操作！";

	/**
	 * 是否 演示模式
	 * @return
	 */
	protected boolean isDemoModel(){
		return "demo".equals(SysUtil.getModel());
	}

	/**
	 * 验证Bean实例对象
	 */
	@Autowired
	protected Validator validator;


	/**
	 * 参数绑定异常
	 */
//	@ExceptionHandler({BindException.class, ConstraintViolationException.class, ValidationException.class})
//    public String bindException() {  
//        return "error/400";
//    }

	/**
	 * 初始化数据绑定
	 * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
	 * 2. 将字段中Date类型转换为String类型
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
//		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
//			@Override
//			public void setAsText(String text) {
//				setValue(text == null ? null : StringEscapeUtils.escapeHtml(text.trim()));
//			}
//			@Override
//			public String getAsText() {
//				Object value = getValue();
//				return value != null ? value.toString() : "";
//			}
//		});
		// Date 类型转换
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(DateUtil.parseDate(text));
			}
//			@Override
//			public String getAsText() {
//				Object value = getValue();
//				return value != null ? DateUtils.formatDateTime((Date)value) : "";
//			}
		});
	}


	/**
	 * 服务端参数有效性验证
	 * @param object 验证的实体对象
	 * @param groups 验证组
	 * @return 验证成功：返回true；严重失败：将错误信息添加到 message 中
	 */
	protected boolean beanValidator(Model model, Object object, Class<?>... groups) {
		try{
			BeanValidators.validateWithException(validator, object, groups);
		}catch(ConstraintViolationException ex){
			List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
			list.add(0, "数据验证失败：");
			addMessage(model, list.toArray(new String[]{}));
			return false;
		}
		return true;
	}

	/**
	 * 服务端参数有效性验证
	 * @param object 验证的实体对象
	 * @param groups 验证组
	 * @return 验证成功：返回true；严重失败：将错误信息添加到 flash message 中
	 */
	protected boolean beanValidator(RedirectAttributes redirectAttributes, Object object, Class<?>... groups) {
		try{
			BeanValidators.validateWithException(validator, object, groups);
		}catch(ConstraintViolationException ex){
			List<String> list = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
			list.add(0, "数据验证失败：");
			addMessage(redirectAttributes, list.toArray(new String[]{}));
			return false;
		}
		return true;
	}

	/**
	 * 服务端参数有效性验证
	 * @param object 验证的实体对象
	 * @param groups 验证组，不传入此参数时，同@Valid注解验证
	 * @return 验证成功：继续执行；验证失败：抛出异常跳转400页面。
	 */
	protected void beanValidator(Object object, Class<?>... groups) {
		BeanValidators.validateWithException(validator, object, groups);
	}

	/**
	 * 添加Model消息
	 * @param messages
	 */
	protected void addMessage(Model model, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		model.addAttribute("message", sb.toString());
	}

	/**
	 * 添加RedirectAttributes消息
	 * @param messages
	 */
	protected void addMessage(RedirectAttributes attributes, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		attributes.addFlashAttribute("message", sb.toString());
	}

	/**
	 * 添加RedirectAttributes消息
	 * @param defMsg
	 */
	protected void addMessage(RedirectAttributes attributes, Exception e, String defMsg) {
		logger.error(defMsg, e);
		if(e != null){
			attributes.addFlashAttribute("message", e.getMessage());
			attributes.addFlashAttribute("errorMsg", e.getCause().getLocalizedMessage());
		}else{
			attributes.addFlashAttribute("message", defMsg);
		}
	}

	protected void addMessage(Model model, Exception e) {
		addMessage(model, e, e.getMessage());
	}

	protected void addMessage(Model model, Exception e, String defMsg) {
		logger.error(defMsg, e);
		if(e != null){
			if(e instanceof BizException)
				defMsg = e.getMessage();
			else if(defMsg == null){
				defMsg = e.getMessage();
			}
			model.addAttribute("errorMsg", e.getCause().getLocalizedMessage());
		}
		model.addAttribute("message", defMsg);
	}

	protected String redirectList(HttpServletRequest request, RedirectAttributes attributes, String message) {
		return redirectList(request, attributes, message, null);
	}
	protected String redirectList(HttpServletRequest request, RedirectAttributes attributes, String message, Exception e) {
		return redirect(request, "list", attributes, message, e);
	}
	protected String redirectEdit(HttpServletRequest request, RedirectAttributes attributes) {
		return redirectEdit(request, attributes, null, null);
	}
	protected String redirectEdit(HttpServletRequest request, RedirectAttributes attributes, String message) {
		return redirectEdit(request, attributes, message, null);
	}
	protected String redirectEdit(HttpServletRequest request, RedirectAttributes attributes, String message, Exception e) {
		return redirect(request, "edit", attributes, message, e);
	}
	protected String redirect(HttpServletRequest request, String view, RedirectAttributes attributes, String message) {
		return redirect(request, view, attributes, message, null);
	}
	protected String redirect(HttpServletRequest request, String view, RedirectAttributes attributes, String message, Exception e) {
		if(e != null)
			logger.error("", e);
		if(ToolkitUtil.isNotBlank(message))
			attributes.addFlashAttribute("message", message);
		String reqUrl = request.getRequestURI();
		return "redirect: "+reqUrl+"/"+view;
	}


	protected String returnStatus(int statusCode, String message){
		return returnJson(statusCode, null, message);
	}

	protected String returnOK(Object obj){
		return returnJson(STATUS_OK, obj, "成功");
	}

	protected String returnOK(String message){
		return returnJson(STATUS_OK, null, message);
	}

	protected String returnOK(Object obj, String message){
		return returnJson(STATUS_OK, obj, message);
	}

	protected String returnFail(Object obj, String message){
		return returnJson(STATUS_ERROR, obj, message);
	}

	protected String returnFail(Object obj, String message, Exception e){
		return returnJson(STATUS_ERROR, obj, message);
	}

	protected String returnFail(Exception e, String message){
		return returnJson(STATUS_ERROR, null, message, e);
	}


	protected String returnFail(RedirectAttributes attributes){
		Object msgObj = attributes.getFlashAttributes().get("message");
		String message = "操作失败！";
		if(msgObj != null)
			message = msgObj.toString();
		return returnJson(STATUS_ERROR, null, message, null);
	}

	protected String returnFail(String message){
		return returnJson(STATUS_ERROR, null, message, null);
	}

	protected String returnJson(int statusCode, Object obj, String message){
		return returnJson(statusCode, obj, message, null);
	}

	protected String returnJson(int statusCode, Object obj, String message, Exception e){
		Map<String, Object> result = new HashMap<String, Object>(6);
		result.put("statusCode", statusCode);
		result.put("obj", obj);
		result.put("message", message);
		if(e != null) {
			logger.error(message, e);
			result.put("exception", e.getMessage());
			if(e instanceof BizException){
				result.put("message", e.getMessage());
			}
		}
		return JSON.toJSONString(result);
	}

}
