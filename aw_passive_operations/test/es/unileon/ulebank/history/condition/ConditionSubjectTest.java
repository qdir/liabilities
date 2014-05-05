/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.condition;

import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import es.unileon.ulebank.history.conditions.ConditionSubject;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author runix
 */
public class ConditionSubjectTest {

    @Test
    public void testSubjectOkOneWord() {
        ConditionSubject condition = new ConditionSubject(true, "prueba");
        assertTrue(condition.test(getTransaction("kdahsdhasdasdpruebaasdajhsdhasd")));
        assertTrue(condition.test(getTransaction("pruebakdahsdhasdasdasdajhsdhasd")));
        assertTrue(condition.test(getTransaction("kdahsdhasdasdasdajhsdhasdprueba")));
    }

    @Test
    public void testSubjectOkTwoWords() {
        ConditionSubject condition = new ConditionSubject(true, "prueba", "jhsd");
        assertTrue(condition.test(getTransaction("kdahsdhasdasdpruebaasdajhsdhasd")));
        assertTrue(condition.test(getTransaction("pruebakdahsdhasdasdasdajhsdhasd")));
        assertTrue(condition.test(getTransaction("kdahsdhasdasdasdajhsdhasdprueba")));
    }

    @Test
    public void testSubjectOkTwoWordsOneValid() {
        ConditionSubject condition = new ConditionSubject(true, "prueba", "zzz");
        assertFalse(condition.test(getTransaction("kdahsdhasdasdpruebaasdajhsdhasd")));
        assertFalse(condition.test(getTransaction("pruebakdahsdhasdasdasdajhsdhasd")));
        assertFalse(condition.test(getTransaction("kdahsdhasdasdasdajhsdhasdprueba")));
    }

    @Test
    public void testSubjectNotOkOneWord() {
        ConditionSubject condition = new ConditionSubject(true, "prueb2");
        assertFalse(condition.test(getTransaction("kdahsdhasdasdpruebaasdajhsdhasd")));
        assertFalse(condition.test(getTransaction("pruebakdahsdhasdasdasdajhsdhasd")));
        assertFalse(condition.test(getTransaction("kdahsdhasdasdasdajhsdhasdprueba")));
    }

    @Test
    public void testSubjectNotOkTwoWords() {
        ConditionSubject condition = new ConditionSubject(true, "prueb2", "zzzzz");
        assertFalse(condition.test(getTransaction("kdahsdhasdasdpruebaasdajhsdhasd")));
        assertFalse(condition.test(getTransaction("pruebakdahsdhasdasdasdajhsdhasd")));
        assertFalse(condition.test(getTransaction("kdahsdhasdasdasdajhsdhasdprueba")));
    }

    @Test
    public void testSubjectOkExclusiveOneWord() {
        ConditionSubject condition = new ConditionSubject(false, "prueba2");
        assertTrue(condition.test(getTransaction("kdahsdhasdasdpruebaasdajhsdhasd")));
        assertTrue(condition.test(getTransaction("pruebakdahsdhasdasdasdajhsdhasd")));
        assertTrue(condition.test(getTransaction("kdahsdhasdasdasdajhsdhasdprueba")));
    }

    @Test
    public void testSubjectOkExclusiveTwoWord() {
        ConditionSubject condition = new ConditionSubject(false, "prueba2", "zzzz");
        assertTrue(condition.test(getTransaction("kdahsdhasdasdpruebaasdajhsdhasd")));
        assertTrue(condition.test(getTransaction("pruebakdahsdhasdasdasdajhsdhasd")));
        assertTrue(condition.test(getTransaction("kdahsdhasdasdasdajhsdhasdprueba")));
    }

    @Test
    public void testSubjectOkExclusiveTwoWordOneValid() {
        ConditionSubject condition = new ConditionSubject(false, "prueba2", "hasd");
        assertTrue(condition.test(getTransaction("kdahsdhasdasdpruebaasdajhsdhasd")));
        assertTrue(condition.test(getTransaction("pruebakdahsdhasdasdasdajhsdhasd")));
        assertTrue(condition.test(getTransaction("kdahsdhasdasdasdajhsdhasdprueba")));
    }

    @Test
    public void testSubjectNotOkExclusiveOneWord() {
        ConditionSubject condition = new ConditionSubject(false, "prueba");
        assertFalse(condition.test(getTransaction("kdahsdhasdasdpruebaasdajhsdhasd")));
        assertFalse(condition.test(getTransaction("pruebakdahsdhasdasdasdajhsdhasd")));
        assertFalse(condition.test(getTransaction("kdahsdhasdasdasdajhsdhasdprueba")));
    }

    @Test
    public void testSubjectNotOkExclusiveTwoWord() {
        ConditionSubject condition = new ConditionSubject(false, "prueba", "hasd");
        assertFalse(condition.test(getTransaction("kdahsdhasdasdpruebaasdajhsdhasd")));
        assertFalse(condition.test(getTransaction("pruebakdahsdhasdasdasdajhsdhasd")));
        assertFalse(condition.test(getTransaction("kdahsdhasdasdasdajhsdhasdprueba")));
    }

    public final Transaction getTransaction(String subject) {
        Transaction t = new GenericTransaction(0, null, subject, TransactionType.CHARGE);
        return t;
    }
}
