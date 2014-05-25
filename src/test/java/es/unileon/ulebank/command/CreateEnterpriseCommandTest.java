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

public class CreateEnterpriseCommandTest {

	private CreateEnterpriseCommand createEnterpriseCommand;
	private Office office;
	private Bank bank;
	private Address address;
	
	@Before
	public void setUp() throws MalformedHandlerException {
		
		bank = new Bank(new GenericHandler("1234"));
		office = new Office(new GenericHandler("1234"), this.bank);
		address = new Address("Street", 4, 2, 'A', "Locality", "Province", 24000);
		
		createEnterpriseCommand = new CreateEnterpriseCommand(office, "enterpriseName", address, 6582297, 'Q', 'E', new Date(),  new GenericHandler("2345"));
	}

	@Test
	public void testExecute() {
		
		Handler clientId = new GenericHandler("Q6582297E");
		createEnterpriseCommand.execute();
		assertEquals(0, office.getClients().get(0).getId().compareTo(clientId),0);
	}
	
	@Test
	public void testGetId() {
		
		Handler commandId = new GenericHandler("2345");
		assertEquals(0, createEnterpriseCommand.getID().compareTo(commandId), 0);
	}
	
	@Test
	public void testUndo() {
		
		Handler clientId = new GenericHandler("Q6582297E");
		createEnterpriseCommand.execute();
		assertEquals(0, office.getClients().get(0).getId().compareTo(clientId),0);
		createEnterpriseCommand.undo();
		assertEquals(0, office.getClients().size(),0);
	}
	

	@Test
	public void testNullClientUndo() {

		createEnterpriseCommand.undo();
	}
	
	@Test
	public void testRedo() {
		
		Handler clientId = new GenericHandler("Q6582297E");
		createEnterpriseCommand.execute();
		assertEquals(0, office.getClients().get(0).getId().compareTo(clientId),0);
		createEnterpriseCommand.undo();
		assertEquals(0, office.getClients().size(),0);
		createEnterpriseCommand.redo();
		assertEquals(0, office.getClients().get(0).getId().compareTo(clientId),0);
	}
	

	@Test
	public void testWrongStateUndo() {
		
		createEnterpriseCommand.redo();
		assertEquals(0, office.getClients().size(),0);
	}
}
