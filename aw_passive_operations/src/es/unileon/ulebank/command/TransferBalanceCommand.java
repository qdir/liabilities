/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.command;

import es.unileon.ulebank.account.Account;

/**
 *
 * @author Paula
 */
public class TransferBalanceCommand implements Command{
    private float balance;
    private float amount;
    private Account id;
    
public TransferBalanceCommand(float balance, float amount){
    this.balance=balance;
    this.amount=amount;
}

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
