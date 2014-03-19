package es.unileon.ulebank.temporary;

import es.unileon.ulebank.account.*;
import es.unileon.ulebank.account.types.SightAccount;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Temporary class which simulates an Account "Database".
 * Intended for internal use only
 * @author Emanuel Iosif Relea
 */
public class TemporaryAccountData {
    
    private static ArrayList<Account> accountList;
    
    public TemporaryAccountData(){
        
        populateList();
        
    }
    
   /* 
    public static void main(String[] args){
        
        new TemporaryAccountData();
        
        Iterator<Account> it = accountList.iterator();
        
        while(it.hasNext()){
            
            System.out.println(it.next().getID().toString());
    
        }
    }*/
    
    private void populateList(){
        
        accountList = new ArrayList();
        Account account1 = null;
        
        try {
            account1 = new SightAccount(new Office(), new Bank(), "9874455387");
        } catch (MalformedHandlerException ex) {
            ex.printStackTrace();
        }
        
        accountList.add(account1);
        
        try {
            account1 = new SightAccount(new Office(), new Bank(), "7746532199");
        } catch (MalformedHandlerException ex) {
            ex.printStackTrace();
        }
        
        accountList.add(account1);
        
        try {
            account1 = new SightAccount(new Office(), new Bank(), "8874573328");
        } catch (MalformedHandlerException ex) {
            ex.printStackTrace();
        }
        
        accountList.add(account1);
        
    }
    
    /*
    * Getter for account list
    */
    
    public ArrayList<Account> getAccountList(){
        
        return accountList;
        
    }
    
}
