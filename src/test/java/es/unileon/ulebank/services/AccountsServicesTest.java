package es.unileon.ulebank.services;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.repository.dao.AccountsDao;
import es.unileon.ulebank.repository.domain.Accounts;
import es.unileon.ulebank.repository.domain.Persons;

public class AccountsServicesTest {

    private ApplicationContext context;
    
    private AccountsServices accountsServices;
    
    private AccountsDao accountsDao;
    
	@Before
	public void setUp() throws Exception {
		
		 context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		 accountsDao = (AccountsDao) context.getBean("accountsDao");
		 accountsServices = (AccountsServices) context.getBean("accountService");
	}

	@Test
	public void testAddTitular() {
		
		Persons titular = new Persons("idperson", "name", "surname", "address", true, "profession", new Date());
		Accounts account = new Accounts("accountId", 20d, new Date(), 5, 2d);
		accountsDao.persist(account);
		accountsServices.addTitular(titular, account.getAccountId());
		
		assertEquals(accountsServices.getTitulars(account.getAccountId()).size(),1,0);
		
		assertFalse(accountsServices.addTitular(titular, account.getAccountId()));
	}

	@Test
	public void testDeleteTitular() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTitulars() {
		fail("Not yet implemented");
	}

}
