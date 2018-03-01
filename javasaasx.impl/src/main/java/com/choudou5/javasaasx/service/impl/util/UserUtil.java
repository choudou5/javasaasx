package com.choudou5.javasaasx.service.impl.util;

import com.choudou5.base.bean.SelectBo;
import com.choudou5.base.util.CollUtil;
import com.choudou5.base.util.StrUtil;
import com.choudou5.javasaasx.common.util.SpringContextHolder;
import com.choudou5.javasaasx.service.sys.SysUserService;
import com.choudou5.javasaasx.service.sys.bo.SysUserBo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Name：用户工具类
 * @Author：xuhaowen
 * @Date：2018-03-01
 */
public class UserUtil {

    private static SysUserService sysUserService = SpringContextHolder.getBean(SysUserService.class);

    /**
     * 获取 用户下拉列表数据
     * @param userId
     * @return
     */
    public static List<SelectBo> getUserSelectListData(String userId){
        final String userIdStr = StrUtil.isBlank(userId)?"":userId;
        List<SysUserBo> boList = sysUserService.findAll();
        if(CollUtil.isNotEmpty(boList)){
            return boList.stream().map(bo -> new SelectBo(bo.getName(), bo.getId().toString(), bo.getId().equals(userIdStr))).collect(Collectors.toList());
        }
        return null;
    }
}
