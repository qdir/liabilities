/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.command;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.iterator.IteratorSubject;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author runix
 */
public class CommandFilterTransactionBySubject implements Command {

    private final Iterator<Transaction> it;
    private Iterator<Transaction> iteratorFiltered;
    private final Handler commandId;
    private final String subject;
    private final boolean isValidSubject;

    public CommandFilterTransactionBySubject(List<Transaction> elems, Handler commandId, String subject, boolean isValidSubject) {
        this(elems.iterator(), commandId, subject, isValidSubject);
    }

    public CommandFilterTransactionBySubject(Iterator<Transaction> it, Handler commandId, String subject, boolean isValidSubject) {
        this.it = it;
        this.commandId = commandId;
        this.isValidSubject = isValidSubject;
        this.subject = subject;
    }

    @Override
    public Handler getID() {
        return this.commandId;
    }

    @Override
    public void execute() {
        this.iteratorFiltered = new IteratorSubject<Transaction>(this.it, this.subject, this.isValidSubject);
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
