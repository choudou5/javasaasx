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
import com.choudou5.javasaasx.service.dic.DicAreaService;
import com.choudou5.javasaasx.service.dic.bo.DicAreaBo;
import com.choudou5.javasaasx.service.dic.bo.DicAreaQueryParam;
import com.choudou5.javasaasx.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Name： 字典地区 Controller
 * @Author：xuhaowen
 * @Date：2018-03-06
 */
@Controller
@Scope("prototype")
@RequestMapping("/dic/dicArea")
public class DicAreaController extends BaseController {

    @Autowired
    private DicAreaService dicAreaService;


    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看-列表", optType = "view")
    @RequiresPermissions("dic:dicArea:view")
    @RequestMapping(value = {"list", ""})
    public String list(DicAreaQueryParam queryParam, HttpServletRequest req, Model model) {
        PageResult<DicAreaBo> pageResult = dicAreaService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/dic/dicAreaList";
    }


}
