package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.InvestmentfundsDao;
import es.unileon.ulebank.repository.domain.Investmentfunds;
import es.unileon.ulebank.repository.domain.InvestmentfundsId;

/**
 * Home object for domain model class Investmentfunds.
 * 
 * @see es.unileon.ulebank.repository.domain.Investmentfunds
 */
@Stateless
@Repository(value = "investmentfundsDao")
public class InvestmentfundsDaoImpl implements InvestmentfundsDao {

	private static final Log log = LogFactory.getLog(InvestmentfundsDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.InvestmentfundsDao#persist(es.unileon.ulebank.repository.domain.Investmentfunds)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Investmentfunds transientInstance) {
		log.debug("persisting Investmentfunds instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.InvestmentfundsDao#remove(es.unileon.ulebank.repository.domain.Investmentfunds)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Investmentfunds persistentInstance) {
		log.debug("removing Investmentfunds instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.InvestmentfundsDao#merge(es.unileon.ulebank.repository.domain.Investmentfunds)
	 */
	@Override
	@Transactional(readOnly = false)
	public Investmentfunds merge(Investmentfunds detachedInstance) {
		log.debug("merging Investmentfunds instance");
		try {
			Investmentfunds result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.InvestmentfundsDao#findById(es.unileon.ulebank.repository.domain.InvestmentfundsId)
	 */
	@Override
	public Investmentfunds findById(InvestmentfundsId id) {
		log.debug("getting Investmentfunds instance with id: " + id);
		try {
			Investmentfunds instance = entityManager.find(
					Investmentfunds.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
