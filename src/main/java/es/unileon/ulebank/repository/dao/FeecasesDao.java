package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Feecases;

public interface FeecasesDao {

	public void persist(Feecases transientInstance);

	public void remove(Feecases persistentInstance);

	public Feecases merge(Feecases detachedInstance);

	public Feecases findById(Integer id);

}