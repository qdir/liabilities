/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.conditions.WrongArgsException;
import es.unileon.ulebank.history.iterator.IteratorBetweenTwoDates;

/**
 *
 * @author runix
 */
public class CommandFilterTransactionByDates implements Command {

	private final Date min;
	private final Date max;
	private Iterator<Transaction> iteratorFiltered;
	private List<Transaction> result;
	private final Handler commandId;

	public CommandFilterTransactionByDates(Date min, Date max,
			List<Transaction> transactions, Handler commandId)
			throws WrongArgsException {
		this(min, max, transactions.iterator(), commandId);
	}

	public CommandFilterTransactionByDates(Date min, Date max,
			Iterator<Transaction> iterator, Handler commandId)
			throws WrongArgsException {
		this.min = min;
		this.max = max;
		this.commandId = commandId;
		this.result = new ArrayList<Transaction>();
		this.iteratorFiltered = new IteratorBetweenTwoDates<Transaction>(
				iterator, min.getTime(), max.getTime());
	}

	@Override
	public Handler getID() {
		return this.commandId;
	}

	@Override
	public void execute() {
		if (this.result.size() == 0) {
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
