package es.unileon.ulebank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.domain.GenericTransactionDomain;

@Repository(value = "transactionsDao")
public class JPATransactionsDao implements TransactionsDao{

	private EntityManager em = null;
	 
	/*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<GenericTransactionDomain> getGenericTransactionsList() {
        return em.createQuery("select p from GenericTransactionDomain p order by p.id").getResultList();
    }

	@Transactional(readOnly = false)
	public void persist(GenericTransactionDomain transientInstance) {
		
		try {
			em.persist(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
