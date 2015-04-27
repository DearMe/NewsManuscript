package com.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.domain.ComDepartment;

/**
 * A data access object (DAO) providing persistence and search support for
 * ComDepartment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.domain.ComDepartment
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ComDepartmentDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ComDepartmentDAO.class);
	// property constants
	public static final String DEPARTMENT_NAME = "departmentName";
	public static final String PARENT_DEPARTMENT = "parentDepartment";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(ComDepartment transientInstance) {
		log.debug("saving ComDepartment instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ComDepartment persistentInstance) {
		log.debug("deleting ComDepartment instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ComDepartment findById(java.lang.String id) {
		log.debug("getting ComDepartment instance with id: " + id);
		try {
			ComDepartment instance = (ComDepartment) getCurrentSession().get(
					"com.domain.ComDepartment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ComDepartment> findByExample(ComDepartment instance) {
		log.debug("finding ComDepartment instance by example");
		try {
			List<ComDepartment> results = (List<ComDepartment>) getCurrentSession()
					.createCriteria("com.domain.ComDepartment")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ComDepartment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ComDepartment as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ComDepartment> findByDepartmentName(Object departmentName) {
		return findByProperty(DEPARTMENT_NAME, departmentName);
	}

	public List<ComDepartment> findByParentDepartment(Object parentDepartment) {
		return findByProperty(PARENT_DEPARTMENT, parentDepartment);
	}

	public List findAll() {
		log.debug("finding all ComDepartment instances");
		try {
			String queryString = "from ComDepartment";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ComDepartment merge(ComDepartment detachedInstance) {
		log.debug("merging ComDepartment instance");
		try {
			ComDepartment result = (ComDepartment) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ComDepartment instance) {
		log.debug("attaching dirty ComDepartment instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ComDepartment instance) {
		log.debug("attaching clean ComDepartment instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ComDepartmentDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ComDepartmentDAO) ctx.getBean("ComDepartmentDAO");
	}
}