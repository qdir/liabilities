package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.StockpacksDao;
import es.unileon.ulebank.repository.domain.Stockpacks;

/**
 * Home object for domain model class Stockpacks.
 * 
 * @see es.unileon.ulebank.repository.domain.Stockpacks
 */
@Stateless
@Repository(value = "stockpacksDao")
public class StockpacksDaoImpl implements StockpacksDao {

	private static final Log log = LogFactory.getLog(StockpacksDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.StockpacksDao#persist(es.unileon.ulebank.repository.domain.Stockpacks)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Stockpacks transientInstance) {
		log.debug("persisting Stockpacks instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.StockpacksDao#remove(es.unileon.ulebank.repository.domain.Stockpacks)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Stockpacks persistentInstance) {
		log.debug("removing Stockpacks instance");
		try {
			persistentInstance = findById(persistentInstance.getStockPackId());
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.StockpacksDao#merge(es.unileon.ulebank.repository.domain.Stockpacks)
	 */
	@Override
	@Transactional(readOnly = false)
	public Stockpacks merge(Stockpacks detachedInstance) {
		log.debug("merging Stockpacks instance");
		try {
			Stockpacks result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.StockpacksDao#findById(java.lang.Long)
	 */
	@Override
	public Stockpacks findById(Long id) {
		log.debug("getting Stockpacks instance with id: " + id);
		try {
			Stockpacks instance = entityManager.find(Stockpacks.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
