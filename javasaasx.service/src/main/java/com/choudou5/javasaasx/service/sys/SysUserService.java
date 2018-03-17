/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.sys;

import com.choudou5.javasaasx.base.service.BaseService;
import com.choudou5.javasaasx.service.sys.bo.SysUserBo;

/**
 * @Name：系统用户接口
 * @Author：xuhaowen
 * @Date：2018-01-13
 */
public interface SysUserService extends BaseService<SysUserBo> {

    void addByDingTalkUser(SysUserBo bo);

    SysUserBo getByEmail(String email);

    SysUserBo getByMobile(String mobile);

}
