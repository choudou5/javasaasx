/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.sys;

import com.alibaba.dingtalk.openapi.department.DepartmentHelper;
import com.alibaba.dingtalk.openapi.message.LinkMessage;
import com.alibaba.dingtalk.openapi.role.RoleHelper;
import com.alibaba.dingtalk.openapi.user.UserHelper;
import com.choudou5.base.exception.BizException;
import com.choudou5.base.mapper.BeanMapper;
import com.choudou5.base.util.AssertUtil;
import com.choudou5.base.util.CollUtil;
import com.choudou5.base.util.ObjUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.base.security.PasswordUtil;
import com.choudou5.javasaasx.base.util.SysSeqUtil;
import com.choudou5.javasaasx.common.constants.CommConsts;
import com.choudou5.javasaasx.common.util.CommUtil;
import com.choudou5.javasaasx.dao.sys.SysRoleDao;
import com.choudou5.javasaasx.dao.sys.SysUserRoleDao;
import com.choudou5.javasaasx.dao.sys.po.SysRolePo;
import com.choudou5.javasaasx.dao.sys.po.SysUserRolePo;
import com.choudou5.javasaasx.service.impl.util.SysExceptionUtil;
import com.choudou5.javasaasx.service.message.MessageTpGroupService;
import com.choudou5.javasaasx.service.sys.DingTalkService;
import com.choudou5.javasaasx.service.sys.SysOfficeService;
import com.choudou5.javasaasx.service.sys.SysUserService;
import com.choudou5.javasaasx.service.sys.bo.*;
import com.com.choudou5.message.dingtalk.service.DingTalkAuthService;
import com.com.choudou5.message.dingtalk.service.DingTalkChatService;
import com.dingtalk.api.model.corp.CorpRole;
import com.dingtalk.api.model.corp.CorpUserDetailExt;
import com.dingtalk.api.model.corp.CorpUserDetailListExt;
import com.dingtalk.api.response.CorpRoleListResponse;
import com.dingtalk.open.client.api.model.corp.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Name：钉钉 接口 实现类
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13
 */
@Service("dingTalkService")
public class DingTalkServiceImpl implements DingTalkService {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysOfficeService sysOfficeService;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    @Autowired
    private MessageTpGroupService messageTpGroupService;
    @Autowired
    private DingTalkAuthService dingTalkAuthService;
    @Autowired
    private DingTalkChatService dingTalkChatService;


    private int getOfficeDepth(Map<String, Integer> tree, String id, String pid){
        Integer depth = tree.get(pid);
        if(depth == null){
            depth = 1;
            tree.put(pid, 1);
        }else{
            if(!pid.equals("1"))
                depth++;
        }
        tree.put(id, depth);
        return depth;
    }

    @Transactional(readOnly = false)
    @Override
    public void synData() {
        String accessToken = dingTalkAuthService.getAccessToken();
        try {
            //同步 角色数据
            synRoleData(accessToken);
            //同步 部门与用户数据
            synDeptData(accessToken);
        } catch (Exception e) {
            SysExceptionUtil.error("同步钉钉部门失败", e);
            throw new BizException(e.getMessage());
        }
    }

    @Override
    public String create(String chatName, String owner, List<String> userIdlist) {
        return dingTalkChatService.create(chatName, owner, userIdlist);
    }

    @Override
    public void sendTextMsg(String bizType, String text) {
        AssertUtil.isNotBlank(text, "消息不能为空");
        String chatId = messageTpGroupService.getCode(bizType);
        AssertUtil.isNotBlank(chatId, "钉钉群组未配置业务:"+bizType);
        dingTalkChatService.sendTextMsg(chatId, text);
    }

    @Override
    public void sendLinkMsg(String bizType, DingLinkMessageBo messageBo) {
        String chatId = messageTpGroupService.getCode(bizType);
        AssertUtil.isNotBlank(chatId, "钉钉群组未配置业务:"+bizType);
        LinkMessage message = BeanMapper.map(messageBo, LinkMessage.class);
        dingTalkChatService.sendLinkMsg(chatId, message);
    }

