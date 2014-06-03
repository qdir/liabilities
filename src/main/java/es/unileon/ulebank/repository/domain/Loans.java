package es.unileon.ulebank.repository.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "loans", catalog = "ulebank")
public class Loans implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String loanId;
	private Persons persons;
	private Linearfees linearfeesByCancelFee;
	private Linearfees linearfeesByModifyFee;
	private Accounts accounts;
	private Linearfees linearfeesByDelayedPaymentFee;
	private Linearfees linearfeesByStudyFee;
	private Linearfees linearfeesByAmortizationFee;
	private Linearfees linearfeesByOpeningFee;
	private boolean type;
	private boolean paymentPeriod;
	private double initialCapital;
	private int amortizationTime;
	private double interest;
	private Date creationDate;
	private String description;
	private double debt;
	private Set<Scheduledpayments> scheduledpaymentses = new HashSet<Scheduledpayments>(0);

	public Loans() {
	}

	public Loans(String loanId, Persons persons,
			Linearfees linearfeesByCancelFee, Linearfees linearfeesByModifyFee,
			Accounts accounts, Linearfees linearfeesByDelayedPaymentFee,
			Linearfees linearfeesByStudyFee,
			Linearfees linearfeesByAmortizationFee,
			Linearfees linearfeesByOpeningFee, boolean type,
			boolean paymentPeriod, double initialCapital, int amortizationTime,
			double interest, Date creationDate, String description, double debt) {
		this.loanId = loanId;
		this.persons = persons;
		this.linearfeesByCancelFee = linearfeesByCancelFee;
		this.linearfeesByModifyFee = linearfeesByModifyFee;
		this.accounts = accounts;
		this.linearfeesByDelayedPaymentFee = linearfeesByDelayedPaymentFee;
		this.linearfeesByStudyFee = linearfeesByStudyFee;
		this.linearfeesByAmortizationFee = linearfeesByAmortizationFee;
		this.linearfeesByOpeningFee = linearfeesByOpeningFee;
		this.type = type;
		this.paymentPeriod = paymentPeriod;
		this.initialCapital = initialCapital;
		this.amortizationTime = amortizationTime;
		this.interest = interest;
		this.creationDate = creationDate;
		this.description = description;
		this.debt = debt;
	}

	public Loans(String loanId, Persons persons,
			Linearfees linearfeesByCancelFee, Linearfees linearfeesByModifyFee,
			Accounts accounts, Linearfees linearfeesByDelayedPaymentFee,
			Linearfees linearfeesByStudyFee,
			Linearfees linearfeesByAmortizationFee,
			Linearfees linearfeesByOpeningFee, boolean type,
			boolean paymentPeriod, double initialCapital, int amortizationTime,
			double interest, Date creationDate, String description,
			double debt, Set<Scheduledpayments> scheduledpaymentses) {
		this.loanId = loanId;
		this.persons = persons;
		this.linearfeesByCancelFee = linearfeesByCancelFee;
		this.linearfeesByModifyFee = linearfeesByModifyFee;
		this.accounts = accounts;
		this.linearfeesByDelayedPaymentFee = linearfeesByDelayedPaymentFee;
		this.linearfeesByStudyFee = linearfeesByStudyFee;
		this.linearfeesByAmortizationFee = linearfeesByAmortizationFee;
		this.linearfeesByOpeningFee = linearfeesByOpeningFee;
		this.type = type;
		this.paymentPeriod = paymentPeriod;
		this.initialCapital = initialCapital;
		this.amortizationTime = amortizationTime;
		this.interest = interest;
		this.creationDate = creationDate;
		this.description = description;
		this.debt = debt;
		this.scheduledpaymentses = scheduledpaymentses;
	}

	@Id
	@Column(name = "loanID", unique = true, nullable = false, length = 32)
	public String getLoanId() {
		return this.loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientID", nullable = false)
	public Persons getPersons() {
		return this.persons;
	}

	public void setPersons(Persons persons) {
		this.persons = persons;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cancelFee", nullable = false)
	public Linearfees getLinearfeesByCancelFee() {
		return this.linearfeesByCancelFee;
	}

	public void setLinearfeesByCancelFee(Linearfees linearfeesByCancelFee) {
		this.linearfeesByCancelFee = linearfeesByCancelFee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modifyFee", nullable = false)
	public Linearfees getLinearfeesByModifyFee() {
		return this.linearfeesByModifyFee;
	}

	public void setLinearfeesByModifyFee(Linearfees linearfeesByModifyFee) {
		this.linearfeesByModifyFee = linearfeesByModifyFee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountID", nullable = false)
	public Accounts getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "delayedPaymentFee", nullable = false)
	public Linearfees getLinearfeesByDelayedPaymentFee() {
		return this.linearfeesByDelayedPaymentFee;
	}

	public void setLinearfeesByDelayedPaymentFee(
			Linearfees linearfeesByDelayedPaymentFee) {
		this.linearfeesByDelayedPaymentFee = linearfeesByDelayedPaymentFee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studyFee", nullable = false)
	public Linearfees getLinearfeesByStudyFee() {
		return this.linearfeesByStudyFee;
	}

	public void setLinearfeesByStudyFee(Linearfees linearfeesByStudyFee) {
		this.linearfeesByStudyFee = linearfeesByStudyFee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "amortizationFee", nullable = false)
	public Linearfees getLinearfeesByAmortizationFee() {
		return this.linearfeesByAmortizationFee;
	}

	public void setLinearfeesByAmortizationFee(
			Linearfees linearfeesByAmortizationFee) {
		this.linearfeesByAmortizationFee = linearfeesByAmortizationFee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "openingFee", nullable = false)
	public Linearfees getLinearfeesByOpeningFee() {
		return this.linearfeesByOpeningFee;
	}

	public void setLinearfeesByOpeningFee(Linearfees linearfeesByOpeningFee) {
		this.linearfeesByOpeningFee = linearfeesByOpeningFee;
	}

	@Column(name = "type", nullable = false)
	public boolean isType() {
		return this.type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	@Column(name = "paymentPeriod", nullable = false)
	public boolean isPaymentPeriod() {
		return this.paymentPeriod;
	}

	public void setPaymentPeriod(boolean paymentPeriod) {
		this.paymentPeriod = paymentPeriod;
	}

	@Column(name = "initialCapital", nullable = false, precision = 22, scale = 0)
	public double getInitialCapital() {
		return this.initialCapital;
	}

	public void setInitialCapital(double initialCapital) {
		this.initialCapital = initialCapital;
	}

	@Column(name = "amortizationTime", nullable = false)
	public int getAmortizationTime() {
		return this.amortizationTime;
	}

	public void setAmortizationTime(int amortizationTime) {
		this.amortizationTime = amortizationTime;
	}

	@Column(name = "interest", nullable = false, precision = 22, scale = 0)
	public double getInterest() {
		return this.interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creationDate", nullable = false, length = 19)
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "debt", nullable = false, precision = 22, scale = 0)
	public double getDebt() {
		return this.debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loans")
	public Set<Scheduledpayments> getScheduledpaymentses() {
		return this.scheduledpaymentses;
	}

	public void setScheduledpaymentses(
			Set<Scheduledpayments> scheduledpaymentses) {
		this.scheduledpaymentses = scheduledpaymentses;
	}

}
