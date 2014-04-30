/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.iterator;

/**
 * This class represents a condition for the ConditionalIterator and determine
 * if a class(T) can be added or not.
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

    /**
     * If a conditions is exclusive means that exclude other conditions. That
     * is, if a condition is exclusive and when some class is tested return
     * false the class won't be added, by contrast if a condition isn't
     * exclusive and return false the element might be added if other condition
     * return true
     *
     * @return ( true if is exclusive, else false)
     */
    boolean isExclusive();
}
