package com.choudou5.javasaasx.service.sys;

import com.choudou5.javasaasx.framework.bean.BaseBo;
import com.choudou5.javasaasx.framework.service.BaseService;
import com.choudou5.javasaasx.service.sys.bo.SysMenuBo;

import java.util.List;
import java.util.Map;

/**
 * @Name：菜单表 接口
 * @Author：xuhaowen
 * @Date：2018-01-18
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public interface SysMenuService extends BaseService<SysMenuBo> {


    Map<String, Object> getParentTree(Integer showLevel);

}
