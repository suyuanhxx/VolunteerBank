package com.vb.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.vb.beans.PrizeUserT;
import com.vb.beans.PrizeUserTId;

/**
 * A data access object (DAO) providing persistence and search support for
 * PrizeUserT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.vb.beans.PrizeUserT
 * @author MyEclipse Persistence Tools
 */
public class PrizeUserTDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PrizeUserTDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(PrizeUserT transientInstance) {
		log.debug("saving PrizeUserT instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PrizeUserT persistentInstance) {
		log.debug("deleting PrizeUserT instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PrizeUserT findById(com.vb.beans.PrizeUserTId id) {
		log.debug("getting PrizeUserT instance with id: " + id);
		try {
			PrizeUserT instance = (PrizeUserT) getHibernateTemplate().get(
					"com.vb.beans.PrizeUserT", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PrizeUserT instance) {
		log.debug("finding PrizeUserT instance by example");
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
		log.debug("finding PrizeUserT instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PrizeUserT as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all PrizeUserT instances");
		try {
			String queryString = "from PrizeUserT";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PrizeUserT merge(PrizeUserT detachedInstance) {
		log.debug("merging PrizeUserT instance");
		try {
			PrizeUserT result = (PrizeUserT) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PrizeUserT instance) {
		log.debug("attaching dirty PrizeUserT instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PrizeUserT instance) {
		log.debug("attaching clean PrizeUserT instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PrizeUserTDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PrizeUserTDAO) ctx.getBean("PrizeUserTDAO");
	}
	
	public List findByUsername(String username){
		try {
			Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.beginTransaction();
			String hql = "from PrizeUserT  where username='" + username + "'";
			List result=session.createQuery(hql).list();
			session.beginTransaction().commit();
			return result;
		} catch (RuntimeException re) {
			log.error("find by username failed", re);
			throw re;
		}
		
	}
}