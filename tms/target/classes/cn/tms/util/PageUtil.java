package cn.tms.util;

import java.util.List;

/**
 * Created by CY on 2017/11/21.
 */
public class PageUtil<T> {
    //1.当前页
    private Integer pageIndex;
    //2.当前页的记录
    private Integer pageSize;
    //3.总记录数
    private Integer totalRecords;
    //4.总页数
    private Integer totalPages;
    //5.总记录数
    private List<T> list;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
