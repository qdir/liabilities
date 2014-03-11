/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.aw.handler;

/**
 *
 * @author runix
 */
public class GenericHandler implements Handler {

    private String id;
    public GenericHandler(String id) {
       this.id = id; 
    }
    
    @Override
    public int compareTo(Handler another) {
       return this.id.compareTo(id);
    }
    
    public String toString() {
        return this.id;
    }
    
}
