package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.CardsDao;
import es.unileon.ulebank.repository.domain.Cards;
import es.unileon.ulebank.repository.domain.CardsId;

/**
 * Home object for domain model class Cards.
 * 
 * @see es.unileon.ulebank.repository.domain.Cards
 */
@Stateless
@Repository(value = "cardsDao")
public class CardsDaoImpl implements CardsDao {

	private static final Log log = LogFactory.getLog(CardsDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.CardsDao#persist(es.unileon.ulebank.repository.domain.Cards)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Cards transientInstance) {
		log.debug("persisting Cards instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.CardsDao#remove(es.unileon.ulebank.repository.domain.Cards)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Cards persistentInstance) {
		log.debug("removing Cards instance");
		try {
			persistentInstance = findById(persistentInstance.getId());
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.CardsDao#merge(es.unileon.ulebank.repository.domain.Cards)
	 */
	@Override
	@Transactional(readOnly = false)
	public Cards merge(Cards detachedInstance) {
		log.debug("merging Cards instance");
		try {
			Cards result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.CardsDao#findById(es.unileon.ulebank.repository.domain.CardsId)
	 */
	@Override
	public Cards findById(CardsId id) {
		log.debug("getting Cards instance with id: " + id);
		try {
			Cards instance = entityManager.find(Cards.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
