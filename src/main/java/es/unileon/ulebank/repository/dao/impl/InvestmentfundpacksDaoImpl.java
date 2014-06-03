package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.InvestmentfundpacksDao;
import es.unileon.ulebank.repository.domain.Investmentfundpacks;

/**
 * Home object for domain model class Investmentfundpacks.
 * 
 * @see es.unileon.ulebank.repository.domain.Investmentfundpacks
 */
@Stateless
@Repository(value = "investmentfundpacksDao")
public class InvestmentfundpacksDaoImpl implements InvestmentfundpacksDao {

	private static final Log log = LogFactory
			.getLog(InvestmentfundpacksDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.InvestmentfundpacksDao#persist(es.unileon.ulebank.repository.domain.Investmentfundpacks)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Investmentfundpacks transientInstance) {
		log.debug("persisting Investmentfundpacks instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.InvestmentfundpacksDao#remove(es.unileon.ulebank.repository.domain.Investmentfundpacks)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Investmentfundpacks persistentInstance) {
		log.debug("removing Investmentfundpacks instance");
		try {
			persistentInstance = findById(persistentInstance.getInvestmentFundPackId());
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.InvestmentfundpacksDao#merge(es.unileon.ulebank.repository.domain.Investmentfundpacks)
	 */
	@Override
	@Transactional(readOnly = false)
	public Investmentfundpacks merge(Investmentfundpacks detachedInstance) {
		log.debug("merging Investmentfundpacks instance");
		try {
			Investmentfundpacks result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.InvestmentfundpacksDao#findById(java.lang.Long)
	 */
	@Override
	public Investmentfundpacks findById(Long id) {
		log.debug("getting Investmentfundpacks instance with id: " + id);
		try {
			Investmentfundpacks instance = entityManager.find(
					Investmentfundpacks.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
