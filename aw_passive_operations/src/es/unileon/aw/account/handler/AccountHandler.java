/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.account.handler;

import es.unileon.aw.office.Office;
import es.unileon.aw.handler.Handler;
import es.unileon.aw.handler.MalformedHandlerException;

/**
 *
 * @author runix
 */
public class AccountHandler implements Handler {

    private Office office;
    private static final int ACCOUNT_NUMBER_LENGTH = 10;
    
    public AccountHandler(Office office, int accountNumber) throws MalformedHandlerException {
        StringBuilder errors = new StringBuilder();
        if((accountNumber+"").length() != ACCOUNT_NUMBER_LENGTH) {
            errors.append("The accountNumber length must be "+ACCOUNT_NUMBER_LENGTH+"\n");
        }
        
        if(errors.length() > 1){
            throw new MalformedHandlerException(errors.toString());
        }
    }
    
    @Override
    public int compareTo(Handler another) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
      
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
