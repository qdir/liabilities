/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Revellado
 */
public class GenericHandlerTest {

	private GenericHandler genericHandler1, genericHandler2;

	@Before
	public void setUp() {

		genericHandler1 = new GenericHandler("0000");
		genericHandler2 = new GenericHandler("0001");
	}

	/**
	 * Test of compareTo method, of class GenericHandler.
	 */
	@Test
	public void testCompareToOk() {
		assertEquals(genericHandler1.compareTo(genericHandler1), 0);
		assertEquals(genericHandler1.compareTo(new GenericHandler("0000")), 0);
		assertEquals(genericHandler1.compareTo(new GenericHandler(
				genericHandler1.toString())), 0);
	}

	@Test
	public void testCompareNotOk() {
		assertFalse(genericHandler1.compareTo(genericHandler2) == 0);
		assertFalse(genericHandler2.compareTo(genericHandler1) == 0);
	}

	/**
	 * Test of toString method, of class GenericHandler.
	 */
	@Test
	public void testToString() {
		assertEquals(genericHandler1.toString(), "0000");
	}
}
