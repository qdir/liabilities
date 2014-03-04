
package es.unileon.aw.account;

import es.unileon.aw.account.commands.AccountBridge;
import es.unileon.aw.account.commands.Command;
import es.unileon.aw.office.Office;
import es.unileon.handler.Handler;

/**
 *
 * @author runix
 */
public class Account {
    
    
    private Office office;
    private Handler handler;
    
    
    public Account(Office office) {
        
    }
    
    public void executeCommand(Command command) {
        //Check if the command is valid and other security threats
        command.execute(new AccountBridge());
        //Check the data of the bridge, valid continue otherwise exception
        //Reload account data
        throw new UnsupportedOperationException("Not supported yet");
    }
}
