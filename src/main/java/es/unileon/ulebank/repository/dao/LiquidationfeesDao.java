package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Liquidationfees;

public interface LiquidationfeesDao {

	public void persist(Liquidationfees transientInstance);

	public void remove(Liquidationfees persistentInstance);

	public Liquidationfees merge(Liquidationfees detachedInstance);

	public Liquidationfees findById(Integer id);

}