/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.pl;

import com.choudou5.base.annotation.ControllerDesc;
import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.base.page.PageResult;
import com.choudou5.base.util.AssertUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.service.pl.ValidcodeTraceService;
import com.choudou5.javasaasx.service.pl.vo.ValidcodeTraceVo;
import com.choudou5.javasaasx.service.pl.vo.ValidcodeTraceListVo;
import com.choudou5.javasaasx.service.pl.vo.ValidcodeTraceQueryParam;

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
 * @Name：验证码记录 Controller
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
@Controller
@Scope("prototype")
@RequestMapping("/pl/validcodeTrace")
public class ValidcodeTraceController extends BaseController {

    @Autowired
    private ValidcodeTraceService validcodeTraceService;


    /**
     * 对象绑定（表单提交时）
     * @param id
     * @return
     */
    @ModelAttribute
    public ValidcodeTraceVo get(@RequestParam(required=false) String id) {
        if (StrUtil.isNotBlank(id)){
            return validcodeTraceService.get(id);
        }else{
            return new ValidcodeTraceVo();
        }
    }

    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看验证码记录-列表", optType = "view")
    @RequiresPermissions("pl:validcodeTrace:view")
    @RequestMapping(value = {"list", ""})
    public String list(ValidcodeTraceQueryParam queryParam, HttpServletRequest req, Model model) {
        PageResult<ValidcodeTraceVo> pageResult = validcodeTraceService.findPage(queryParam);
//        PageResult<ValidcodeTraceListVo> result = BeanMapper.mapPage(pageResult, ValidcodeTraceListVo.class);
        model.addAttribute("pageResult", pageResult);
        return "/pl/validcodeTraceList";
    }

    /**
     * @param vo
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看验证码记录-详情", optType = "view")
    @RequiresPermissions("pl:validcodeTrace:view")
    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public String view(ValidcodeTraceVo vo, HttpServletRequest req, Model model) {
        model.addAttribute("validcodeTraceVo", vo);
        return "/pl/validcodeTraceView";
    }

    /**
     * @param vo
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "编辑验证码记录", optType = "edit")
    @RequiresPermissions("pl:validcodeTrace:edit")
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(ValidcodeTraceVo vo, HttpServletRequest req, Model model) {
        try {
            AssertUtil.isNotNull(vo, "数据不存在");
            model.addAttribute("validcodeTraceVo", vo);
        } catch (Exception e) {
            addMessage(model, e);
        }
        return "/pl/validcodeTraceForm";
    }

    /**
     * @param validcodeTraceVo
     * @param req
     * @param attributes
     * @return
     */
    @ControllerDesc(desc = "保存验证码记录", optType = "save")
    @RequiresPermissions("pl:validcodeTrace:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(ValidcodeTraceVo validcodeTraceVo, HttpServletRequest req, RedirectAttributes attributes) {
        //数据 验证
        if (!beanValidator(attributes, validcodeTraceVo))
            return returnFail(attributes);
        try {
            validcodeTraceService.save(validcodeTraceVo);
            return returnOK("保存成功");
        } catch (Exception e) {
            return returnFail(e, "保存失败");
        }
    }

    /**
     * @param id
     * @param req
     * @return
     */
    @ControllerDesc(desc = "删除验证码记录", optType = "delete")
    @RequiresPermissions("pl:validcodeTrace:delete")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String id, HttpServletRequest req) {
        try {
            validcodeTraceService.logicDeleteById(id);
            return returnOK("删除成功");
        } catch (Exception e) {
            return returnFail(e, "删除失败");
        }
    }

}
