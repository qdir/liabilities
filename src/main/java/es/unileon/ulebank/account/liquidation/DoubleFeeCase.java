package es.unileon.ulebank.account.liquidation;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.mvel2.MVEL;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.StaticVariableSet;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.time.Time;

public class DoubleFeeCase implements AbstractFeeCase<Double> {

	private Features<Double> features;
	private String amountFormula;
	private StringBuilder triggeringConditions;
	private String subject;
	private static final DoubleEvaluator EVALUATOR = new DoubleEvaluator();
	private static final double PRECISION = 10;
	private static final double EPSILON = Math.pow(10, -PRECISION);

	public DoubleFeeCase(Features<Double> features, String amountFormula,
			String subject, Account account) {
		this.features = features;
		this.triggeringConditions = new StringBuilder();
		this.amountFormula = amountFormula;
		this.subject = subject;
	}

	public void addConditionEquation(String leftOperand, char comparator,
			String rightOperand) throws InvalidCondition {
		leftOperand = leftOperand.replace(" ", "");
		rightOperand = rightOperand.replace(" ", "");
		if (isValidComparator(comparator) && testValidOperand(leftOperand)
				&& testValidOperand(rightOperand)) {
			if (this.triggeringConditions.length() > 0) {
				this.triggeringConditions.append("&&");
			}
			this.triggeringConditions.append(generateEquation(leftOperand,
					comparator, rightOperand));
		} else {
			throw new InvalidCondition("Invalid condition");
		}
	}

	@Override
	public boolean triggerCase() {
		if (this.triggeringConditions.length() > 0) {
			return MVEL.evalToBoolean(this.triggeringConditions.toString(),
					this.features.generateRandomFeatures());
		}
		return true;
	}

	@Override
	public Transaction calculateAmount() throws TransactionException {
		Transaction result = null;
		if (this.triggerCase()) {
			StringBuilder err = new StringBuilder();
			try {
				double amount = EVALUATOR.evaluate(this.amountFormula,
						castTo(this.features.getFeatures()));
				result = new GenericTransaction(amount, new Date(Time
						.getInstance().getTime()), subject);
			} catch (RuntimeException r) {
				err.append(r);
			}
			if (err.length() > 0) {
				throw new TransactionException(err.toString());
			}
		}
		return result;
	}

	private boolean testValidOperand(String operand) throws InvalidCondition {
		try {
			EVALUATOR.evaluate(operand,
					castTo(this.features.generateRandomFeatures()));
		} catch (RuntimeException e) {
			throw new InvalidCondition(e.toString());
		}
		return true;
	}

	private static String generateEquation(String leftOperand, char comparator,
			String rightOperand) {
		return "((" + leftOperand + " - " + rightOperand + ")" + comparator
				+ " " + EPSILON + ")";
	}

	private static boolean isValidComparator(char comparator) {
		return comparator == '<' || comparator == '>';
	}

	private static StaticVariableSet<Double> castTo(Map<String, Double> map) {
		Set<String> keys = map.keySet();
		StaticVariableSet<Double> set = new StaticVariableSet<Double>();
		for (String key : keys) {
			set.set(key, map.get(key));
		}
		return set;
	}

	@Override
	public Features<Double> getFeatures() {
		return this.features;
	}
}
