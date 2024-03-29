/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.command;

import java.util.Date;

import es.unileon.ulebank.account.DetailedInformation;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.Transaction;

/**
 *
 * @author Paula
 */
public class DoTransactionCommand implements Command {

	private final Handler commandID;
	private final double amount;
	private final Date date;
	private final String subject;
	private final DetailedInformation extraInformation;
	private Transaction transaction;
	private final Bank bank;
	private final Handler destine;

	/**
	 *
	 * @param amount
	 * @param date
	 * @param subject
	 * @param info
	 * @param commandId
	 */
	public DoTransactionCommand(Bank bank, double amount, Handler destine,
			Date date, String subject, DetailedInformation info,
			Handler commandId) {
		this.amount = amount;
		this.date = date;
		this.subject = subject;
		this.extraInformation = info;
		this.commandID = commandId;
		this.destine = destine;
		this.bank = bank;
	}

	/**
     *
     */
	@Override
	public void execute() {
//		try {
//			this.transaction = new GenericTransaction(this.amount, this.date,
//					this.subject, this.extraInformation);
//			this.bank.doTransaction(transaction, destine);
//
//		} catch (MalformedHandlerException ex) {
//			Logger.getLogger(DoTransactionCommand.class.getName()).log(
//					Level.SEVERE, null, ex);
//		} catch (TransactionException ex) {
//			Logger.getLogger(DoTransactionCommand.class.getName()).log(
//					Level.SEVERE, null, ex);
//		}
	}

	/**
	 *
	 * @return
	 */
	@Override
	public Handler getID() {
		return this.commandID;
	}

	/**
     *
     */
	@Override
	public void undo() {
	}

	/**
     *
     */
	@Override
	public void redo() {
	}

}
