package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.FeecasesDao;
import es.unileon.ulebank.repository.domain.Feecases;

/**
 * Home object for domain model class Feecases.
 * 
 * @see es.unileon.ulebank.repository.domain.Feecases
 */
@Stateless
@Repository(value = "feecasesDao")
public class FeecasesDaoImpl implements FeecasesDao {

	private static final Log log = LogFactory.getLog(FeecasesDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.FeecasesDao#persist(es.unileon.ulebank.repository.domain.Feecases)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Feecases transientInstance) {
		log.debug("persisting Feecases instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.FeecasesDao#remove(es.unileon.ulebank.repository.domain.Feecases)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Feecases persistentInstance) {
		log.debug("removing Feecases instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.FeecasesDao#merge(es.unileon.ulebank.repository.domain.Feecases)
	 */
	@Override
	@Transactional(readOnly = false)
	public Feecases merge(Feecases detachedInstance) {
		log.debug("merging Feecases instance");
		try {
			Feecases result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.FeecasesDao#findById(java.lang.Integer)
	 */
	@Override
	public Feecases findById(Integer id) {
		log.debug("getting Feecases instance with id: " + id);
		try {
			Feecases instance = entityManager.find(Feecases.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
