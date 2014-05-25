package es.unileon.ulebank.command;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Address;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;

public class CreateClientCommandTest {

	CreateClientCommand createClientCommand;
	Office office;
	Bank bank;
	Address address;
	
	@Before
	public void setUp() throws MalformedHandlerException {
		
		bank = new Bank(new GenericHandler("1234"));
		office = new Office(new GenericHandler("1234"), this.bank);
		address = new Address("Street", 4, 2, 'A', "Locality", "Province", 24000);
		
		createClientCommand = new CreateClientCommand(office, "Name", "Surnames", address, "Civil State", 999999999, 999999999, "Profession", new Date(), 'X', 71525252, 'J', new GenericHandler("2345"));		
	}
	
	@Test
	public void testExecute() {
		
		Handler clientId = new GenericHandler("X71525252J");
		createClientCommand.execute();
		assertEquals(0, office.getClients().get(0).getId().compareTo(clientId),0);
	}
	
//	@Test(expected = MalformedHandlerException.class)
//	public void testWrongStateExecute() throws MalformedHandlerException{
//	
//		createClientCommand = new CreateClientCommand(office, "Name", "Surnames", address, "Civil State", 999999999, 999999999, "Profession", new Date(), 'X', 7155252, 'J', new GenericHandler("2345"));
//	}
	
	@Test
	public void testGetId() {
		
		Handler commandId = new GenericHandler("2345");
		assertEquals(0, createClientCommand.getID().compareTo(commandId), 0);
	}

	@Test
	public void testUndo() {
		
		Handler clientId = new GenericHandler("X71525252J");
		createClientCommand.execute();
		assertEquals(0, office.getClients().get(0).getId().compareTo(clientId),0);
		createClientCommand.undo();
		assertEquals(0, office.getClients().size(),0);
	}
	

	@Test
	public void testNullClientUndo() {

		createClientCommand.undo();
	}
	
	@Test
	public void testRedo() {
		
		Handler clientId = new GenericHandler("X71525252J");
		createClientCommand.execute();
		assertEquals(0, office.getClients().get(0).getId().compareTo(clientId),0);
		createClientCommand.undo();
		assertEquals(0, office.getClients().size(),0);
		createClientCommand.redo();
		assertEquals(0, office.getClients().get(0).getId().compareTo(clientId),0);
	}
	

	@Test
	public void testWrongStateUndo() {
		
		createClientCommand.redo();
		assertEquals(0, office.getClients().size(),0);
	}
}
