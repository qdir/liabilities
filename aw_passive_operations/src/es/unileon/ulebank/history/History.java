package es.unileon.ulebank.history;

import es.unileon.ulebank.history.conditions.ConditionFactory;
import es.unileon.ulebank.history.conditions.WrongArgsException;
import es.unileon.ulebank.iterator.Condition;
import es.unileon.ulebank.iterator.ConditionalIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author roobre
 * @param <T>
 */
public abstract class History<T extends Transaction> {

    /**
     * Delete the spaces in the iterator args
     *
     * @param args ( arguments to trim )
     *
     * @return
     */
    private static String[] correctArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            args[i] = args[i].trim();
        }
        return args;
    }

    private final Collection<T> transactions;
    private final ConditionFactory<T> conditionFactory;

    /**
     *
     */
    public History() {
        this.transactions = new ArrayList();
        this.conditionFactory = ConditionFactory.getInstance();
    }

    /**
     *
     * @param transaction
     * @return
     */
    public boolean addTransaction(T transaction) {
        return this.transactions.add(transaction);
    }

    /**
     * Get the iterator for the history. With the args we can specify conditions
     * for include or exclude dates. The available args are : {include day, date
     * in millis } {exclude day, date in millis } {between, date in millis, date
     * in millis } {notBetween, date in millis, date in millis } {from, date in
     * millis } {after, date in millis }
     *
     * Note, all commands start with - , example -include, -exclude..
     *
     * The args can be combined, for example if we want the dates between 0 and
     * 100000000 and exclude the day 3000000.
     *
     * {"-between","0","100000000","-exclude",3000000}
     *
     * If we only want to iterate for all elements we can specify {} args or
     * null
     *
     * @param args ( iterator args )
     * @return ( The iterator )
     * @author runix
     */
    public Iterator<T> getIterator(String[] args) {
        int i = 0;
        final List<Condition<T>> conditions = new ArrayList<>();
        boolean malformed = false;
        if (args != null) {
            args = correctArgs(args);
            while (i < args.length && !malformed) {
                if (args[i++].startsWith("-")) {
                    final int leftPivot = i;
                    while (i < args.length && !args[i].startsWith("-")) {
                        i++;
                    }
                    String[] arg = new String[i - leftPivot];
                    System.arraycopy(args, leftPivot, arg, 0, i - leftPivot);
                    try {
                        Condition<T> condition = this.conditionFactory.getCondition(args[leftPivot - 1], arg);
                        if (condition != null) {
                            conditions.add(condition);
                        } else {
                            malformed = true;
                        }
                    } catch (WrongArgsException w) {
                        malformed = true;
                    }
                } else {
                    malformed = true;
                }
            }
        }
        if (malformed) {
            conditions.clear();
        }
        return new ConditionalIterator<>(conditions, new ArrayList<>(this.transactions));
    }

    /**
     *
     * @param t
     * @return
     */
    public boolean remove(T t) {
        return this.transactions.remove(t);
    }
}
