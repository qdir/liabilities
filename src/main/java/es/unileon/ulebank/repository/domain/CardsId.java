package es.unileon.ulebank.repository.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CardsId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cardId;
	private String clientId;
	private String accountId;
	private String pin;
	private double buyDiaryLimit;
	private double buyMonthlyLimit;
	private double cashDiaryLimit;
	private double cashMonthlyLimit;
	private Date emissionDate;
	private Date expirationDate;
	private boolean type;
	private String cvv;
	private long emissionFee;
	private long maintenanceFee;
	private long renovationFee;

	public CardsId() {
	}

	public CardsId(String cardId, String clientId, String accountId,
			String pin, double buyDiaryLimit, double buyMonthlyLimit,
			double cashDiaryLimit, double cashMonthlyLimit, Date emissionDate,
			Date expirationDate, boolean type, String cvv, long emissionFee,
			long maintenanceFee, long renovationFee) {
		this.cardId = cardId;
		this.clientId = clientId;
		this.accountId = accountId;
		this.pin = pin;
		this.buyDiaryLimit = buyDiaryLimit;
		this.buyMonthlyLimit = buyMonthlyLimit;
		this.cashDiaryLimit = cashDiaryLimit;
		this.cashMonthlyLimit = cashMonthlyLimit;
		this.emissionDate = emissionDate;
		this.expirationDate = expirationDate;
		this.type = type;
		this.cvv = cvv;
		this.emissionFee = emissionFee;
		this.maintenanceFee = maintenanceFee;
		this.renovationFee = renovationFee;
	}

	@Column(name = "cardID", nullable = false, length = 32)
	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	@Column(name = "clientID", nullable = false, length = 32)
	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Column(name = "accountID", nullable = false, length = 32)
	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Column(name = "pin", nullable = false, length = 4)
	public String getPin() {
		return this.pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Column(name = "buyDiaryLimit", nullable = false, precision = 22, scale = 0)
	public double getBuyDiaryLimit() {
		return this.buyDiaryLimit;
	}

	public void setBuyDiaryLimit(double buyDiaryLimit) {
		this.buyDiaryLimit = buyDiaryLimit;
	}

	@Column(name = "buyMonthlyLimit", nullable = false, precision = 22, scale = 0)
	public double getBuyMonthlyLimit() {
		return this.buyMonthlyLimit;
	}

	public void setBuyMonthlyLimit(double buyMonthlyLimit) {
		this.buyMonthlyLimit = buyMonthlyLimit;
	}

	@Column(name = "cashDiaryLimit", nullable = false, precision = 22, scale = 0)
	public double getCashDiaryLimit() {
		return this.cashDiaryLimit;
	}

	public void setCashDiaryLimit(double cashDiaryLimit) {
		this.cashDiaryLimit = cashDiaryLimit;
	}

	@Column(name = "cashMonthlyLimit", nullable = false, precision = 22, scale = 0)
	public double getCashMonthlyLimit() {
		return this.cashMonthlyLimit;
	}

	public void setCashMonthlyLimit(double cashMonthlyLimit) {
		this.cashMonthlyLimit = cashMonthlyLimit;
	}

	@Column(name = "emissionDate", nullable = false, length = 19)
	public Date getEmissionDate() {
		return this.emissionDate;
	}

	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
	}

	@Column(name = "expirationDate", nullable = false, length = 19)
	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Column(name = "type", nullable = false)
	public boolean isType() {
		return this.type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	@Column(name = "cvv", nullable = false, length = 3)
	public String getCvv() {
		return this.cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Column(name = "emissionFee", nullable = false)
	public long getEmissionFee() {
		return this.emissionFee;
	}

	public void setEmissionFee(long emissionFee) {
		this.emissionFee = emissionFee;
	}

	@Column(name = "maintenanceFee", nullable = false)
	public long getMaintenanceFee() {
		return this.maintenanceFee;
	}

	public void setMaintenanceFee(long maintenanceFee) {
		this.maintenanceFee = maintenanceFee;
	}

	@Column(name = "renovationFee", nullable = false)
	public long getRenovationFee() {
		return this.renovationFee;
	}

	public void setRenovationFee(long renovationFee) {
		this.renovationFee = renovationFee;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CardsId))
			return false;
		CardsId castOther = (CardsId) other;

		return ((this.getCardId() == castOther.getCardId()) || (this
				.getCardId() != null && castOther.getCardId() != null && this
				.getCardId().equals(castOther.getCardId())))
				&& ((this.getClientId() == castOther.getClientId()) || (this
						.getClientId() != null
						&& castOther.getClientId() != null && this
						.getClientId().equals(castOther.getClientId())))
				&& ((this.getAccountId() == castOther.getAccountId()) || (this
						.getAccountId() != null
						&& castOther.getAccountId() != null && this
						.getAccountId().equals(castOther.getAccountId())))
				&& ((this.getPin() == castOther.getPin()) || (this.getPin() != null
						&& castOther.getPin() != null && this.getPin().equals(
						castOther.getPin())))
				&& (this.getBuyDiaryLimit() == castOther.getBuyDiaryLimit())
				&& (this.getBuyMonthlyLimit() == castOther.getBuyMonthlyLimit())
				&& (this.getCashDiaryLimit() == castOther.getCashDiaryLimit())
				&& (this.getCashMonthlyLimit() == castOther
						.getCashMonthlyLimit())
				&& ((this.getEmissionDate() == castOther.getEmissionDate()) || (this
						.getEmissionDate() != null
						&& castOther.getEmissionDate() != null && this
						.getEmissionDate().equals(castOther.getEmissionDate())))
				&& ((this.getExpirationDate() == castOther.getExpirationDate()) || (this
						.getExpirationDate() != null
						&& castOther.getExpirationDate() != null && this
						.getExpirationDate().equals(
								castOther.getExpirationDate())))
				&& (this.isType() == castOther.isType())
				&& ((this.getCvv() == castOther.getCvv()) || (this.getCvv() != null
						&& castOther.getCvv() != null && this.getCvv().equals(
						castOther.getCvv())))
				&& (this.getEmissionFee() == castOther.getEmissionFee())
				&& (this.getMaintenanceFee() == castOther.getMaintenanceFee())
				&& (this.getRenovationFee() == castOther.getRenovationFee());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCardId() == null ? 0 : this.getCardId().hashCode());
		result = 37 * result
				+ (getClientId() == null ? 0 : this.getClientId().hashCode());
		result = 37 * result
				+ (getAccountId() == null ? 0 : this.getAccountId().hashCode());
		result = 37 * result
				+ (getPin() == null ? 0 : this.getPin().hashCode());
		result = 37 * result + (int) this.getBuyDiaryLimit();
		result = 37 * result + (int) this.getBuyMonthlyLimit();
		result = 37 * result + (int) this.getCashDiaryLimit();
		result = 37 * result + (int) this.getCashMonthlyLimit();
		result = 37
				* result
				+ (getEmissionDate() == null ? 0 : this.getEmissionDate()
						.hashCode());
		result = 37
				* result
				+ (getExpirationDate() == null ? 0 : this.getExpirationDate()
						.hashCode());
		result = 37 * result + (this.isType() ? 1 : 0);
		result = 37 * result
				+ (getCvv() == null ? 0 : this.getCvv().hashCode());
		result = 37 * result + (int) this.getEmissionFee();
		result = 37 * result + (int) this.getMaintenanceFee();
		result = 37 * result + (int) this.getRenovationFee();
		return result;
	}

}
