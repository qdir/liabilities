package es.unileon.ulebank.history;

import es.unileon.ulebank.handler.Handler;
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
public class History<T extends Transaction> {

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

    /**
     *
     * @param transaction
     * @return
     */
    public boolean add(T transaction) {
        boolean found = false;
        Iterator<T> it = this.transactions.iterator();
        while (it.hasNext() && !found) {
            T t = it.next();
            if (t.getId().compareTo(transaction.getId()) == 0) {
                found = true;
            }
        }
        if (!found) {
            return this.transactions.add(transaction);
        }
        return false;

    }

    /**
     * Get the iterator for the history. With the args we can specify conditions
     * for include or exclude dates, subjects and amounts.
     *
     * Note, all commands start with - , After the command goes _ and the type.
     *
     * The available commands are :
     *
     * For dates :
     *
     * date_include .........; example => {"-date_include","110000"}
     *
     * date_exclude .........; example => {"-date_exclude","110000"}
     *
     * date_from ............; example => {"-date_from","110000"}
     *
     * date_until ...........; example => {"-date_until","110000"}
     *
     * date_between .........; example => {"-date_between","110000","210000"}
     *
     * date_notBetween ......; example => {"-date_notBetween","110000","210000"}
     *
     * For amounts :
     *
     * amount_from ..........; example => {"-amount_from","110000"}
     *
     * amount_until .........; example => {"-amount_until","110000"}
     *
     * amount_between .......; example => {"-amount_between","110000","210000"}
     *
     * amount_notBetween ....; example => {"-amount_notBetween","1100","210000"}
     *
     * For subjects :
     *
     * subject_contains ......; example => {"-subject_contains","aA"}. with
     * multiple words {"-subject_contains","aA","Bbbbbb"}
     *
     * subject_notContains ...; example => {"-subject_contains","asdasd"}
     *
     *
     * The args can be combined, for example :
     *
     * {"-amount_notBetween","1100","210000",
     * "-subject_contains","asdasd","-date_include","110000"}
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
                    final String[] arg = new String[i - leftPivot];
                    System.arraycopy(args, leftPivot, arg, 0, i - leftPivot);
                    try {
                        final Condition<T> condition = this.conditionFactory.getCondition(args[leftPivot - 1], arg);
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
     * @param id
     * @return
     */
    public boolean remove(Handler id) {
        boolean found = false;
        Iterator<T> it = this.transactions.iterator();
        while (it.hasNext() && !found) {
            T t = it.next();
            if (t.getId().compareTo(id) == 0) {
                found = true;
                this.transactions.remove(t);
            }
        }
        return found;
    }
}
