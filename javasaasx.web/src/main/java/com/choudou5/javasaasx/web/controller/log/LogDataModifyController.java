/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.log;

import com.choudou5.base.annotation.ControllerDesc;
import com.choudou5.base.page.PageResult;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.service.log.LogDataModifyService;
import com.choudou5.javasaasx.service.log.vo.LogDataModifyQueryParam;
import com.choudou5.javasaasx.service.log.vo.LogDataModifyVo;
import com.choudou5.javasaasx.web.controller.BaseController;
import com.choudou5.javasaasx.web.util.RequestUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Name：数据修改日志 Controller
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
@Controller
@Scope("prototype")
@RequestMapping("/log/logDataModify")
public class LogDataModifyController extends BaseController {

    @Autowired
    private LogDataModifyService logDataModifyService;


    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看数据修改日志-列表", optType = "view")
    @RequiresPermissions("log:logDataModify:view")
    @RequestMapping(value = {"list", ""})
    public String list(LogDataModifyQueryParam queryParam, HttpServletRequest req, Model model) {
        String bizKey = RequestUtil.getStrParameter(req, "bizKey");
        String bizId = RequestUtil.getStrParameter(req, "bizId");
        if(StrUtil.isNotBlank(bizKey))
            queryParam.setDefVo().setBizKey(bizKey);
        if(StrUtil.isNotBlank(bizId))
            queryParam.setDefVo().setBizId(bizId);
        PageResult<LogDataModifyVo> pageResult = logDataModifyService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/log/logDataModifyList";
    }


}
