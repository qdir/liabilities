package es.unileon.ulebank.repository.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "histories", catalog = "ulebank")
public class Histories implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long historyId;
	private Set<Investmentaccounts> investmentaccountses = new HashSet<Investmentaccounts>(0);
	private Set<Transactions> transactionses = new HashSet<Transactions>(0);

	public Histories() {
	}

	public Histories(Set<Investmentaccounts> investmentaccountses,
			Set<Transactions> transactionses) {
		this.investmentaccountses = investmentaccountses;
		this.transactionses = transactionses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "historyID", unique = true, nullable = false)
	public Long getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "histories")
	public Set<Investmentaccounts> getInvestmentaccountses() {
		return this.investmentaccountses;
	}

	public void setInvestmentaccountses(
			Set<Investmentaccounts> investmentaccountses) {
		this.investmentaccountses = investmentaccountses;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "historiestransactions", catalog = "ulebank", joinColumns = { @JoinColumn(name = "historyID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "transactionID", nullable = false, updatable = false) })
	public Set<Transactions> getTransactionses() {
		return this.transactionses;
	}

	public void setTransactionses(Set<Transactions> transactionses) {
		this.transactionses = transactionses;
	}

}
