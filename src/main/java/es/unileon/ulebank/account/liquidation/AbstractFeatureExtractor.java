package es.unileon.ulebank.account.liquidation;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.fathzer.soft.javaluator.StaticVariableSet;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountDirectDebits;
import es.unileon.ulebank.history.DirectDebitTransaction;
import es.unileon.ulebank.history.Transaction;

public interface AbstractFeatureExtractor<T> {

	Map<String,T> getVariables();

	Map<String,T> generateRandomVariables();

	String[] getVariableNames();

	void updateVariables(Account account, Date min, Date max);
}
