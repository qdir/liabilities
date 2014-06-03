package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Cards;
import es.unileon.ulebank.repository.domain.CardsId;

public interface CardsDao {

	public void persist(Cards transientInstance);

	public void remove(Cards persistentInstance);

	public Cards merge(Cards detachedInstance);

	public Cards findById(CardsId id);

}