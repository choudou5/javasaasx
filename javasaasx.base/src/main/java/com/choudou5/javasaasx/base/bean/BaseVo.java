package com.choudou5.javasaasx.base.bean;

import java.io.Serializable;

/**
 * @Name：说明
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-14 00:15
 * @Site：http://www.javasaas.top
 * @License：MIT
 */
public interface BaseVo<T> extends Serializable {

    T getId();
    void setId(T id);
}
