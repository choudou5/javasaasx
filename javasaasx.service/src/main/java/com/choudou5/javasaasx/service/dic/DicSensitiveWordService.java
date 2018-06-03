/*
* Powered By [javasaasx]
* Web Site: http://www.javasaas.top
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/
package com.choudou5.javasaasx.service.dic;

import com.choudou5.javasaasx.dao.dic.DicSensitiveWordDao;
import com.choudou5.javasaasx.dao.dic.po.DicSensitiveWordPo;
import com.choudou5.javasaasx.service.dic.vo.DicSensitiveWordVo;
import com.choudou5.javasaasx.base.dao.BaseDao;
import com.choudou5.javasaasx.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Name：敏感词库 Service实现类
 * @Author：xuhaowen
 * @Date：2018-06-03
 */
@Service("dicSensitiveWordService")
public class DicSensitiveWordService extends BaseService<DicSensitiveWordPo, DicSensitiveWordVo>{

    @Autowired
    private DicSensitiveWordDao dao;

    @Override
    protected BaseDao getDao() {
        return dao;
    }

    public List<String> findAllWord() {
        return dao.findAllWord();
    }

}
