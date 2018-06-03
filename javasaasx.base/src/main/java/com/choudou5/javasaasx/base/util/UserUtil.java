package com.choudou5.javasaasx.base.util;

import com.choudou5.base.bean.SelectBean;
import com.choudou5.base.util.CollUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.base.service.CommService;
import com.choudou5.javasaasx.base.service.vo.SysUserSimpleVo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Name：用户工具类
 * @Author：xuhaowen
 * @Date：2018-03-01
 */
public class UserUtil {

    private static CommService commService = SpringContextHolder.getBean(CommService.class);


    public static String getUserId(){
        return "1";
    }


    /**
     * 获取 用户下拉列表数据
     * @param userId
     * @return
     */
    public static List<SelectBean> getUserSelectListData(String userId){
        final String userIdStr = StrUtil.isBlank(userId)?"":userId;
        List<SysUserSimpleVo> userVos = commService.findAllActiveUsers();
        if(CollUtil.isNotEmpty(userVos)){
            return userVos.stream().map(bo -> new SelectBean(bo.getName(), bo.getId().toString(), bo.getId().equals(userIdStr))).collect(Collectors.toList());
        }
        return null;
    }
}
