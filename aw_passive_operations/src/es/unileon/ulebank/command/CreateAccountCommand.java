
package es.unileon.ulebank.command;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountHandler;
import es.unileon.ulebank.account.types.AccountType;
import es.unileon.ulebank.account.types.CommercialAccount;
import es.unileon.ulebank.account.types.SightAccount;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.command.Command;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;
import java.util.Date;


import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountHandler;
import es.unileon.ulebank.account.types.AccountType;
import es.unileon.ulebank.account.types.CommercialAccount;
import es.unileon.ulebank.account.types.SightAccount;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.command.Command;
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
    private Handler accountHandler;
    
    
    
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
            this.accountHandler = account.getID();
        } else if(this.accountType.equals(AccountType.SIGHT)){
            
//            account = new SightAccount(office, bank, null, interest, administrationWage, anualInterest, administrationFee, negativeBallanceFee, complaintFee, buyingFee, withdrawFee, chequeFee, repaymentFee, depositOperationFee, magneticSuppportFee, paperFee, terminalFee, buyingFeePercentage)
        }
        
        this.office.addAccount(account);
        
    }

    @Override
    public Date getEffectiveDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Handler getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Handler getAccountId(){
        return this.accountHandler;
    }
}
