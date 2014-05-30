/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.client;

import es.unileon.ulebank.handler.MalformedHandlerException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Oigrex
 */
public class EnterpriseTest {

    private Enterprise enterprise, enterprise1;
    private Address address, address1;
    private Person persona;
    private PersonHandler personHandler;

    @Before
    public void setUp() throws MalformedHandlerException {
        enterprise = new Enterprise('A', 5881850, '1');
        address = new Address("Gran Vía", 11, 2, 'B', "Madrid", "Madrid", 28013);
        address1 = new Address("Calle Spooner", 10, 1, 'A', "Quahog", "Rhode Island", 12345);
        enterprise1 = new Enterprise('A', 5881850, '1', "Universidad de León", address);
        persona = new Person(84431140, 'A');
        personHandler = new PersonHandler(84431140, 'A');
    }

    /**
     * Test of addAuthorizedPerson method, of class Enterprise.
     */
    @Test
    public void testAddAuthorizedPerson() {
        this.enterprise.addAuthorizedPerson(persona);
        assertTrue(this.enterprise.existsAuthorizedPerson(personHandler));
    }

    /**
     * Test of removeAuthorizedPerson method, of class Enterprise.
     */
    @Test

    //Error de concurrencia WTF!?
    public void testRemoveAuthorizedPerson() {
        this.enterprise.addAuthorizedPerson(persona);
        assertTrue(this.enterprise.existsAuthorizedPerson(personHandler));
        this.enterprise.removeAuthorizedPerson(personHandler);
        assertFalse(this.enterprise.existsAuthorizedPerson(personHandler));
    }

    /**
     * Test of existsAuthorizedPerson method, of class Enterprise.
     */
    @Test
    public void testExistsAuthorizedPerson() {
        assertFalse(this.enterprise.existsAuthorizedPerson(personHandler));
        this.enterprise.addAuthorizedPerson(persona);
        assertTrue(this.enterprise.existsAuthorizedPerson(personHandler));
    }

    /**
     * Test of getEnterpriseName method, of class Enterprise.
     */
    @Test
    public void testGetEnterpriseName() {
        assertNotNull(this.enterprise1.getEnterpriseName());
        assertEquals(this.enterprise1.getEnterpriseName(), "Universidad de León");
    }

    /**
     * Test of setEnterpriseName method, of class Enterprise.
     */
    @Test
    public void testSetEnterpriseName() {
        assertEquals(this.enterprise1.getEnterpriseName(), "Universidad de León");
        this.enterprise1.setEnterpriseName("Oigrex Company");
        assertEquals(this.enterprise1.getEnterpriseName(), "Oigrex Company");
    }

    /**
     * Test of getAddress method, of class Enterprise.
     */
    @Test
    public void testGetAddress() {
        assertNotNull(this.enterprise1.getAddress());
        assertEquals(this.enterprise1.getAddress(), address);
    }

    /**
     * Test of setAddress method, of class Enterprise.
     */
    @Test
    public void testSetAddress() {
        assertEquals(this.enterprise1.getAddress(), address);
        this.enterprise1.setAddress(address1);
        assertEquals(this.enterprise1.getAddress(), address1);
    }

}
