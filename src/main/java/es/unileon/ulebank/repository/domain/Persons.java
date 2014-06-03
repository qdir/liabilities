package es.unileon.ulebank.repository.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "persons", catalog = "ulebank")
public class Persons implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String personId;
	private String name;
	private String surname;
	private String address;
	private boolean civilState;
	private String profession;
	private Date birthDate;
	private Set<Accounts> accountses = new HashSet<Accounts>(0);
	private Set<Investmentaccounts> investmentaccountses = new HashSet<Investmentaccounts>(
			0);
	private Set<Loans> loanses = new HashSet<Loans>(0);
	private Set<Cards> cardses = new HashSet<Cards>(0);

	public Persons() {
	}

	public Persons(String personId, String name, String surname,
			String address, boolean civilState, String profession,
			Date birthDate) {
		this.personId = personId;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.civilState = civilState;
		this.profession = profession;
		this.birthDate = birthDate;
	}

	public Persons(String personId, String name, String surname,
			String address, boolean civilState, String profession,
			Date birthDate, Set<Accounts> accountses,
			Set<Investmentaccounts> investmentaccountses, Set<Loans> loanses,
			Set<Cards> cardses) {
		this.personId = personId;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.civilState = civilState;
		this.profession = profession;
		this.birthDate = birthDate;
		this.accountses = accountses;
		this.investmentaccountses = investmentaccountses;
		this.loanses = loanses;
		this.cardses = cardses;
	}

	@Id
	@Column(name = "personID", unique = true, nullable = false, length = 32)
	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "surname", nullable = false, length = 32)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "address", nullable = false, length = 32)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "civilState", nullable = false)
	public boolean isCivilState() {
		return this.civilState;
	}

	public void setCivilState(boolean civilState) {
		this.civilState = civilState;
	}

	@Column(name = "profession", nullable = false, length = 32)
	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthDate", nullable = false, length = 19)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "personses")
	public Set<Accounts> getAccountses() {
		return this.accountses;
	}

	public void setAccountses(Set<Accounts> accountses) {
		this.accountses = accountses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persons")
	public Set<Investmentaccounts> getInvestmentaccountses() {
		return this.investmentaccountses;
	}

	public void setInvestmentaccountses(
			Set<Investmentaccounts> investmentaccountses) {
		this.investmentaccountses = investmentaccountses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persons")
	public Set<Loans> getLoanses() {
		return this.loanses;
	}

	public void setLoanses(Set<Loans> loanses) {
		this.loanses = loanses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persons")
	public Set<Cards> getCardses() {
		return this.cardses;
	}

	public void setCardses(Set<Cards> cardses) {
		this.cardses = cardses;
	}

}
