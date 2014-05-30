/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.client;

import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Oigrex
 */
public class PersonHandlerTest {

    private Person persona;
    private PersonHandler personHandler;
    private PersonHandler personHandler1;
    private String dni;
    private String nie;

    @Before
    public void setUp() throws MalformedHandlerException {
        personHandler = new PersonHandler(72464828, 'Q');
        personHandler1 = new PersonHandler('Y', 1800076, 'H');
    }

    /**
     * Test of compareTo method, of class PersonHandler.
     */
    @Test
    public void testCompareTo() {
        dni = "72464828Q";
        Handler handler = new GenericHandler(this.dni);
        assertEquals(this.personHandler.compareTo(handler), 0);
        nie = "Y1800076H";
        Handler handler1 = new GenericHandler(this.nie);
        assertEquals(this.personHandler1.compareTo(handler1), 0);
    }

    /**
     * Test of toString method, of class PersonHandler.
     */
    @Test
    public void testToString() {
        assertEquals(this.personHandler.toString(), "72464828Q");
        assertEquals(this.personHandler1.toString(), "Y1800076H");
    }

    @Test
    public void testHandlerCorrecto() throws MalformedHandlerException {
        Person persona = new Person(72464828, 'Q');
    }

    @Test(expected = MalformedHandlerException.class)
    public void testDNILetraIncorrecta() throws MalformedHandlerException {
        Person persona = new Person(72464828, 'A');
    }

//    @Test(expected = MalformedHandlerException.class)
//    public void testDNILongitudMenor() throws MalformedHandlerException {
//        Person persona = new Person(7246482, 'X');
//    }
    
    @Test(expected = MalformedHandlerException.class)
    public void testDNILongitudMayor() throws MalformedHandlerException {
        Person persona = new Person(724648289, 'P');
    }

    @Test(expected = MalformedHandlerException.class)
    public void testDNINumeroEnLugarDeLetra() throws MalformedHandlerException {
        Person persona = new Person(72464828, '9');
    }

    @Test(expected = MalformedHandlerException.class)
    public void testNIELetraIncorrecta1() throws MalformedHandlerException {
        Person persona = new Person('P', 1800076, 'H');
    }

    @Test(expected = MalformedHandlerException.class)
    public void testNIELetraIncorrecta2() throws MalformedHandlerException {
        Person persona = new Person('Y', 1800076, 'P');
    }

    @Test(expected = MalformedHandlerException.class)
    public void testNIELongitudIncorrectaMenor() throws MalformedHandlerException {
        Person persona = new Person('Y', 180007, 'H');
    }

    @Test(expected = MalformedHandlerException.class)
    public void testNIELongitudIncorrectaMayor() throws MalformedHandlerException {
        Person persona = new Person('Y', 18000768, 'H');
    }

    @Test(expected = MalformedHandlerException.class)
    public void testNIENumeroEnLugarLetra1() throws MalformedHandlerException {
        Person persona = new Person('1', 1800076, 'H');
    }

    @Test(expected = MalformedHandlerException.class)
    public void testNIENumeroEnLugarLetra2() throws MalformedHandlerException {
        Person persona = new Person('Y', 1800076, '1');
    }
}
