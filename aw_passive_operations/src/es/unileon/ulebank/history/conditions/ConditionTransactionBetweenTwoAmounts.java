/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.conditions;

import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.iterator.Condition;

/**
 *
 * @author runix
 * @param <T>
 */
public class ConditionTransactionBetweenTwoAmounts<T extends Transaction> implements Condition<T> {

    private long low;
    private long high;
    private boolean exclusive;

    /**
     *
     * @param low
     * @param high
     * @param isValid
     * @throws WrongArgsException
     */
    public ConditionTransactionBetweenTwoAmounts(long low, long high, boolean isValid) throws WrongArgsException {
        if (low > high) {
            throw new WrongArgsException("Low param is higher than high param\n");
        }
        this.low = low;
        this.high = high;
        this.exclusive = !isValid;
    }

    @Override
    public boolean test(T t) {
        double amount = t.getAmount();
        return (this.low <= amount && amount <= this.high) ^ this.exclusive;
    }

    @Override
    public boolean isExclusive() {
        return this.exclusive;
    }

}
