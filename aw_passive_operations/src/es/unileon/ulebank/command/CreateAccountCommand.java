/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.command;

import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.office.Office;

/**
 *
 * @author Paula
 */
public class CreateAccountCommand implements Command{
    private Handler id;
    private String accountNumber;
    private Office office;
    private final Bank bank;
    
    
    public CreateAccountCommand(Bank bank, Office office, String accountNumber){
        this.accountNumber= accountNumber;
        this.office=office;
        this.bank=bank;
}
    
    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
