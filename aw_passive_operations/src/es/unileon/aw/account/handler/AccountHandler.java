/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.account.handler;

import es.unileon.aw.office.Office;
import es.unileon.aw.handler.Handler;

/**
 *
 * @author runix
 */
public class AccountHandler implements Handler {

    private Office office;
    
    public AccountHandler(Office office) {
        
    }
    
    @Override
    public int compareTo(Handler another) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
      
}
