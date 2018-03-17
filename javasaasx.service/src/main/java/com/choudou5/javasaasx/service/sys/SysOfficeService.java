/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.sys;

import com.choudou5.javasaasx.base.service.BaseService;
import com.choudou5.javasaasx.service.sys.bo.SysOfficeBo;

/**
 * @Name：系统机构 接口
 * @Author：xuhaowen
 * @Date：2018-02-18
 */
public interface SysOfficeService extends BaseService<SysOfficeBo> {

    void addDingTalkOffice(SysOfficeBo bo);

}
