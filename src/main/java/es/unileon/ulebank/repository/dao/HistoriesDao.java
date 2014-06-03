package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Histories;

public interface HistoriesDao {

	public void persist(Histories transientInstance);

	public void remove(Histories persistentInstance);

	public Histories merge(Histories detachedInstance);

	public Histories findById(Long id);

}