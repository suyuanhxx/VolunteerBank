package com.vb.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.vb.beans.Pagination;
import com.vb.beans.PrizeT;
import com.vb.beans.TaskT;

/**
 * A data access object (DAO) providing persistence and search support for TaskT
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.vb.beans.TaskT
 * @author MyEclipse Persistence Tools
 */
public class TaskTDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TaskTDAO.class);
	// property constants
	public static final String TASK_NAME = "taskName";
	public static final String CONTENT = "content";
	public static final String TASK_COMMENT = "taskComment";

	protected void initDao() {
		// do nothing
	}

	public void save(TaskT transientInstance) {
		log.debug("saving TaskT instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TaskT persistentInstance) {
		log.debug("deleting TaskT instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TaskT findById(java.lang.String id) {
		log.debug("getting TaskT instance with id: " + id);
		try {
			TaskT instance = (TaskT) getHibernateTemplate().get(
					"com.vb.beans.TaskT", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TaskT instance) {
		log.debug("finding TaskT instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TaskT instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TaskT as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTaskName(Object taskName) {
		return findByProperty(TASK_NAME, taskName);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByTaskComment(Object taskComment) {
		return findByProperty(TASK_COMMENT, taskComment);
	}

	public List findAll() {
		log.debug("finding all TaskT instances");
		try {
			String queryString = "from TaskT";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TaskT merge(TaskT detachedInstance) {
		log.debug("merging TaskT instance");
		try {
			TaskT result = (TaskT) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TaskT instance) {
		log.debug("attaching dirty TaskT instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TaskT instance) {
		log.debug("attaching clean TaskT instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TaskTDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TaskTDAO) ctx.getBean("TaskTDAO");
	}
	public List searchTask(Object value){
		log.debug("实现模糊查询查找任务" );
		List l1=searchTaskName(value);
		List l2=searchTaskContent(value);
		List temp=new ArrayList(l1);//用来保存两者共同有的数据
		temp.retainAll(l2);//temp中只保留两者共同的数据
		l1.removeAll(temp);//l1中去掉两者共同有的数据
		List l3=new ArrayList();
		l3.addAll(l1);
		l3.addAll(l2);
		return l3;
	}
	public List searchTaskName(Object taskname){
		try {
			Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.beginTransaction();
			List result=session.createQuery("from TaskT as a where a."+TASK_NAME+
					" like '%"+taskname+"%'").list();
			return result;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List searchTaskContent(Object taskContent){
		try {
			Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.beginTransaction();
			List result=session.createQuery("from TaskT as a where a."+CONTENT+
					" like '%"+taskContent+"%'").list();
			return result;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/**
	 * 查找未开始的任务
	 * @return
	 */
	public List findNotStartTask(){
		try {
			Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.beginTransaction();
			List result=session.createQuery("from TaskT  where start_Flag < 1").list();
			session.beginTransaction().commit();
			return result;
		} catch (RuntimeException re) {
			log.error("find by Not Start Task failed", re);
			throw re;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public Pagination fuzzyQuery(final TaskT task, final Pagination pagination ,final String keyword) {
		HibernateCallback callback = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				int totalRow = 0;
				List<TaskT> objList = new ArrayList<TaskT>();
				try {
					Criteria criteria = session.createCriteria(TaskT.class);
					// 只查状态有效的
					//criteria.add(Restrictions.eq("status", CConstants.VALID));
					totalRow = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
					criteria.setProjection(null);
					pagination.setTotalRow(totalRow);
					String str = "%" + keyword + "%";
					objList = criteria.add(Restrictions.like("taskName", str ))
							.addOrder(Order.asc("taskId"))
							.setFirstResult(pagination.getStartRow())
							.setMaxResults(pagination.getPageSize())
							.list();
					pagination.setObjList(objList);
				} catch (Exception e) {
					log.error("Query by Pagination failed...");
					e.printStackTrace();
				}
				return pagination;
			}
		};
		return (Pagination) getHibernateTemplate().execute(callback);
	}
	
}