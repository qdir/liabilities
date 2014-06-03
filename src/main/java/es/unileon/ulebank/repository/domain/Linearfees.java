package es.unileon.ulebank.repository.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "linearfees", catalog = "ulebank")
public class Linearfees implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long feeId;
	private double minimum;
	private double fee;
	private Set<Loans> loansesForAmortizationFee = new HashSet<Loans>(0);
	private Set<Loans> loansesForDelayedPaymentFee = new HashSet<Loans>(0);
	private Set<Loans> loansesForCancelFee = new HashSet<Loans>(0);
	private Set<Cards> cardsesForRenovationFee = new HashSet<Cards>(0);
	private Set<Loans> loansesForModifyFee = new HashSet<Loans>(0);
	private Set<Investmentaccounts> investmentaccountsesForSellStockageFee = new HashSet<Investmentaccounts>(0);
	private Set<Investmentaccounts> investmentaccountsesForBuyStockageFee = new HashSet<Investmentaccounts>(0);
	private Set<Investmentfunds> investmentfundsesForFee = new HashSet<Investmentfunds>(0);
	private Set<Investmentfunds> investmentfundsesForCancellationFee = new HashSet<Investmentfunds>(0);
	private Set<Loans> loansesForOpeningFee = new HashSet<Loans>(0);
	private Set<Cards> cardsesForMaintenanceFee = new HashSet<Cards>(0);
	private Set<Loans> loansesForStudyFee = new HashSet<Loans>(0);
	private Set<Cards> cardsesForEmissionFee = new HashSet<Cards>(0);

	public Linearfees() {
	}

	public Linearfees(double minimum, double fee) {
		this.minimum = minimum;
		this.fee = fee;
	}

	public Linearfees(double minimum, double fee,
			Set<Loans> loansesForAmortizationFee,
			Set<Loans> loansesForDelayedPaymentFee,
			Set<Loans> loansesForCancelFee, Set<Cards> cardsesForRenovationFee,
			Set<Loans> loansesForModifyFee,
			Set<Investmentaccounts> investmentaccountsesForSellStockageFee,
			Set<Investmentaccounts> investmentaccountsesForBuyStockageFee,
			Set<Investmentfunds> investmentfundsesForFee,
			Set<Investmentfunds> investmentfundsesForCancellationFee,
			Set<Loans> loansesForOpeningFee,
			Set<Cards> cardsesForMaintenanceFee, Set<Loans> loansesForStudyFee,
			Set<Cards> cardsesForEmissionFee) {
		this.minimum = minimum;
		this.fee = fee;
		this.loansesForAmortizationFee = loansesForAmortizationFee;
		this.loansesForDelayedPaymentFee = loansesForDelayedPaymentFee;
		this.loansesForCancelFee = loansesForCancelFee;
		this.cardsesForRenovationFee = cardsesForRenovationFee;
		this.loansesForModifyFee = loansesForModifyFee;
		this.investmentaccountsesForSellStockageFee = investmentaccountsesForSellStockageFee;
		this.investmentaccountsesForBuyStockageFee = investmentaccountsesForBuyStockageFee;
		this.investmentfundsesForFee = investmentfundsesForFee;
		this.investmentfundsesForCancellationFee = investmentfundsesForCancellationFee;
		this.loansesForOpeningFee = loansesForOpeningFee;
		this.cardsesForMaintenanceFee = cardsesForMaintenanceFee;
		this.loansesForStudyFee = loansesForStudyFee;
		this.cardsesForEmissionFee = cardsesForEmissionFee;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "feeID", unique = true, nullable = false)
	public Long getFeeId() {
		return this.feeId;
	}

	public void setFeeId(Long feeId) {
		this.feeId = feeId;
	}

	@Column(name = "minimum", nullable = false, precision = 22, scale = 0)
	public double getMinimum() {
		return this.minimum;
	}

	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}

	@Column(name = "fee", nullable = false, precision = 22, scale = 0)
	public double getFee() {
		return this.fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "linearfeesByAmortizationFee")
	public Set<Loans> getLoansesForAmortizationFee() {
		return this.loansesForAmortizationFee;
	}

	public void setLoansesForAmortizationFee(
			Set<Loans> loansesForAmortizationFee) {
		this.loansesForAmortizationFee = loansesForAmortizationFee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "linearfeesByDelayedPaymentFee")
	public Set<Loans> getLoansesForDelayedPaymentFee() {
		return this.loansesForDelayedPaymentFee;
	}

	public void setLoansesForDelayedPaymentFee(
			Set<Loans> loansesForDelayedPaymentFee) {
		this.loansesForDelayedPaymentFee = loansesForDelayedPaymentFee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "linearfeesByCancelFee")
	public Set<Loans> getLoansesForCancelFee() {
		return this.loansesForCancelFee;
	}

	public void setLoansesForCancelFee(Set<Loans> loansesForCancelFee) {
		this.loansesForCancelFee = loansesForCancelFee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "linearfeesByRenovationFee")
	public Set<Cards> getCardsesForRenovationFee() {
		return this.cardsesForRenovationFee;
	}

	public void setCardsesForRenovationFee(Set<Cards> cardsesForRenovationFee) {
		this.cardsesForRenovationFee = cardsesForRenovationFee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "linearfeesByModifyFee")
	public Set<Loans> getLoansesForModifyFee() {
		return this.loansesForModifyFee;
	}

	public void setLoansesForModifyFee(Set<Loans> loansesForModifyFee) {
		this.loansesForModifyFee = loansesForModifyFee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "linearfeesBySellStockageFee")
	public Set<Investmentaccounts> getInvestmentaccountsesForSellStockageFee() {
		return this.investmentaccountsesForSellStockageFee;
	}

	public void setInvestmentaccountsesForSellStockageFee(
			Set<Investmentaccounts> investmentaccountsesForSellStockageFee) {
		this.investmentaccountsesForSellStockageFee = investmentaccountsesForSellStockageFee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "linearfeesByBuyStockageFee")
	public Set<Investmentaccounts> getInvestmentaccountsesForBuyStockageFee() {
		return this.investmentaccountsesForBuyStockageFee;
	}

	public void setInvestmentaccountsesForBuyStockageFee(
			Set<Investmentaccounts> investmentaccountsesForBuyStockageFee) {
		this.investmentaccountsesForBuyStockageFee = investmentaccountsesForBuyStockageFee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "linearfeesByFee")
	public Set<Investmentfunds> getInvestmentfundsesForFee() {
		return this.investmentfundsesForFee;
	}

	public void setInvestmentfundsesForFee(
			Set<Investmentfunds> investmentfundsesForFee) {
		this.investmentfundsesForFee = investmentfundsesForFee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "linearfeesByCancellationFee")
	public Set<Investmentfunds> getInvestmentfundsesForCancellationFee() {
		return this.investmentfundsesForCancellationFee;
	}

	public void setInvestmentfundsesForCancellationFee(
			Set<Investmentfunds> investmentfundsesForCancellationFee) {
		this.investmentfundsesForCancellationFee = investmentfundsesForCancellationFee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "linearfeesByOpeningFee")
	public Set<Loans> getLoansesForOpeningFee() {
		return this.loansesForOpeningFee;
	}

	public void setLoansesForOpeningFee(Set<Loans> loansesForOpeningFee) {
		this.loansesForOpeningFee = loansesForOpeningFee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "linearfeesByMaintenanceFee")
	public Set<Cards> getCardsesForMaintenanceFee() {
		return this.cardsesForMaintenanceFee;
	}

	public void setCardsesForMaintenanceFee(Set<Cards> cardsesForMaintenanceFee) {
		this.cardsesForMaintenanceFee = cardsesForMaintenanceFee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "linearfeesByStudyFee")
	public Set<Loans> getLoansesForStudyFee() {
		return this.loansesForStudyFee;
	}

	public void setLoansesForStudyFee(Set<Loans> loansesForStudyFee) {
		this.loansesForStudyFee = loansesForStudyFee;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "linearfeesByEmissionFee")
	public Set<Cards> getCardsesForEmissionFee() {
		return this.cardsesForEmissionFee;
	}

	public void setCardsesForEmissionFee(Set<Cards> cardsesForEmissionFee) {
		this.cardsesForEmissionFee = cardsesForEmissionFee;
	}

}
