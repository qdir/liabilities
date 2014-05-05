/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.iterator;

import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import es.unileon.ulebank.history.conditions.ConditionTransactionBetweenTwoDates;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author runix
 */
public class ConditionalIteratorTest {

    private Iterator<Integer> iterator;
    private List<Condition<Integer>> conditions;
    private List<Integer> elemsList;

    @Before
    public void setup() {
        this.elemsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            this.elemsList.add(i + 1);
        }
        this.conditions = new ArrayList<>();
        this.iterator = new ConditionalIterator<>(conditions, elemsList);
    }            
   
}
