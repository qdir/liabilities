package es.unileon.ulebank.repository.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "accounts", catalog = "ulebank")
public class Accounts implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String accountId;
	private double balance;
	private Date lastLiquidationTime;
	private int liquidationFrequency;
	private double maxOverdraft;
	private Set<Persons> personses = new HashSet<Persons>(0);
	private Set<Stockpacks> stockpackses = new HashSet<Stockpacks>(0);
	private Set<Liquidationfees> liquidationfeeses = new HashSet<Liquidationfees>(0);
	private Set<Investmentaccounts> investmentaccountses = new HashSet<Investmentaccounts>(0);
	private Set<Cards> cardses = new HashSet<Cards>(0);
	private Set<Loans> loanses = new HashSet<Loans>(0);

	public Accounts() {
	}

	public Accounts(String accountId, double balance, Date lastLiquidationTime,
			int liquidationFrequency, double maxOverdraft) {
		this.accountId = accountId;
		this.balance = balance;
		this.lastLiquidationTime = lastLiquidationTime;
		this.liquidationFrequency = liquidationFrequency;
		this.maxOverdraft = maxOverdraft;
	}

	public Accounts(String accountId, double balance, Date lastLiquidationTime,
			int liquidationFrequency, double maxOverdraft,
			Set<Persons> personses, Set<Stockpacks> stockpackses,
			Set<Liquidationfees> liquidationfeeses,
			Set<Investmentaccounts> investmentaccountses, Set<Cards> cardses,
			Set<Loans> loanses) {
		this.accountId = accountId;
		this.balance = balance;
		this.lastLiquidationTime = lastLiquidationTime;
		this.liquidationFrequency = liquidationFrequency;
		this.maxOverdraft = maxOverdraft;
		this.personses = personses;
		this.stockpackses = stockpackses;
		this.liquidationfeeses = liquidationfeeses;
		this.investmentaccountses = investmentaccountses;
		this.cardses = cardses;
		this.loanses = loanses;
	}

	@Id
	@Column(name = "accountID", unique = true, nullable = false, length = 32)
	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Column(name = "balance", nullable = false, precision = 22, scale = 0)
	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastLiquidationTime", nullable = false, length = 19)
	public Date getLastLiquidationTime() {
		return this.lastLiquidationTime;
	}

	public void setLastLiquidationTime(Date lastLiquidationTime) {
		this.lastLiquidationTime = lastLiquidationTime;
	}

	@Column(name = "liquidationFrequency", nullable = false)
	public int getLiquidationFrequency() {
		return this.liquidationFrequency;
	}

	public void setLiquidationFrequency(int liquidationFrequency) {
		this.liquidationFrequency = liquidationFrequency;
	}

	@Column(name = "maxOverdraft", nullable = false, precision = 22, scale = 0)
	public double getMaxOverdraft() {
		return this.maxOverdraft;
	}

	public void setMaxOverdraft(double maxOverdraft) {
		this.maxOverdraft = maxOverdraft;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "accountsclients", catalog = "ulebank", joinColumns = { @JoinColumn(name = "accountID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "clientID", nullable = false, updatable = false) })
	public Set<Persons> getPersonses() {
		return this.personses;
	}

	public void setPersonses(Set<Persons> personses) {
		this.personses = personses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accounts")
	public Set<Stockpacks> getStockpackses() {
		return this.stockpackses;
	}

	public void setStockpackses(Set<Stockpacks> stockpackses) {
		this.stockpackses = stockpackses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accounts")
	public Set<Liquidationfees> getLiquidationfeeses() {
		return this.liquidationfeeses;
	}

	public void setLiquidationfeeses(Set<Liquidationfees> liquidationfeeses) {
		this.liquidationfeeses = liquidationfeeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accounts")
	public Set<Investmentaccounts> getInvestmentaccountses() {
		return this.investmentaccountses;
	}

	public void setInvestmentaccountses(
			Set<Investmentaccounts> investmentaccountses) {
		this.investmentaccountses = investmentaccountses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accounts")
	public Set<Cards> getCardses() {
		return this.cardses;
	}

	public void setCardses(Set<Cards> cardses) {
		this.cardses = cardses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accounts")
	public Set<Loans> getLoanses() {
		return this.loanses;
	}

	public void setLoanses(Set<Loans> loanses) {
		this.loanses = loanses;
	}

}
