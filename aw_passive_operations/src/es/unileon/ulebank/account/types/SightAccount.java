/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.account.types;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.fees.FeeStrategy;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;

/**
 *
 * @author runix
 */
public class SightAccount extends Account {

    private FeeStrategy interest;
    private FeeStrategy administrationWage;
    private FeeStrategy anualInterest;
    private FeeStrategy administrationFee;
    private FeeStrategy negativeBallanceFee;
    private FeeStrategy complaintFee;
    private FeeStrategy buyingFee;
    private FeeStrategy withdrawFee;
    private FeeStrategy chequeFee;
    private FeeStrategy repaymentFee;
    private FeeStrategy depositOperationFee;
    private FeeStrategy magneticSuppportFee;
    private FeeStrategy paperFee;
    private FeeStrategy terminalFee;
    private FeeStrategy buyingFeePercentage;

    public SightAccount(FeeStrategy interest, FeeStrategy administrationWage, FeeStrategy anualInterest, FeeStrategy administrationFee, FeeStrategy negativeBallanceFee, FeeStrategy complaintFee, FeeStrategy buyingFee, FeeStrategy withdrawFee, FeeStrategy chequeFee, FeeStrategy repaymentFee, FeeStrategy depositOperationFee, FeeStrategy magneticSuppportFee, FeeStrategy paperFee, FeeStrategy terminalFee, FeeStrategy buyingFeePercentage, Office office, Bank bank, String accountnumber) throws MalformedHandlerException {
        super(office, bank, accountnumber);
        this.interest = interest;
        this.administrationWage = administrationWage;
        this.anualInterest = anualInterest;
        this.administrationFee = administrationFee;
        this.negativeBallanceFee = negativeBallanceFee;
        this.complaintFee = complaintFee;
        this.buyingFee = buyingFee;
        this.withdrawFee = withdrawFee;
        this.chequeFee = chequeFee;
        this.repaymentFee = repaymentFee;
        this.depositOperationFee = depositOperationFee;
        this.magneticSuppportFee = magneticSuppportFee;
        this.paperFee = paperFee;
        this.terminalFee = terminalFee;
        this.buyingFeePercentage = buyingFeePercentage;
    }

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


    public void setInterest(FeeStrategy interest) {
        this.interest = interest;
    }

    public void setAdministrationWage(FeeStrategy administrationWage) {
        this.administrationWage = administrationWage;
    }

    public void setAnualInterest(FeeStrategy anualInterest) {
        this.anualInterest = anualInterest;
    }

    public void setAdministrationFee(FeeStrategy administrationFee) {
        this.administrationFee = administrationFee;
    }

    public void setNegativeBallanceFee(FeeStrategy negativeBallanceFee) {
        this.negativeBallanceFee = negativeBallanceFee;
    }

    public void setComplaintFee(FeeStrategy complaintFee) {
        this.complaintFee = complaintFee;
    }

    public void setBuyingFee(FeeStrategy buyingFee) {
        this.buyingFee = buyingFee;
    }

    public void setWithdrawFee(FeeStrategy withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    public void setChequeFee(FeeStrategy chequeFee) {
        this.chequeFee = chequeFee;
    }

    public void setRepaymentFee(FeeStrategy repaymentFee) {
        this.repaymentFee = repaymentFee;
    }

    public void setDepositOperationFee(FeeStrategy depositOperationFee) {
        this.depositOperationFee = depositOperationFee;
    }

    public void setMagneticSuppportFee(FeeStrategy magneticSuppportFee) {
        this.magneticSuppportFee = magneticSuppportFee;
    }

    public void setPaperFee(FeeStrategy paperFee) {
        this.paperFee = paperFee;
    }

    public void setTerminalFee(FeeStrategy terminalFee) {
        this.terminalFee = terminalFee;
    }

    public void setBuyingFeePercentage(FeeStrategy buyingFeePercentage) {
        this.buyingFeePercentage = buyingFeePercentage;
    }
}
