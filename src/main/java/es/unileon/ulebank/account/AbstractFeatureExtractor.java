package es.unileon.ulebank.account;

import java.util.Iterator;

import com.fathzer.soft.javaluator.StaticVariableSet;

import es.unileon.ulebank.history.DirectDebitTransaction;
import es.unileon.ulebank.history.Transaction;

public interface AbstractFeatureExtractor {

	StaticVariableSet<Double> getVariables();

	StaticVariableSet<Double> generateRandomVariables();
	
	String [] getVariableNames();
	
	void updateVariables(Iterator<Transaction> transactions, Iterator<DirectDebitTransaction> directDebitTransactions, AccountDirectDebits accountDirectDebits);
}
