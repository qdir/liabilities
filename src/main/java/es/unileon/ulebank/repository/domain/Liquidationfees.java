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
@Table(name = "liquidationfees", catalog = "ulebank")
public class Liquidationfees implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer liquidationFeeId;
	private Accounts accounts;

	public Liquidationfees() {
	}

	public Liquidationfees(Accounts accounts) {
		this.accounts = accounts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "liquidationFeeID", unique = true, nullable = false)
	public Integer getLiquidationFeeId() {
		return this.liquidationFeeId;
	}

	public void setLiquidationFeeId(Integer liquidationFeeId) {
		this.liquidationFeeId = liquidationFeeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountID", nullable = false)
	public Accounts getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

}
