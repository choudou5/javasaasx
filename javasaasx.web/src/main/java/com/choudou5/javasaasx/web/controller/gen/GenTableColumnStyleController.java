/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.gen;

import com.choudou5.base.annotation.ControllerDesc;
import com.choudou5.base.bean.SelectBo;
import com.choudou5.javasaasx.common.util.SysUtil;
import com.choudou5.javasaasx.service.gen.GenTableColumnStyleService;
import com.choudou5.javasaasx.service.gen.bo.GenCodeBo;
import com.choudou5.javasaasx.service.gen.bo.GenTableColumnStyleBo;
import com.choudou5.javasaasx.service.impl.util.GenUtil;
import com.choudou5.javasaasx.web.controller.BaseController;
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
 * @Author：xuhaowen
 * @Date：2018-01-14
 */
@Controller
@Scope("prototype")
@RequestMapping("/gen/genTableColumnStyle")
public class GenTableColumnStyleController extends BaseController {

    @Autowired
    private GenTableColumnStyleService genTableColumnStyleService;


    /**
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看生成表字段样式-列表", optType = "view")
    @RequiresPermissions("gen:genTableColumnStyle:view")
    @RequestMapping(value = {"list", ""}, method = RequestMethod.GET)
    public String list(HttpServletRequest req, Model model) {
        List<SelectBo> list = genTableColumnStyleService.getTableList();
        model.addAttribute("leftDataList", list);
        model.addAttribute("genCodePath", SysUtil.getGenCodePath());
        return "/gen/genTableColumnStyleListListEdit";
    }


    /**
     * @param table
     * @return
     */
    @ControllerDesc(desc = "编辑生成表字段样式", optType = "edit")
    @RequiresPermissions("gen:genTableColumnStyle:edit")
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public String edit(String table, HttpServletRequest req) {
        try {
            List<GenTableColumnStyleBo> list = genTableColumnStyleService.getGenTableColumnStyleList(table);
            return returnTableData(list);
        } catch (Exception e) {
            return returnFail(e, "表字段样式列表失败");
        }
    }


    /**
     * @param req
     * @param attributes
     * @return
     */
    @ControllerDesc(desc = "保存生成表字段样式", optType = "save")
    @RequiresPermissions("gen:genTableColumnStyle:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(GenCodeBo genCodeBo, HttpServletRequest req, RedirectAttributes attributes) {
        //数据 验证
        if (!beanValidator(attributes, genCodeBo))
            return returnFail(attributes);
        try {
            //生成代码
            GenUtil.genCode(genCodeBo);
            genTableColumnStyleService.save(genCodeBo.getColumnStyleList());
            return returnOK("保存成功");
        } catch (Exception e) {
            return returnFail(e, "保存失败");
        }
    }

}