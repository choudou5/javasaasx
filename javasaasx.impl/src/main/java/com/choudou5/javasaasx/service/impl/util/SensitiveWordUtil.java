package com.choudou5.javasaasx.service.impl.util;

import com.choudou5.base.util.CollUtil;
import com.choudou5.base.util.sensitive.SensitiveUtil;
import com.choudou5.javasaasx.common.cache.GlobalCacheHelper;
import com.choudou5.javasaasx.base.util.SpringContextHolder;
import com.choudou5.javasaasx.service.dic.DicSensitiveWordService;

import java.util.List;

/**
 * @Name：敏感词工具类
 * @Author：xuhaowen
 * @Date：2018-03-05
 */
public class SensitiveWordUtil extends SensitiveUtil {

    private static DicSensitiveWordService sysUserService = SpringContextHolder.getBean(DicSensitiveWordService.class);

    static {
        refresh();
        staticSetCache(GlobalCacheHelper.getGlobalInstance());
    }

    public static void refresh(){
        List<String> list = sysUserService.findAllWord();
        if(CollUtil.isNotEmpty(list)){
            SensitiveUtil.init(list, true);
        }
    }

}
