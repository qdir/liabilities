package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Loans;

public interface LoansDao {

	public void persist(Loans transientInstance);

	public void remove(Loans persistentInstance);

	public Loans merge(Loans detachedInstance);

	public Loans findById(String id);

}