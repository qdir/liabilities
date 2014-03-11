/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.aw.handler;

/**
 *
 * @author runix
 *
 */
public class GenericHandler implements Handler {

    /**
     * Generic id
     */
    private String id;

    /**
     * Create a new Generic Handler
     *
     * @param id (The id)3
     * @author runix
     */
    public GenericHandler(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(Handler another) {
        return this.id.compareTo(id);
    }

    @Override
    public String toString() {
        return this.id;
    }

}
