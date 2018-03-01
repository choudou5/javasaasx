/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.sys;

import com.choudou5.base.annotation.ControllerDesc;
import com.choudou5.base.page.PageResult;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.service.sys.SysOperationLogService;
import com.choudou5.javasaasx.service.sys.bo.SysOperationLogBo;
import com.choudou5.javasaasx.service.sys.bo.SysOperationLogQueryParam;
import com.choudou5.javasaasx.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @Name：系统操作日志 Controller
 * @Author：xuhaowen
 * @Date：2018-02-28
 */
@Controller
@Scope("prototype")
@RequestMapping("/sys/sysOperationLog")
public class SysOperationLogController extends BaseController {

    @Autowired
    private SysOperationLogService sysOperationLogService;


    /**
     * 对象绑定（表单提交时）
     * @param id
     * @return
     */
    @ModelAttribute
    public SysOperationLogBo get(@RequestParam(required=false) String id) {
        if (StrUtil.isNotBlank(id)){
            return sysOperationLogService.get(id);
        }else{
            return new SysOperationLogBo();
        }
    }

    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统操作日志-列表", optType = "view")
    @RequiresPermissions("sys:sysOperationLog:view")
    @RequestMapping(value = {"list", ""})
    public String list(SysOperationLogQueryParam queryParam, HttpServletRequest req, Model model) {
        queryParam.setDefOrder("create_time", "desc");
        PageResult<SysOperationLogBo> pageResult = sysOperationLogService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/sys/sysOperationLogList";
    }

    /**
     * @param id
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看系统操作日志-详情", optType = "view")
    @RequiresPermissions("sys:sysOperationLog:view")
    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public String view(String id, HttpServletRequest req, Model model) {
        SysOperationLogBo sysOperationLogBo = sysOperationLogService.get(id);
        model.addAttribute("sysOperationLogBo", sysOperationLogBo);
        return "/sys/sysOperationLogView";
    }

}
