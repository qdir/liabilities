package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Investmentaccounts;

public interface InvestmentaccountsDao {

	public void persist(Investmentaccounts transientInstance);

	public void remove(Investmentaccounts persistentInstance);

	public Investmentaccounts merge(Investmentaccounts detachedInstance);

	public Investmentaccounts findById(Long id);

}