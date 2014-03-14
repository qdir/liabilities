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
        titularAccounts = new ArrayList<Account>();
        authorizedAccounts = new ArrayList<Account>();
    }
    
    public void addTitularAccount(Account account){
        if(!titularAccounts.contains(account)){
            titularAccounts.add(account);
        }
    }
    
    public void addAuthorizedAccount(Account account){
        if(!authorizedAccounts.contains(account)){
            authorizedAccounts.add(account);
        }
    }
    
    public boolean removeTitularAccount(Handler accountHandler){
        boolean result = false;
        for(int i=0; i<titularAccounts.size(); i++){
            Account account = titularAccounts.get(i);
            if(account.getID().compareTo(accountHandler)==0){
                result = titularAccounts.remove(account);
            }
        }
        return result;
    }
    
    public boolean removeAuthorizedAccount(Handler accountHandler){
        boolean result = false;
        for(int i=0; i<authorizedAccounts.size(); i++){
            Account account = authorizedAccounts.get(i);
            if(account.getID().compareTo(accountHandler)==0){
                result = authorizedAccounts.remove(account);
            }
        }
        return result;
    }
    
    public boolean existsTitularAccount(Handler accountHandler){
        boolean result = false;
        for(int i=0; i<titularAccounts.size(); i++){
            Account account = titularAccounts.get(i);
            if(account.getID().compareTo(accountHandler)==0){
                result = true;
            }
        }
        return result;
    }
    
    public boolean existsAuthorizedAccount(Handler accountHandler){
        boolean result = false;
        for(int i=0; i<authorizedAccounts.size(); i++){
            Account account = authorizedAccounts.get(i);
            if(account.getID().compareTo(accountHandler)==0){
                result = true;
            }
        }
        return result;
    }
}
