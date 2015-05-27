package com.ntu.pms.dto;

import java.util.List;

public class Pagination {

    private int pageSize = 5;
    private int startIndex;
    private int totalCount;
    private int currentPage;
    @SuppressWarnings("rawtypes")
    private List list;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @SuppressWarnings("rawtypes")
    public List getList() {
        return list;
    }

    @SuppressWarnings("rawtypes")
    public void setList(List list) {
        this.list = list;
    }

    public int getTotalPageCount() {
        if (totalCount % pageSize == 0) {
            return totalCount / pageSize;
        } else {
            return totalCount / pageSize + 1;
        }
    }

}
