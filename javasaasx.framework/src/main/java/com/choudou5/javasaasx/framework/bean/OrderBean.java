package com.choudou5.javasaasx.framework.bean;

import java.io.Serializable;

/**
 * @Name：排序Bean
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 16:36
 * @Site：http://solrhome.com
 * @License：MIT
 */
public class OrderBean implements Serializable {

    /** 排序字段 */
    private String orderBy;
    /** 排序方式：ASC/DESC */
    private String order;

    public OrderBean() {
    }

    public OrderBean(String orderBy) {
        this.orderBy = orderBy;
        this.order = "DESC";
    }

    /**
     * @param orderBy 排序字段
     * @param order 排序方式 ASC / DESC
     */
    public OrderBean(String orderBy, String order) {
        this.orderBy = orderBy;
        this.order = order;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
