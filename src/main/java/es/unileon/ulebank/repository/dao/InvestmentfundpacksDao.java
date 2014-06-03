package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Investmentfundpacks;

public interface InvestmentfundpacksDao {

	public void persist(Investmentfundpacks transientInstance);

	public void remove(Investmentfundpacks persistentInstance);

	public Investmentfundpacks merge(Investmentfundpacks detachedInstance);

	public Investmentfundpacks findById(Long id);

}