package com.vb.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.vb.beans.CatchTask;
import com.vb.beans.Page;
import com.vb.beans.PendingTask;
import com.vb.beans.TaskList;
import com.vb.beans.TaskT;

public class PaginationDAO extends HibernateDaoSupport{
	private String hql; 
    public Page page; 
    public int start; 
    
    public void init(int start,String hql){
       page = new Page(); 
       this.hql = hql;
       this.start = start; 
       this.setRowCount();	 //设置page的总数量
       this.setTotalPage();	 //设置page的总页数
       this.setCurrentPage();	//设置page的当前页
       this.setPrePage();	 //设置page的上一页
       this.setNextPage();	 //设置page的下一页
       this.setPreOrNextBoolean();	//判断page是否有上一页或下一页 
    } 
    
    @SuppressWarnings("unchecked") 
	public Page getPage(){
//    	HibernateCallback callback = new HibernateCallback(){
//	        public Object doInHibernate(Session session) throws HibernateException, SQLException { 
	        	List<PendingTask>list = null;
//	    		Session session1 = null;
	        	Session session =  getHibernateTemplate().getSessionFactory().getCurrentSession();
	    		session.beginTransaction();
				SQLQuery query = session.createSQLQuery(hql);
				query.setFirstResult(getStartIndex());
				query.setMaxResults(page.getPageSize());
				query.addScalar("task_id",Hibernate.STRING);
				query.addScalar("task_name",Hibernate.STRING);
				query.addScalar("content",Hibernate.STRING);
				query.addScalar("task_score",Hibernate.INTEGER);
				query.addScalar("start_time",Hibernate.TIMESTAMP);
				query.addScalar("end_time",Hibernate.TIMESTAMP);
				query.addScalar("task_comment",Hibernate.STRING);
				query.addScalar("accepter_name",Hibernate.STRING);
				query.addScalar("publisher_name",Hibernate.STRING);
				query.addScalar("progress",Hibernate.STRING);
				query.setResultTransformer(new AliasToBeanResultTransformer(PendingTask.class));
				list = query.list();
				session.beginTransaction().commit();
				page.setList(list);
				return page;
//			}
//    	};
//	   return (Page)getHibernateTemplate().execute(callback);
	 } 
    
    @SuppressWarnings("unchecked") 
	public Page getTaskList(){
//    	HibernateCallback callback = new HibernateCallback(){
//	        public Object doInHibernate(Session session) throws HibernateException, SQLException { 
	        	List<TaskT>list = null;
//	    		Session session1 = null;
	        	Session session =  getHibernateTemplate().getSessionFactory().getCurrentSession();
	    		session.beginTransaction();
				SQLQuery query = session.createSQLQuery(hql);
				query.setFirstResult(getStartIndex());
				query.setMaxResults(page.getPageSize());
				query.addScalar("task_id",Hibernate.STRING);
				query.addScalar("task_name",Hibernate.STRING);
				query.addScalar("content",Hibernate.STRING);
				query.addScalar("task_score",Hibernate.INTEGER);
				query.addScalar("start_time",Hibernate.TIMESTAMP);
				query.addScalar("end_time",Hibernate.TIMESTAMP);
				query.addScalar("task_comment",Hibernate.STRING);
				query.addScalar("start_flag" , Hibernate.INTEGER);
				query.setResultTransformer(new AliasToBeanResultTransformer(TaskList.class));
				list = query.list();
				session.beginTransaction().commit();
				page.setList(list);
				return page;
	 } 
    
//    @SuppressWarnings("unchecked") 
//	public Page catchTask(){
//	        	List<TaskT>list = null;
//	        	Session session =  getHibernateTemplate().getSessionFactory().getCurrentSession();
//	    		session.beginTransaction();
//				SQLQuery query = session.createSQLQuery(hql);
//				query.setFirstResult(getStartIndex());
//				query.setMaxResults(page.getPageSize());
//				query.addScalar("task_id",Hibernate.STRING);
//				query.addScalar("task_name",Hibernate.STRING);
//				query.setResultTransformer(new AliasToBeanResultTransformer(CatchTask.class));
//				list = query.list();
//				session.beginTransaction().commit();
//				page.setList(list);
//				return page;
//	 } 

    /**获得数据的总数量*/
	@SuppressWarnings("unchecked") 
	public int getRowCount(){
		Session session = null;
		session =  getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(hql);
		List list = query.list();
		session.beginTransaction().commit();
       if(list.isEmpty()){
	        return 0; 
	    } 
       return list.size(); 
	}


    /** 
     * 判断是否有下一页 
     * */ 
    public void setPreOrNextBoolean() { 
        if (page.getCurrentPage() <= 1) { 
            page.setHasPreviousPage(false); 
        } else { 
            page.setHasPreviousPage(true); 
        } 
        if (page.getCurrentPage() >= page.getTotalPage()) { 
            page.setHasNextPage(false); 
        } else { 
            page.setHasNextPage(true); 
        } 

    } 

    /** 
     * 设置当前查询页 
     * */ 
    public void setCurrentPage(){ 
        if (start < 1) { 
            page.setCurrentPage(1); 
        } 
        else if (start > page.getTotalPage()) { 
            page.setCurrentPage(page.getTotalPage()); 
        } 
        else { 
        page.setCurrentPage(start); 
        } 
    } 

    /** 
     * 设置上一页的页数 
     * */ 
    public void setPrePage() { 
        page.setPrePage(page.getCurrentPage() - 1); 
    } 

    /** 
     * 设置下一页的页数 
     * */ 
    public void setNextPage() { 
        page.setNextPage(page.getCurrentPage() + 1); 

    } 

    /** 
     * 计算总页数 
     * */ 
    public void setTotalPage(){
        int rowCount = getRowCount(); 
        int pageSize = page.getPageSize(); 
        if (rowCount > pageSize){
            if (rowCount % pageSize == 0) { 
                page.setTotalPage(rowCount/pageSize); 
            } else { 
                page.setTotalPage(1 + (rowCount / pageSize)); 
            } 
        } else { 
            page.setTotalPage(1); 
        } 
    } 

    public void setRowCount() { 
        page.setRowCount(getRowCount()); 
    } 

    /** 
     * 设置查询数据的起始位置 
     * */ 
    public int getStartIndex(){
        int startIndex = 0; 
        if (start < 0) { 
            startIndex = 0; 
        }else {
            if (start > page.getTotalPage()) { 
                startIndex = page.getPageSize() * (page.getTotalPage() - 1); 
            } else{ 
                startIndex = page.getPageSize() * (start - 1); 
            } 
        }
        return startIndex; 
    }
}
