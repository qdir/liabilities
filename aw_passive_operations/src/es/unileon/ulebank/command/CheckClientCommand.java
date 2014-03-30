/* Application developed for AW subject, belonging to passive operations
 group.*/
    
package es.unileon.ulebank.command;

import es.unileon.ulebank.client.handler.PersonHandler;
import es.unileon.ulebank.handler.MalformedHandlerException;

/**
 *
 * @author Paula
 */
                /****DUDOSO****/
            
public class CheckClientCommand implements Command{
         private PersonHandler nif;
        
    
        public CheckClientCommand (int dni, char letter) throws MalformedHandlerException{
            
            this.nif=new PersonHandler(dni, letter);
        }
    
    
    @Override
    public void execute() {
             this.nif.compareTo(nif);
    }
    
}
