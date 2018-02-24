package com.choudou5.javasaasx.common.cache;

import com.choudou5.cache.ehcache.EhCacheUtil;

/**
 * @Name：全局 缓存API
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 17:33
 * @Site：http://solrhome.com
 * @License：MIT
 */
public class GlobalCacheHelper extends EhCacheUtil {

    public GlobalCacheHelper(String path) {
        super(path);
    }

    private static GlobalCacheHelper ehCache;

    public static GlobalCacheHelper getGlobalInstance() {
        if (ehCache== null) {
            ehCache= new GlobalCacheHelper(CONF_PATH);
        }
        return ehCache;
    }

}
