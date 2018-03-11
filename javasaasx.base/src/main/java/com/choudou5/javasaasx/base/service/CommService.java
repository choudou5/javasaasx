package com.choudou5.javasaasx.base.service;

import com.choudou5.javasaasx.base.service.vo.SysUserVo;

import java.util.List;

/**
 * @Name：CommService 说明
 * @Author：xuhaowen
 * @Date：2018-03-11
 */
public interface CommService {

    List<SysUserVo> findAllActiveUsers();

    SysUserVo getByEmail(String email);

    SysUserVo getByMobile(String mobile);


}
