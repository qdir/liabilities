/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.command;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.office.Office;


       /****SIN ACABAR****/

/**
 *
 * @author Paula
 */
public abstract class CreateAccountCommand implements Command{
    private AccountHandler accountNumber;
    private Office office;
    private Bank bank;
    private AccountHandler dc;
    
    
    
    public CreateAccountCommand(AccountHandler dc, AccountHandler accountNumber, Office office, Bank bank){
       this.accountNumber = accountNumber;
       this.bank= bank;
       this.office= office;
       this.dc=dc;

    }
   
    @Override
    public void execute() {
     this.bank.getID();
     this.office.getID();
     
     this.accountNumber.toString();
    }

 
    
}