    private void synDeptData(String accessToken) throws Exception {
        List<Department> list = DepartmentHelper.listDepartments(accessToken, "1");
        Map<String, Integer> tree = new HashMap<>();
        if(CollUtil.isNotEmpty(list)) {
            for (Department dept : list) {
                Long officeId = dept.getId();
                SysOfficeBo officeBo = new SysOfficeBo(officeId.toString(), dept.getName(), dept.getParentid().toString());
                officeBo.setDepth(getOfficeDepth(tree, officeBo.getId(), officeBo.getPid()));
                sysOfficeService.addDingTalkOffice(officeBo);

                long offset = 0;
                int size = 50;
                CorpUserDetailListExt corpUserList = null;
                List<CorpUserDetailExt> userlist = null;
                while (true) {
                    corpUserList = UserHelper.getUserDetails(accessToken, officeId, offset, size);
                    if (corpUserList == null || CollUtil.isEmpty(corpUserList.getUserlist()))
                        break;
                    userlist = corpUserList.getUserlist();
                    for (CorpUserDetailExt user : userlist) {
                        sysUserService.addByDingTalkUser(buildSysUserBo(dept.getId().toString(), user));
                        //同步 用户详情数据
                        synUserInfoData(accessToken, user.getUserid());
                    }
                    if (Boolean.TRUE.equals(corpUserList.isHasMore())) {
                        offset += size;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private SysUserBo buildSysUserBo(String deptId, CorpUserDetailExt user){
        SysUserBo userBo = new SysUserBo();
        userBo.setId(SysSeqUtil.getIdStr());
        userBo.setOfficeId(deptId);
        userBo.setCompanyId(deptId);
        userBo.setName(user.getName());
        userBo.setPassword(PasswordUtil.entryptPassword(CommConsts.SYS_DEF_PWD));
        userBo.setPhone(user.getTel());
        userBo.setMobile(user.getMobile());
        userBo.setEmail(user.getEmail());
        userBo.setIsAdmin(CommUtil.getBoolCode(user.getIsAdmin()));
        userBo.setIsBoss(CommUtil.getBoolCode(user.getIsBoss()));
        userBo.setPosition(user.getPosition());
        userBo.setAvatar(user.getAvatar());
        userBo.setJobNumber(user.getJobnumber());
        userBo.setRemarks(user.getRemark());
        userBo.setStatus(CommUtil.getBoolNum(user.getActive()));
        userBo.setSource(CommConsts.SYS_USER_SOURCE_DD);
        //第三方关联信息
        SysUserRelThirdpartyBo tpBo = new SysUserRelThirdpartyBo(userBo.getId());
        tpBo.setDingUserId(user.getUserid());
        tpBo.setDingUnionId(user.getUnionid());
        tpBo.setDingGlobalId(user.getDingId());
        userBo.setTpBo(tpBo);
        return userBo;
    }

    private void synUserInfoData(String accessToken, String userId) throws Exception {
        CorpUserDetailExt user = UserHelper.getUserInfo(accessToken, userId);
        //删除 旧角色
        sysUserRoleDao.deleteBy(new SysUserRoleQueryParam(new SysUserRoleBo().setUserId(userId)));
        //新增
        List<CorpRole> roles = user.getRoles();
        if(CollUtil.isNotEmpty(roles)){
            SysUserRolePo po = null;
            for (CorpRole role : roles) {
                po = new SysUserRolePo();
                po.setUserId(userId);
                po.setRoleId(role.getId().toString());
                po.preInsert();
                sysUserRoleDao.insert(po);
            }
        }
    }

    private void synRoleData(String accessToken) throws Exception {
        List<CorpRoleListResponse.RoleGroups> list = RoleHelper.getRoleList(accessToken, 100, 0);
        if(CollUtil.isEmpty(list)){
            return;
        }
        String groupName = null;
        for (CorpRoleListResponse.RoleGroups roleGroup : list) {
            groupName = roleGroup.getGroupName();
            List<CorpRoleListResponse.Roles> roles = roleGroup.getRoles();
            SysRolePo po = null;
            for (CorpRoleListResponse.Roles role : roles) {
                po = sysRoleDao.findById(role.getId());
                if(ObjUtil.isNotNull(po)){
                    //更新 信息
                    if(!StrUtil.equals(role.getRoleName(), po.getName()))
                        po.setName(role.getRoleName());
                    if(!StrUtil.equals(groupName, po.getGroupName()))
                        po.setGroupName(groupName);
                    sysRoleDao.update(po);
                }else{
                    po = new SysRolePo();
                    po.setName(role.getRoleName());
                    po.setId(role.getId().toString());
                    po.setGroupName(groupName);
                    po.preInsert(false);
                    sysRoleDao.insert(po);
                }
            }
        }
    }

}
