/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.sys;

import com.choudou5.base.page.PageResult;
import com.choudou5.base.util.AssertUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.service.sys.SysOfficeService;
import com.choudou5.javasaasx.service.sys.bo.SysOfficeBo;
import com.choudou5.javasaasx.service.sys.bo.SysOfficeQueryParam;
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
 * @Name：系统机构 Controller
 * @Author：xuhaowen
 * @Date：2018-02-18
 */
@Controller
@Scope("prototype")
@RequestMapping("/sys/sysOffice")
public class SysOfficeController extends BaseController {

    @Autowired
    private SysOfficeService sysOfficeService;


    /**
     * 对象绑定（表单提交时）
     * @param id
     * @return
     */
    @ModelAttribute
    public SysOfficeBo get(@RequestParam(required=false) String id) {
        if (StrUtil.isNotBlank(id)){
            return sysOfficeService.get(id);
        }else{
            return new SysOfficeBo();
        }
    }

    /**
     * 列表
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("sys:sysOffice:view")
    @RequestMapping(value = {"list", ""}, method = RequestMethod.GET)
    public String list(SysOfficeQueryParam queryParam, HttpServletRequest req, Model model) {
        PageResult<SysOfficeBo> pageResult = sysOfficeService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/sys/sysOfficeList";
    }

    /**
     * 查看
     * @param id
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("sys:sysOffice:view")
    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public String view(String id, HttpServletRequest req, Model model) {
        SysOfficeBo sysOfficeBo = sysOfficeService.get(id);
        model.addAttribute("sysOfficeBo", sysOfficeBo);
        return "/sys/sysOfficeView";
    }

    /**
     * 编辑记录
     * @param id
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("sys:sysOffice:edit")
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(String id, HttpServletRequest req, Model model) {
        try {
            SysOfficeBo bo = sysOfficeService.get(id);
            AssertUtil.isNotNull(bo, "数据不存在！");
            model.addAttribute("sysOfficeBo", bo);
        } catch (Exception e) {
            addMessage(model, e);
        }
        return "/sys/sysOfficeForm";
    }

    /**
     * 保存记录
     * @param sysOfficeBo
     * @param req
     * @param attributes
     * @return
     */
    @RequiresPermissions("sys:sysOffice:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(SysOfficeBo sysOfficeBo, HttpServletRequest req, RedirectAttributes attributes) {
        //数据 验证
        if (!beanValidator(attributes, sysOfficeBo))
            return returnFail(attributes);
        try {
            sysOfficeService.save(sysOfficeBo);
            return returnOK("保存成功！");
        } catch (Exception e) {
            return returnFail(e, "保存失败！");
        }
    }

    /**
     * 删除记录
     * @param id
     * @param req
     * @param attributes
     * @return
     */
    @RequiresPermissions("sys:sysOffice:delete")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String id, HttpServletRequest req, RedirectAttributes attributes) {
        try {
            sysOfficeService.logicDeleteById(id);
            return returnOK("删除成功！");
        } catch (Exception e) {
            return returnFail(e, "删除失败！");
        }
    }

}
