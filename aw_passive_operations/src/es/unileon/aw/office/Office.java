/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.aw.office;

import es.unileon.aw.handler.GenericHandler;
import es.unileon.aw.handler.Handler;

/**
 *
 * @author runix
 */
public class Office {

    @SuppressWarnings("Temporal class")
    public Handler getID() {
        return new GenericHandler("1234");
    }
}
