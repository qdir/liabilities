package es.unileon.ulebank.account.liquidation;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.liquidation.doublefeaturextractors.DoubleFeatureExtractorDirectDebitMaxAmount;
import es.unileon.ulebank.account.liquidation.doublefeaturextractors.DoubleFeatureExtractorDirectDebitsAverage;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.client.Person;
import es.unileon.ulebank.exceptions.TransactionException;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.DirectDebitTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionHandlerProvider;
import es.unileon.ulebank.history.conditions.WrongArgsException;
import es.unileon.ulebank.office.Office;

public class GenericLiquidationFeeTest {

	private Features<Double> features;

	private String subject;

	private Account account;

	private Office office;

	private Bank bank;

	private Client titular;

	private DoubleFeeCase feeCase;

	private DoubleFeeCase feeCase2;

	private DoubleFeeCase feeCase3;

	private String amountFormula;

	private String amountFormula2;

	private String amountFormula3;

	private GenericLiquidationFee<Double> liquidationFee;

	private Handler id;

	@Before
	public void setUp() throws MalformedHandlerException, WrongArgsException,
			InvalidCondition, TransactionException {
		bank = new Bank(new GenericHandler("1234"));
		office = new Office(new GenericHandler("1234"), bank);
		titular = new Person(74484986, 'S');
		account = new Account(office, bank, office.getNewAccountNumber(),
				titular);
		features = new Features<Double>();
		this.amountFormula = "2*3";
		this.amountFormula2 = "3*3+1";
		this.amountFormula3 = "3 * 3 * 3 + 1";
		this.subject = "subject";
		assertTrue(features
				.addFeature(new DoubleFeatureExtractorDirectDebitMaxAmount()));
		assertTrue(features
				.addFeature(new DoubleFeatureExtractorDirectDebitsAverage()));
		feeCase = new DoubleFeeCase(features, amountFormula, subject, account);
		feeCase.addConditionEquation("pago domiciliado mas alto", '>', "4");

		feeCase2 = new DoubleFeeCase(features, amountFormula2, subject, account);
		feeCase2.addConditionEquation("pago domiciliado mas alto", '<', "4");

		feeCase3 = new DoubleFeeCase(features, amountFormula3, subject, account);
		feeCase3.addConditionEquation("importe medio pagos domiciliados", '<',
				"2");
		for (int i = 0; i < 10; i++) {
			account.doDirectDebit(getTransaction(subject, i, new Date(i)));
		}
		id = new GenericHandler("basicLiquidationFee");
		this.liquidationFee = new GenericLiquidationFee<Double>(account, id,
				features);
		assertTrue(this.liquidationFee.addFeeCase(feeCase));
		assertTrue(this.liquidationFee.addFeeCase(feeCase2));
		assertTrue(this.liquidationFee.addFeeCase(feeCase3));
		assertFalse(this.liquidationFee.addFeeCase(new DoubleFeeCase(new Features<Double>(), amountFormula, subject, account)));
	}

	@Test
	public void testGetId() {
		assertEquals(this.id.compareTo(this.liquidationFee.getId()), 0);
	}

	@Test
	public void testCalculateFee() throws TransactionException {
		Transaction t = this.liquidationFee.calculateFee(new Date(0), new Date(
				10));
		assertEquals(t.getAmount(), 10.0, Math.pow(10, -5));
		assertEquals(t.getSubject(), subject);
	}
	
	@Test
	public void testCalculateFeeNotFound() throws TransactionException, InvalidCondition{
		feeCase = new DoubleFeeCase(features, amountFormula, subject, account);
		feeCase.addConditionEquation("1", '>', "4");
		assertEquals(this.id.compareTo(this.liquidationFee.getId()), 0);
		this.liquidationFee = new GenericLiquidationFee<Double>(account, id,
				features);
		assertTrue(this.liquidationFee.addFeeCase(feeCase));
		assertNull(this.liquidationFee.calculateFee(new Date(0), new Date(10)));
	}

	public DirectDebitTransaction getTransaction(String subject, double amount,
			Date date) throws TransactionException {
		DirectDebitTransaction dt = new DirectDebitTransaction(amount, date,
				subject, TransactionHandlerProvider.getTransactionHandler());
		dt.setEffectiveDate(date);
		return dt;
	}
}
