/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.log;

import com.choudou5.base.annotation.ControllerDesc;
import com.choudou5.base.bean.BetweenBean;
import com.choudou5.base.page.PageResult;
import com.choudou5.javasaasx.service.log.bo.SysOperationLogBo;
import com.choudou5.javasaasx.service.log.bo.SysOperationLogQueryParam;
import com.choudou5.javasaasx.web.controller.BaseController;
import com.choudou5.javasaasx.web.util.LogHelper;
import com.choudou5.javasaasx.web.util.LoggerInfo;
import com.choudou5.javasaasx.web.util.RequestUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Name：系统日志管理 Controller
 * @Author：xuhaowen
 * @Date：2018-02-28
 */
@Controller
@Scope("prototype")
@RequestMapping("/log/sysLogAdmin")
public class SysLogAdminController extends BaseController {


    /**
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "系统日志管理-列表", optType = "view")
    @RequiresPermissions("log:sysLogAdmin:view")
    @RequestMapping(value = {"ajaxList"})
    @ResponseBody
    public Map<String, Object> ajaxList(HttpServletRequest req, Model model) {
        Map<String, Object> result = new HashMap<String, Object>(2);
        result.put("levels", LogHelper.LEVELS);
        List<LoggerInfo> loggers = new ArrayList(LogHelper.getLogList());
        Collections.sort(loggers);
        List info = new ArrayList();
        for (LoggerInfo wrap : loggers) {
            info.add(wrap);
        }
        result.put("loggers", info);
        result.put("watcher", "Log4j (org.slf4j.impl.Log4jLoggerFactory)");
        return result;
    }


    /**
     * @param name
     * @param level
     * @param req
     * @return
     */
    @ControllerDesc(desc = "系统日志管理-设置", optType = "edit")
    @RequiresPermissions("log:sysLogAdmin:setting")
    @RequestMapping(value = {"setting"})
    @ResponseBody
    public String setting(String name, String level, HttpServletRequest req) {
        LogHelper.setLevel(name, level);
        return returnOK("日志级别-更改成功");
    }


    @ControllerDesc(desc = "系统日志-打印", optType = "view")
    @RequiresPermissions("log:sysLogAdmin:setting")
    @RequestMapping(value = {"ajaxPrintLog"})
    @ResponseBody
    public String ajaxPrintLog(HttpServletRequest req, Model model) {
        return "/log/sysOperationLogList";
    }

}
