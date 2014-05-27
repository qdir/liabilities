package es.unileon.ulebank.account.liquidation;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.Person;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.conditions.WrongArgsException;
import es.unileon.ulebank.office.Office;

public class MockFeatureExtractorTest {

	private String feature;
	private String randomFeature;
	private String featureName;
	private Account accountUpdated;
	private Date min;
	private Date max;
	private Office office;
	private Bank bank;
	private Client titular;
	private MockFeatureExtractor<String> mock;

	@Before
	public void setUp() throws MalformedHandlerException, WrongArgsException {
		feature = "nothing";
		randomFeature = "nothingrandom";
		featureName = "interestingFeature";
		bank = new Bank(new GenericHandler("1234"));
		office = new Office(new GenericHandler("1234"), bank);
		titular = new Person(74484986, 'S');
		accountUpdated = new Account(office, bank,
				office.getNewAccountNumber(), titular);
		min = new Date(1);
		max = new Date(3);
		mock = new MockFeatureExtractor<String>(feature, randomFeature,
				featureName);
		mock.updateFeature(accountUpdated, min, max);
	}

	@Test
	public void testGetFeature() {
		assertEquals(feature, mock.getFeature());
	}

	@Test
	public void testGetRandomFeature() {
		assertEquals(randomFeature, mock.generateRandomFeature());
	}

	@Test
	public void testGetUpdateAccount() {
		assertEquals(this.accountUpdated, mock.getAccountUpdated());
	}

	@Test
	public void testGetMinDateUpdate() {
		assertEquals(this.min, mock.getMin());
	}

	@Test
	public void testGetMaxDateUpdate() {
		assertEquals(this.max, mock.getMax());
	}

	@Test
	public void testGetFeatureName() {
		assertEquals(featureName, mock.getFeatureName());
	}

}
