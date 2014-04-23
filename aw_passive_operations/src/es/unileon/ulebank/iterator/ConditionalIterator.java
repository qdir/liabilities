/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ConditionalIterator<T> implements Iterator<T> {

    private final List<Condition<T>> conditions;
    private final java.util.Iterator<T> elementsIterator;
    private T next;

    public ConditionalIterator(List<Condition<T>> conditions, Collection<T> elements) {
        this.conditions = conditions;
        this.elementsIterator = elements.iterator();
        this.calcNext();
    }

    public ConditionalIterator(List<T> elements) {
        this(new ArrayList<Condition<T>>(), elements);
    }

    @Override
    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public T next() {
        T element = this.next;
        this.calcNext();
        return element;
    }

    private void calcNext() {
        this.next = null;
        boolean done = false;
        while (this.elementsIterator.hasNext() && !done) {
            T actual = this.elementsIterator.next();
            boolean valid = true;
            for (int i = 0; i < this.conditions.size() && valid; i++) {
                if (!this.conditions.get(i).test(actual)) {
                    valid = false;
                }
            }
            if (valid) {
                this.next = actual;
                done = true;
            }
        }
    }
}
