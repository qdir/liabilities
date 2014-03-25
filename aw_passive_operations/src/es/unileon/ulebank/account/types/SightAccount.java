/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.account.types;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountTypes;
import es.unileon.ulebank.account.exception.BalanceException;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;

/**
 *
 * @author runix
 */
public class SightAccount extends Account {

    double interest;
    private double administrationWage;
    private double anualInterest;
    private double administrationFee;
    private double negativeBallanceFee;
    private double complaintFee;
    private double buyingFee;
    private double withdrawFee;
    private double chequeFee;
    private double repaymentFee;
    private double depositOperationFee;
    private double magneticSuppportFee;
    private double paperFee;
    private double terminalFee;
    private double buyingFeePercentage;

    public SightAccount(Office office, Bank bank, String accountnumber, double interest,
            double administrationWage,
            double anualInterest,
            double administrationFee,
            double negativeBallanceFee,
            double complaintFee,
            double buyingFee,
            double withdrawFee,
            double chequeFee,
            double repaymentFee,
            double depositOperationFee,
            double magneticSuppportFee,
            double paperFee,
            double terminalFee,
            double buyingFeePercentage) throws MalformedHandlerException {
        super(office, bank, accountnumber);
    }

    @Override
    public void addBalance(float balance) throws BalanceException {
        throw new BalanceException("The account balance cannot be negative");
    }
}
