package es.unileon.ulebank.account.liquidation;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.fathzer.soft.javaluator.StaticVariableSet;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountDirectDebits;
import es.unileon.ulebank.history.DirectDebitTransaction;
import es.unileon.ulebank.history.Transaction;

public class DoubleFeatureExtractor implements AbstractFeatureExtractor<Double> {


	@Override
	public String[] getVariableNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateVariables(Account account, Date min, Date max) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Double> getVariables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> generateRandomVariables() {
		// TODO Auto-generated method stub
		return null;
	}


}
