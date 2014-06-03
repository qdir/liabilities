package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Enterprises;
import es.unileon.ulebank.repository.domain.EnterprisesId;

public interface EnterprisesDao {

	public void persist(Enterprises transientInstance);

	public void remove(Enterprises persistentInstance);

	public Enterprises merge(Enterprises detachedInstance);

	public Enterprises findById(EnterprisesId id);

}