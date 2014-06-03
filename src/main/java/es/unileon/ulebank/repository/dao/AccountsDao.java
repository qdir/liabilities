package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Accounts;

public interface AccountsDao {

	public void persist(Accounts transientInstance);

	public void remove(Accounts persistentInstance);

	public Accounts merge(Accounts detachedInstance);

	public Accounts findById(String id);

}