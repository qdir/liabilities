/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.command;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.conditions.WrongArgsException;
import es.unileon.ulebank.history.iterator.IteratorBetweenTwoDates;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author runix
 */
public class CommandFilterTransactionByDates implements Command {

    private final Date min;
    private final Date max;
    private final Iterator<Transaction> it;
    private Iterator<Transaction> iteratorFiltered;
    private final Handler commandId;

    public CommandFilterTransactionByDates(Date min, Date max, List<Transaction> transactions, Handler commandId) {
        this(min, max, transactions.iterator(), commandId);
    }

    public CommandFilterTransactionByDates(Date min, Date max, Iterator<Transaction> iterator, Handler commandId) {
        this.min = min;
        this.max = max;
        this.it = iterator;
        this.commandId = commandId;
    }

    @Override
    public Handler getID() {
        return this.commandId;
    }

    @Override
    public void execute() {
        try {
            this.iteratorFiltered = new IteratorBetweenTwoDates<Transaction>(it, min.getTime(), max.getTime());
        } catch (WrongArgsException ex) {
            Logger.getLogger(CommandFilterTransactionByDates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Iterator<Transaction> getIterator() {
        return this.iteratorFiltered;
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
