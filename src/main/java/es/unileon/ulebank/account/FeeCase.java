package es.unileon.ulebank.account;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.mvel2.MVEL;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.StaticVariableSet;

import es.unileon.ulebank.history.DirectDebitTransaction;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.time.Time;

public class FeeCase {

	private AbstractFeatureExtractor featureExtractor;
	private String amountFormula;
	private StringBuffer triggeringConditions;
	private String subject;
	private static final DoubleEvaluator EVALUATOR = new DoubleEvaluator();
	private static final double PRECISION = 10;
	private static final double EPSILON = Math.pow(10, -PRECISION);

	public FeeCase(AbstractFeatureExtractor featureExtractor,
			String amountFormula, String subject) {
		this.featureExtractor = featureExtractor;
		this.triggeringConditions = new StringBuffer();
		this.amountFormula = amountFormula;
		this.subject = subject;
	}

	public boolean addConditionEquation(String leftOperand, char comparator,
			String rightOperand) {
		boolean result = true;
		if (comparator == '<' || comparator == '>' || comparator == '='
				|| comparator == '!') {
			if (comparator == '=') {
				comparator = '<';
			} else if (comparator == '!') {
				comparator = '>';
			}
			StaticVariableSet<Double> randomVariables = this.featureExtractor
					.generateRandomVariables();
			try {
				EVALUATOR.evaluate(leftOperand, randomVariables);
				EVALUATOR.evaluate(rightOperand, randomVariables);
				String equation = "((" + leftOperand + " - " + rightOperand
						+ ")" + comparator + " " + EPSILON + ")";
				if (this.triggeringConditions.length() > 0) {
					this.triggeringConditions.append("&&");
				}

				this.triggeringConditions.append(equation);
			
			} catch (Throwable e) {
				result = false;
			}
		}

		return result;
	}

	public boolean triggerCase(Iterator<Transaction> transactions,
			Iterator<DirectDebitTransaction> directDebitTransactions,
			AccountDirectDebits accountDirectDebits) {
		HashMap<String, Object> variables = new HashMap<String, Object>();
		StaticVariableSet<Double> set = this.featureExtractor.getVariables();
		for (String name : this.featureExtractor.getVariableNames()) {
			variables.put(name, set.get(name));
		}
		return MVEL.evalToBoolean(this.triggeringConditions.toString(),
				variables);
	}

	public Transaction calculateAmount(Iterator<Transaction> transactions,
			Iterator<DirectDebitTransaction> directDebitTransactions,
			AccountDirectDebits accountDirectDebits) {
		Transaction result = null;
		if (this.triggerCase(transactions, directDebitTransactions,
				accountDirectDebits)) {
			double amount = EVALUATOR.evaluate(this.amountFormula,
					this.featureExtractor.generateRandomVariables());
			result = new GenericTransaction(amount, new Date(Time.getInstance()
					.getTime()), subject);
		}
		return result;
	}

}
