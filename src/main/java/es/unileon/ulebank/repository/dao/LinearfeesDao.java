package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Linearfees;

public interface LinearfeesDao {

	public void persist(Linearfees transientInstance);

	public void remove(Linearfees persistentInstance);

	public Linearfees merge(Linearfees detachedInstance);

	public Linearfees findById(Long id);

}