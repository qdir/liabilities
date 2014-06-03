package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.HistoriesDao;
import es.unileon.ulebank.repository.domain.Histories;

/**
 * Home object for domain model class Histories.
 * 
 * @see es.unileon.ulebank.repository.domain.Histories
 */
@Stateless
@Repository(value = "historiesDao")
public class HistoriesDaoImpl implements HistoriesDao {

	private static final Log log = LogFactory.getLog(HistoriesDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.HistoriesDao#persist(es.unileon.ulebank.repository.domain.Histories)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Histories transientInstance) {
		log.debug("persisting Histories instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.HistoriesDao#remove(es.unileon.ulebank.repository.domain.Histories)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Histories persistentInstance) {
		log.debug("removing Histories instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.HistoriesDao#merge(es.unileon.ulebank.repository.domain.Histories)
	 */
	@Override
	@Transactional(readOnly = false)
	public Histories merge(Histories detachedInstance) {
		log.debug("merging Histories instance");
		try {
			Histories result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.HistoriesDao#findById(java.lang.Long)
	 */
	@Override
	public Histories findById(Long id) {
		log.debug("getting Histories instance with id: " + id);
		try {
			Histories instance = entityManager.find(Histories.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
