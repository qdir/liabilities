package es.unileon.ulebank.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feecases", catalog = "ulebank")
public class Feecases implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer feeCaseId;
	private String amountFormula;
	private String triggeringConditions;
	private String subject;

	public Feecases() {
	}

	public Feecases(String amountFormula, String triggeringConditions,
			String subject) {
		this.amountFormula = amountFormula;
		this.triggeringConditions = triggeringConditions;
		this.subject = subject;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "feeCaseID", unique = true, nullable = false)
	public Integer getFeeCaseId() {
		return this.feeCaseId;
	}

	public void setFeeCaseId(Integer feeCaseId) {
		this.feeCaseId = feeCaseId;
	}

	@Column(name = "amountFormula", nullable = false, length = 256)
	public String getAmountFormula() {
		return this.amountFormula;
	}

	public void setAmountFormula(String amountFormula) {
		this.amountFormula = amountFormula;
	}

	@Column(name = "triggeringConditions", nullable = false, length = 256)
	public String getTriggeringConditions() {
		return this.triggeringConditions;
	}

	public void setTriggeringConditions(String triggeringConditions) {
		this.triggeringConditions = triggeringConditions;
	}

	@Column(name = "subject", nullable = false)
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
