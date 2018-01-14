package com.choudou5.javasaasx.common.mapper;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * 功能：
 * 简单封装Dozer, 实现深度转换Bean<->Bean的Mapper.实现:
 * 1. 持有Mapper的单例.
 * 2. 返回值类型转换.
 * 3. 批量转换Collection中的所有对象.
 * 4. 区分创建新的B对象与将对象A值复制到已存在的B对象两种函数.
 */
public class BeanMapper {

    private static DozerBeanMapper dozer = new DozerBeanMapper();

    /**
     * 基于Dozer转换对象的类型.
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        if(source == null || destinationClass == null) return null;
        return dozer.map(source, destinationClass);
    }

    /**
     * 基于Dozer将对象A的值拷贝到对象B中.
     */
    public static void copy(Object source, Object destinationObject) {
        if(source == null || destinationObject == null) return;
        dozer.map(source, destinationObject);
    }

    /**
     * 基于Dozer转换Collection中对象的类型.
     */
    public static <T> List<T> mapList(Collection<Object> sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<T>();
        if(sourceList == null) return destinationList;
        for (Object sourceObject : sourceList) {
            T destinationObject = dozer.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    /**
     * 基于Dozer转换Collection中对象的类型.
     */
    public static <T> List<T> mapList2(Collection<Map> sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<T>();
        if(sourceList == null) return destinationList;
        for (Map map : sourceList) {
            T destinationObject = dozer.map(map, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

}
