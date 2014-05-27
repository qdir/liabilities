/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.iterator.IteratorSubject;

/**
 *
 * @author runix
 */
public class CommandFilterTransactionBySubject implements Command {

	private Iterator<Transaction> iteratorFiltered;
	private final Handler commandId;
	private List<Transaction> result;

	public CommandFilterTransactionBySubject(List<Transaction> elems,
			Handler commandId, String subject, boolean isValidSubject) {
		this(elems.iterator(), commandId, subject, isValidSubject);
	}

	public CommandFilterTransactionBySubject(Iterator<Transaction> it,
			Handler commandId, String subject, boolean isValidSubject) {
		this.iteratorFiltered = new IteratorSubject<Transaction>(it, subject,
				isValidSubject);
		this.commandId = commandId;
		this.result = new ArrayList<Transaction>();
	}

	@Override
	public Handler getID() {
		return this.commandId;
	}

	@Override
	public void execute() {
		if (this.result.isEmpty()) {
			while (this.iteratorFiltered.hasNext()) {
				this.result.add(this.iteratorFiltered.next());
			}
		}
	}

	public List<Transaction> getList() {
		return this.result;
	}

	@Override
	public void undo() {

	}

	@Override
	public void redo() {
	}

}
