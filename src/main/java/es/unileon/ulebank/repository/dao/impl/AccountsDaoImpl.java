package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.AccountsDao;
import es.unileon.ulebank.repository.domain.Accounts;

/**
 * Home object for domain model class Accounts.
 * 
 * @see es.unileon.ulebank.repository.domain.Accounts
 */
@Stateless
@Repository(value = "accountsDao")
public class AccountsDaoImpl implements AccountsDao {

	private static final Log log = LogFactory.getLog(AccountsDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.AccountsDao#persist(es.unileon.ulebank.repository.domain.Accounts)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Accounts transientInstance) {
		log.debug("persisting Accounts instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.AccountsDao#remove(es.unileon.ulebank.repository.domain.Accounts)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Accounts persistentInstance) {
		log.debug("removing Accounts instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.AccountsDao#merge(es.unileon.ulebank.repository.domain.Accounts)
	 */
	@Override
	@Transactional(readOnly = false)
	public Accounts merge(Accounts detachedInstance) {
		log.debug("merging Accounts instance");
		try {
			Accounts result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.AccountsDao#findById(java.lang.String)
	 */
	@Override
	public Accounts findById(String id) {
		log.debug("getting Accounts instance with id: " + id);
		try {
			Accounts instance = entityManager.find(Accounts.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
