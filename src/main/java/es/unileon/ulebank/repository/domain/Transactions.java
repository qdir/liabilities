package es.unileon.ulebank.repository.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "transactions", catalog = "ulebank")
public class Transactions implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String transactionId;
	private double amount;
	private Date date;
	private Date effectiveDate;
	private String subject;
	private Set<Histories> historieses = new HashSet<Histories>(0);

	public Transactions() {
	}

	public Transactions(String transactionId, double amount, Date date,
			Date effectiveDate, String subject) {
		this.transactionId = transactionId;
		this.amount = amount;
		this.date = date;
		this.effectiveDate = effectiveDate;
		this.subject = subject;
	}

	public Transactions(String transactionId, double amount, Date date,
			Date effectiveDate, String subject, Set<Histories> historieses) {
		this.transactionId = transactionId;
		this.amount = amount;
		this.date = date;
		this.effectiveDate = effectiveDate;
		this.subject = subject;
		this.historieses = historieses;
	}

	@Id
	@Column(name = "transactionID", unique = true, nullable = false, length = 32)
	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Column(name = "amount", nullable = false, precision = 22, scale = 0)
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false, length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "effectiveDate", nullable = false, length = 19)
	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Column(name = "subject", nullable = false)
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "transactionses")
	public Set<Histories> getHistorieses() {
		return this.historieses;
	}

	public void setHistorieses(Set<Histories> historieses) {
		this.historieses = historieses;
	}

}
