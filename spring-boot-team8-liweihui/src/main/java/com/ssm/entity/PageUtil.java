package com.ssm.entity;

public class PageUtil {
    private int pageSize;//每页显示的条数
    private int recordCount;//总共的条数
    private int currentPage;//当前页面
    public PageUtil(int pageSize, int recordCount, int currentPage){
        this.pageSize = pageSize;
        this.recordCount = recordCount;
        setCurrentPage(currentPage);
    }
    //构造方法
    public PageUtil(int pageSize, int recordCount) {
        this(pageSize, recordCount, 1);
    }
    //总页数
    public int getPageCount() {
        int size = recordCount/pageSize;//总条数/每页显示的条数=总页数
        int mod = recordCount%pageSize;//最后一页的条数
        if(mod != 0)
            size++;
        return recordCount == 0 ? 1 : size;
    }

    //得到当前页
    public int getCurrentPage(){
        return currentPage;
    }//设置当前页
    public void setCurrentPage(int currentPage) {
        int validPage = currentPage <= 0 ? 1 : currentPage;
        validPage = validPage > getPageCount() ? getPageCount() : validPage;
        this.currentPage = validPage;
    }//得到每页显示的条数
    public int getSize() {
        return pageSize;
    }//设置每页显示的条数
    public void setSize(int pageSize) {
        this.pageSize = pageSize;
    }//得到总共的条数
    public int getStart() {
        return currentPage;
    }//设置总共的条数
    public void setStart(int currentPage){
        this.currentPage = currentPage;
    }
}
