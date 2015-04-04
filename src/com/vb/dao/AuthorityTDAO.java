package com.vb.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.vb.beans.AuthorityT;

/**
 * A data access object (DAO) providing persistence and search support for
 * AuthorityT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.vb.beans.AuthorityT
 * @author MyEclipse Persistence Tools
 */
public class AuthorityTDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AuthorityTDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(AuthorityT transientInstance) {
		log.debug("saving AuthorityT instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AuthorityT persistentInstance) {
		log.debug("deleting AuthorityT instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AuthorityT findById(com.vb.beans.AuthorityTId id) {
		log.debug("getting AuthorityT instance with id: " + id);
		try {
			AuthorityT instance = (AuthorityT) getHibernateTemplate().get(
					"com.vb.beans.AuthorityT", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AuthorityT instance) {
		log.debug("finding AuthorityT instance by example");
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
		log.debug("finding AuthorityT instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AuthorityT as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all AuthorityT instances");
		try {
			String queryString = "from AuthorityT";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AuthorityT merge(AuthorityT detachedInstance) {
		log.debug("merging AuthorityT instance");
		try {
			AuthorityT result = (AuthorityT) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AuthorityT instance) {
		log.debug("attaching dirty AuthorityT instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AuthorityT instance) {
		log.debug("attaching clean AuthorityT instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AuthorityTDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AuthorityTDAO) ctx.getBean("AuthorityTDAO");
	}
}