package com.vb.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.vb.beans.ActivityT;

/**
 * A data access object (DAO) providing persistence and search support for
 * ActivityT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.vb.beans.ActivityT
 * @author MyEclipse Persistence Tools
 */
public class ActivityTDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ActivityTDAO.class);
	// property constants
	public static final String ACTIVITY_TITLE = "activityTitle";
	public static final String ACTIVITY_CONTENT = "activityContent";

	protected void initDao() {
		// do nothing
	}

	public void save(ActivityT transientInstance) {
		log.debug("saving ActivityT instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ActivityT persistentInstance) {
		log.debug("deleting ActivityT instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ActivityT findById(java.lang.String id) {
		log.debug("getting ActivityT instance with id: " + id);
		try {
			ActivityT instance = (ActivityT) getHibernateTemplate().get(
					"com.vb.beans.ActivityT", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ActivityT instance) {
		log.debug("finding ActivityT instance by example");
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
		log.debug("finding ActivityT instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ActivityT as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByActivityTitle(Object activityTitle) {
		return findByProperty(ACTIVITY_TITLE, activityTitle);
	}

	public List findByActivityContent(Object activityContent) {
		return findByProperty(ACTIVITY_CONTENT, activityContent);
	}

	public List findAll() {
		log.debug("finding all ActivityT instances");
		try {
			String queryString = "from ActivityT";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ActivityT merge(ActivityT detachedInstance) {
		log.debug("merging ActivityT instance");
		try {
			ActivityT result = (ActivityT) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ActivityT instance) {
		log.debug("attaching dirty ActivityT instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ActivityT instance) {
		log.debug("attaching clean ActivityT instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ActivityTDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ActivityTDAO) ctx.getBean("ActivityTDAO");
	}
}