/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.sys;

import com.choudou5.javasaasx.base.service.BaseService;
import com.choudou5.javasaasx.service.sys.bo.SysUserRelThirdpartyBo;

/**
 * @Name：用户关联第三方 接口
 * @Author：xuhaowen
 * @Date：2018-02-19
 */
public interface SysUserRelThirdpartyService extends BaseService<SysUserRelThirdpartyBo> {

    SysUserRelThirdpartyBo findByDingTalkUserId(String dingUserId);

}
