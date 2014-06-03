package es.unileon.ulebank.repository.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "investmentfunds", catalog = "ulebank")
public class Investmentfunds implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private InvestmentfundsId id;
	private Linearfees linearfeesByFee;
	private Linearfees linearfeesByCancellationFee;

	public Investmentfunds() {
	}

	public Investmentfunds(InvestmentfundsId id, Linearfees linearfeesByFee,
			Linearfees linearfeesByCancellationFee) {
		this.id = id;
		this.linearfeesByFee = linearfeesByFee;
		this.linearfeesByCancellationFee = linearfeesByCancellationFee;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "investmentFundId", column = @Column(name = "investmentFundID", nullable = false, length = 32)),
			@AttributeOverride(name = "openerId", column = @Column(name = "openerID", nullable = false, length = 32)),
			@AttributeOverride(name = "amount", column = @Column(name = "amount", nullable = false)),
			@AttributeOverride(name = "purchasedAmount", column = @Column(name = "purchasedAmount", nullable = false)),
			@AttributeOverride(name = "totalPrice", column = @Column(name = "totalPrice", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "estimatedProfitability", column = @Column(name = "estimatedProfitability", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "fee", column = @Column(name = "fee", nullable = false)),
			@AttributeOverride(name = "cancellationFee", column = @Column(name = "cancellationFee", nullable = false)) })
	public InvestmentfundsId getId() {
		return this.id;
	}

	public void setId(InvestmentfundsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fee", nullable = false, insertable = false, updatable = false)
	public Linearfees getLinearfeesByFee() {
		return this.linearfeesByFee;
	}

	public void setLinearfeesByFee(Linearfees linearfeesByFee) {
		this.linearfeesByFee = linearfeesByFee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cancellationFee", nullable = false, insertable = false, updatable = false)
	public Linearfees getLinearfeesByCancellationFee() {
		return this.linearfeesByCancellationFee;
	}

	public void setLinearfeesByCancellationFee(
			Linearfees linearfeesByCancellationFee) {
		this.linearfeesByCancellationFee = linearfeesByCancellationFee;
	}

}
