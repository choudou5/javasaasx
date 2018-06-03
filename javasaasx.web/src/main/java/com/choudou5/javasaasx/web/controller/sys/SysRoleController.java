/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.sys;

import com.choudou5.base.annotation.ControllerDesc;
import com.choudou5.base.page.PageResult;
import com.choudou5.base.util.AssertUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.service.sys.SysRoleService;
import com.choudou5.javasaasx.service.sys.vo.SysRoleQueryParam;
import com.choudou5.javasaasx.service.sys.vo.SysRoleVo;
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
 * @Name：系统角色 Controller
 * @Author：xuhaowen
 * @Date：2018-03-03
 */
@Controller
@Scope("prototype")
@RequestMapping("/sys/sysRole")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;


    /**
     * 对象绑定（表单提交时）
     * @param id
     * @return
     */
    @ModelAttribute
    public SysRoleVo get(@RequestParam(required=false) String id) {
        if (StrUtil.isNotBlank(id)){
            return sysRoleService.get(id);
        }else{
            return new SysRoleVo();
        }
    }

    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统角色-列表", optType = "view")
    @RequiresPermissions("sys:sysRole:view")
    @RequestMapping(value = {"list", ""})
    public String list(SysRoleQueryParam queryParam, HttpServletRequest req, Model model) {
        queryParam.setPageParam(1, 500);
        PageResult<SysRoleVo> pageResult = sysRoleService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/sys/sysRoleList";
    }

    /**
     * @param id
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统角色-详情", optType = "view")
    @RequiresPermissions("sys:sysRole:view")
    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public String view(String id, HttpServletRequest req, Model model) {
        SysRoleVo sysRoleVo = sysRoleService.get(id);
        model.addAttribute("sysRoleVo", sysRoleVo);
        return "/sys/sysRoleView";
    }

    /**
     * @param vo
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "编辑系统角色", optType = "edit")
    @RequiresPermissions("sys:sysRole:edit")
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(SysRoleVo vo, HttpServletRequest req, Model model) {
        try {
            AssertUtil.isNotNull(vo, "数据不存在");
            model.addAttribute("sysRoleVo", vo);
        } catch (Exception e) {
            addMessage(model, e);
        }
        return "/sys/sysRoleForm";
    }

    /**
     * @param sysRoleVo
     * @param req
     * @param attributes
     * @return
     */
    @ControllerDesc(desc = "保存系统角色", optType = "save")
    @RequiresPermissions("sys:sysRole:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(SysRoleVo sysRoleVo, HttpServletRequest req, RedirectAttributes attributes) {
        //数据 验证
        if (!beanValidator(attributes, sysRoleVo))
            return returnFail(attributes);
        try {
            sysRoleService.save(sysRoleVo);
            return returnOK("保存成功");
        } catch (Exception e) {
            return returnFail(e, "保存失败");
        }
    }

    /**
     * @param id
     * @param req
     * @param attributes
     * @return
     */
    @ControllerDesc(desc = "删除系统角色", optType = "delete")
    @RequiresPermissions("sys:sysRole:delete")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String id, HttpServletRequest req, RedirectAttributes attributes) {
        try {
            sysRoleService.logicDeleteById(id);
            return returnOK("删除成功");
        } catch (Exception e) {
            return returnFail(e, "删除失败");
        }
    }

}
