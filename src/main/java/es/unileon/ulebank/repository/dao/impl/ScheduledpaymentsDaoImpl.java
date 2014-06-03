package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.ScheduledpaymentsDao;
import es.unileon.ulebank.repository.domain.Scheduledpayments;

/**
 * Home object for domain model class Scheduledpayments.
 * 
 * @see es.unileon.ulebank.repository.domain.Scheduledpayments
 */
@Stateless
@Repository(value = "scheduledpaymentsDao")
public class ScheduledpaymentsDaoImpl implements ScheduledpaymentsDao {

	private static final Log log = LogFactory
			.getLog(ScheduledpaymentsDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.ScheduledpaymentsDao#persist(es.unileon.ulebank.repository.domain.Scheduledpayments)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Scheduledpayments transientInstance) {
		log.debug("persisting Scheduledpayments instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.ScheduledpaymentsDao#remove(es.unileon.ulebank.repository.domain.Scheduledpayments)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Scheduledpayments persistentInstance) {
		log.debug("removing Scheduledpayments instance");
		try {
			persistentInstance = findById(persistentInstance.getSheduledPayementId());
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.ScheduledpaymentsDao#merge(es.unileon.ulebank.repository.domain.Scheduledpayments)
	 */
	@Override
	@Transactional(readOnly = false)
	public Scheduledpayments merge(Scheduledpayments detachedInstance) {
		log.debug("merging Scheduledpayments instance");
		try {
			Scheduledpayments result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.ScheduledpaymentsDao#findById(java.lang.String)
	 */
	@Override
	public Scheduledpayments findById(String id) {
		log.debug("getting Scheduledpayments instance with id: " + id);
		try {
			Scheduledpayments instance = entityManager.find(
					Scheduledpayments.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
