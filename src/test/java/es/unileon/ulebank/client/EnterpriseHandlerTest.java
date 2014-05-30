/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.client;

import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oigrex
 */
public class EnterpriseHandlerTest {

    private EnterpriseHandler enterpriseHandler;
    private String string;

    @Before
    public void setUp() throws MalformedHandlerException {
        enterpriseHandler = new EnterpriseHandler('A', 5881850, '1');
    }

    /**
     * Test of compareTo method, of class EnterpriseHandler.
     */
    @Test
    public void testCompareTo() {
        string = "A58818501";
        Handler handler = new GenericHandler(this.string);
        assertEquals(this.enterpriseHandler.compareTo(handler), 0);
    }

    /**
     * Test of toString method, of class EnterpriseHandler.
     */
    @Test
    public void testToString() {
        assertEquals(enterpriseHandler.toString(), "A58818501");
    }
    
    @Test
    public void testHandlerCorrecto() throws MalformedHandlerException {
        Enterprise empresa = new Enterprise('A', 5881850, '1');
    }

    @Test(expected = MalformedHandlerException.class)
    public void testNumeroEnLugarLetraCIF() throws MalformedHandlerException {
        Enterprise empresa = new Enterprise('1', 5881850, '1');
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLetraCIFErronea() throws MalformedHandlerException {
        Enterprise empresa = new Enterprise('B', 5881850, '1');
    }

    @Test(expected = MalformedHandlerException.class)
    public void testDigitoControlErroneo() throws MalformedHandlerException {
        Enterprise empresa = new Enterprise('A', 5881850, '2');
    }

    @Test(expected = MalformedHandlerException.class)
    public void testLongitudErroneaMenorDigitoControlCorrecto() throws MalformedHandlerException {
        Enterprise empresa = new Enterprise('A', 588185, '1');
    }
    
    @Test(expected = MalformedHandlerException.class)
    public void testLongitudErroneaMenorDigitoControlErroneo() throws MalformedHandlerException {
        Enterprise empresa = new Enterprise('A', 588185, '2');
    }
    
        @Test(expected = MalformedHandlerException.class)
    public void testLongitudErroneaMayorDigitoControlCorrecto() throws MalformedHandlerException {
        Enterprise empresa = new Enterprise('A', 58818500, '1');
    }
    
    @Test(expected = MalformedHandlerException.class)
    public void testLongitudErroneaMayorDigitoControlErroneo() throws MalformedHandlerException {
        Enterprise empresa = new Enterprise('A', 58818508, '2');
    }
}
