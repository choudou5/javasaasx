/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.dic;

import com.choudou5.base.annotation.ControllerDesc;
import com.choudou5.base.page.PageResult;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.service.dic.DicSensitiveWordService;
import com.choudou5.javasaasx.service.dic.bo.DicSensitiveWordBo;
import com.choudou5.javasaasx.service.dic.bo.DicSensitiveWordQueryParam;
import com.choudou5.javasaasx.service.impl.util.SensitiveWordUtil;
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
 * @Name：敏感词库 Controller
 * @Author：xuhaowen
 * @Date：2018-03-04
 */
@Controller
@Scope("prototype")
@RequestMapping("/dic/dicSensitiveWord")
public class DicSensitiveWordController extends BaseController {

    @Autowired
    private DicSensitiveWordService dicSensitiveWordService;


    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看敏感词库-列表", optType = "view")
    @RequiresPermissions("dic:dicSensitiveWord:view")
    @RequestMapping(value = {"list", ""})
    public String list(DicSensitiveWordQueryParam queryParam, HttpServletRequest req, Model model) {
        queryParam.setOrderDefParam("create_time", "DESC");
        PageResult<DicSensitiveWordBo> pageResult = dicSensitiveWordService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/dic/dicSensitiveWordList";
    }


    /**
     * @param dicSensitiveWordBo
     * @param req
     * @param attributes
     * @return
     */
    @ControllerDesc(desc = "保存敏感词库", optType = "save")
    @RequiresPermissions("dic:dicSensitiveWord:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(DicSensitiveWordBo dicSensitiveWordBo, HttpServletRequest req, RedirectAttributes attributes) {
        dicSensitiveWordBo.setWord(RequestUtil.getStrParameter(req, "text"));
        //数据 验证
        if (!beanValidator(attributes, dicSensitiveWordBo))
            return returnFail(attributes);
        try {
            dicSensitiveWordService.save(dicSensitiveWordBo);
            SensitiveWordUtil.refresh();
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
    @ControllerDesc(desc = "删除敏感词库", optType = "delete")
    @RequiresPermissions("dic:dicSensitiveWord:delete")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String id, HttpServletRequest req, RedirectAttributes attributes) {
        try {
            dicSensitiveWordService.delete(id);
            SensitiveWordUtil.refresh();
            return returnOK("删除成功！");
        } catch (Exception e) {
            return returnFail(e, "删除失败！");
        }
    }

    /**
     * 测试敏感词
     * @param text
     * @param req
     * @return
     */
    @ControllerDesc(desc = "查看敏感词库-列表", optType = "view")
    @RequiresPermissions("dic:dicSensitiveWord:view")
    @RequestMapping(value = {"test"})
    @ResponseBody
    public String test(String text, HttpServletRequest req) {
        boolean smallModel = RequestUtil.getBoolParameter(req, "smallModel", true);
        List<String> list = SensitiveWordUtil.getAll(text, true, true);
        return returnOK(StrUtil.join("  |  ", list), "");
    }

}
