/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.sys;

import com.choudou5.javasaasx.service.sys.DingTalkService;
import com.choudou5.javasaasx.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Name：系统数据 Controller
 * @Author：xuhaowen
 * @Date：2018-02-18
 */
@Controller
@Scope("prototype")
@RequestMapping("/sys/data")
public class SysDataController extends BaseController {

    @Autowired
    private DingTalkService dingTalkService;

    /**
     * 同步数据
     * @param req
     * @return
     */
    @RequiresPermissions("sys:data:synData")
    @RequestMapping(value = "synData", method = RequestMethod.POST)
    @ResponseBody
    public String synData(HttpServletRequest req) {
        try {
            dingTalkService.synData();
            return returnOK("同步数据完成！");
        } catch (Exception e) {
            return returnFail(e, "同步数据失败！");
        }
    }

}
