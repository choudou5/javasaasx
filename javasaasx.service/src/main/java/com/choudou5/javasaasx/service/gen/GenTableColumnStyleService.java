package com.choudou5.javasaasx.service.gen;

import com.choudou5.javasaasx.framework.bean.BaseBo;
import com.choudou5.javasaasx.framework.bean.SelectBo;
import com.choudou5.javasaasx.framework.bean.TableDataBo;
import com.choudou5.javasaasx.framework.service.BaseService;
import com.choudou5.javasaasx.service.gen.bo.GenTableColumnStyleBo;

import java.util.List;

/**
 * @Name：生成表字段样式 接口
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-14
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public interface GenTableColumnStyleService extends BaseService<GenTableColumnStyleBo> {

    List<SelectBo> getTableList();

    List<GenTableColumnStyleBo>  getGenTableColumnStyleList(String table);

}
