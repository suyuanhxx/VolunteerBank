package com.vb.service;

import com.vb.beans.Page;
import com.vb.dao.PaginationDAO;
public class PaginationService extends BasicService{
	private PaginationDAO pageDao= (PaginationDAO)factory.getBean("PageDAO");

	public Page getPage(int pno ,String hql){
		pageDao.init(pno, hql);
		return pageDao.getPage(); 
   }
	
	public Page getTaskList(int pno ,String hql){
		pageDao.init(pno, hql);
		return pageDao.getTaskList(); 
   }
	
//	public Page catchTask(int pno,String hql){
//		pageDao.init(pno, hql);
//		return pageDao.catchTask(); 
//	}
//	
//    public void init(int pno ,String hql){
//    	pageDao.init(pno, hql);
//    } 

	public PaginationDAO getPageDao() { 
		return pageDao; 
	} 

	public void setPageDao(PaginationDAO pageDao) { 
		this.pageDao = pageDao; 
	} 
	
}
