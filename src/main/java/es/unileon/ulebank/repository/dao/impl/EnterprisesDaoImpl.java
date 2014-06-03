package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.EnterprisesDao;
import es.unileon.ulebank.repository.domain.Enterprises;
import es.unileon.ulebank.repository.domain.EnterprisesId;

/**
 * Home object for domain model class Enterprises.
 * 
 * @see es.unileon.ulebank.repository.domain.Enterprise
 */
@Stateless
@Repository(value = "enterprisesDao")
public class EnterprisesDaoImpl implements EnterprisesDao {

	private static final Log log = LogFactory.getLog(EnterprisesDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.EnterprisesDao#persist(es.unileon.ulebank.repository.domain.Enterprises)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Enterprises transientInstance) {
		log.debug("persisting Enterprises instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.EnterprisesDao#remove(es.unileon.ulebank.repository.domain.Enterprises)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Enterprises persistentInstance) {
		log.debug("removing Enterprises instance");
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
	 * @see es.unileon.ulebank.repository.dao.impl.EnterprisesDao#merge(es.unileon.ulebank.repository.domain.Enterprises)
	 */
	@Override
	@Transactional(readOnly = false)
	public Enterprises merge(Enterprises detachedInstance) {
		log.debug("merging Enterprises instance");
		try {
			Enterprises result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.EnterprisesDao#findById(es.unileon.ulebank.repository.domain.EnterprisesId)
	 */
	@Override
	public Enterprises findById(EnterprisesId id) {
		log.debug("getting Enterprises instance with id: " + id);
		try {
			Enterprises instance = entityManager.find(Enterprises.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
