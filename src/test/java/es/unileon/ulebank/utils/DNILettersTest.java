package es.unileon.ulebank.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DNILettersTest {


	@Test
	public void tesDNI() {
		assertEquals(DniLetters.getInstance().isDniValid(6907700,'H'),true);
		assertEquals(DniLetters.getInstance().isDniValid(91481910,'P'),true);
		assertEquals(DniLetters.getInstance().isDniValid(99617625,'W'),true);
		assertEquals(DniLetters.getInstance().isDniValid(81008615,'Q'),true);
		assertEquals(DniLetters.getInstance().isDniValid(84424612,'F'),true);
		assertEquals(DniLetters.getInstance().isDniValid(47838005,'Y'),true);
		assertEquals(DniLetters.getInstance().isDniValid(29380649,'N'),true);
		assertEquals(DniLetters.getInstance().isDniValid(89963984,'J'),true);
		assertEquals(DniLetters.getInstance().isDniValid(49554503,'Z'),true);
		assertEquals(DniLetters.getInstance().isDniValid(35925348,'S'),true);
		assertEquals(DniLetters.getInstance().isDniValid(82648552,'F'),true);
		assertEquals(DniLetters.getInstance().isDniValid(61320031,'F'),true);
		assertEquals(DniLetters.getInstance().isDniValid(76441858,'R'),true);
		assertEquals(DniLetters.getInstance().isDniValid(20765371,'M'),true);
		assertEquals(DniLetters.getInstance().isDniValid(90444550,'V'),true);
		assertEquals(DniLetters.getInstance().isDniValid(9789678,'G'),true);
		assertEquals(DniLetters.getInstance().isDniValid(75360404,'F'),true);
		assertEquals(DniLetters.getInstance().isDniValid(43773308,'F'),true);
		assertEquals(DniLetters.getInstance().isDniValid(49251342,'Q'),true);
		assertEquals(DniLetters.getInstance().isDniValid(6419148,'D'),true);
		assertEquals(DniLetters.getInstance().isDniValid(13342143,'G'),true);
		assertEquals(DniLetters.getInstance().isDniValid(79506018,'D'),true);
		assertEquals(DniLetters.getInstance().isDniValid(58774021,'M'),true);
		assertEquals(DniLetters.getInstance().isDniValid(9139728,'B'),true);
		assertEquals(DniLetters.getInstance().isDniValid(59790203,'R'),true);
		assertEquals(DniLetters.getInstance().isDniValid(50611466,'N'),true);
		assertEquals(DniLetters.getInstance().isDniValid(83528034,'S'),true);
		assertEquals(DniLetters.getInstance().isDniValid(27674537,'V'),true);
		assertEquals(DniLetters.getInstance().isDniValid(67327369,'K'),true);
		assertNotSame(DniLetters.getInstance().isDniValid(12314, 'z'),true);
		assertNotSame(DniLetters.getInstance().isDniValid(1231234, 'z'),true);
		assertNotSame(DniLetters.getInstance().isDniValid(112312314, 'z'),true);
		assertEquals(DniLetters.getInstance().isDniValid(1000000000, 'A'),false);
		assertEquals(DniLetters.getInstance().isDniValid(1000000000, 'C'),false);
		assertEquals(DniLetters.getInstance().isDniValid(10000000, 'Z'),true);
	}

}
