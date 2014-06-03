package es.unileon.ulebank.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offices", catalog = "ulebank")
public class Offices implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String officeId;

	public Offices() {
	}

	public Offices(String officeId) {
		this.officeId = officeId;
	}

	@Id
	@Column(name = "officeID", nullable = false, length = 32)
	public String getOfficeId() {
		return this.officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

}
