/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.log;

import com.choudou5.base.annotation.ControllerDesc;
import com.choudou5.base.bean.BetweenBean;
import com.choudou5.base.page.PageResult;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.service.log.LogOperationService;
import com.choudou5.javasaasx.service.log.vo.LogOperationQueryParam;
import com.choudou5.javasaasx.service.log.vo.LogOperationVo;
import com.choudou5.javasaasx.web.controller.BaseController;
import com.choudou5.javasaasx.web.util.RequestUtil;
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
 * @Name：操作日志 Controller
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
@Controller
@Scope("prototype")
@RequestMapping("/log/logOperation")
public class LogOperationController extends BaseController {

    @Autowired
    private LogOperationService logOperationService;


    /**
     * 对象绑定（表单提交时）
     * @param id
     * @return
     */
    @ModelAttribute
    public LogOperationVo get(@RequestParam(required=false) String id) {
        if (StrUtil.isNotBlank(id)){
            return logOperationService.get(id);
        }else{
            return new LogOperationVo();
        }
    }

    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看操作日志-列表", optType = "view")
    @RequiresPermissions("log:logOperation:view")
    @RequestMapping(value = {"list", ""})
    public String list(LogOperationQueryParam queryParam, HttpServletRequest req, Model model) {
        queryParam.setOrderDefParam("create_time", "desc");
        queryParam.setLogOperationVo(new LogOperationVo());
        BetweenBean betweenBean = RequestUtil.getRangeDateParameter(req, "rangeCreateDate", " - ");
        if(betweenBean != null)
            queryParam.addExtendParam("create_time", betweenBean.toSql());
        PageResult<LogOperationVo> pageResult = logOperationService.findPage(queryParam);
//        PageResult<ValidcodeTraceListVo> result = BeanMapper.mapPage(pageResult, ValidcodeTraceListVo.class);
        model.addAttribute("pageResult", pageResult);
        model.addAttribute("rangeCreateDate", RequestUtil.getStrParameter(req, "rangeCreateDate"));
        return "/log/logOperationList";
    }

    /**
     * @param vo
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看操作日志-详情", optType = "view")
    @RequiresPermissions("log:logOperation:view")
    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public String view(LogOperationVo vo, HttpServletRequest req, Model model) {
        model.addAttribute("logOperationVo", vo);
        return "/log/logOperationView";
    }

}
