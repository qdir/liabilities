package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.GenericTransactionDomain;

public interface TransactionsDao {

	public void persist (GenericTransactionDomain transientInstance);
	public List<GenericTransactionDomain> getGenericTransactionsList();
}
