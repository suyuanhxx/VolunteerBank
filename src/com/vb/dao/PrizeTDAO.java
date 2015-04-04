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

import com.vb.beans.Pagination;
import com.vb.beans.PrizeT;

/**
 * A data access object (DAO) providing persistence and search support for
 * PrizeT entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.vb.beans.PrizeT
 * @author MyEclipse Persistence Tools
 */
public class PrizeTDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PrizeTDAO.class);
	// property constants
	public static final String PRIZE_NAME = "prizeName";
	public static final String PRIZE_IMG = "prizeImg";

	protected void initDao() {
		// do nothing
	}

	public void save(PrizeT transientInstance) {
		log.debug("saving PrizeT instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PrizeT persistentInstance) {
		log.debug("deleting PrizeT instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PrizeT findById(java.lang.String id) {
		log.debug("getting PrizeT instance with id: " + id);
		try {
			PrizeT instance = (PrizeT) getHibernateTemplate().get(
					"com.vb.beans.PrizeT", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PrizeT instance) {
		log.debug("finding PrizeT instance by example");
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
		log.debug("finding PrizeT instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PrizeT as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPrizeName(Object prizeName) {
		return findByProperty(PRIZE_NAME, prizeName);
	}

	public List findByPrizeImg(Object prizeImg) {
		return findByProperty(PRIZE_IMG, prizeImg);
	}

	public List findAll() {
		log.debug("finding all PrizeT instances");
		try {
			String queryString = "from PrizeT";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PrizeT merge(PrizeT detachedInstance) {
		log.debug("merging PrizeT instance");
		try {
			PrizeT result = (PrizeT) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PrizeT instance) {
		log.debug("attaching dirty PrizeT instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PrizeT instance) {
		log.debug("attaching clean PrizeT instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PrizeTDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PrizeTDAO) ctx.getBean("PrizeTDAO");
	}
	
	/**
	 * 根据商品名称进行模糊查询
	 * @param prizename
	 * @return
	 */
	public List searchPrizeName(Object prizename){
		try {
			Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.beginTransaction();
			List result=session.createQuery("from PrizeT as a where a."+PRIZE_NAME+
					" like '%"+prizename+"%'").list();
			return result;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/**
	 * get prizes by Pagination
	 * 
	 * @param prize
	 * @param pagination
	 */
	@SuppressWarnings("unchecked")
	public Pagination getPrizes(final PrizeT prize, final Pagination pagination) {
		HibernateCallback callback = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				int totalRow = 0;
				List<PrizeT> objList = new ArrayList<PrizeT>();
				try {
					Criteria criteria = session.createCriteria(PrizeT.class);
					// 只查状态有效的
					//criteria.add(Restrictions.eq("status", CConstants.VALID));
					totalRow = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
					criteria.setProjection(null);
					pagination.setTotalRow(totalRow);
					objList = criteria.addOrder(Order.asc("prizeScore")).addOrder(Order.asc("prizeId")).setFirstResult(pagination.getStartRow()).setMaxResults(pagination.getPageSize()).list();
					pagination.setObjList(objList);
				} catch (Exception e) {
					log.error("getPrizes by Pagination failed...");
					e.printStackTrace();
				}
				return pagination;
			}
		};
		return (Pagination) getHibernateTemplate().execute(callback);
	}

	
}