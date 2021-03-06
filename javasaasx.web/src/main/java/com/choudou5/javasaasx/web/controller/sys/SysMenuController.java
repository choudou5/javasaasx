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
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.common.constants.SysConstants;
import com.choudou5.javasaasx.service.sys.SysMenuService;
import com.choudou5.javasaasx.service.sys.vo.SysMenuQueryParam;
import com.choudou5.javasaasx.service.sys.vo.SysMenuVo;
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
import java.util.List;
import java.util.Map;

/**
 * @Name：系统菜单 Controller
 * @Author：xuhaowen
 * @Date：2018-01-18
 */
@Controller
@Scope("prototype")
@RequestMapping("/sys/sysMenu")
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 对象绑定（表单提交时）
     * @param id
     * @return
     */
    @ModelAttribute
    public SysMenuVo get(@RequestParam(required=false) String id) {
        if (StrUtil.isNotBlank(id)){
            return sysMenuService.get(id);
        }else{
            return new SysMenuVo();
        }
    }


    /**
     * 列表
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统菜单-列表", optType = "view")
    @RequiresPermissions("sys:sysMenu:view")
    @RequestMapping(value = {"list", ""})
    public String list(SysMenuQueryParam queryParam, HttpServletRequest req, Model model) {
        queryParam.setDefVo().setType(SysConstants.MenuTypeEnum.MENU.getType());
        PageResult<SysMenuVo> pageResult = sysMenuService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/sys/sysMenuListTree";
    }

    @RequiresPermissions("sys:sysMenu:view")
    @RequestMapping(value = {"ajaxButtomList"}, method = RequestMethod.POST)
    @ResponseBody
    public String ajaxButtomList(String pid, HttpServletRequest req) {
        List<SysMenuVo> list = sysMenuService.findButtomList(pid);
        return returnTableData(list);
    }

    @RequiresPermissions("sys:sysMenu:view")
    @RequestMapping(value = {"ajaxParentTree"}, method = RequestMethod.GET)
    @ResponseBody
    public String ajaxParentTree(HttpServletRequest req, Model model) {
        Map tree = sysMenuService.getParentTree();
        return returnJson(new Object[]{tree});
    }

    /**
     * 查看
     * @param id
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("sys:sysMenu:view")
    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public String view(String id, HttpServletRequest req, Model model) {
        SysMenuVo sysMenuVo = sysMenuService.get(id);
        model.addAttribute("sysMenuVo", sysMenuVo);
        return "/sys/sysMenuView";
    }

    /**
     * @param id
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "编辑系统菜单", optType = "edit")
    @RequiresPermissions("sys:sysMenu:edit")
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(String id, HttpServletRequest req, Model model) {
        String pid = RequestUtil.getStrParameter(req, "pid");
        model.addAttribute("pid", pid);
        model.addAttribute("isShowParent", (StrUtil.isNotBlank(id) && StrUtil.isNotBlank(pid)));
        return "/sys/sysMenuForm";
    }

    /**
     * @param sysMenuBo
     * @param req
     * @param attributes
     * @return
     */
    @ControllerDesc(desc = "保存系统菜单", optType = "save")
    @RequiresPermissions("sys:sysMenu:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(SysMenuVo sysMenuBo, HttpServletRequest req, RedirectAttributes attributes) {
        String[] perms = RequestUtil.getStrParameters(req, "perms", ",");
        //数据 验证
        if (!beanValidator(attributes, sysMenuBo))
            return returnFail(attributes);
        try {
            sysMenuService.save(sysMenuBo, perms);
            return returnOK("保存成功");
        } catch (Exception e) {
            return returnFail(e, "保存失败");
        }
    }


    @ControllerDesc(desc = "更新系统菜单", optType = "update")
    @RequiresPermissions("sys:sysMenu:edit")
    @RequestMapping(value = "ajaxUpdate", method = RequestMethod.POST)
    @ResponseBody
    public String ajaxUpdate(String id, String field, Boolean flag, HttpServletRequest req) {
        String[] perms = RequestUtil.getStrParameters(req, "perms", ",");
        //数据 验证
        if (!paramValidNull(id, field, flag))
            return returnFail("请求出错");
        try {
            sysMenuService.updateField(id, field, flag);
            return returnOK("更新成功");
        } catch (Exception e) {
            return returnFail(e, "更新失败");
        }
    }


    /**
     * @param id
     * @param req
     * @param attributes
     * @return
     */
    @ControllerDesc(desc = "删除系统菜单", optType = "delete")
    @RequiresPermissions("sys:sysMenu:delete")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String id, HttpServletRequest req, RedirectAttributes attributes) {
        try {
            sysMenuService.logicDeleteById(id);
            return returnOK("删除成功");
        } catch (Exception e) {
            return returnFail(e, "删除失败");
        }
    }

}
