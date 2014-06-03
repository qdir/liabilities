package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Investmentfunds;
import es.unileon.ulebank.repository.domain.InvestmentfundsId;

public interface InvestmentfundsDao {

	public void persist(Investmentfunds transientInstance);

	public void remove(Investmentfunds persistentInstance);

	public Investmentfunds merge(Investmentfunds detachedInstance);

	public Investmentfunds findById(InvestmentfundsId id);

}