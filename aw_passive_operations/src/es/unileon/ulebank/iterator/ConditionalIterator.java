/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;

/**
 * This iterator allow to iterate for a list of elements and include those that
 * pass a set of conditions.
 *
 *
 * @author runix
 * @param <T>
 */
public class ConditionalIterator<T> implements Iterator<T> {

    /**
     * Conditions for decide if a element is going to be include or not
     */
    private final List<Condition<T>> conditions;
    /**
     * The iterator for the complete collection
     */
    private final java.util.Iterator<T> elementsIterator;
    /**
     * The next element
     */
    private T next;

    /**
     * Create a new Iterator with the conditions for decide if a determinate
     * element is going to be added or not.
     *
     * @param conditions ( conditions for the elements )
     * @param elements ( elements for the iterator )
     */
    public ConditionalIterator(List<Condition<T>> conditions, Collection<T> elements) {
        this.conditions = conditions;
        this.elementsIterator = elements.iterator();
        this.calcNext();
    }

    /**
     * Create a new Iterator without conditions. All items of the list will be
     * included ( no conditions )
     *
     * @param elements ( elements for the iterator )
     */
    public ConditionalIterator(List<T> elements) {
        this(new ArrayList<Condition<T>>(), elements);
    }

    /**
     * Check if there are more elements in the iterator.
     *
     * @return ( true if there are elements, false otherwise )
     */
    @Override
    public boolean hasNext() {
        return this.next != null;
    }

    /**
     * Get the next element
     *
     * @return (next element)
     */
    @Override
    public T next() {
        T element = this.next;
        this.calcNext();
        return element;
    }

    /**
     * Calculate the next element. The next element won't be necessarily the
     * next element in the original list, the next element will be the next
     * valid element, so the list can has elements yet and any elements of this
     * be valid ( hasNext = false, next null ).
     */
    private void calcNext() {
        this.next = null;
        boolean done = false;
        while (this.elementsIterator.hasNext() && !done) {
            T actual = this.elementsIterator.next();
            boolean valid = true;
            boolean end = false;
            boolean excluyent = false;
            for (int i = 0; i < this.conditions.size() && !end; i++) {
                Condition<T> condition = this.conditions.get(i);
                if (!condition.isExclusive()) {
                    if (!excluyent) {
                        valid = false;
                    }
                    valid |= condition.test(actual);
                    excluyent = true;
                } else {
                    if (!this.conditions.get(i).test(actual)) {
                        end = true;
                        valid = false;
                    }
                }
            }
            if (valid) {
                this.next = actual;
                done = true;
            }
        }
    }

    /**
     * Not supported in this iterator.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
