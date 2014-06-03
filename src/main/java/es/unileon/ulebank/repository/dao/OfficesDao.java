package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Offices;

public interface OfficesDao {

	public void persist(Offices transientInstance);

	public void remove(Offices persistentInstance);

	public Offices merge(Offices detachedInstance);

	public Offices findById(String id);

}