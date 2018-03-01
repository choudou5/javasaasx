/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.sys;

import com.choudou5.base.annotation.ControllerDesc;
import com.choudou5.base.page.PageResult;
import com.choudou5.base.util.AssertUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.service.sys.SysUserService;
import com.choudou5.javasaasx.service.sys.bo.SysUserBo;
import com.choudou5.javasaasx.service.sys.bo.SysUserQueryParam;
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
 * @Name：系统用户 Controller
 * @Author：xuhaowen
 * @Date：2018-02-18
 */
@Controller
@Scope("prototype")
@RequestMapping("/sys/sysUser")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 对象绑定（表单提交时）
     * @param id
     * @return
     */
    @ModelAttribute
    public SysUserBo get(@RequestParam(required=false) String id) {
        if (StrUtil.isNotBlank(id)){
            return sysUserService.get(id);
        }else{
            return new SysUserBo();
        }
    }

    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统用户-列表", optType = "view")
    @RequiresPermissions("sys:sysUser:view")
    @RequestMapping(value = {"list", ""})
    public String list(SysUserQueryParam queryParam, HttpServletRequest req, Model model) {
        PageResult<SysUserBo> pageResult = sysUserService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/sys/sysUserList";
    }

    /**
     * @param id
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统用户-详情", optType = "view")
    @RequiresPermissions("sys:sysUser:view")
    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public String view(String id, HttpServletRequest req, Model model) {
        SysUserBo sysUserBo = sysUserService.get(id);
        model.addAttribute("sysUserBo", sysUserBo);
        return "/sys/sysUserView";
    }

    /**
     * @param id
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "编辑系统用户", optType = "edit")
    @RequiresPermissions("sys:sysUser:edit")
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(String id, HttpServletRequest req, Model model) {
        try {
            SysUserBo bo = sysUserService.get(id);
            AssertUtil.isNotNull(bo, "数据不存在！");
            model.addAttribute("sysUserBo", bo);
        } catch (Exception e) {
            addMessage(model, e);
        }
        return "/sys/sysUserForm";
    }

    /**
     * @param sysUserBo
     * @param req
     * @param attributes
     * @return
     */
    @ControllerDesc(desc = "保存系统用户", optType = "save")
    @RequiresPermissions("sys:sysUser:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(SysUserBo sysUserBo, HttpServletRequest req, RedirectAttributes attributes) {
        //数据 验证
        if (!beanValidator(attributes, sysUserBo))
            return returnFail(attributes);
        try {
            sysUserService.save(sysUserBo);
            return returnOK("保存成功！");
        } catch (Exception e) {
            return returnFail(e, "保存失败！");
        }
    }

    /**
     * @param id
     * @param req
     * @param attributes
     * @return
     */
    @ControllerDesc(desc = "删除系统用户", optType = "delete")
    @RequiresPermissions("sys:sysUser:delete")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String id, HttpServletRequest req, RedirectAttributes attributes) {
        try {
//            sysUserService.logicDeleteById(id);
            return returnOK("删除成功！");
        } catch (Exception e) {
            return returnFail(e, "删除失败！");
        }
    }

}
