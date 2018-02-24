package com.choudou5.javasaasx.service.impl;

import com.choudou5.javasaasx.service.CommonService;
import com.choudou5.javasaasx.service.gen.GenTableColumnStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Name：公共 接口实现类
 * @Author：xuhaowende
 * @Date：2018-02-22
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {

    @Autowired
    private GenTableColumnStyleService genTableColumnStyleService;

    @Override
    public void clearCache() {
        genTableColumnStyleService.refreshCache();

    }

}
