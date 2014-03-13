/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.client;

import es.unileon.aw.account.Account;
import java.util.ArrayList;

/**
 *
 * @author Gonzalo
 */
public class Client {
    ArrayList<Account> titularAccounts, authorizedAccounts;
    
    public Client() {
        titularAccounts = new ArrayList<Account>();
        authorizedAccounts = new ArrayList<Account>();
    }
    
    public boolean addTitularAccount(Account acount){
        return false;
    }
}
