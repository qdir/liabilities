package es.unileon.ulebank.account.liquidation.doubleFeatureExtractors;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.liquidation.AbstractFeatureExtractor;
import es.unileon.ulebank.account.liquidation.DoubleFeeCase;
import es.unileon.ulebank.account.liquidation.Features;
import es.unileon.ulebank.account.liquidation.InvalidCondition;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.Person;
import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.DirectDebitTransaction;
import es.unileon.ulebank.history.TransactionHandlerProvider;
import es.unileon.ulebank.history.conditions.WrongArgsException;
import es.unileon.ulebank.office.Office;

public class DoubleFeatureExtractorPayrrolAverageTests {

	private String subject;

	private Account account;

	private Office office;

	private Bank bank;

	private Client titular;

	private AbstractFeatureExtractor<Double> extractor;

	@Before
	public void setUp() throws MalformedHandlerException, WrongArgsException,
			InvalidCondition, TransactionException {
		bank = new Bank(new GenericHandler("1234"));
		office = new Office(new GenericHandler("1234"), bank);
		titular = new Person(74484986, 'S');
		account = new Account(office, bank, office.getNewAccountNumber(),
				titular);
		account.setMaxOverdraft(10000);
		this.subject = "subject";
		for (int i = 0; i < 10; i++) {
			account.doDirectDebit(getTransaction(subject, i % 2 == 0 ? -i : i,
					new Date(i)));
		}
		extractor = new DoubleFeatureExtractorPayrrolAverage();
		assertEquals(extractor.getFeature(), 0.0, Math.pow(10, -5));
		extractor.generateRandomFeature();
		extractor.updateFeature(account, new Date(2), new Date(8));
	}

	@Test
	public void testGetFeature() {
		assertEquals(extractor.getFeature(), 5.0, Math.pow(10, -5));
	}

	public DirectDebitTransaction getTransaction(String subject, double amount,
			Date date) throws TransactionException {
		DirectDebitTransaction dt = new DirectDebitTransaction(amount, date,
				subject, TransactionHandlerProvider.getTransactionHandler());
		dt.setEffectiveDate(date);
		return dt;
	}

}
