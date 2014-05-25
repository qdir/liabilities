package es.unileon.ulebank.client;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.handler.GenericHandler;

public class EnterpriseTest {

	private Enterprise enterprise;
	private Address address;
	private Person person;
	
	@Before
	public void setUp() throws Exception {
		
		address = new Address("Street", 4, 2, 'A', "Locality", "Province", 24000);
		enterprise = new Enterprise('Q', 6582297, 'E', "enterpriseName", address);
		person = new Person(98765432, 'M');
	}

	@Test
	public void testAddAuthorizedPerson() {
		
		enterprise.addAuthorizedPerson(person);
		assertTrue(enterprise.existsAuthorizedPerson(new GenericHandler("98765432M")));
	}

	@Test
	public void testRemoveAuthorizedPerson() {
		
		enterprise.addAuthorizedPerson(person);
		assertTrue(enterprise.existsAuthorizedPerson(new GenericHandler("98765432M")));
		enterprise.removeAuthorizedPerson(new GenericHandler("98765432M"));
		assertFalse(enterprise.existsAuthorizedPerson(new GenericHandler("98765432M")));
	}

	@Test
	public void testExistsAuthorizedPerson() {
		
		enterprise.addAuthorizedPerson(person);
		assertTrue(enterprise.existsAuthorizedPerson(new GenericHandler("98765432M")));
	}

	@Test
	public void testGetEnterpriseName() {
		
		assertTrue(enterprise.getEnterpriseName().equals("enterpriseName"));
		enterprise.setEnterpriseName("Banco");
		assertTrue(enterprise.getEnterpriseName().equals("Banco"));
	}

	@Test
	public void testGetAddress() {
		
		assertNotNull(enterprise.getAddress()); 
		address = new Address("Calle", 3, 4, 'A', "Leon", "Provincia Leon", 25000);
		enterprise.setAddress(address);
		assertTrue(enterprise.getAddress().getStreet().equals("Calle"));
		assertTrue(enterprise.getAddress().getLocality().equals("Leon"));
		assertTrue(enterprise.getAddress().getProvince().equals("Provincia Leon"));
		assertTrue(String.valueOf(enterprise.getAddress().getDoor()).equals("A"));
		assertEquals(3, enterprise.getAddress().getBlockNumber(), 0);
		assertEquals(4, enterprise.getAddress().getFloor(), 0);
		assertEquals(25000, enterprise.getAddress().getZipCode(), 0);
		
	}
}
