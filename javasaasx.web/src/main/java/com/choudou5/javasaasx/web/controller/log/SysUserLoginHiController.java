/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.log;

import com.choudou5.base.annotation.ControllerDesc;
import com.choudou5.base.page.PageResult;
import com.choudou5.base.util.AssertUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.service.log.SysUserLoginHiService;
import com.choudou5.javasaasx.service.log.bo.SysUserLoginHiBo;
import com.choudou5.javasaasx.service.log.bo.SysUserLoginHiQueryParam;
import com.choudou5.javasaasx.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletRequest;

/**
 * @Name：系统用户登录记录 Controller
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
@Controller
@Scope("prototype")
@RequestMapping("/log/sysUserLoginHi")
public class SysUserLoginHiController extends BaseController {

    @Autowired
    private SysUserLoginHiService sysUserLoginHiService;

    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统用户登录记录-列表", optType = "view")
    @RequiresPermissions("log:sysUserLoginHi:view")
    @RequestMapping(value = {"list", ""})
    public String list(SysUserLoginHiQueryParam queryParam, HttpServletRequest req, Model model) {
        PageResult<SysUserLoginHiBo> pageResult = sysUserLoginHiService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/log/sysUserLoginHiList";
    }


}
