/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.office;

import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;

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