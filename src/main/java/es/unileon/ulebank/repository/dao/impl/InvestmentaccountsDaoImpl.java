package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.InvestmentaccountsDao;
import es.unileon.ulebank.repository.domain.Investmentaccounts;

/**
 * Home object for domain model class Investmentaccounts.
 * 
 * @see es.unileon.ulebank.repository.domain.Investmentaccounts
 */
@Stateless
@Repository(value = "investmentaccountsDao")
public class InvestmentaccountsDaoImpl implements InvestmentaccountsDao {

	private static final Log log = LogFactory
			.getLog(InvestmentaccountsDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.InvestmentaccountsDao#persist(es.unileon.ulebank.repository.domain.Investmentaccounts)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Investmentaccounts transientInstance) {
		log.debug("persisting Investmentaccounts instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.InvestmentaccountsDao#remove(es.unileon.ulebank.repository.domain.Investmentaccounts)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Investmentaccounts persistentInstance) {
		log.debug("removing Investmentaccounts instance");
		try {
			persistentInstance = findById(persistentInstance.getInvestmentAccountId());
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.InvestmentaccountsDao#merge(es.unileon.ulebank.repository.domain.Investmentaccounts)
	 */
	@Override
	@Transactional(readOnly = false)
	public Investmentaccounts merge(Investmentaccounts detachedInstance) {
		log.debug("merging Investmentaccounts instance");
		try {
			Investmentaccounts result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.InvestmentaccountsDao#findById(java.lang.Long)
	 */
	@Override
	public Investmentaccounts findById(Long id) {
		log.debug("getting Investmentaccounts instance with id: " + id);
		try {
			Investmentaccounts instance = entityManager.find(
					Investmentaccounts.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
