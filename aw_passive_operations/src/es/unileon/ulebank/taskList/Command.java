/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.taskList;

import es.unileon.ulebank.handler.*;
import java.util.Date;

/**
 *
 * @author runix
 */
public interface Command {
    
    public Date getEffectiveDate();
    
    public Handler getID();

    public void execute();
}
