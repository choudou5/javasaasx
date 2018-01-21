package com.choudou5.javasaasx.framework.bean;

import com.choudou5.javasaasx.framework.page.PageBean;
import com.choudou5.javasaasx.framework.util.ToolkitUtil;

import java.beans.Transient;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Name：查询Bean
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 16:39
 * @Site：http://solrhome.com
 * @License：MIT
 */
public class QueryParam implements Serializable {

    private Object paramBean;
    private PageBean pageBean;
    private OrderBean orderBean;
    private static String dbName;
    private Map<String, Object> extendParams = new HashMap();


    public Object getParamBean() {
        return paramBean;
    }

    public void setParamBean(Object paramBean) {
        this.paramBean = paramBean;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public OrderBean getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(OrderBean orderBean) {
        this.orderBean = orderBean;
    }

    @Transient
    public String getDbName() {
        return QueryParam.dbName;
    }

    public static void setDbName(String dbName) {
        QueryParam.dbName = dbName;
    }

    public Map<String, Object> getExtendParams() {
        return this.extendParams;
    }

    public void addExtendParam(String extendParamKey, Object extendParamValue) {
        this.extendParams.put(extendParamKey, extendParamValue);
    }

    public void removeExtendParam(String extendParamKey) {
        this.extendParams.remove(extendParamKey);
    }

    public void setDefaultParam(int pageNo, int pageSize, String orderBy, String order) {
        OrderBean orderBean = this.getOrderBean();
        if(orderBean == null) {
            this.setOrderBean(new OrderBean(orderBy, ToolkitUtil.isBlank(order)?"DESC":order));
        } else {
            if(ToolkitUtil.isEmpty(orderBean.getOrderBy()))
                orderBean.setOrderBy(orderBy);
            if(ToolkitUtil.isEmpty(orderBean.getOrder()))
                orderBean.setOrder(ToolkitUtil.isBlank(order)?"DESC":order);
            this.setOrderBean(orderBean);
        }
        PageBean pageBean = this.getPageBean();
        if(pageBean == null) {
            pageBean = new PageBean(pageNo, pageSize);
            this.setPageBean(pageBean);
        }
    }

    public void setDefaultPage() {
        PageBean pageBean = this.getPageBean();
        if(pageBean == null) {
            this.setPageBean(new PageBean(1, PageBean.DEF_PAGE_SIZE));
        }
    }

}
