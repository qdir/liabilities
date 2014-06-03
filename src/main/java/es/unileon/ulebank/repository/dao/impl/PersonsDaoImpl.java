package es.unileon.ulebank.repository.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.repository.dao.PersonsDao;
import es.unileon.ulebank.repository.domain.Persons;

/**
 * Home object for domain model class Persons.
 * 
 * @see es.unileon.ulebank.repository.domain.Persons
 */
@Stateless
@Repository(value = "personsDao")
public class PersonsDaoImpl implements PersonsDao {

	private static final Log log = LogFactory.getLog(PersonsDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.PersonsDao#persist(es.unileon.ulebank.repository.domain.Persons)
	 */
	@Override
	@Transactional(readOnly = false)
	public void persist(Persons transientInstance) {
		log.debug("persisting Persons instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.PersonsDao#remove(es.unileon.ulebank.repository.domain.Persons)
	 */
	@Override
	@Transactional(readOnly = false)
	public void remove(Persons persistentInstance) {
		log.debug("removing Persons instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.PersonsDao#merge(es.unileon.ulebank.repository.domain.Persons)
	 */
	@Override
	@Transactional(readOnly = false)
	public Persons merge(Persons detachedInstance) {
		log.debug("merging Persons instance");
		try {
			Persons result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see es.unileon.ulebank.repository.dao.impl.PersonsDao#findById(java.lang.String)
	 */
	@Override
	public Persons findById(String id) {
		log.debug("getting Persons instance with id: " + id);
		try {
			Persons instance = entityManager.find(Persons.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
