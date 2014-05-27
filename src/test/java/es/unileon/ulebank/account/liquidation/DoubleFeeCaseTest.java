package es.unileon.ulebank.account.liquidation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.Person;
import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.DirectDebitTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionHandlerProvider;
import es.unileon.ulebank.history.conditions.WrongArgsException;
import es.unileon.ulebank.office.Office;

public class DoubleFeeCaseTest {

	private Features<Double> features;

	private String amountFormula;

	private String subject;

	private Account account;

	private Office office;

	private Bank bank;

	private Client titular;

	private DoubleFeeCase feeCase;

	@Before
	public void setUp() throws MalformedHandlerException, WrongArgsException,
			InvalidCondition, TransactionException {
		bank = new Bank(new GenericHandler("1234"));
		office = new Office(new GenericHandler("1234"), bank);
		titular = new Person(74484986, 'S');
		account = new Account(office, bank, office.getNewAccountNumber(),
				titular);
		features = new Features<Double>();
		this.amountFormula = "2*3";
		this.subject = "subject";
		feeCase = new DoubleFeeCase(features, amountFormula, subject, account);
		for (int i = 0; i < 10; i++) {
			account.doDirectDebit(getTransaction(subject, i, new Date()));
		}
	}

	@Test
	public void testTrigger() throws InvalidCondition {
		assertTrue(feeCase.triggerCase());
		feeCase.addConditionEquation("1", '<', "2");
		assertTrue(feeCase.triggerCase());
		feeCase.addConditionEquation("3", '>', "2");
		assertTrue(feeCase.triggerCase());
	}

	@Test(expected = InvalidCondition.class)
	public void testTriggerErrorComparator() throws InvalidCondition {
		feeCase.addConditionEquation("1", '!', "1");
	}

	@Test(expected = InvalidCondition.class)
	public void testTriggerErrorLeftOperand() throws InvalidCondition {
		feeCase.addConditionEquation("a", '=', "1");
	}

	@Test(expected = InvalidCondition.class)
	public void testTriggerErrorRightOperand() throws InvalidCondition {
		feeCase.addConditionEquation("1", '=', "a");
	}

	@Test
	public void testCalculateAmount() throws TransactionException {
		Transaction t = feeCase.calculateAmount();
		assertNotNull(t);
		assertEquals(t.getAmount(),6, Math.pow(10, -6));
		assertEquals(subject, t.getSubject());
	}
	
	@Test
	public void testCalculateAmountNotTrigger() throws TransactionException, InvalidCondition {
		feeCase.addConditionEquation("1", '>', "2");
		assertFalse(feeCase.triggerCase());
		Transaction t =feeCase.calculateAmount();
		assertNull(t);
	}

	public DirectDebitTransaction getTransaction(String subject, double amount,
			Date date) throws TransactionException {
		DirectDebitTransaction dt = new DirectDebitTransaction(amount, date,
				subject, TransactionHandlerProvider.getTransactionHandler());
		return dt;
	}

}
