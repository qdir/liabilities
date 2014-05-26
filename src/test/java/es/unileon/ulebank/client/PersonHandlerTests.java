package es.unileon.ulebank.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.MalformedHandlerException;

public class PersonHandlerTests {

	@Test
	public void testCreatePersonHandlerOk() throws MalformedHandlerException {
		new PersonHandler(74484986, 'S');
	}

	@Test(expected=MalformedHandlerException.class)
	public void testCreatePersonHandlerNotOk() throws MalformedHandlerException {
		new PersonHandler(74484986, 'A');
	}

	@Test
	public void testCreatePersonHandlerForeignOk()
			throws MalformedHandlerException {
		new PersonHandler('X',74484986, 'S');
	}

	@Test(expected=MalformedHandlerException.class)
	public void testCreatePersonHandlerForeignNotOk()
			throws MalformedHandlerException {
		new PersonHandler('M', 74484986, 'S');
	}
	
	public void testCreatePersonHandlerForeignNotOkY()
			throws MalformedHandlerException {
		new PersonHandler('Y', 74484986, 'Y');
	}

	
	public void testCreatePersonHandlerForeignNotOkZ()
			throws MalformedHandlerException {
		new PersonHandler('Z', 74484986, 'C');
	}
	
	@Test
	public void testToString() throws MalformedHandlerException {
		PersonHandler ph = new PersonHandler('Z', 74484986, 'C');
		assertEquals("Z74484986C",ph.toString());
	}

	@Test
	public void testCompareTo() throws MalformedHandlerException{
		PersonHandler ph = new PersonHandler('Z', 74484986, 'C');
		assertEquals(ph.compareTo(new GenericHandler("Z74484986C")),0);
		assertNotSame(ph.compareTo(new GenericHandler("Z74184986C")),0);
	}

}
