<#include "/java_copyright.include"/>
<#assign className = table.className>
<#assign classBOName = table.className + 'Bo'>
<#assign classNameLower = className?uncap_first>
<#assign classService = classNameLower + 'Service'>
<#assign classBONameLower = classBOName?uncap_first>
package ${packageNamePrefix}.web.controller.${moduleName};

import ${packageNamePrefix}.framework.page.PageResult;
import ${packageNamePrefix}.framework.util.AssertUtil;
import ${packageNamePrefix}.service.${moduleName}.${className}Service;
import ${packageNamePrefix}.service.${moduleName}.bo.${classBOName};
import ${packageNamePrefix}.service.${moduleName}.bo.${className}QueryParam;
import ${packageNamePrefix}.web.controller.BaseController;
import com.choudou5.base.util.StrUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletRequest;

/**
 * @Name：${table.remarks} Controller
 * @Author：${author}
 * @Date：${createTime}
 */
@Controller
@Scope("prototype")
@RequestMapping("/${moduleName}/${classNameLower}")
public class ${className}Controller extends BaseController {

    @Autowired
    private ${className}Service ${classService};


    /**
     * 对象绑定（表单提交时）
     * @param id
     * @return
     */
    @ModelAttribute
    public ${classBOName} get(@RequestParam(required=false) String id) {
        if (StrUtil.isNotBlank(id)){
            return ${classService}.get(id);
        }else{
            return new ${classBOName}();
        }
    }

    /**
     * 列表
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("${moduleName}:${classNameLower}:view")
    @RequestMapping(value = {"list", ""}, method = RequestMethod.GET)
    public String list(${className}QueryParam queryParam, HttpServletRequest req, Model model) {
        PageResult<${classBOName}> pageResult = ${classService}.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/${moduleName}/${classNameLower}List";
    }

    /**
     * 查看
     * @param id
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("${moduleName}:${classNameLower}:view")
    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public String view(String id, HttpServletRequest req, Model model) {
        ${classBOName} ${classBONameLower} = ${classService}.get(id);
        model.addAttribute("${classBONameLower}", ${classBONameLower});
        return "/${moduleName}/${classNameLower}View";
    }

    /**
     * 编辑记录
     * @param id
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("${moduleName}:${classNameLower}:edit")
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(String id, HttpServletRequest req, Model model) {
        try {
            ${classBOName} bo = ${classService}.get(id);
            AssertUtil.isNotNull(bo, "数据不存在！");
            model.addAttribute("${classBONameLower}", bo);
        } catch (Exception e) {
            addMessage(model, e);
        }
        return "/${moduleName}/${classNameLower}Form";
    }

    /**
     * 保存记录
     * @param ${classBONameLower}
     * @param req
     * @param attributes
     * @return
     */
    @RequiresPermissions("${moduleName}:${classNameLower}:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(${classBOName} ${classBONameLower}, HttpServletRequest req, RedirectAttributes attributes) {
        //数据 验证
        if (!beanValidator(attributes, ${classBONameLower}))
            return returnFail(attributes);
        try {
            ${classService}.save(${classBONameLower});
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
    @RequiresPermissions("${moduleName}:${classNameLower}:delete")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String id, HttpServletRequest req, RedirectAttributes attributes) {
        try {
            ${classService}.logicDeleteById(id);
            return returnOK("删除成功！");
        } catch (Exception e) {
            return returnFail(e, "删除失败！");
        }
    }

}
