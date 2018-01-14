package com.choudou5.javasaasx.framework.bean;

import com.choudou5.javasaasx.framework.util.ToolkitUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @Name：范围 Bean
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 15:48
 * @Site：http://www.javasaas.top
 * @License：MIT
 */
public class BetweenBean implements Serializable {

    private Object begin;
    private Object end;

    public BetweenBean() {
    }

    public BetweenBean(Object begin, Object end) {
        this.begin = begin;
        this.end = end;
    }

    public Object getBegin() {
        return begin;
    }

    public void setBegin(Object begin) {
        this.begin = begin;
    }

    public Object getEnd() {
        return end;
    }

    public void setEnd(Object end) {
        this.end = end;
    }
}
