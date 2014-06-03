package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Employees;

public interface EmployeesDao {

	public void persist(Employees transientInstance);

	public void remove(Employees persistentInstance);

	public Employees merge(Employees detachedInstance);

	public Employees findById(String id);

}