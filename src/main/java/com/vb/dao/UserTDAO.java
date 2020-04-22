package com.vb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.vb.beans.Page;
import com.vb.beans.Pagination;
import com.vb.beans.UserT;

/**
 * A data access object (DAO) providing persistence and search support for UserT
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.vb.beans.UserT
 * @author MyEclipse Persistence Tools
 */
public class UserTDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(UserTDAO.class);
	// property constants
	public static final String PWD = "pwd";
	public static final String TRUENAME = "truename";
	public static final String SEX = "sex";
	public static final String MAJOR = "major";
	public static final String SNO = "sno";
	public static final String HIMAGE = "himage";
	public static final String AUTHORITY_ID = "authorityId";

	protected void initDao() {
		// do nothing
	}

	public void save(UserT transientInstance) {
		log.debug("saving UserT instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserT persistentInstance) {
		log.debug("deleting UserT instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserT findById(java.lang.String id) {
		log.debug("getting UserT instance with id: " + id);
		try {
			UserT instance = (UserT) getHibernateTemplate().get(
					"com.vb.beans.UserT", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserT instance) {
		log.debug("finding UserT instance by example");
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
		log.debug("finding UserT instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserT as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPwd(Object pwd) {
		return findByProperty(PWD, pwd);
	}

	public List findByTruename(Object truename) {
		return findByProperty(TRUENAME, truename);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByMajor(Object major) {
		return findByProperty(MAJOR, major);
	}

	public List findBySno(Object sno) {
		return findByProperty(SNO, sno);
	}

	public List findByHimage(Object himage) {
		return findByProperty(HIMAGE, himage);
	}

	public List findByAuthorityId(Object authorityId) {
		return findByProperty(AUTHORITY_ID, authorityId);
	}

	public List findAll() {
		log.debug("finding all UserT instances");
		try {
			String queryString = "from UserT";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserT merge(UserT detachedInstance) {
		log.debug("merging UserT instance");
		try {
			UserT result = (UserT) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserT instance) {
		log.debug("attaching dirty UserT instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserT instance) {
		log.debug("attaching clean UserT instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserTDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserTDAO) ctx.getBean("UserTDAO");
	}
	
	/**
	 * @param RowName 列名
	 * @param order升序或降序(desc,asc)
	 * @return
	 */
	public List Orderfind(String RowName , String order){
		log.debug("按顺序查询（降序和升序）");
		try{
			//select * from UserT order by score desc;
			String hql = "from UserT order by " + RowName + " " + order;
			return getHibernateTemplate().find(hql);
		} catch (RuntimeException re) {
			log.error("find by order failed", re);
			throw re;
		}
	}
	
	/**
	 * 积分排名
	 * @param user
	 * @param pagination
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Pagination findScoreRank(final UserT user, final Pagination pagination) {
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				int totalRow = 0;
				List<UserT> objList = new ArrayList<UserT>();
				try {
					Criteria criteria = session.createCriteria(UserT.class);
					totalRow = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
					criteria.setProjection(null);
					pagination.setTotalRow(totalRow);
					objList = criteria.addOrder(Order.asc("score"))
							.setFirstResult(pagination.getStartRow())
							.setMaxResults(pagination.getPageSize())
							.list();
					pagination.setObjList(objList);
				} catch (Exception e) {
					log.error("find score rank by Pagination failed...");
					e.printStackTrace();
				}
				return pagination;
			}
		};
		return (Pagination) getHibernateTemplate().execute(callback);
	}
	
	/**
	 * 积分排名
	 * @param user
	 * @param pagination
	 * @return
	 */
//	@SuppressWarnings("unchecked")
//	public Page findScoreRank(final UserT user, final Page page) {
//		HibernateCallback callback = new HibernateCallback() {
//			public Object doInHibernate(Session session) throws HibernateException, SQLException {
//				int totalRow = 0;
//				List<UserT> objList = new ArrayList<UserT>();
//				try {
//					Criteria criteria = session.createCriteria(UserT.class);
//					totalRow = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
//					criteria.setProjection(null);
//					page.setRowCount(totalRow);
//					objList = criteria.addOrder(Order.asc("score"))
//							.setFirstResult(page.getStartIndex())
//							.setMaxResults(page.getPageSize())
//							.list();
//					page.setList(objList);
//				} catch (Exception e) {
//					log.error("find score rank by Pagination failed...");
//					e.printStackTrace();
//				}
//				return page;
//			}
//		};
//		return (Page) getHibernateTemplate().execute(callback);
//	}
	
}