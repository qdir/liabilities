/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.command;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.exception.BalanceException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Paula
 */
public class AddBalanceCommand implements Command{
    private Account cuenta;
    private float balance;
    private float amount;
    
    public AddBalanceCommand(float balance, float amount){
        this.balance=balance;
        this.amount=amount;
    }
    
    @Override
    public void execute() {
        try {
            cuenta.addBalance(amount);
        } catch (BalanceException ex) {
            Logger.getLogger(AddBalanceCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
           
  
        
            
    }
    
}
