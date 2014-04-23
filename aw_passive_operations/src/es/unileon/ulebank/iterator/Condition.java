/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.iterator;

/**
 *
 * @author runix
 */
public interface Condition<T> {

    /**
     *
     * @param t (Class to test)
     *
     * @return true if is valid, otherwise false
     */
    boolean test(T t);
}
