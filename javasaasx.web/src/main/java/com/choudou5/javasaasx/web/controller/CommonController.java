package com.choudou5.javasaasx.web.controller;

import com.alibaba.fastjson.JSON;
import com.choudou5.javasaasx.common.util.SysUtil;
import com.choudou5.javasaasx.framework.exception.BizException;
import com.choudou5.javasaasx.framework.util.ToolkitUtil;
import com.choudou5.javasaasx.web.beanvalidator.BeanValidators;
import com.choudou5.javasaasx.web.util.RequestUtil;
import com.xiaoleilu.hutool.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
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
@Controller
@Scope("prototype")
@RequestMapping("/")
public class CommonController extends BaseController{

	/**
	 * 页面跳转
	 * @param module 模块文件目录名
	 * @param page 页面文件名
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/viewPage/{module}/{page}",method= RequestMethod.GET)
	public String viewPage(@PathVariable("module")String module, @PathVariable("page")String page, HttpServletRequest req){
		return module+"/"+page;
	}


	@RequestMapping(value="/common/chooseTreeValue",method= RequestMethod.GET)
	public String chooseTreeValue(String ajaxJsonUrl, HttpServletRequest req, Model model){
		boolean multi = RequestUtil.getBoolParameter(req, "multi", false);
		model.addAttribute("multi", multi);
		model.addAttribute("ajaxJsonUrl", ajaxJsonUrl);
		return "/common/chooseTreeValue";
	}


	/**
	 * 新增 留言
	 * @param message
	 * @param req
	 * @param attributes
	 * @return
	 */
//	@RequestMapping(value="/guestbook",method=RequestMethod.POST)
//	@ResponseBody
//    public String guestbook(MessageBoard message, HttpServletRequest req, RedirectAttributes attributes){
//		//数据 验证
//		if (!beanValidator(attributes, message)){
//			return writeJson(STATUS_UNVALID_PARAM, attributes.asMap().get("message"));
//		}
//		try {
//			MessageBoardService.add(req, message);
//			return writeJson(STATUS_OK, "留言成功！");
//		} catch (Exception e) {
//			log.error("新增留言失败!", e);
//			return writeJson(STATUS_ERROR, "亲...留言失败了");
//		}
//    }



}
