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
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.service.log.SysExceptionService;
import com.choudou5.javasaasx.service.log.bo.SysExceptionBo;
import com.choudou5.javasaasx.service.log.bo.SysExceptionQueryParam;
import com.choudou5.javasaasx.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @Name：系统异常 Controller
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
@Controller
@Scope("prototype")
@RequestMapping("/log/sysException")
public class SysExceptionController extends BaseController {

    @Autowired
    private SysExceptionService sysExceptionService;


    /**
     * 对象绑定（表单提交时）
     * @param id
     * @return
     */
    @ModelAttribute
    public SysExceptionBo get(@RequestParam(required=false) String id) {
        if (StrUtil.isNotBlank(id)){
            return sysExceptionService.get(id);
        }else{
            return new SysExceptionBo();
        }
    }

    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统异常-列表", optType = "view")
    @RequiresPermissions("log:sysException:view")
    @RequestMapping(value = {"list", ""})
    public String list(SysExceptionQueryParam queryParam, HttpServletRequest req, Model model) {
        PageResult<SysExceptionBo> pageResult = sysExceptionService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/log/sysExceptionList";
    }


}
