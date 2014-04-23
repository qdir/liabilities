/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.iterator;

import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.iterator.Condition;
import java.util.Date;

/**
 *
 * @author runix
 */
public class ConditionTransactionBetweenTwoDates<T extends Transaction> implements Condition<T> {

    private final long timestampLess;
    private final long timestampHigher;
    private final boolean isValid;

    public ConditionTransactionBetweenTwoDates(Date less, Date high, boolean isValid) {
        this.timestampLess = less.getTime();
        this.timestampHigher = high.getTime();
        this.isValid = isValid;
    }

    @Override
    public boolean test(T t) {
        final long timestamp = t.getEffectiveDate().getTime();
        return (this.timestampLess <= timestamp && timestamp <= this.timestampHigher) == isValid;
    }

}
