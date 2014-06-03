package es.unileon.ulebank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.domain.TransactionHandlerDomain;

//@Repository(value = "transactionsHandlerDao")
public class JPATransactionsHandlerDao implements TransactionsHandlerDao{

	private EntityManager em = null;
	 
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<TransactionHandlerDomain> getTransactionsHandlerList() {
        return em.createQuery("select p from TransactionsHandlerDomain p order by p.id").getResultList();
    }

    @Transactional(readOnly = false)
	public void persist(TransactionHandlerDomain transientInstance) {
		
		try {
			em.persist(transientInstance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
