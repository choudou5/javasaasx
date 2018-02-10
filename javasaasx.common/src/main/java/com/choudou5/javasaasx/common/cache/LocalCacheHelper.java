package com.choudou5.javasaasx.common.cache;

import com.choudou5.base.exception.BizException;
import com.choudou5.base.helper.CacheHelper;
import com.choudou5.base.util.AssertUtil;

import java.io.Serializable;
import java.util.List;

/**
 * @Name：本地 缓存API
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 17:33
 * @Site：http://solrhome.com
 * @License：MIT
 */
public class LocalCacheHelper implements CacheHelper {



    @Override
    public void put(String cacheKey, Object object) throws BizException {

    }

    @Override
    public void put(String cacheKey, Object object, int secondTimeout) throws BizException {
        AssertUtil.outThrow("未实现此功能");
    }

    @Override
    public String get(String cacheKey) throws BizException {
        return null;
    }

    @Override
    public String getIntValue(String cacheKey) throws BizException {
        return null;
    }

    @Override
    public String getLongValue(String cacheKey) throws BizException {
        return null;
    }

    @Override
    public <T extends Serializable> T get(String cacheKey, Class<T> classz) throws BizException {
        return null;
    }

    @Override
    public <T extends Serializable> List<T> getList(String cacheKey, Class<T> classz) throws BizException {
        return null;
    }

    @Override
    public void remove(String cacheKey) throws BizException {

    }

    @Override
    public void removes(String... cacheKeys) throws BizException {

    }
}
