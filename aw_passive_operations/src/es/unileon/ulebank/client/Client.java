/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.client;

import java.util.ArrayList;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.handler.Handler;

/**
 *
 * @author Gonzalo
 */
public class Client {
    private Handler id;
    private ArrayList<Account> titularAccounts;
    private ArrayList<Account> authorizedAccounts;
    
    public Client(Handler clientHandler){
        titularAccounts = new ArrayList<Account>();
        authorizedAccounts = new ArrayList<Account>();
        this.id=clientHandler;
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

    public Handler getId() {
        return id;
    }
    
}
