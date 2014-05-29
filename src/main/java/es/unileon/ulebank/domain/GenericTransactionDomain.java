package es.unileon.ulebank.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import es.unileon.ulebank.exceptions.TransactionException;

@Entity
@Table(name="GenericTransactions") 
public class GenericTransactionDomain implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private double amount;
	private Date transactionDate;
	private Date effectiveDate;
	private String subject;
	
	public GenericTransactionDomain(){
		
	}
	
	public GenericTransactionDomain(double amount, Date date, String subject) throws TransactionException {
		
		StringBuilder err = new StringBuilder();

		if (subject == null) {
			err.append("The subject cannot be null \n");
		} else {
			if (subject.length() == 0) {
				err.append("Transaction length cannot be 0 \n");
			}
		}
		
		if (date == null) {
			err.append("The date cannot be null \n");
		}

		if (err.length() > 0) {
			throw new TransactionException(err.toString());
		}
		
		this.amount = amount;
		this.transactionDate = date;
		this.subject = subject;
	}
	
	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "Amount")
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TransactionDate", length = 10)
	public Date getDate() {
		return transactionDate;
	}

	public void setDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EffectiveDate", length = 10)
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Column(name = "Subject", nullable = false, length = 45)
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return "Transaction " + "id=" + id + ", amount=" + amount + ", date="
				+ transactionDate + ", effectiveDate=" + effectiveDate + ", subject="
				+ subject;
	}
}
