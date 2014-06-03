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
@Table(name = "cards", catalog = "ulebank")
public class Cards implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private CardsId id;
	private Persons persons;
	private Accounts accounts;
	private Linearfees linearfeesByMaintenanceFee;
	private Linearfees linearfeesByRenovationFee;
	private Linearfees linearfeesByEmissionFee;

	public Cards() {
	}

	public Cards(CardsId id, Persons persons, Accounts accounts,
			Linearfees linearfeesByMaintenanceFee,
			Linearfees linearfeesByRenovationFee,
			Linearfees linearfeesByEmissionFee) {
		this.id = id;
		this.persons = persons;
		this.accounts = accounts;
		this.linearfeesByMaintenanceFee = linearfeesByMaintenanceFee;
		this.linearfeesByRenovationFee = linearfeesByRenovationFee;
		this.linearfeesByEmissionFee = linearfeesByEmissionFee;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cardId", column = @Column(name = "cardID", nullable = false, length = 32)),
			@AttributeOverride(name = "clientId", column = @Column(name = "clientID", nullable = false, length = 32)),
			@AttributeOverride(name = "accountId", column = @Column(name = "accountID", nullable = false, length = 32)),
			@AttributeOverride(name = "pin", column = @Column(name = "pin", nullable = false, length = 4)),
			@AttributeOverride(name = "buyDiaryLimit", column = @Column(name = "buyDiaryLimit", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "buyMonthlyLimit", column = @Column(name = "buyMonthlyLimit", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "cashDiaryLimit", column = @Column(name = "cashDiaryLimit", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "cashMonthlyLimit", column = @Column(name = "cashMonthlyLimit", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "emissionDate", column = @Column(name = "emissionDate", nullable = false, length = 19)),
			@AttributeOverride(name = "expirationDate", column = @Column(name = "expirationDate", nullable = false, length = 19)),
			@AttributeOverride(name = "type", column = @Column(name = "type", nullable = false)),
			@AttributeOverride(name = "cvv", column = @Column(name = "cvv", nullable = false, length = 3)),
			@AttributeOverride(name = "emissionFee", column = @Column(name = "emissionFee", nullable = false)),
			@AttributeOverride(name = "maintenanceFee", column = @Column(name = "maintenanceFee", nullable = false)),
			@AttributeOverride(name = "renovationFee", column = @Column(name = "renovationFee", nullable = false)) })
	public CardsId getId() {
		return this.id;
	}

	public void setId(CardsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientID", nullable = false, insertable = false, updatable = false)
	public Persons getPersons() {
		return this.persons;
	}

	public void setPersons(Persons persons) {
		this.persons = persons;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accountID", nullable = false, insertable = false, updatable = false)
	public Accounts getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maintenanceFee", nullable = false, insertable = false, updatable = false)
	public Linearfees getLinearfeesByMaintenanceFee() {
		return this.linearfeesByMaintenanceFee;
	}

	public void setLinearfeesByMaintenanceFee(
			Linearfees linearfeesByMaintenanceFee) {
		this.linearfeesByMaintenanceFee = linearfeesByMaintenanceFee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "renovationFee", nullable = false, insertable = false, updatable = false)
	public Linearfees getLinearfeesByRenovationFee() {
		return this.linearfeesByRenovationFee;
	}

	public void setLinearfeesByRenovationFee(
			Linearfees linearfeesByRenovationFee) {
		this.linearfeesByRenovationFee = linearfeesByRenovationFee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emissionFee", nullable = false, insertable = false, updatable = false)
	public Linearfees getLinearfeesByEmissionFee() {
		return this.linearfeesByEmissionFee;
	}

	public void setLinearfeesByEmissionFee(Linearfees linearfeesByEmissionFee) {
		this.linearfeesByEmissionFee = linearfeesByEmissionFee;
	}

}
