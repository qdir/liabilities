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

    /**
     * The office
     */
    private Office office;
    /**
     * The account number, the number of digits of this number is given by 
     * {@see ACCOUNT_NUMBER_LENGHT}
     */
    private final int accountNumber;
    
    /**
     * the number of digits 
     */
    private static final int ACCOUNT_NUMBER_LENGTH = 10;
    
    /**
     * Create a new AccountHandler
     * 
     * @param office ( the office of thea account ) 
     * @param accountNumber ( the account number )
     * 
     * @throws MalformedHandlerException ( If the account number isn't
     * correct )
     */
    public AccountHandler(Office office, int accountNumber) throws MalformedHandlerException {
        StringBuilder errors = new StringBuilder();
        if((accountNumber+"").length() != ACCOUNT_NUMBER_LENGTH) {
            errors.append("The accountNumber length must be "+ACCOUNT_NUMBER_LENGTH+"\n");
        }
        
        if(errors.length() > 1){
            throw new MalformedHandlerException(errors.toString());
        }
        this.accountNumber = accountNumber;
    }
    
    @Override
    public int compareTo(Handler another) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
     
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
