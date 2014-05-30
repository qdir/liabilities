/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.client;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.AccountHandler;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.bank.BankHandler;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.conditions.WrongArgsException;
import es.unileon.ulebank.office.Office;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oigrex
 */
public class ClientTest {

    private Client cliente;
    private Bank bank;
    private Office office;
    private Account cuenta;
    private Handler clientHandler;
    private Handler officeHandler;
    private AccountHandler accountHandler;
    private BankHandler bankHandler;

    @Before
    public void setUp() throws MalformedHandlerException, WrongArgsException {
        this.bank = new Bank(new GenericHandler("1234"));
        this.bankHandler = new BankHandler("1234");
        this.office = new Office(new GenericHandler("4321"), this.bank);
        this.officeHandler = new GenericHandler("4321");
        this.clientHandler = new GenericHandler("Peter Griffin");
        this.bank.addOffice(office);
        this.cliente = new Client(clientHandler);
        this.cuenta = new Account(office, bank, "1234567890", cliente);
        this.accountHandler = new AccountHandler(officeHandler, bankHandler, "1234567890");
    }

    /**
     * Test of add method, of class Client.
     */
    @Test
    public void testAdd() {
        assertFalse(this.cliente.existsAccount(accountHandler));
        this.cliente.add(cuenta);
        assertTrue(this.cliente.existsAccount(accountHandler));
    }

    /**
     * Test of removeAccount method, of class Client.
     */
    @Test
    public void testRemoveAccount() {
        assertFalse(this.cliente.existsAccount(accountHandler));
        this.cliente.add(cuenta);
        assertTrue(this.cliente.existsAccount(accountHandler));
        Handler cuentaABorrar = new GenericHandler("1234567890");
        this.cliente.removeAccount(cuentaABorrar);
        assertFalse(this.cliente.existsAccount(accountHandler));
    }

    /**
     * Test of existsAccount method, of class Client.
     */
    @Test
    public void testExistsAccount() {
        assertFalse(this.cliente.existsAccount(accountHandler));
        this.cliente.add(cuenta);
        assertTrue(this.cliente.existsAccount(accountHandler));
    }

    /**
     * Test of getId method, of class Client.
     */
    @Test
    public void testGetId() {
        assertNotNull(cliente.getId());
        assertEquals(cliente.getId().toString(), "Peter Griffin");
    }

}
