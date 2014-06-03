package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Transactions;

public interface TransactionsDao {

	public void persist(Transactions transientInstance);

	public void remove(Transactions persistentInstance);

	public Transactions merge(Transactions detachedInstance);

	public Transactions findById(String id);

}