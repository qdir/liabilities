/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.conditions;

import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.iterator.Condition;

/**
 *
 * @author runix
 */
public class ConditionFactory<T extends Transaction> {

    public Condition<T> getCondition(String condition, String[] args) throws WrongArgsException {
        return null;
    }
}
