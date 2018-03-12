/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.sys;

import com.choudou5.base.annotation.ControllerDesc;
import com.choudou5.base.exception.BizException;
import com.choudou5.base.page.PageResult;
import com.choudou5.base.util.AssertUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.common.util.SysUtil;
import com.choudou5.javasaasx.service.sys.SysSettingService;
import com.choudou5.javasaasx.service.sys.bo.SysSettingBo;
import com.choudou5.javasaasx.service.sys.bo.SysSettingQueryParam;
import com.choudou5.javasaasx.web.controller.BaseController;
import com.choudou5.javasaasx.web.util.RequestUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Name：系统设置 Controller
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
@Controller
@Scope("prototype")
@RequestMapping("/sys/sysSetting")
public class SysSettingController extends BaseController {

    @Autowired
    private SysSettingService sysSettingService;


    /**
     * 对象绑定（表单提交时）
     * @param id
     * @return
     */
    @ModelAttribute
    public SysSettingBo get(@RequestParam(required=false) String id) {
        if (StrUtil.isNotBlank(id)){
            return sysSettingService.get(id);
        }else{
            return new SysSettingBo();
        }
    }

    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统设置-列表", optType = "view")
    @RequiresPermissions("sys:sysSetting:view")
    @RequestMapping(value = {"list", ""})
    public String list(SysSettingQueryParam queryParam, HttpServletRequest req, Model model) {
        queryParam.setDefParam(1, 1000, "create_time", "DESC");
        PageResult<SysSettingBo> pageResult = sysSettingService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/sys/sysSettingList";
    }

    /**
     * @param id
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统设置-详情", optType = "view")
    @RequiresPermissions("sys:sysSetting:view")
    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public String view(String id, HttpServletRequest req, Model model) {
        SysSettingBo sysSettingBo = sysSettingService.get(id);
        model.addAttribute("sysSettingBo", sysSettingBo);
        return "/sys/sysSettingView";
    }

    /**
     * @param bo
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "编辑系统设置", optType = "edit")
    @RequiresPermissions("sys:sysSetting:edit")
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(SysSettingBo bo, HttpServletRequest req, Model model) {
        try {
            AssertUtil.isNotNull(bo, "数据不存在！");
            model.addAttribute("sysSettingBo", bo);
        } catch (Exception e) {
            addMessage(model, e);
        }
        return "/sys/sysSettingForm";
    }

    /**
     * @param sysSettingBo
     * @param req
     * @param attributes
     * @return
     */
    @ControllerDesc(desc = "保存系统设置", optType = "save")
    @RequiresPermissions("sys:sysSetting:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(SysSettingBo sysSettingBo, HttpServletRequest req, RedirectAttributes attributes) {
        //数据 验证
        if (!beanValidator(attributes, sysSettingBo))
            return returnFail(attributes);
        try {
            sysSettingService.save(sysSettingBo);
            return returnOK("保存成功！");
        } catch (Exception e) {
            return returnFail(e, "保存失败！");
        }
    }

    /**
     * @param id
     * @param req
     * @return
     */
    @ControllerDesc(desc = "删除系统设置", optType = "delete")
    @RequiresPermissions("sys:sysSetting:delete")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String id, HttpServletRequest req) {
        try {
            sysSettingService.logicDeleteById(id);
            return returnOK("删除成功！");
        } catch (Exception e) {
            return returnFail(e, "删除失败！");
        }
    }


    /**
     * @param req
     * @return
     */
    @ControllerDesc(desc = "设置调试", optType = "edit")
    @RequiresPermissions("sys:sysSetting:edit")
    @RequestMapping(value = "debug", method = RequestMethod.POST)
    @ResponseBody
    public String debug(HttpServletRequest req) {
        boolean flag = RequestUtil.getBoolParameter(req, "flag", false);
        String tip = flag?"开启":"关闭";
        try {
            if(flag && SysUtil.isDebug())
                throw new BizException("已开启调试，请刷新F5刷新页面");
            SysUtil.openDebug(flag);
            return returnOK("已"+tip+"调试，请刷新F5刷新页面");
        } catch (Exception e) {
            return returnFail(e, tip+"调试失败！");
        }
    }
}
