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
import com.choudou5.javasaasx.service.log.LogRemoteExceptionService;
import com.choudou5.javasaasx.service.log.vo.LogRemoteExceptionQueryParam;
import com.choudou5.javasaasx.service.log.vo.LogRemoteExceptionVo;
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
 * @Date：2018-06-03
 */
@Controller
@Scope("prototype")
@RequestMapping("/log/logRemoteException")
public class LogRemoteExceptionController extends BaseController {

    @Autowired
    private LogRemoteExceptionService logRemoteExceptionService;


    /**
     * 对象绑定（表单提交时）
     * @param id
     * @return
     */
    @ModelAttribute
    public LogRemoteExceptionVo get(@RequestParam(required=false) String id) {
        if (StrUtil.isNotBlank(id)){
            return logRemoteExceptionService.get(id);
        }else{
            return new LogRemoteExceptionVo();
        }
    }

    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统远程异常-列表", optType = "view")
    @RequiresPermissions("log:logRemoteException:view")
    @RequestMapping(value = {"list", ""})
    public String list(LogRemoteExceptionQueryParam queryParam, HttpServletRequest req, Model model) {
        PageResult<LogRemoteExceptionVo> pageResult = logRemoteExceptionService.findPage(queryParam);
//        PageResult<ValidcodeTraceListVo> result = BeanMapper.mapPage(pageResult, ValidcodeTraceListVo.class);
        model.addAttribute("pageResult", pageResult);
        return "/log/logRemoteExceptionList";
    }

    /**
     * @param vo
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统远程异常-详情", optType = "view")
    @RequiresPermissions("log:logRemoteException:view")
    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public String view(LogRemoteExceptionVo vo, HttpServletRequest req, Model model) {
        model.addAttribute("logRemoteExceptionVo", vo);
        return "/log/logRemoteExceptionView";
    }

    /**
     * @param vo
     * @param req
     * @param attributes
     * @return
     */
    @ControllerDesc(desc = "修复系统远程异常", optType = "edit")
    @RequiresPermissions("log:logRemoteException:edit")
    @RequestMapping(value = "repair", method = RequestMethod.POST)
    @ResponseBody
    public String repair(LogRemoteExceptionVo vo, HttpServletRequest req, RedirectAttributes attributes) {
        //数据 验证
        if (!beanValidator(attributes, vo))
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
    @RequiresPermissions("log:logRemoteException:edit")
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
