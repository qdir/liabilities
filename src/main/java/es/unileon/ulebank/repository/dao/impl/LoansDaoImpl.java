package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.LoansDao;
import es.unileon.ulebank.repository.domain.Loans;

/**
 * Home object for domain model class Loans.
 * 
 * @see es.unileon.ulebank.repository.domain.Loans
 */
@Stateless
@Repository(value = "loansDao")
public class LoansDaoImpl implements LoansDao {

	private static final Log log = LogFactory.getLog(LoansDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.LoansDao#persist(es.unileon.ulebank.repository.domain.Loans)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Loans transientInstance) {
		log.debug("persisting Loans instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.LoansDao#remove(es.unileon.ulebank.repository.domain.Loans)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Loans persistentInstance) {
		log.debug("removing Loans instance");
		try {
			persistentInstance = findById(persistentInstance.getLoanId());
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.LoansDao#merge(es.unileon.ulebank.repository.domain.Loans)
	 */
	@Override
	@Transactional(readOnly = false)
	public Loans merge(Loans detachedInstance) {
		log.debug("merging Loans instance");
		try {
			Loans result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.LoansDao#findById(java.lang.String)
	 */
	@Override
	public Loans findById(String id) {
		log.debug("getting Loans instance with id: " + id);
		try {
			Loans instance = entityManager.find(Loans.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
