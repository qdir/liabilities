package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.LiquidationfeesDao;
import es.unileon.ulebank.repository.domain.Liquidationfees;

/**
 * Home object for domain model class Liquidationfees.
 * 
 * @see es.unileon.ulebank.repository.domain.Liquidationfees
 */
@Stateless
@Repository(value = "liquidationfeesDao")
public class LiquidationfeesDaoImpl implements LiquidationfeesDao {

	private static final Log log = LogFactory.getLog(LiquidationfeesDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.LiquidationfeesDao#persist(es.unileon.ulebank.repository.domain.Liquidationfees)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Liquidationfees transientInstance) {
		log.debug("persisting Liquidationfees instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.LiquidationfeesDao#remove(es.unileon.ulebank.repository.domain.Liquidationfees)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Liquidationfees persistentInstance) {
		log.debug("removing Liquidationfees instance");
		try {
			persistentInstance = findById(persistentInstance.getLiquidationFeeId());
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.LiquidationfeesDao#merge(es.unileon.ulebank.repository.domain.Liquidationfees)
	 */
	@Override
	@Transactional(readOnly = false)
	public Liquidationfees merge(Liquidationfees detachedInstance) {
		log.debug("merging Liquidationfees instance");
		try {
			Liquidationfees result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.LiquidationfeesDao#findById(java.lang.Integer)
	 */
	@Override
	public Liquidationfees findById(Integer id) {
		log.debug("getting Liquidationfees instance with id: " + id);
		try {
			Liquidationfees instance = entityManager.find(
					Liquidationfees.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
