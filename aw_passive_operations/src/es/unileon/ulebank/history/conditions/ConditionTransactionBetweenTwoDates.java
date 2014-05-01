/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.conditions;

import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.iterator.Condition;
import java.util.Date;

/**
 *
 * @author runix
 * @param <T>
 */
public class ConditionTransactionBetweenTwoDates<T extends Transaction> implements Condition<T> {

    private final long timestampLess;
    private final long timestampHigher;
    private final boolean isValid;

    /**
     *
     * @param less
     * @param high
     * @param isValid
     * @throws WrongArgsException
     */
    public ConditionTransactionBetweenTwoDates(Date less, Date high, boolean isValid) throws WrongArgsException {
        this.timestampLess = less.getTime();
        this.timestampHigher = high.getTime();
        if(this.timestampLess > this.timestampHigher) {
            throw new WrongArgsException("Less date is higher than the high");
        }
        this.isValid = isValid;
    }

    @Override
    public boolean test(T t) {
        final long timestamp = t.getEffectiveDate().getTime();
        return (this.timestampLess <= timestamp && timestamp <= this.timestampHigher) == isValid;
    }

    @Override
    public boolean isExclusive() {
        return !this.isValid;
    }

}
