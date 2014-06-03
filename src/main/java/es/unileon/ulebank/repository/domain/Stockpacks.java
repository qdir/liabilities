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
@Table(name = "stockpacks", catalog = "ulebank")
public class Stockpacks implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long stockPackId;
	private Accounts accounts;
	private String stockTicker;
	private long investmentAccountId;
	private int amount;

	public Stockpacks() {
	}

	public Stockpacks(Accounts accounts, String stockTicker,
			long investmentAccountId, int amount) {
		this.accounts = accounts;
		this.stockTicker = stockTicker;
		this.investmentAccountId = investmentAccountId;
		this.amount = amount;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "stockPackID", unique = true, nullable = false)
	public Long getStockPackId() {
		return this.stockPackId;
	}

	public void setStockPackId(Long stockPackId) {
		this.stockPackId = stockPackId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountID", nullable = false)
	public Accounts getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	@Column(name = "stockTicker", nullable = false, length = 6)
	public String getStockTicker() {
		return this.stockTicker;
	}

	public void setStockTicker(String stockTicker) {
		this.stockTicker = stockTicker;
	}

	@Column(name = "investmentAccountID", nullable = false)
	public long getInvestmentAccountId() {
		return this.investmentAccountId;
	}

	public void setInvestmentAccountId(long investmentAccountId) {
		this.investmentAccountId = investmentAccountId;
	}

	@Column(name = "amount", nullable = false)
	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
