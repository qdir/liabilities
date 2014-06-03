package es.unileon.ulebank.repository.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnterprisesId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String enterpriseId;
	private String name;
	private String address;

	public EnterprisesId() {
	}

	public EnterprisesId(String enterpriseId, String name, String address) {
		this.enterpriseId = enterpriseId;
		this.name = name;
		this.address = address;
	}

	@Column(name = "enterpriseID", nullable = false, length = 32)
	public String getEnterpriseId() {
		return this.enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EnterprisesId))
			return false;
		EnterprisesId castOther = (EnterprisesId) other;

		return ((this.getEnterpriseId() == castOther.getEnterpriseId()) || (this
				.getEnterpriseId() != null
				&& castOther.getEnterpriseId() != null && this
				.getEnterpriseId().equals(castOther.getEnterpriseId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getAddress() == castOther.getAddress()) || (this
						.getAddress() != null && castOther.getAddress() != null && this
						.getAddress().equals(castOther.getAddress())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getEnterpriseId() == null ? 0 : this.getEnterpriseId()
						.hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getAddress() == null ? 0 : this.getAddress().hashCode());
		return result;
	}

}
