package com.choudou5.javasaasx.web.controller;

import com.choudou5.javasaasx.service.sys.bo.SysMenuQueryParam;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Name：首页 Controller
 * @Author：xuhaowen
 * @Date：2018-01-18
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
@Controller
@Scope("prototype")
@RequestMapping("/index")
public class IndexController extends BaseController {

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String list(SysMenuQueryParam queryParam, HttpServletRequest req, Model model) {
        return "/index";
    }

}
