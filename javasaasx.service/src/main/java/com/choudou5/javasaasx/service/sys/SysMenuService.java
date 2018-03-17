/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.sys;

import com.choudou5.javasaasx.base.service.BaseService;
import com.choudou5.javasaasx.service.sys.bo.SysMenuBo;

import java.util.List;
import java.util.Map;

/**
 * @Name：菜单表 接口
 * @Author：xuhaowen
 * @Date：2018-02-15
 */
public interface SysMenuService extends BaseService<SysMenuBo> {

    void updateField(String id, String field, boolean flag);

    void save(SysMenuBo bo, String[] perms);

    Map<String, Object> getParentTree();

    List<SysMenuBo> findButtomList(String pid);

}