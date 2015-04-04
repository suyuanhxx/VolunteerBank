package com.vb.dao;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.vb.beans.AccepterTaskT;

/**
 * A data access object (DAO) providing persistence and search support for
 * AccepterTaskT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.vb.beans.AccepterTaskT
 * @author MyEclipse Persistence Tools
 */
public class AccepterTaskTDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AccepterTaskTDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(AccepterTaskT transientInstance) {
		log.debug("saving AccepterTaskT instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AccepterTaskT persistentInstance) {
		log.debug("deleting AccepterTaskT instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AccepterTaskT findById(com.vb.beans.AccepterTaskTId id) {
		log.debug("getting AccepterTaskT instance with id: " + id);
		try {
			AccepterTaskT instance = (AccepterTaskT) getHibernateTemplate()
					.get("com.vb.beans.AccepterTaskT", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AccepterTaskT instance) {
		log.debug("finding AccepterTaskT instance by example");
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
		log.debug("finding AccepterTaskT instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AccepterTaskT as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all AccepterTaskT instances");
		try {
			String queryString = "from AccepterTaskT";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AccepterTaskT merge(AccepterTaskT detachedInstance) {
		log.debug("merging AccepterTaskT instance");
		try {
			AccepterTaskT result = (AccepterTaskT) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AccepterTaskT instance) {
		log.debug("attaching dirty AccepterTaskT instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AccepterTaskT instance) {
		log.debug("attaching clean AccepterTaskT instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AccepterTaskTDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AccepterTaskTDAO) ctx.getBean("AccepterTaskTDAO");
	}
	
	/**
	 * 根据接收者用户名查找任务
	 * @param username
	 * @return
	 */
	@Transactional
	public List findByUsername(String username){
		log.debug("finding AccepterTaskT by username: ");
		try {
			String hql = "from AccepterTaskT where accepter_name= '"+ username + "'";
			Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find by username failed", re);
			throw re;
		}
	}
	
	@Transactional
	public List findPendingTask(){
		log.debug("finding Pending tasks from AccpeterTaskT");
		try {
			String hql = "from AccepterTaskT where progress=-1";
			Session session =  getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find by AccepterTaskT where progress=-1 failed", re);
			throw re;
		}
	}
	
}