/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.web.controller.message;

import com.choudou5.base.annotation.ControllerDesc;
import com.choudou5.base.bean.SelectBean;
import com.choudou5.base.page.PageResult;
import com.choudou5.base.util.AssertUtil;
import com.choudou5.base.util.CollUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.service.message.MessageTpGroupService;
import com.choudou5.javasaasx.service.message.vo.MessageTpGroupQueryParam;
import com.choudou5.javasaasx.service.message.vo.MessageTpGroupVo;
import com.choudou5.javasaasx.service.sys.DingTalkService;
import com.choudou5.javasaasx.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Name：第三方消息群 Controller
 * @Author：xuhaowen
 * @Date：2018-03-18
 */
@Controller
@Scope("prototype")
@RequestMapping("/message/messageTpGroup")
public class MessageTpGroupController extends BaseController {

    @Autowired
    private MessageTpGroupService messageTpGroupService;
    @Autowired
    private DingTalkService dingTalkService;


    /**
     * 对象绑定（表单提交时）
     * @param id
     * @return
     */
    @ModelAttribute
    public MessageTpGroupVo get(@RequestParam(required=false) String id) {
        if (StrUtil.isNotBlank(id)){
            return messageTpGroupService.get(id);
        }else{
            return new MessageTpGroupVo();
        }
    }

    /**
     * @param queryParam
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看第三方消息群-列表", optType = "view")
    @RequiresPermissions("message:messageTpGroup:view")
    @RequestMapping(value = {"list", ""})
    public String list(MessageTpGroupQueryParam queryParam, HttpServletRequest req, Model model) {
        PageResult<MessageTpGroupVo> pageResult = messageTpGroupService.findPage(queryParam);
        model.addAttribute("pageResult", pageResult);
        return "/message/messageTpGroupList";
    }

    /**
     * @param vo
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "查看第三方消息群-详情", optType = "view")
    @RequiresPermissions("message:messageTpGroup:view")
    @RequestMapping(value = {"view"}, method = RequestMethod.GET)
    public String view(MessageTpGroupVo vo, HttpServletRequest req, Model model) {
        model.addAttribute("messageTpGroupVo", vo);
        return "/message/messageTpGroupView";
    }

    /**
     * @param vo
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "编辑第三方消息群", optType = "edit")
    @RequiresPermissions("message:messageTpGroup:edit")
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(MessageTpGroupVo vo, HttpServletRequest req, Model model) {
        try {
            AssertUtil.isNotNull(vo, "数据不存在");
            model.addAttribute("messageTpGroupVo", vo);
        } catch (Exception e) {
            addMessage(model, e);
        }
        return "/message/messageTpGroupForm";
    }

    /**
     * @param messageTpGroupVo
     * @param req
     * @param attributes
     * @return
     */
    @ControllerDesc(desc = "保存第三方消息群", optType = "save")
    @RequiresPermissions("message:messageTpGroup:edit")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String save(MessageTpGroupVo messageTpGroupVo, HttpServletRequest req, RedirectAttributes attributes) {
        //数据 验证
        if (!beanValidator(attributes, messageTpGroupVo))
            return returnFail(attributes);
        try {
            messageTpGroupService.save(messageTpGroupVo);
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
    @ControllerDesc(desc = "删除第三方消息群", optType = "delete")
    @RequiresPermissions("message:messageTpGroup:delete")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String id, HttpServletRequest req) {
        try {
            messageTpGroupService.logicDeleteById(id);
            return returnOK("删除成功");
        } catch (Exception e) {
            return returnFail(e, "删除失败");
        }
    }

    /**
     * @param req
     * @param model
     * @return
     */
    @ControllerDesc(desc = "第三方消息群-测试", optType = "view")
    @RequiresPermissions("message:messageTpGroup:view")
    @RequestMapping(value = {"test"})
    public String test(HttpServletRequest req, Model model) {
        List<MessageTpGroupVo> list = messageTpGroupService.findAll();
        List<SelectBean> dataList = null;
        if(CollUtil.isNotEmpty(list))
            dataList = list.stream().map(info -> new SelectBean(info.getName(), info.getBizType())).collect(Collectors.toList());
        model.addAttribute("leftDataList", dataList);
        return "/message/messageTpGroupTest";
    }

    /**
     * @param bizType
     * @param message
     * @param req
     * @return
     */
    @ControllerDesc(desc = "发送消息到第三方群", optType = "send")
    @RequiresPermissions("message:messageTpGroup:delete")
    @RequestMapping(value = "send", method = RequestMethod.POST)
    @ResponseBody
    public String send(String bizType, String message, HttpServletRequest req) {
        try {
            if(!"dingtalk".equals(bizType))
                returnFail("暂未集成"+bizType+"消息");
            dingTalkService.sendTextMsg(bizType, message);
            return returnOK("发送成功");
        } catch (Exception e) {
            return returnFail(e, "发送失败");
        }
    }


}
