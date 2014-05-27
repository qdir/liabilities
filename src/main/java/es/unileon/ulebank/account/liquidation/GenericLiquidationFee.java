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
	private Features<T> features;
	private Account account;
	private Handler id;

	public GenericLiquidationFee(Account account, Handler id,
			Features<T> features) {
		this.feeCases = new ArrayList<AbstractFeeCase<T>>();
		this.account = account;
		this.features = features;
		this.id = id;
	}

	@Override
	public boolean addFeeCase(AbstractFeeCase<T> feeCase) {
		if (feeCase.getFeatures() == features) {
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
		this.features.updateFeatures(account, min, max);
		while (!foundValidCase && ++i < feeCases.size()) {
			foundValidCase = this.feeCases.get(i).triggerCase();
		}
		if (foundValidCase) {
			result = this.feeCases.get(i).calculateAmount();
		}
		return result;
	}

	@Override
	public Handler getId() {
		return this.id;
	}

}
