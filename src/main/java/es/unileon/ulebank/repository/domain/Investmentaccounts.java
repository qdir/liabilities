package es.unileon.ulebank.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "investmentaccounts", catalog = "ulebank")
public class Investmentaccounts implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long investmentAccountId;
	private Histories histories;
	private Persons persons;
	private Accounts accounts;
	private Linearfees linearfeesBySellStockageFee;
	private Linearfees linearfeesByBuyStockageFee;

	public Investmentaccounts() {
	}

	public Investmentaccounts(Histories histories, Persons persons,
			Accounts accounts, Linearfees linearfeesBySellStockageFee,
			Linearfees linearfeesByBuyStockageFee) {
		this.histories = histories;
		this.persons = persons;
		this.accounts = accounts;
		this.linearfeesBySellStockageFee = linearfeesBySellStockageFee;
		this.linearfeesByBuyStockageFee = linearfeesByBuyStockageFee;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "investmentAccountID", unique = true, nullable = false)
	public Long getInvestmentAccountId() {
		return this.investmentAccountId;
	}

	public void setInvestmentAccountId(Long investmentAccountId) {
		this.investmentAccountId = investmentAccountId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transactionHistory", nullable = false)
	public Histories getHistories() {
		return this.histories;
	}

	public void setHistories(Histories histories) {
		this.histories = histories;
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
	@JoinColumn(name = "accountID", nullable = false)
	public Accounts getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sellStockageFee", nullable = false)
	public Linearfees getLinearfeesBySellStockageFee() {
		return this.linearfeesBySellStockageFee;
	}

	public void setLinearfeesBySellStockageFee(
			Linearfees linearfeesBySellStockageFee) {
		this.linearfeesBySellStockageFee = linearfeesBySellStockageFee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "buyStockageFee", nullable = false)
	public Linearfees getLinearfeesByBuyStockageFee() {
		return this.linearfeesByBuyStockageFee;
	}

	public void setLinearfeesByBuyStockageFee(
			Linearfees linearfeesByBuyStockageFee) {
		this.linearfeesByBuyStockageFee = linearfeesByBuyStockageFee;
	}

}
