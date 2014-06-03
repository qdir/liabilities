package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.TransactionsDao;
import es.unileon.ulebank.repository.domain.Transactions;

/**
 * Home object for domain model class Transactions.
 * 
 * @see es.unileon.ulebank.repository.domain.Transactions
 */
@Stateless
@Repository(value = "transactionsDao")
public class TransactionsDaoImpl implements TransactionsDao {

	private static final Log log = LogFactory.getLog(TransactionsDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.TransactionsDao#persist(es.unileon.ulebank.repository.domain.Transactions)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Transactions transientInstance) {
		log.debug("persisting Transactions instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.TransactionsDao#remove(es.unileon.ulebank.repository.domain.Transactions)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Transactions persistentInstance) {
		log.debug("removing Transactions instance");
		try {
			persistentInstance = findById(persistentInstance.getTransactionId());
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.TransactionsDao#merge(es.unileon.ulebank.repository.domain.Transactions)
	 */
	@Override
	@Transactional(readOnly = false)
	public Transactions merge(Transactions detachedInstance) {
		log.debug("merging Transactions instance");
		try {
			Transactions result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.TransactionsDao#findById(java.lang.String)
	 */
	@Override
	public Transactions findById(String id) {
		log.debug("getting Transactions instance with id: " + id);
		try {
			Transactions instance = entityManager.find(Transactions.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
