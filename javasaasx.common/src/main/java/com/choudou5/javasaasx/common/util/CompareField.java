package com.choudou5.javasaasx.common.util;

import java.io.Serializable;

/**
 * @Name：对比字段 实体
 * @Author：xuhaowen
 * @Date：2018-03-11
 */
public class CompareField implements Serializable {

    private String fieldName;
    private String oldVal;
    private String newVal;

    public CompareField(String fieldName, String oldVal, String newVal) {
        this.fieldName = fieldName;
        this.oldVal = oldVal;
        this.newVal = newVal;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getOldVal() {
        return oldVal;
    }

    public void setOldVal(String oldVal) {
        this.oldVal = oldVal;
    }

    public String getNewVal() {
        return newVal;
    }

    public void setNewVal(String newVal) {
        this.newVal = newVal;
    }

}
