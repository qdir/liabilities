/* Application developed for AW subject, belonging to passive operations
 group.*/
    
package es.unileon.ulebank.command;

import es.unileon.ulebank.client.handler.PersonHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import java.util.Date;

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

    @Override
    public Date getEffectiveDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Handler getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
