package es.unileon.ulebank.account;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DetailedInformationTest {

	private DetailedInformation fromEmpty;
	private DetailedInformation detailed;
	
	@Before
	public void setUp() throws Exception {
		this.fromEmpty = new DetailedInformation();
		this.detailed = new DetailedInformation("");
	}

	@Test
	public void testAppend() {
		String toAppend = "Text to append";
		this.fromEmpty.appendInformation(toAppend);
		this.detailed.appendInformation(toAppend);
		assertEquals(this.fromEmpty.toString().equals(toAppend),true);
		assertEquals(this.detailed.toString().equals(toAppend),true);
		String toAppend2 = "Second case...";
		this.fromEmpty.appendInformation(toAppend2);
		this.detailed.appendInformation(toAppend2);
		assertEquals(this.fromEmpty.toString().equals(toAppend+toAppend2),true);
		assertEquals(this.detailed.toString().equals(toAppend+toAppend2),true);
	}
	
	@Test
	public void testAppendWithFinal() {
		String toAppend = "Text to append";
		this.fromEmpty.appendInformation(toAppend);
		this.detailed.appendInformation(toAppend);
		assertEquals(this.fromEmpty.toString().equals(toAppend),true);
		assertEquals(this.detailed.toString().equals(toAppend),true);
		String toAppend2 = "Second case...";
		this.fromEmpty.appendInformation(toAppend2);
		this.detailed.appendInformation(toAppend2);
		assertEquals(this.fromEmpty.toString().equals(toAppend+toAppend2),true);
		assertEquals(this.detailed.toString().equals(toAppend+toAppend2),true);
		this.detailed.doFinal();
		this.fromEmpty.doFinal();
		this.fromEmpty.appendInformation(toAppend);
		this.detailed.appendInformation(toAppend);
		this.fromEmpty.appendInformation(toAppend2);
		this.detailed.appendInformation(toAppend2);
		assertEquals(this.fromEmpty.toString().equals(toAppend+toAppend2),true);
		assertEquals(this.detailed.toString().equals(toAppend+toAppend2),true);
	}
	
	

}
