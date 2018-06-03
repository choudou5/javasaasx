package com.choudou5.javasaasx.base.service;

import com.choudou5.javasaasx.base.service.vo.SysUserSimpleVo;

import java.util.List;

/**
 * @Name：CommService 说明
 * @Author：xuhaowen
 * @Date：2018-03-11
 */
public interface CommService {

    List<SysUserSimpleVo> findAllActiveUsers();

    SysUserSimpleVo getByEmail(String email);

    SysUserSimpleVo getByMobile(String mobile);


}
