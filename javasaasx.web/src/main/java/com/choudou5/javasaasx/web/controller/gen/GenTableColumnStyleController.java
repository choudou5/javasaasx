package com.choudou5.javasaasx.web.controller.gen;

import com.choudou5.javasaasx.framework.bean.SelectBo;
import com.choudou5.javasaasx.framework.util.AssertUtil;
import com.choudou5.javasaasx.service.gen.GenTableColumnStyleService;
import com.choudou5.javasaasx.service.gen.bo.GenTableColumnStyleBo;
import com.choudou5.javasaasx.service.gen.bo.GenTableColumnStyleQueryParam;
import com.choudou5.javasaasx.web.controller.BaseController;
import com.choudou5.javasaasx.web.util.RequestUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Name：生成表字段样式 Controller
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-14
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
@Controller
@Scope("prototype")
@RequestMapping("/gen/genTableColumnStyle")
public class GenTableColumnStyleController extends BaseController {

    @Autowired
    private GenTableColumnStyleService genTableColumnStyleService;


    /**
     * 获取 数据库表
     * @param req
     * @param attributes
     * @return
     */
    @RequiresPermissions("gen:genTableColumnStyle:view")
    @RequestMapping(value = "getTableList", method = RequestMethod.POST)
    @ResponseBody
    public String getTableList(HttpServletRequest req, RedirectAttributes attributes) {
        try {
            List<SelectBo> list =  genTableColumnStyleService.getTableList();
            return returnOK(list);
        } catch (Exception e) {
            return returnFail(e, "获取数据库表失败.");
        }
    }


    /**
     * 获取 表字段样式 列表
     * @param req
     * @param attributes
     * @return
     */
    @RequiresPermissions("gen:genTableColumnStyle:view")
    @RequestMapping(value = "getGenTableColumnStyleList", method = RequestMethod.POST)
    @ResponseBody
    public String getGenTableColumnStyleList(String table, HttpServletRequest req, RedirectAttributes attributes) {
        try {
            List<GenTableColumnStyleBo> list =  genTableColumnStyleService.getGenTableColumnStyleList(table);
            return returnTableData(list);
        } catch (Exception e) {
            return returnFail(e, "表字段样式列表失败.");
        }
    }


    /**
     * 列表
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("gen:genTableColumnStyle:view")
    @RequestMapping(value = {"list", ""}, method = RequestMethod.GET)
    public String list(GenTableColumnStyleQueryParam queryParam, HttpServletRequest req, Model model) {
//        PageResult<GenTableColumnStyleBo> pageResult = genTableColumnStyleService.findPage(queryParam);
//        model.addAttribute("pageResult", pageResult);
        List<SelectBo> list =  genTableColumnStyleService.getTableList();
        model.addAttribute("tableList", list);
        return "/gen/genTableColumnStyleListTree";
    }

    /**
     * 查看
     * @param id
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("gen:genTableColumnStyle:view")
    @RequestMapping(value = {"view"})
    public String view(String id, HttpServletRequest req, Model model) {
        GenTableColumnStyleBo genTableColumnStyleBo = genTableColumnStyleService.get(id);
        model.addAttribute("genTableColumnStyleBo", genTableColumnStyleBo);
        return "/gen/genTableColumnStyleView";
    }

    /**
     * 编辑记录
     * @param id
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("gen:genTableColumnStyle:edit")
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(String id, HttpServletRequest req, Model model) {
        try {
            GenTableColumnStyleBo bo = genTableColumnStyleService.get(id);
            AssertUtil.isNotNull(bo, "数据不存在！");
            model.addAttribute("genTableColumnStyleBo", bo);
        } catch (Exception e) {
            addMessage(model, e);
        }
        return "/gen/genTableColumnStyleEdit";
    }

    /**
     * 保存记录
     * @param list
     * @param req
     * @param attributes
     * @return
     */
    @RequiresPermissions("gen:genTableColumnStyle:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(List<GenTableColumnStyleBo> list, HttpServletRequest req, RedirectAttributes attributes) {
        boolean isNew = RequestUtil.getBoolParameter(req, "isNew", false);
        //数据 验证
        if (!beanValidator(attributes, list))
            return returnFail(attributes);
        try {
            genTableColumnStyleService.save(isNew, list);
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
    @RequiresPermissions("gen:genTableColumnStyle:delete")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String id, HttpServletRequest req, RedirectAttributes attributes) {
        try {
            genTableColumnStyleService.delete(id);
            return returnOK("删除成功！");
        } catch (Exception e) {
            return returnFail(e, "删除失败！");
        }
    }

}
