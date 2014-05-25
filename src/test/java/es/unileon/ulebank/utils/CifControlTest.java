package es.unileon.ulebank.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CifControlTest {

	private CifControl cifControl;
	
	@Before
	public void setUp() throws Exception {
		
		cifControl = CifControl.instance();
	}

	@Test
	public void testIsCifValid() {
		assertTrue(cifControl.isCifValid('Q', 65, 82297, 'E'));
		assertFalse(cifControl.isCifValid('H', 23, 54333, 'X'));
	}

}
