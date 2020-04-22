package com.vb.beans;

import java.util.ArrayList;
import java.util.List;

public class Pagination {
	/** 当前页 */
	private int currentPage = 1;
	/** 每页显示数 */
	private int pageSize = 10;
	/** 总行数 */
	private int totalRow = 0;
	/** 页码 List */
	private List<Integer> pages = new ArrayList<Integer>();
	
	/** 总页数 */
	private int totalPage;
	/** 当前页在数据库中的起始行 */
	private int startRow=0;
	
	/** 查询参数保存 javabean的形式 */
	private Object queryObject ;
	
	/**  要显示的数据集 */
    private List objList;
    
	public Pagination() {
	}

	public Pagination(int currentPage, int pageSize, int totalRow) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalRow = totalRow;
	}

	public Pagination(int pageSize) {
		this.pageSize = pageSize;
		this.currentPage = 1;
		this.totalRow = 1;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if (currentPage==0) {
			return;
		}
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getStartRow() {
		if (this.currentPage > 1) {
			this.startRow = (this.currentPage - 1) * this.pageSize;
		} else {
			this.startRow = 0;
		}
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public List<Integer> getPages() {
		this.pages.clear();
		for (int i = 0; i < this.totalPage; i++) {
			try {
				this.pages.add((i+1));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pages;
	}

	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}

	public Object getQueryObject() {
		return queryObject;
	}

	public void setQueryObject(Object queryObject) {
		this.queryObject = queryObject;
	}

	public List getObjList() {
		return objList;
	}

	public void setObjList(List objList) {
		this.objList = objList;
	}

	public int getTotalPage() {
		this.totalPage = this.totalRow / this.pageSize;
		if (this.totalRow % this.pageSize != 0) {
			this.totalPage += 1;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
