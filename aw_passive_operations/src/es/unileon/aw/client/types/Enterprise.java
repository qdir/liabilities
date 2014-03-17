/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.client.types;

import es.unileon.aw.client.Client;
import es.unileon.aw.client.handler.EnterpriseHandler;

/**
 *
 * @author Gonzalo
 */
public class Enterprise extends Client{

    public Enterprise(int cifNumber) {
        super(new EnterpriseHandler(cifNumber));
    }
    
    
}
