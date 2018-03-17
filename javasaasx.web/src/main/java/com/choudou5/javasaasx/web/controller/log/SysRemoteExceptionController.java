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
import com.choudou5.base.util.AssertUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.service.log.SysRemoteExceptionService;
import com.choudou5.javasaasx.service.log.bo.SysRemoteExceptionBo;
import com.choudou5.javasaasx.service.log.bo.SysRemoteExceptionQueryParam;
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
 * @Name：系统远程异常 Controller
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
@Controller
@Scope("prototype")
@RequestMapping("/log/sysRemoteException")
public class SysRemoteExceptionController extends BaseController {

    @Autowired
    private SysRemoteExceptionService sysRemoteExceptionService;


    /**
     * 对象绑定（表单提交时）
     * @param id
     * @return
     */
    @ModelAttribute
    public SysRemoteExceptionBo get(@RequestParam(required=false) String id) {
        if (StrUtil.isNotBlank(id)){
            return sysRemoteExceptionService.get(id);
        }else{
            return new SysRemoteExceptionBo();
        }
    }

    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统远程异常-列表", optType = "view")
    @RequiresPermissions("log:sysRemoteException:view")
    @RequestMapping(value = {"list", ""})
    public String list(SysRemoteExceptionQueryParam queryParam, HttpServletRequest req, Model model) {
        PageResult<SysRemoteExceptionBo> pageResult = sysRemoteExceptionService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/log/sysRemoteExceptionList";
    }

    /**
     * @param bo
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统远程异常-详情", optType = "view")
    @RequiresPermissions("log:sysRemoteException:view")
    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public String view(SysRemoteExceptionBo bo, HttpServletRequest req, Model model) {
        model.addAttribute("sysRemoteExceptionBo", bo);
        return "/log/sysRemoteExceptionView";
    }


    /**
     * @param sysRemoteExceptionBo
     * @param req
     * @param attributes
     * @return
     */
    @ControllerDesc(desc = "修复系统远程异常", optType = "edit")
    @RequiresPermissions("log:sysRemoteException:edit")
    @RequestMapping(value = "repair", method = RequestMethod.POST)
    @ResponseBody
    public String repair(SysRemoteExceptionBo sysRemoteExceptionBo, HttpServletRequest req, RedirectAttributes attributes) {
        //数据 验证
        if (!beanValidator(attributes, sysRemoteExceptionBo))
            return returnFail(attributes);
        try {
//            sysRemoteExceptionService.save(sysRemoteExceptionBo);
            return returnOK("修复成功");
        } catch (Exception e) {
            return returnFail(e, "修复失败");
        }
    }

    /**
     * @param id
     * @param req
     * @param attributes
     * @return
     */
    @ControllerDesc(desc = "删除系统远程异常", optType = "edit")
    @RequiresPermissions("log:sysRemoteException:edit")
    @RequestMapping(value = "ignore", method = RequestMethod.POST)
    @ResponseBody
    public String ignore(String id, HttpServletRequest req, RedirectAttributes attributes) {
        try {
//            sysRemoteExceptionService.logicDeleteById(id);
            return returnOK("忽略成功");
        } catch (Exception e) {
            return returnFail(e, "忽略失败");
        }
    }

}
