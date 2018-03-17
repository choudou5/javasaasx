/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.gen;

import com.choudou5.base.bean.SelectBo;
import com.choudou5.base.exception.BizException;
import com.choudou5.javasaasx.base.service.BaseService;
import com.choudou5.javasaasx.service.gen.bo.GenTableColumnStyleBo;

import java.util.List;

/**
 * @Name：生成表字段样式 接口
 * @Author：xuhaowen
 * @Date：2018-01-14
 */
public interface GenTableColumnStyleService extends BaseService<GenTableColumnStyleBo> {

    void save(List<GenTableColumnStyleBo> columnStyleBoList) throws BizException;

    List<SelectBo> getTableList();

    List<GenTableColumnStyleBo>  getGenTableColumnStyleList(String table);

    void refreshCache();
}
