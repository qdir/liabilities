package es.unileon.ulebank.repository.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InvestmentfundsId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String investmentFundId;
	private String openerId;
	private int amount;
	private long purchasedAmount;
	private double totalPrice;
	private double estimatedProfitability;
	private long fee;
	private long cancellationFee;

	public InvestmentfundsId() {
	}

	public InvestmentfundsId(String investmentFundId, String openerId,
			int amount, long purchasedAmount, double totalPrice,
			double estimatedProfitability, long fee, long cancellationFee) {
		this.investmentFundId = investmentFundId;
		this.openerId = openerId;
		this.amount = amount;
		this.purchasedAmount = purchasedAmount;
		this.totalPrice = totalPrice;
		this.estimatedProfitability = estimatedProfitability;
		this.fee = fee;
		this.cancellationFee = cancellationFee;
	}

	@Column(name = "investmentFundID", nullable = false, length = 32)
	public String getInvestmentFundId() {
		return this.investmentFundId;
	}

	public void setInvestmentFundId(String investmentFundId) {
		this.investmentFundId = investmentFundId;
	}

	@Column(name = "openerID", nullable = false, length = 32)
	public String getOpenerId() {
		return this.openerId;
	}

	public void setOpenerId(String openerId) {
		this.openerId = openerId;
	}

	@Column(name = "amount", nullable = false)
	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Column(name = "purchasedAmount", nullable = false)
	public long getPurchasedAmount() {
		return this.purchasedAmount;
	}

	public void setPurchasedAmount(long purchasedAmount) {
		this.purchasedAmount = purchasedAmount;
	}

	@Column(name = "totalPrice", nullable = false, precision = 22, scale = 0)
	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name = "estimatedProfitability", nullable = false, precision = 22, scale = 0)
	public double getEstimatedProfitability() {
		return this.estimatedProfitability;
	}

	public void setEstimatedProfitability(double estimatedProfitability) {
		this.estimatedProfitability = estimatedProfitability;
	}

	@Column(name = "fee", nullable = false)
	public long getFee() {
		return this.fee;
	}

	public void setFee(long fee) {
		this.fee = fee;
	}

	@Column(name = "cancellationFee", nullable = false)
	public long getCancellationFee() {
		return this.cancellationFee;
	}

	public void setCancellationFee(long cancellationFee) {
		this.cancellationFee = cancellationFee;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InvestmentfundsId))
			return false;
		InvestmentfundsId castOther = (InvestmentfundsId) other;

		return ((this.getInvestmentFundId() == castOther.getInvestmentFundId()) || (this
				.getInvestmentFundId() != null
				&& castOther.getInvestmentFundId() != null && this
				.getInvestmentFundId().equals(castOther.getInvestmentFundId())))
				&& ((this.getOpenerId() == castOther.getOpenerId()) || (this
						.getOpenerId() != null
						&& castOther.getOpenerId() != null && this
						.getOpenerId().equals(castOther.getOpenerId())))
				&& (this.getAmount() == castOther.getAmount())
				&& (this.getPurchasedAmount() == castOther.getPurchasedAmount())
				&& (this.getTotalPrice() == castOther.getTotalPrice())
				&& (this.getEstimatedProfitability() == castOther
						.getEstimatedProfitability())
				&& (this.getFee() == castOther.getFee())
				&& (this.getCancellationFee() == castOther.getCancellationFee());
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getInvestmentFundId() == null ? 0 : this
						.getInvestmentFundId().hashCode());
		result = 37 * result
				+ (getOpenerId() == null ? 0 : this.getOpenerId().hashCode());
		result = 37 * result + this.getAmount();
		result = 37 * result + (int) this.getPurchasedAmount();
		result = 37 * result + (int) this.getTotalPrice();
		result = 37 * result + (int) this.getEstimatedProfitability();
		result = 37 * result + (int) this.getFee();
		result = 37 * result + (int) this.getCancellationFee();
		return result;
	}

}
