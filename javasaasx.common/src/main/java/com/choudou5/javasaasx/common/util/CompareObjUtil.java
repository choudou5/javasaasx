package com.choudou5.javasaasx.common.util;


import com.choudou5.base.util.DateUtil;
import com.choudou5.base.util.StrUtil;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Name：对比对象 工具类
 * @Author：xuhaowen
 * @Date：2018-03-11
 */
public class CompareObjUtil {

    private static final String[] IGNORE_FIELDS = {"serialVersionUID", "logger", "recordDataChange", "createTime", "updateBy", "updateBy", "id"};

    private static final String DATE_TYPE_STR = "java.lang.DateTime,java.lang.Date,java.util.Date";

    /**
     * 获取 对比
     * @param oldObj
     * @param newObj
     * @return
     */
    public static <T extends Serializable> List<CompareField> compareObj(T oldObj, T newObj) {
        ArrayList<CompareField> list = new ArrayList<CompareField>();

        if (newObj == null || oldObj == null) {
            return null;
        }
        // 得道给定实例的类型。
        Class<?> theClass = newObj.getClass();
        Field[] oldFields = oldObj.getClass().getDeclaredFields();
        Field[] fields = newObj.getClass().getDeclaredFields();

        // 遍历所有属性
        for (int i = 0; i < fields.length; i++) {
            PropertyDescriptor pd = null;
            Field field = fields[i];
            Field oldField = oldFields[i];
            //跳过 忽略字段
            boolean isIgnoreField = false;
            for (int j = 0; j < IGNORE_FIELDS.length; j++) {
                if (field.getName().equals(IGNORE_FIELDS[j])) {
                    isIgnoreField = true;
                    break;
                }
            }
            if (isIgnoreField)
                continue;

            try {
                pd = new PropertyDescriptor(field.getName(), theClass);
                // 获得所有属性的读取方法
                Method getMethod = pd.getReadMethod();
                // 执行读取方法，获得属性值
                Object newVal = getMethod.invoke(newObj);
                // 执行读取方法，获得属性值
                Object oldVal = getMethod.invoke(oldObj);
                // 如果属性值为null，就略过 //新单，肯定不会为null
                if (newVal == null) {
                    // 旧单也为null
                    continue;
                }
                // 相同字段
                if (newVal.equals(oldVal)) {
                    continue;
                } else if (StrUtil.isBlank(newVal.toString())) {
                    // 为空视为相等
                    if (null == oldVal) {
                        continue;
                    } else {
                        if (StrUtil.isBlank(oldField.toString())) {
                            continue;
                        }
                    }
                }
                // 先处理时间格式
                if (DATE_TYPE_STR.contains(field.getType().getName())) {
                    newVal = DateUtil.formatDateTime((Date) newVal);
                }
                list.add(new CompareField(field.getName(), (oldVal != null ? oldVal.toString() : null), newVal.toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}