/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.client;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oigrex
 */
public class AddressTest {

    Address address;

    @Before
    public void setUp() {
        address = new Address("Calle de Peter", 314159, 10, 'A', "León", "León", 24001);
    }

    /**
     * Test of getStreet method, of class Address.
     */
    @Test
    public void testGetStreet() {
        assertNotNull(address.getStreet());
        assertEquals(address.getStreet(), "Calle de Peter");
    }

    /**
     * Test of setStreet method, of class Address.
     */
    @Test
    public void testSetStreet() {
        assertEquals(address.getStreet(), "Calle de Peter");
        address.setStreet("Calle de Juan");
        assertEquals(address.getStreet(), "Calle de Juan");
    }

    /**
     * Test of getBlockNumber method, of class Address.
     */
    @Test
    public void testGetBlockNumber() {
        assertNotNull(address.getBlockNumber());
        assertEquals(address.getBlockNumber(), 314159);
    }

    /**
     * Test of setBlockNumber method, of class Address.
     */
    @Test
    public void testSetBlockNumber() {
        assertEquals(address.getBlockNumber(), 314159);
        address.setBlockNumber(4);
        assertEquals(address.getBlockNumber(), 4);
    }

    /**
     * Test of getFloor method, of class Address.
     */
    @Test
    public void testGetFloor() {
        assertNotNull(address.getFloor());
        assertEquals(address.getFloor(), 10);
    }

    /**
     * Test of setFloor method, of class Address.
     */
    @Test
    public void testSetFloor() {
        assertEquals(address.getFloor(), 10);
        address.setFloor(11);
        assertEquals(address.getFloor(), 11);
    }

    /**
     * Test of getDoor method, of class Address.
     */
    @Test
    public void testGetDoor() {
        assertNotNull(address.getDoor());
        assertEquals(address.getDoor(), 'A');
    }

    /**
     * Test of setDoor method, of class Address.
     */
    @Test
    public void testSetDoor() {
        assertEquals(address.getDoor(), 'A');
        address.setDoor('B');
        assertEquals(address.getDoor(), 'B');
    }

    /**
     * Test of getLocality method, of class Address.
     */
    @Test
    public void testGetLocality() {
        assertNotNull(address.getLocality());
        assertEquals(address.getLocality(), "León");
    }

    /**
     * Test of setLocality method, of class Address.
     */
    @Test
    public void testSetLocality() {
        assertEquals(address.getLocality(), "León");
        address.setLocality("Madrid");
        assertEquals(address.getLocality(), "Madrid");
    }

    /**
     * Test of getProvince method, of class Address.
     */
    @Test
    public void testGetProvince() {
        assertNotNull(address.getProvince());
        assertEquals(address.getProvince(), "León");
    }

    /**
     * Test of setProvince method, of class Address.
     */
    @Test
    public void testSetProvince() {
        assertEquals(address.getProvince(), "León");
        address.setProvince("Madrid");
        assertEquals(address.getProvince(), "Madrid");
    }

    /**
     * Test of getZipCode method, of class Address.
     */
    @Test
    public void testGetZipCode() {
        assertNotNull(address.getZipCode());
        assertEquals(address.getZipCode(), 24001);
    }

    /**
     * Test of setZipCode method, of class Address.
     */
    @Test
    public void testSetZipCode() {
        assertEquals(address.getZipCode(), 24001);
        address.setZipCode(24002);
        assertEquals(address.getZipCode(), 24002);
    }

}
