/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.log;

import com.choudou5.base.annotation.ControllerDesc;
import com.choudou5.base.page.PageResult;
import com.choudou5.javasaasx.service.log.LogUserLoginService;
import com.choudou5.javasaasx.service.log.vo.LogUserLoginQueryParam;
import com.choudou5.javasaasx.service.log.vo.LogUserLoginVo;
import com.choudou5.javasaasx.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Name：用户登录记录 Controller
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
@Controller
@Scope("prototype")
@RequestMapping("/log/logUserLogin")
public class LogUserLoginController extends BaseController {

    @Autowired
    private LogUserLoginService logUserLoginService;

    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看用户登录记录-列表", optType = "view")
    @RequiresPermissions("log:logUserLogin:view")
    @RequestMapping(value = {"list", ""})
    public String list(LogUserLoginQueryParam queryParam, HttpServletRequest req, Model model) {
        PageResult<LogUserLoginVo> pageResult = logUserLoginService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/log/logUserLoginList";
    }


}
