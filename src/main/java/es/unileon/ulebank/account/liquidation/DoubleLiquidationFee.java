/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.account.liquidation;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountDirectDebits;
import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.history.DirectDebitTransaction;
import es.unileon.ulebank.history.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author runix
 * @param <T>
 */
public class DoubleLiquidationFee implements AbstractLiquidationFee<Double> {

	private List<AbstractFeeCase<Double>> feeCases;
	private AbstractFeatureExtractor<Double> featureExtractor;
	private Account account;

	public DoubleLiquidationFee(Account account) {
		this.feeCases = new ArrayList<AbstractFeeCase<Double>>();
		this.account = account;
	}

	@Override
	public boolean addFeeCase(AbstractFeeCase<Double> feeCase) {
		if (feeCase.getFeatureExtractor() == featureExtractor) {
			return this.feeCases.add(feeCase);
		}
		return false;
	}

	@Override
	public Transaction calculateFee(Date min, Date max)
			throws TransactionException {
		boolean foundValidCase = false;
		Transaction result = null;
		int i = -1;
		this.featureExtractor.updateVariables(account, min, max);
		while (foundValidCase && ++i < feeCases.size()) {
			foundValidCase = this.feeCases.get(i).triggerCase();
		}
		if (foundValidCase) {
			result = this.feeCases.get(i).calculateAmount();
		}
		return result;
	}

}
