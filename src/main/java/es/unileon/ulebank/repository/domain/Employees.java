package es.unileon.ulebank.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees", catalog = "ulebank")
public class Employees implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String employeeId;

	public Employees() {
	}

	public Employees(String employeeId) {
		this.employeeId = employeeId;
	}

	@Id
	@Column(name = "employeeID", nullable = false, length = 32)
	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}
