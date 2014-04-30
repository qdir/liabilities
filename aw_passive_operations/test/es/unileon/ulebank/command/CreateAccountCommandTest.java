/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.command;

import es.unileon.ulebank.account.AccountHandler;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.transacionManager.TransactionManager;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tania Pérez
 */
public class CreateAccountCommandTest {

    private Office office;
    private Bank bank;
    private TransactionManager manager;

    @Before
    public void setUp() throws MalformedHandlerException {

        this.manager = new TransactionManager();
        this.bank = new Bank(this.manager, new GenericHandler("1234"));
        this.office = new Office(new GenericHandler("1234"), this.bank);
    }

    /**
     * Test of execute method, of class CreateAccountCommand.
     */
    @Test
    public void testExecute() throws MalformedHandlerException {

        System.out.println("execute");

        CreateAccountCommand command = new CreateAccountCommand(this.office, this.bank, new Date(System.currentTimeMillis()), new GenericHandler(""));
        command.execute();
        command.execute();

        assertEquals(((AccountHandler) this.office.getAccounts().get(0).getID()).getNumber(), "0000000000", "0000000000");
        assertEquals(((AccountHandler) this.office.getAccounts().get(0).getID()).getNumber(), "0000000001", "0000000001");
    }
}
