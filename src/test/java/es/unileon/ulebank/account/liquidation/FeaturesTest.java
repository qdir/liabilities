package es.unileon.ulebank.account.liquidation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

public class FeaturesTest {

	private List<String> featureName;
	private Account accountUpdated;
	private Date min;
	private Date max;
	private Office office;
	private Bank bank;
	private Client titular;
	private List<MockFeatureExtractor<String>> mocks;
	private Features<String> features;

	@Before
	public void setUp() throws MalformedHandlerException, WrongArgsException {
		bank = new Bank(new GenericHandler("1234"));
		office = new Office(new GenericHandler("1234"), bank);
		titular = new Person(74484986, 'S');
		accountUpdated = new Account(office, bank,
				office.getNewAccountNumber(), titular);
		min = new Date(1);
		max = new Date(3);
		this.featureName = new ArrayList<String>();
		this.mocks = new ArrayList<MockFeatureExtractor<String>>();
		this.featureName.add("mock");
		this.featureName.add("mock1");
		this.featureName.add("mock2");
		this.featureName.add("mock3");
		this.features = new Features<String>();
		for (String s : this.featureName) {
			MockFeatureExtractor<String> mock = new MockFeatureExtractor<String>(
					s, s, s);
			this.features.addFeature(mock);
			this.mocks.add(mock);
		}
	}

	@Test
	public void testGetNames() {
		String[] names = this.features.getFeaturesNames();
		for (String s : names) {
			assertTrue(this.featureName.remove(s));
		}
		assertEquals(this.featureName.size(), 0);
	}

	@Test
	public void testUpdate() {
		for(MockFeatureExtractor<String> mock : this.mocks) {
			assertEquals(mock.getAccountUpdated(),null);
			assertEquals(mock.getMax(), null);
			assertEquals(mock.getMin(), null);
		}
		this.features.updateFeatures(accountUpdated, min, max);
		for(MockFeatureExtractor<String> mock : this.mocks) {
			assertEquals(mock.getAccountUpdated(),accountUpdated);
			assertEquals(mock.getMax(), max);
			assertEquals(mock.getMin(), min);
		}
	}
	
	@Test
	public void testGetFeatures() {
		this.features.updateFeatures(accountUpdated, min, max);
		Map<String,String> map = this.features.getFeatures();
		for (String s : this.featureName) {
			assertTrue(map.containsKey(s));
			assertTrue(map.containsValue(s));
		}
	}
	
	@Test
	public void testGetRandomFeatures() {
		this.features.updateFeatures(accountUpdated, min, max);
		Map<String,String> map = this.features.generateRandomFeatures();
		for (String s : this.featureName) {
			assertTrue(map.containsKey(s));
			assertTrue(map.containsValue(s));
		}
	}
}
