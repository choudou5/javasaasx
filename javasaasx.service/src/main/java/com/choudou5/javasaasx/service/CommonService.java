package com.choudou5.javasaasx.service;

import com.choudou5.javasaasx.base.service.CommService;
import com.choudou5.javasaasx.base.service.vo.SysUserSimpleVo;
import com.choudou5.javasaasx.service.gen.GenTableColumnStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Name：公共 接口实现类
 * @Author：xuhaowende
 * @Date：2018-02-22
 */
@Service("commonService")
public class CommonService implements CommService {

    @Autowired
    private GenTableColumnStyleService genTableColumnStyleService;

    public void clearCache() {
        genTableColumnStyleService.refreshCache();

    }

    @Override
    public List<SysUserSimpleVo> findAllActiveUsers() {
        return null;
    }

    @Override
    public SysUserSimpleVo getByEmail(String email) {
        return null;
    }

    @Override
    public SysUserSimpleVo getByMobile(String mobile) {
        return null;
    }
}
