package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.TransactionHandlerDomain;

public interface TransactionsHandlerDao {

	public void persist(TransactionHandlerDomain transientInstance);
	public List<TransactionHandlerDomain> getTransactionsHandlerList();
}
