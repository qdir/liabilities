/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.iterator;

import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.conditions.ConditionTransactionBetweenTwoDates;
import es.unileon.ulebank.history.conditions.WrongArgsException;
import es.unileon.ulebank.iterator.Condition;
import es.unileon.ulebank.iterator.ConditionalIterator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author runix
 * @param <T>
 */
public class IteratorBetweenTwoDates<T extends Transaction> extends ConditionalIterator<T> {

    public IteratorBetweenTwoDates(List<Condition<T>> conditions, List<T> elements, long lowDate, long highDate, boolean dayValid) throws WrongArgsException {
        super(new ConditionTransactionBetweenTwoDates<T>(new Date(lowDate), new Date(highDate), dayValid), elements);
    }
}
