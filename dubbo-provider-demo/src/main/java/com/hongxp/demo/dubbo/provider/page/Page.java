package com.hongxp.demo.dubbo.provider.page;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Page implements Serializable {
    private static final long serialVersionUID = 7480385388122875227L;

    /**
     * 当前页
     */
    private int page = 1;

    /**
     * 页大小
     */
    private int pageSize = 20;

    /**
     * 数据总条数
     */
    private int total;

    public Page() {
    }

    public void setPage(int page) {
        if (page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public void setPageSize(int pageSize) {
        if (pageSize <= 0) {
            this.pageSize = 20;
        } else {
            this.pageSize = pageSize;
        }
    }

    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * mysql limit
     */
    public int limit() {
        return pageSize;
    }

    /**
     * mysql offset
     */
    public int offset() {
        return (page - 1) * pageSize;
    }
}
