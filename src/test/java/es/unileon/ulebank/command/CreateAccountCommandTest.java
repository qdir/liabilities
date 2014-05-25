/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.command;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.account.AccountHandler;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.Person;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;

/**
 *
 * @author Tania Pérez
 */
public class CreateAccountCommandTest {

	private Office office;
	private Bank bank;

	@Before
	public void setUp() throws MalformedHandlerException {
		this.bank = new Bank(new GenericHandler("1234"));
		this.office = new Office(new GenericHandler("1234"), this.bank);
	}

	/**
	 * Test of execute method, of class CreateAccountCommand.
	 *
	 * @throws es.unileon.ulebank.handler.MalformedHandlerException
	 */
	@Test
	public void testExecute() throws MalformedHandlerException {
		Client titular = new Person(71525252, 'J');
		CreateAccountCommand command = new CreateAccountCommand(this.office,
				this.bank, new Date(System.currentTimeMillis()),
				new GenericHandler(""), titular);
		command.execute();
		assertEquals(
				((AccountHandler) this.office.getAccounts().get(0).getID())
						.getNumber(),
				"0000000000", "0000000000");
	}
}
