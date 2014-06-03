package es.unileon.ulebank.repository.dao;

import es.unileon.ulebank.repository.domain.Scheduledpayments;

public interface ScheduledpaymentsDao {

	public void persist(Scheduledpayments transientInstance);

	public void remove(Scheduledpayments persistentInstance);

	public Scheduledpayments merge(Scheduledpayments detachedInstance);

	public Scheduledpayments findById(String id);

}