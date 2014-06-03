package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.LinearfeesDao;
import es.unileon.ulebank.repository.domain.Linearfees;

/**
 * Home object for domain model class Linearfees.
 * 
 * @see es.unileon.ulebank.repository.domain.Linearfees
 */
@Stateless
@Repository(value = "linearfeesDao")
public class LinearfeesDaoImpl implements LinearfeesDao {

	private static final Log log = LogFactory.getLog(LinearfeesDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.LinearfeesDao#persist(es.unileon.ulebank.repository.domain.Linearfees)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Linearfees transientInstance) {
		log.debug("persisting Linearfees instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.LinearfeesDao#remove(es.unileon.ulebank.repository.domain.Linearfees)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Linearfees persistentInstance) {
		log.debug("removing Linearfees instance");
		try {
			persistentInstance = findById(persistentInstance.getFeeId());
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.LinearfeesDao#merge(es.unileon.ulebank.repository.domain.Linearfees)
	 */
	@Override
	@Transactional(readOnly = false)
	public Linearfees merge(Linearfees detachedInstance) {
		log.debug("merging Linearfees instance");
		try {
			Linearfees result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.LinearfeesDao#findById(java.lang.Long)
	 */
	@Override
	public Linearfees findById(Long id) {
		log.debug("getting Linearfees instance with id: " + id);
		try {
			Linearfees instance = entityManager.find(Linearfees.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
