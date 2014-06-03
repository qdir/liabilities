package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Persons;

public interface PersonsDao {

	public void persist(Persons transientInstance);

	public void remove(Persons persistentInstance);

	public Persons merge(Persons detachedInstance);

	public Persons findById(String id);

}