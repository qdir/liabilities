package es.unileon.ulebank.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.domain.GenericTransactionDomain;
import es.unileon.ulebank.domain.TransactionHandlerDomain;
import es.unileon.ulebank.domain.TransactionHandlerDomainId;
import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.repository.dao.HistoriesDao;
import es.unileon.ulebank.repository.dao.TransactionsDao;
import es.unileon.ulebank.repository.domain.Histories;
import es.unileon.ulebank.repository.domain.Transactions;

public class TransactionsDaoTest {

    private ApplicationContext context;
//    private TransactionsDao transactionsDao;
//    private TransactionsHandlerDao transactionsHandlerDao;
    private TransactionsDao transactionsDao;
    private HistoriesDao historiesDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        transactionsDao = (TransactionsDao) context.getBean("transactionsDao");
        historiesDao = (HistoriesDao) context.getBean("historiesDao");
//        transactionsDao = (TransactionsDao) context.getBean("transactionsDao");
//        transactionsHandlerDao = (TransactionsHandlerDao) context.getBean("transactionsHandlerDao");
    }

    @Test
    public void testGetProductList() throws TransactionException {
    	
    	Transactions transaction = new Transactions();
    	transaction.setAmount(10);
    	transaction.setDate(new Date());
    	transaction.setEffectiveDate(new Date());
    	transaction.setSubject("subject");
    	transaction.setTransactionId("transactionId");
    	transactionsDao.persist(transaction);
    	
    	Histories history = new Histories();
    	history.getTransactionses().add(transaction);
    	historiesDao.persist(history);
    	
//    	GenericTransactionDomain transaction = new GenericTransactionDomain(20, new Date(), "Subject");
//    	transaction.setEffectiveDate(new Date());
//    	transactionsDao.persist(transaction);
//        List<GenericTransactionDomain> transactions = transactionsDao.getGenericTransactionsList();
//        assertEquals(transactions.size(), 1, 0);
//        TransactionHandlerDomain transactionHandler = new TransactionHandlerDomain(new TransactionHandlerDomainId(transaction.getId(), 1), "29 del tal y cual");
//        transactionsHandlerDao.persist(transactionHandler);
    }
}