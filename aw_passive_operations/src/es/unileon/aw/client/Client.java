/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.client;

import java.util.ArrayList;
import es.unileon.aw.account.Account;
import es.unileon.aw.handler.Handler;

/**
 *
 * @author Gonzalo
 */
public class Client {
    ArrayList<Account> titularAccounts;
    ArrayList<Account> authorizedAccounts;
    
    public Client(){
        
    }
    
    public boolean addTitularAccount(Account account){
        return false;
    }
    
    public boolean addAuthorizedAccount(Account account){
        return false;
    }
    
    public boolean removeTitularAccount(Handler accountHandler){
        return false;
    }
    
    public boolean removeAuthorizedAccount(Handler accountHandler){
        return false;
    }
}
