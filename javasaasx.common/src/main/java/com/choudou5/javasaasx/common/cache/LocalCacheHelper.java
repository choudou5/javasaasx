package com.choudou5.javasaasx.common.cache;

import com.choudou5.cache.ehcache.EhCacheUtil;

/**
 * @Name：本地 缓存API
 * @Author：xuhaowen
 * @Date：2018-01-13
 */
public class LocalCacheHelper extends EhCacheUtil {

    private static LocalCacheHelper ehCache;

    public LocalCacheHelper(String path) {
        super(path);
    }

    public static LocalCacheHelper getLocalInstance() {
        if (ehCache== null) {
            ehCache= new LocalCacheHelper(CONF_PATH);
        }
        return ehCache;
    }

}
