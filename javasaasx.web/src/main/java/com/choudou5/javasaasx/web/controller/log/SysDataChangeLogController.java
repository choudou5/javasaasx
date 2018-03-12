/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.log;

import com.choudou5.base.annotation.ControllerDesc;
import com.choudou5.base.page.PageResult;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.service.log.SysDataChangeLogService;
import com.choudou5.javasaasx.service.log.bo.SysDataChangeLogBo;
import com.choudou5.javasaasx.service.log.bo.SysDataChangeLogQueryParam;
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
 * @Name：系统数据变更日志 Controller
 * @Author：xuhaowen
 * @Date：2018-03-11
 */
@Controller
@Scope("prototype")
@RequestMapping("/log/sysDataChangeLog")
public class SysDataChangeLogController extends BaseController {

    @Autowired
    private SysDataChangeLogService sysDataChangeLogService;

    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统数据变更日志-列表", optType = "view")
    @RequiresPermissions("log:sysDataChangeLog:view")
    @RequestMapping(value = {"list", ""})
    public String list(SysDataChangeLogQueryParam queryParam, HttpServletRequest req, Model model) {
        String bizKey = RequestUtil.getStrParameter(req, "bizKey");
        String bizId = RequestUtil.getStrParameter(req, "bizId");
        if(StrUtil.isNotBlank(bizKey))
            queryParam.setDefBo().setBizKey(bizKey);
        if(StrUtil.isNotBlank(bizId))
            queryParam.setDefBo().setBizId(bizId);
        PageResult<SysDataChangeLogBo> pageResult = sysDataChangeLogService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/log/sysDataChangeLogList";
    }

}
