package com.vb.beans;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable{
	private int pageSize;     //每页的数量 
    private int totalPage;   //总页数 
    private int rowCount;	 //总数量 
    private int start;
    private int currentPage; //当前页数 
    private int prePage; //上一页 
    private int nextPage;	 //下一页 
    private boolean hasNextPage;	 //是否有下一页 
    private boolean hasPreviousPage;	 //是否有下一页 
    @SuppressWarnings("unchecked") 
    private List list;	 //返回的数据 
    
    public Page() { 
        this.pageSize=6; 
    } 
    
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}
	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	
	@SuppressWarnings("unchecked") 
	public List getList() {
		return list;
	}
	@SuppressWarnings("unchecked") 
	public void setList(List list) {
		this.list = list;
	}
	
    /** 
     * 设置查询数据的起始位置 
     * */ 
    public int getStartIndex(){
        int startIndex = 0; 
        if (start < 0) { 
            startIndex = 0; 
        }else {
            if (start > totalPage ) { 
                startIndex = pageSize * ( totalPage - 1); 
            } else{ 
                startIndex = pageSize * (start - 1); 
            } 
        }
        return startIndex; 
    }

}
