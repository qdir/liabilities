package es.unileon.ulebank.history;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.account.DetailedInformation;
import es.unileon.ulebank.exceptions.TransactionException;

public class GenericTransactionTest {

	private String subject;
	private double amount;
	private Date date;
	private static final double EPSILON = Math.pow(10, -10);
	private Transaction generic;
	private Transaction genericWithExtraInfo;
	private Date effectiveDate;
	private String extraInfo;

	@Before
	public void setUp() throws Exception {
		this.extraInfo = "extraInfo";
		this.date = new Date();
		this.effectiveDate = new Date();
		this.amount = 10;
		this.subject = "subject";
		this.generic = new GenericTransaction(amount, date, subject);
		this.genericWithExtraInfo = new GenericTransaction(amount, date,
				subject, new DetailedInformation(extraInfo));
		this.generic.setEffectiveDate(effectiveDate);
		this.genericWithExtraInfo.setEffectiveDate(effectiveDate);
	}

	@Test(expected = TransactionException.class)
	public void testNullSubject() throws TransactionException {
		new GenericTransaction(amount, date, null, new DetailedInformation(
				extraInfo));
	}

	@Test(expected = TransactionException.class)
	public void testNullDate() throws TransactionException {
		new GenericTransaction(amount, null, subject, new DetailedInformation(
				extraInfo));
	}

	@Test(expected = TransactionException.class)
	public void testNullSubjectNullDate() throws TransactionException {
		new GenericTransaction(amount, null, null, new DetailedInformation(
				extraInfo));
	}

	@Test(expected = TransactionException.class)
	public void testNullSubjectNullDetailedInformation()
			throws TransactionException {
		new GenericTransaction(amount, date, subject, null);
	}

	@Test(expected = TransactionException.class)
	public void testEmptySubject() throws TransactionException {
		new GenericTransaction(amount, date, "", new DetailedInformation(
				extraInfo));
	}

	@Test
	public void testGetAmount() {
		assertEquals(this.amount, this.generic.getAmount(), EPSILON);
		assertEquals(this.amount, this.genericWithExtraInfo.getAmount(),
				EPSILON);
	}

	@Test
	public void testGetSubject() {
		assertEquals(this.subject.equals(this.generic.getSubject()), true);
		assertEquals(
				this.subject.equals(this.genericWithExtraInfo.getSubject()),
				true);
	}

	@Test
	public void testGetDate() {
		assertEquals(this.date.getTime(), this.generic.getDate().getTime(),
				EPSILON);
		assertEquals(this.date.getTime(), this.genericWithExtraInfo.getDate()
				.getTime(), EPSILON);
	}

	@Test
	public void testGetAndSetEffectiveDate() {
		assertEquals(this.effectiveDate.getTime(), this.generic
				.getEffectiveDate().getTime(), EPSILON);
		assertEquals(this.effectiveDate.getTime(), this.genericWithExtraInfo
				.getEffectiveDate().getTime(), EPSILON);
		Date newDate = new Date();
		this.generic.setEffectiveDate(newDate);
		this.genericWithExtraInfo.setEffectiveDate(newDate);
		assertEquals(newDate.getTime(), this.generic.getEffectiveDate()
				.getTime(), EPSILON);
		assertEquals(newDate.getTime(), this.genericWithExtraInfo
				.getEffectiveDate().getTime(), EPSILON);
	}

	@Test
	public void testGetDetailedInformation() {
		assertEquals(
				"".equals(this.generic.getDetailedInformation().toString()),
				true);
		assertEquals(extraInfo.equals(this.genericWithExtraInfo
				.getDetailedInformation().toString()), true);
	}

	@Test
	public void testToString() {

		String exp = "Transaction id=" + this.generic.getId() + ", amount="
				+ this.generic.getAmount() + ", date=" + this.generic.getDate()
				+ ", effectiveDate=" + this.generic.getEffectiveDate()
				+ ", subject=" + subject;
		assertEquals(exp, this.generic.toString());
	}
}
