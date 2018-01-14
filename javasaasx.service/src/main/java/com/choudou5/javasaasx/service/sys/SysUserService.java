package com.choudou5.javasaasx.service.sys;

import com.choudou5.javasaasx.framework.bean.BaseBo;
import com.choudou5.javasaasx.framework.bean.BasePo;
import com.choudou5.javasaasx.framework.service.BaseService;
import com.choudou5.javasaasx.service.sys.bo.SysUserBo;

/**
 * @Name：系统用户接口
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 16:11
 * @Site：http://www.javasaas.top
 * @License：MIT
 */
public interface SysUserService<T extends BaseBo> extends BaseService<T> {


    public SysUserBo getByEmail(String email);

    public SysUserBo getByMobile(String mobile);

}
