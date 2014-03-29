/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.client;

import java.util.ArrayList;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.handler.Handler;
import java.util.Iterator;

/**
 *
 * @author Gonzalo
 */
public class Client {
    private Handler id;
    private ArrayList<Account> accounts;
    
    public Client(Handler clientHandler){
        accounts = new ArrayList<Account>();
        this.id=clientHandler;
    }
    
    public void add(Account account){
        if(!accounts.contains(account)){
            accounts.add(account);
        }
    }
    
    public boolean removeAccount(Handler accountHandler){
        boolean result = false;
        Iterator<Account> iterator = accounts.iterator();
        while(iterator.hasNext()){
            Account account = iterator.next();
            if(account.getID().compareTo(accountHandler)==0){
                result = accounts.remove(account);
            }
        }
        return result;
    }
    
    public boolean existsAccount(Handler accountHandler){
        boolean result = false;
        Iterator<Account> iterator = accounts.iterator();
        while(iterator.hasNext()){
            Account account = iterator.next();
            if(account.getID().compareTo(accountHandler)==0){
                result = true;
            }
        }
        return result;
    }

    public Handler getId() {
        return id;
    }
    
}
