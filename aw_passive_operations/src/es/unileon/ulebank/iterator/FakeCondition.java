/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.iterator;

/**
 * This class is a empty condition. This condition only return the values that
 * you set in the constructor.
 *
 * @author runix
 * @param <T>
 */
public class FakeCondition<T> implements Condition<T> {

    private final boolean test;

    /**
     *
     * @param test
     */
    public FakeCondition(boolean test) {
        this.test = test;
    }

    /**
     * Return test value
     *
     * @param t (not used)
     *
     * @return (test)
     */
    @Override
    public boolean test(T t) {
        return this.test;
    }

}
