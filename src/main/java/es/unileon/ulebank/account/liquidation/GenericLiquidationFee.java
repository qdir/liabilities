/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.account.liquidation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.Transaction;

/**
 *
 * @author runix
 * @param <T>
 */
public class GenericLiquidationFee<T> implements AbstractLiquidationFee<T> {

	private List<AbstractFeeCase<T>> feeCases;
	private Features<T> featureExtractor;
	private Account account;

	public GenericLiquidationFee(Account account) {
		this.feeCases = new ArrayList<AbstractFeeCase<T>>();
		this.account = account;
	}

	@Override
	public boolean addFeeCase(AbstractFeeCase<T> feeCase) {
		if (feeCase.getFeatures() == featureExtractor) {
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
		this.featureExtractor.updateFeatures(account, min, max);
		while (foundValidCase && ++i < feeCases.size()) {
			foundValidCase = this.feeCases.get(i).triggerCase();
		}
		if (foundValidCase) {
			result = this.feeCases.get(i).calculateAmount();
		}
		return result;
	}

	@Override
	public Handler getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
