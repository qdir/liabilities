/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.condition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.conditions.ConditionSubject;

/**
 *
 * @author runix
 */
public class ConditionSubjectTest {

	@Test
	public void testSubjectOkOneWord() throws TransactionException {
		ConditionSubject condition = new ConditionSubject(true, "prueba");
		assertTrue(condition
				.test(getTransaction("kdahsdhasdasdpruebaasdajhsdhasd")));
		assertTrue(condition
				.test(getTransaction("pruebakdahsdhasdasdasdajhsdhasd")));
		assertTrue(condition
				.test(getTransaction("kdahsdhasdasdasdajhsdhasdprueba")));
	}

	@Test
	public void testSubjectNotOkOneWord() throws TransactionException {
		ConditionSubject condition = new ConditionSubject(true, "prueb2");
		assertFalse(condition
				.test(getTransaction("kdahsdhasdasdpruebaasdajhsdhasd")));
		assertFalse(condition
				.test(getTransaction("pruebakdahsdhasdasdasdajhsdhasd")));
		assertFalse(condition
				.test(getTransaction("kdahsdhasdasdasdajhsdhasdprueba")));
	}

	@Test
	public void testSubjectOkExclusiveOneWord() throws TransactionException {
		ConditionSubject condition = new ConditionSubject(false, "prueba2");
		assertTrue(condition
				.test(getTransaction("kdahsdhasdasdpruebaasdajhsdhasd")));
		assertTrue(condition
				.test(getTransaction("pruebakdahsdhasdasdasdajhsdhasd")));
		assertTrue(condition
				.test(getTransaction("kdahsdhasdasdasdajhsdhasdprueba")));
	}

	@Test
	public void testSubjectNotOkExclusiveOneWord() throws TransactionException {
		ConditionSubject condition = new ConditionSubject(false, "prueba");
		assertFalse(condition
				.test(getTransaction("kdahsdhasdasdpruebaasdajhsdhasd")));
		assertFalse(condition
				.test(getTransaction("pruebakdahsdhasdasdasdajhsdhasd")));
		assertFalse(condition
				.test(getTransaction("kdahsdhasdasdasdajhsdhasdprueba")));
	}

	public final Transaction getTransaction(String subject)
			throws TransactionException {
		Transaction t = new GenericTransaction(0, new Date(), subject);
		return t;
	}
}
