package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Stockpacks;

public interface StockpacksDao {

	public void persist(Stockpacks transientInstance);

	public void remove(Stockpacks persistentInstance);

	public Stockpacks merge(Stockpacks detachedInstance);

	public Stockpacks findById(Long id);

}