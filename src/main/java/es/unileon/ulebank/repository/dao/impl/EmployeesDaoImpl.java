package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.EmployeesDao;
import es.unileon.ulebank.repository.domain.Employees;

/**
 * Home object for domain model class Employees.
 * 
 * @see es.unileon.ulebank.repository.domain.Employees
 */
@Stateless
@Repository(value = "employeesDao")
public class EmployeesDaoImpl implements EmployeesDao {

	private static final Log log = LogFactory.getLog(EmployeesDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.EmployeesDao#persist(es.unileon.ulebank.repository.domain.Employees)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Employees transientInstance) {
		log.debug("persisting Employees instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.EmployeesDao#remove(es.unileon.ulebank.repository.domain.Employees)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Employees persistentInstance) {
		log.debug("removing Employees instance");
		try {
			persistentInstance = findById(persistentInstance.getEmployeeId());
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.EmployeesDao#merge(es.unileon.ulebank.repository.domain.Employees)
	 */
	@Override
	@Transactional(readOnly = false)
	public Employees merge(Employees detachedInstance) {
		log.debug("merging Employees instance");
		try {
			Employees result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.EmployeesDao#findById(java.lang.String)
	 */
	@Override
	public Employees findById(String id) {
		log.debug("getting Employees instance with id: " + id);
		try {
			Employees instance = entityManager.find(Employees.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
