package es.unileon.ulebank.account.liquidation;

import java.util.Date;

import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.history.Transaction;

public interface AbstractFeeCase<T> {

	public boolean triggerCase();
	
	public Transaction calculateAmount() throws TransactionException;
	
	public AbstractFeatureExtractor<T> getFeatureExtractor();
}
