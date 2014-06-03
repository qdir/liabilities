package es.unileon.ulebank.repository.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "scheduledpayments", catalog = "ulebank")
public class Scheduledpayments implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String sheduledPayementId;
	private Loans loans;
	private Date paymentDate;
	private Date expirationDate;
	private double amount;
	private double amortization;
	private double interest;
	private double outstandingCapital;
	private boolean paid;

	public Scheduledpayments() {
	}

	public Scheduledpayments(String sheduledPayementId, Loans loans,
			Date paymentDate, Date expirationDate, double amount,
			double amortization, double interest, double outstandingCapital,
			boolean paid) {
		this.sheduledPayementId = sheduledPayementId;
		this.loans = loans;
		this.paymentDate = paymentDate;
		this.expirationDate = expirationDate;
		this.amount = amount;
		this.amortization = amortization;
		this.interest = interest;
		this.outstandingCapital = outstandingCapital;
		this.paid = paid;
	}

	@Id
	@Column(name = "sheduledPayementID", unique = true, nullable = false, length = 32)
	public String getSheduledPayementId() {
		return this.sheduledPayementId;
	}

	public void setSheduledPayementId(String sheduledPayementId) {
		this.sheduledPayementId = sheduledPayementId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loanID", nullable = false)
	public Loans getLoans() {
		return this.loans;
	}

	public void setLoans(Loans loans) {
		this.loans = loans;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "paymentDate", nullable = false, length = 19)
	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expirationDate", nullable = false, length = 19)
	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Column(name = "amount", nullable = false, precision = 22, scale = 0)
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(name = "amortization", nullable = false, precision = 22, scale = 0)
	public double getAmortization() {
		return this.amortization;
	}

	public void setAmortization(double amortization) {
		this.amortization = amortization;
	}

	@Column(name = "interest", nullable = false, precision = 22, scale = 0)
	public double getInterest() {
		return this.interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	@Column(name = "outstandingCapital", nullable = false, precision = 22, scale = 0)
	public double getOutstandingCapital() {
		return this.outstandingCapital;
	}

	public void setOutstandingCapital(double outstandingCapital) {
		this.outstandingCapital = outstandingCapital;
	}

	@Column(name = "paid", nullable = false)
	public boolean isPaid() {
		return this.paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

}
