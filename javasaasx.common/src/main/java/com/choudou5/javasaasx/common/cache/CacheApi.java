package com.choudou5.javasaasx.common.cache;

import com.choudou5.javasaasx.framework.exception.BizException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Name：缓存 API
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 17:35
 * @Site：http://solrhome.com
 * @License：MIT
 */
public interface CacheApi {

    void put(String cacheKey, Object object) throws BizException;

    void put(String cacheKey, Object object, int secondTimeout) throws BizException;

    String get(String cacheKey) throws BizException;

    String getIntValue(String cacheKey) throws BizException;

    String getLongValue(String cacheKey) throws BizException;

    <T extends Serializable> T get(String cacheKey, Class<T> classz) throws BizException;

    <T extends Serializable> List<T> getList(String cacheKey, Class<T> classz) throws BizException;

    void remove(String cacheKey) throws BizException;

    void removes(String ... cacheKeys) throws BizException;
}
