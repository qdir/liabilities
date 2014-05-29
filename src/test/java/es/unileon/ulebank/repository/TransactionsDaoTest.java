package es.unileon.ulebank.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.domain.GenericTransactionDomain;
import es.unileon.ulebank.domain.TransactionHandlerDomain;
import es.unileon.ulebank.domain.TransactionHandlerDomainId;
import es.unileon.ulebank.exceptions.TransactionException;

public class TransactionsDaoTest {

    private ApplicationContext context;
    private TransactionsDao transactionsDao;
    private TransactionsHandlerDao transactionsHandlerDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        transactionsDao = (TransactionsDao) context.getBean("transactionsDao");
        transactionsHandlerDao = (TransactionsHandlerDao) context.getBean("transactionsHandlerDao");
    }

    @Test
    public void testGetProductList() throws TransactionException {
    	
    	GenericTransactionDomain transaction = new GenericTransactionDomain(20, new Date(), "Subject");
    	transaction.setEffectiveDate(new Date());
    	transactionsDao.persist(transaction);
        List<GenericTransactionDomain> transactions = transactionsDao.getGenericTransactionsList();
        assertEquals(transactions.size(), 1, 0);
        TransactionHandlerDomain transactionHandler = new TransactionHandlerDomain(new TransactionHandlerDomainId(transaction.getId(), 1), "29 del tal y cual");
        transactionsHandlerDao.persist(transactionHandler);
    }
}