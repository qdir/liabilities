package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.OfficesDao;
import es.unileon.ulebank.repository.domain.Offices;

/**
 * Home object for domain model class Offices.
 * 
 * @see es.unileon.ulebank.repository.domain.Offices
 */
@Stateless
@Repository(value = "officesDao")
public class OfficesDaoImpl implements OfficesDao {

	private static final Log log = LogFactory.getLog(OfficesDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.OfficesDao#persist(es.unileon.ulebank.repository.domain.Offices)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Offices transientInstance) {
		log.debug("persisting Offices instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.OfficesDao#remove(es.unileon.ulebank.repository.domain.Offices)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Offices persistentInstance) {
		log.debug("removing Offices instance");
		try {
			persistentInstance = findById(persistentInstance.getOfficeId());
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.OfficesDao#merge(es.unileon.ulebank.repository.domain.Offices)
	 */
	@Override
	@Transactional(readOnly = false)
	public Offices merge(Offices detachedInstance) {
		log.debug("merging Offices instance");
		try {
			Offices result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.OfficesDao#findById(java.lang.String)
	 */
	@Override
	public Offices findById(String id) {
		log.debug("getting Offices instance with id: " + id);
		try {
			Offices instance = entityManager.find(Offices.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
