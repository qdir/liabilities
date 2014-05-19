/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.account;

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
public class LiquidationFee {

	private List<FeeCase> feeCases;
	
	public LiquidationFee() {
		this.feeCases = new ArrayList<FeeCase>();
	}
	
	public void addFeeCase(FeeCase fee){
		this.feeCases.add(fee);
	}
	
    public Transaction calculateFee(Iterator<Transaction> transactions, Iterator<DirectDebitTransaction> directDebitTransactions, AccountDirectDebits accountDirectDebits, Date min, Date max) throws TransactionException{
    	int i = -1;
    	boolean foundValidCase = false;
    	while(foundValidCase && ++i < feeCases.size() ) {
    		foundValidCase = this.feeCases.get(i).triggerCase(transactions, directDebitTransactions, accountDirectDebits,min,max);
    	}
    	if(foundValidCase) {
    		return this.feeCases.get(i).calculateAmount(transactions, directDebitTransactions, accountDirectDebits,min,max);
    	}
    	return null;
    }

}
