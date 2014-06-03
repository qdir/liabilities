package es.unileon.ulebank.repository.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "enterprises", catalog = "ulebank")
public class Enterprises implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private EnterprisesId id;

	public Enterprises() {
	}

	public Enterprises(EnterprisesId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "enterpriseId", column = @Column(name = "enterpriseID", nullable = false, length = 32)),
			@AttributeOverride(name = "name", column = @Column(name = "name", nullable = false, length = 32)),
			@AttributeOverride(name = "address", column = @Column(name = "address", nullable = false)) })
	public EnterprisesId getId() {
		return this.id;
	}

	public void setId(EnterprisesId id) {
		this.id = id;
	}

}
