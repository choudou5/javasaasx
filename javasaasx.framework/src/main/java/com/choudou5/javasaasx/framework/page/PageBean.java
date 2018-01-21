package com.choudou5.javasaasx.framework.page;

import java.io.Serializable;

/**
 * @Name：分页Bean
 * @Author：xuhaowende@sina.cn
 * @Date：2018-01-13 16:27
 * @Site：http://solrhome.com
 * @License：MIT
 */
public class PageBean implements Serializable {

    public static final Integer MAX_PAGE_SIZE = 100;	// 每页最大分页数大小限制
    public static final Integer DEF_PAGE_SIZE = 10;

    private int pageNo = 1;
    private int pageSize = 10;

    public PageBean() {
    }

    public PageBean(int pageNo) {
        this.pageNo = pageNo;
    }

    public PageBean(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            pageSize = 1;
        }else if(pageSize > MAX_PAGE_SIZE){
            pageSize = MAX_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public int getStart() {
        return (pageNo - 1) * pageSize;
    }
}
