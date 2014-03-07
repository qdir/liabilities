
package es.unileon.aw.account;

import es.unileon.aw.account.commands.AccountBridge;
import es.unileon.aw.account.commands.Command;
import es.unileon.aw.office.Office;
import es.unileon.aw.handler.Handler;

/**
 *
 * @author runix
 */
public class Account {
    
    /**
     * The office of the account
     */
    private Office office;
    /**
     * The account identifier
     */
    private Handler id;
    /**
     * The amount of money of the account
     */
    private float money;
    
    /**
     * Create a new account
     * 
     * @param office (The office of the account)
     * 
     * @param accountnumber (the number of the account)
     */
    public Account(Office office, int accountnumber) {
        this.money = 0;
    }
    
    /**
     * 
     * @param command (Commant to execute)
     */
    @SuppressWarnings("Test version")
    public final void executeCommand(Command command) {
        //Check if the command is valid and other security threats ?
        AccountBridge acb = new AccountBridge(money);
        command.execute(acb);
        //Check the data of the bridge, valid continue otherwise exception ?
        // <0 money in a debit account..
        
        //Reload account data
        float tempMoney = acb.getMoney();
        money = tempMoney;  
    }
    
    /**
     * Get the amount of money of the account
     * 
     * @return (the amount of money)
     */
    public final float getAmountOfMoney() {
        return this.money;
    }
    
    /**
     * Get the account ID
     * @return (the account id)
     */
    public final Handler getID() {
        return this.id;
    }
}
