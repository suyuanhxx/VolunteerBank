package com.vb.dao;

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

import com.vb.beans.PublisherTaskT;

/**
 * A data access object (DAO) providing persistence and search support for
 * PublisherTaskT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.vb.beans.PublisherTaskT
 * @author MyEclipse Persistence Tools
 */

public class PublisherTaskTDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PublisherTaskTDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(PublisherTaskT transientInstance) {
		log.debug("saving PublisherTaskT instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PublisherTaskT persistentInstance) {
		log.debug("deleting PublisherTaskT instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PublisherTaskT findById(com.vb.beans.PublisherTaskTId id) {
		log.debug("getting PublisherTaskT instance with id: " + id);
		try {
			PublisherTaskT instance = (PublisherTaskT) getHibernateTemplate()
					.get("com.vb.beans.PublisherTaskT", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PublisherTaskT instance) {
		log.debug("finding PublisherTaskT instance by example");
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
		log.debug("finding PublisherTaskT instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PublisherTaskT as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all PublisherTaskT instances");
		try {
			String queryString = "from PublisherTaskT";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PublisherTaskT merge(PublisherTaskT detachedInstance) {
		log.debug("merging PublisherTaskT instance");
		try {
			PublisherTaskT result = (PublisherTaskT) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PublisherTaskT instance) {
		log.debug("attaching dirty PublisherTaskT instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PublisherTaskT instance) {
		log.debug("attaching clean PublisherTaskT instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PublisherTaskTDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PublisherTaskTDAO) ctx.getBean("PublisherTaskTDAO");
	}
	
	/**
	 * 根据发布者用户名查找任务
	 * @param username
	 * @return
	 */
	@Transactional
	public List findByUsername(String username){
		log.debug("finding PublisherTaskT by username: ");
		try {
			String hql = "from PublisherTaskT where publisher_name= '"+ username + "'";
			Session session =  getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery(hql);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}