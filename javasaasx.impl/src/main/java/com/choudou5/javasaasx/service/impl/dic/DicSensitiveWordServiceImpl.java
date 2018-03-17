/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.impl.dic;

import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.dao.dic.DicSensitiveWordDao;
import com.choudou5.javasaasx.dao.dic.po.DicSensitiveWordPo;
import com.choudou5.javasaasx.service.dic.DicSensitiveWordService;
import com.choudou5.javasaasx.service.dic.bo.DicSensitiveWordBo;
import com.choudou5.javasaasx.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Name：敏感词库 接口实现类
 * @Author：xuhaowen
 * @Date：2018-03-04
 */
@Service("dicSensitiveWordService")
public class DicSensitiveWordServiceImpl extends BaseServiceImpl<DicSensitiveWordPo, DicSensitiveWordBo> implements DicSensitiveWordService {

    @Autowired
    private DicSensitiveWordDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

    @Override
    public List<String> findAllWord() {
        return dao.findAllWord();
    }
}
