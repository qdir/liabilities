package es.unileon.ulebank.history;

import es.unileon.ulebank.iterator.Condition;
import es.unileon.ulebank.iterator.ConditionalIterator;
import es.unileon.ulebank.iterator.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author roobre
 * @param <T>
 */
public abstract class History<T extends Transaction> {

    private final Collection<T> transactions;

    public History() {
        this.transactions = new ArrayList();
    }

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
     * The args can be combined, for example if we want the dates between 0 and
     * 100000000 and exclude the day 3000000.
     *
     * {"between","0","100000000","exclude",3000000}
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
            final Pattern numberPattern = Pattern.compile("^[0-9]*$");
            Matcher matcher;
            args = correctArgs(args);
            while (i < args.length && !malformed) {
                if (args[i++].startsWith("-")) {
                    final int leftPivot = i - 1;
                    while (i < args.length && !args[i].startsWith("-")) {
                        ++i;
                    }
                    String[] arg = new String[i - leftPivot];
                    System.arraycopy(args, leftPivot, arg, 0, i - leftPivot);
//                    conditions.add(ConditionFactory.getCondition(arg))
                } else {
                    malformed = true;
                }
            }
        }
        if (malformed) {
            conditions.clear();
        }
        return new ConditionalIterator<>(conditions, this.getTransactions());
    }

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

    public boolean remove(T t) {
        return this.transactions.remove(t);
    }

    public Collection<T> getTransactions() {
        return new ArrayList<>(this.transactions);
    }
}
