package es.unileon.ulebank.account;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.mvel2.MVEL;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.StaticVariableSet;

import es.unileon.ulebank.exceptions.TransactionException;
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

			} catch (RuntimeException e) {
				result = false;
			} catch (Exception e) {
				result = false;
			}
		}

		return result;
	}

	public boolean triggerCase(Iterator<Transaction> transactions,
			Iterator<DirectDebitTransaction> directDebitTransactions,
			AccountDirectDebits accountDirectDebits, Date min, Date max) {
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
			AccountDirectDebits accountDirectDebits, Date min, Date max)
			throws TransactionException {
		Transaction result = null;
		StringBuffer error = new StringBuffer();
		if (this.triggerCase(transactions, directDebitTransactions,
				accountDirectDebits, min, max)) {
			try {
				double amount = EVALUATOR.evaluate(this.amountFormula,
						this.featureExtractor.generateRandomVariables());
				result = new GenericTransaction(amount, new Date(Time
						.getInstance().getTime()), subject);
			} catch (RuntimeException r) {
				error.append(r.toString());
			} catch (Exception e) {
				error.append(e.toString());
			}
		}
		if(error.length() > 0) {
			throw new TransactionException(error.toString());
		}
		return result;
	}

}
