package es.unileon.ulebank.account;

import java.util.Iterator;

import com.fathzer.soft.javaluator.StaticVariableSet;

import es.unileon.ulebank.history.DirectDebitTransaction;
import es.unileon.ulebank.history.Transaction;

public class FeatureExtractor implements AbstractFeatureExtractor {

	private StaticVariableSet<Double> variables;

	public FeatureExtractor() {
		this.variables = new StaticVariableSet<Double>();
	}

	@Override
	public StaticVariableSet<Double> getVariables() {
		return this.variables;
	}

	@Override
	public StaticVariableSet<Double> generateRandomVariables() {
		StaticVariableSet<Double> set = new StaticVariableSet<Double>();
		return set;
	}

	@Override
	public void updateVariables(Iterator<Transaction> transactions,
			Iterator<DirectDebitTransaction> directDebitTransactions,
			AccountDirectDebits accountDirectDebits) {

	}

	@Override
	public String[] getVariableNames() {
		return null;
	}

}
