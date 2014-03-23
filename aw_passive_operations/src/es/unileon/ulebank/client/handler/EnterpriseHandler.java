/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.client.handler;

import es.unileon.ulebank.handler.Handler;

/**
 *
 * @author Gonzalo
 */
public class EnterpriseHandler implements Handler{

    char letter;
    int cif;

    public EnterpriseHandler(char letter, int cif) {
        this.letter=letter;
        this.cif = cif;
    }
    
    @Override
    public int compareTo(Handler another) {
        return toString().compareTo(another.toString());
    }
    
    @Override
    public String toString(){
        return letter + Integer.toString(cif);
    }
    
}
