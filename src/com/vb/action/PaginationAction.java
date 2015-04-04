package com.vb.action;
import java.util.List;

import com.vb.beans.Page;
import com.vb.beans.UserT;
import com.vb.service.PaginationService;
public class PaginationAction extends BasicAction{
	private int pno;	 //查看的表单页数 
	private PaginationService pageService =new PaginationService();
	private Page myPage;
	private List mylist;

	public  String findPendingTask(){
		String hql = "select a.task_id,a.task_name,a.content,a.task_score,a.start_time,a.end_time,a.task_comment,b.accepter_name,b.progress,c.publisher_name " +
				"from (select task_id,task_name,content,task_score,start_time,end_time,task_comment from task_t where start_flag='-1') a " +
				"join accepter_task_t b on a.task_id = b.task_id " +
				"join publisher_task_t c on b.task_id = c.task_id";
	    if (pno == 0 ) {
	    	pno = 1;
	    } 
//	    pageService.init(pno,hql); 
	    myPage = pageService.getPage(pno,hql);
//	    myPage.getRowCount()
//	    mylist = pageService.getPage(pno,hql).getList();
//	    if(mylist!=null){
	    	session.put("myPage", myPage);
		    return "success";
//	    }
//	    else
//	    	return ERROR;
	}
	
	public String commentlist(){
		UserT user = (UserT)session.get("user");
		String username = user.getUsername();
		String hql = "select a.publisher_name,b.task_id,b.task_name,b.content,b.start_time,b.end_time,b.task_score,b.task_comment,c.accepter_name,c.progress " +
				"from ( select publisher_name ,task_id from publisher_task_t where publisher_name='" + username + "') a " +
				"join task_t b on a.task_id=b.task_id " +
				"join accepter_task_t c on b.task_id=c.task_id";
	    if (pno == 0 ) { 
	    	pno = 1;
	    } 
	    myPage = pageService.getPage(pno,hql);
	    session.put("comment", myPage);
		return "success";
	}

	public String tasklist(){
		String hql = "select * from task_t  where start_flag < 1";
	    if (pno == 0 ) { 
	    	pno = 1;
	    } 
	    myPage = pageService.getTaskList(pno,hql);
	    session.put("notstarttsak", myPage);
		return "success";
	}
	
	public String catchTask(){
		String hql = "select * from task_t";
	    if (pno == 0 ) { 
	    	pno = 1;
	    } 
//	    myPage.setPageSize(3);
	    myPage = pageService.getTaskList(pno,hql);
	    session.put("asd", myPage);
		return "success";
	}
	
	public int getPno() {
		return pno; 
	} 

	public void setPno(int pno) {
		this.pno = pno; 
	} 

	public PaginationService getPageService() {
		return pageService;
	}

	public void setPageService(PaginationService pageService) {
		this.pageService = pageService;
	}
	
	public Page getMyPage() { 
		return myPage; 
	} 

	public void setMyPage(Page myPage) { 
		this.myPage = myPage; 
	} 

	public List getMylist() { 
		return mylist; 
	} 

	public void setMylist(List mylist) { 
		this.mylist = mylist; 
	} 

}
