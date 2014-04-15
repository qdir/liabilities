/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.command;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.account.types.AccountType;
import es.unileon.ulebank.account.types.CommercialAccount;
import es.unileon.ulebank.account.types.SightAccount;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;


       /****SIN ACABAR****/

/**
 *
 * @author Paula
 */
public class CreateAccountCommand implements Command{
    
    private Office office;
    private Bank bank;
    private AccountType accountType;
    
    
    
    public CreateAccountCommand(Office office, Bank bank, AccountType accountType){
        
       this.bank = bank;
       this.office = office;
       this.accountType = accountType;
    }
   
    @Override
    public void execute() throws MalformedHandlerException{
        
        Account account = null;
        
        if(this.accountType.equals(AccountType.COMMERCIAL)){
            
            account = new CommercialAccount(this.office, this.bank, this.office.getNewAccountNumber());
        } else if(this.accountType.equals(AccountType.SIGHT)){
            
//            account = new SightAccount(office, bank, null, interest, administrationWage, anualInterest, administrationFee, negativeBallanceFee, complaintFee, buyingFee, withdrawFee, chequeFee, repaymentFee, depositOperationFee, magneticSuppportFee, paperFee, terminalFee, buyingFeePercentage)
        }
        
        this.office.addAccount(account);
        
    }
}
