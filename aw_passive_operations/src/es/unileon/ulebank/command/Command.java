/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.command;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import java.util.Date;

/**
 *
 * @author Paula
 */
public interface Command {
 
    public Date getEffectiveDate();

    public Handler getID();

    public void execute() throws MalformedHandlerException;

    public void undo();
    
    public void redo();
   
}
