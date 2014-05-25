/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.conditions.WrongArgsException;
import es.unileon.ulebank.history.iterator.IteratorBetweenTwoAmounts;

/**
 *
 * @author runix
 */
public class CommandFilterTransactionByAmounts implements Command {

	private final double min;
	private final double max;
	private Iterator<Transaction> iteratorFiltered;
	private final Handler commandId;
	private List<Transaction> result;

	public CommandFilterTransactionByAmounts(double min, double max,
			List<Transaction> transactions, Handler commandId)
			throws WrongArgsException {
		this(min, max, transactions.iterator(), commandId);
	}

	public CommandFilterTransactionByAmounts(double min, double max,
			Iterator<Transaction> iterator, Handler commandId)
			throws WrongArgsException {
		this.min = min;
		this.max = max;
		this.commandId = commandId;
		this.iteratorFiltered = new IteratorBetweenTwoAmounts<Transaction>(
				iterator, min, max);
		this.result = new ArrayList<Transaction>();
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
