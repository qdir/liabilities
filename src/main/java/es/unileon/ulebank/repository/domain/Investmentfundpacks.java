package es.unileon.ulebank.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "investmentfundpacks", catalog = "ulebank")
public class Investmentfundpacks implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long investmentFundPackId;
	private String investmentFundId;
	private String accountId;
	private long investmentAccountId;
	private int amount;

	public Investmentfundpacks() {
	}

	public Investmentfundpacks(String investmentFundId, String accountId,
			long investmentAccountId, int amount) {
		this.investmentFundId = investmentFundId;
		this.accountId = accountId;
		this.investmentAccountId = investmentAccountId;
		this.amount = amount;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "investmentFundPackID", unique = true, nullable = false)
	public Long getInvestmentFundPackId() {
		return this.investmentFundPackId;
	}

	public void setInvestmentFundPackId(Long investmentFundPackId) {
		this.investmentFundPackId = investmentFundPackId;
	}

	@Column(name = "investmentFundID", nullable = false, length = 32)
	public String getInvestmentFundId() {
		return this.investmentFundId;
	}

	public void setInvestmentFundId(String investmentFundId) {
		this.investmentFundId = investmentFundId;
	}

	@Column(name = "accountID", nullable = false, length = 32)
	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
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
