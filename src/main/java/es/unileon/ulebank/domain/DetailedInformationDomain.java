package es.unileon.ulebank.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="DetailedInformations") 
public class DetailedInformationDomain implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private DetailedInformationDomainId id;
	private String info;
	private boolean nonEditable;

	
	public DetailedInformationDomain(){
	}
	
	public DetailedInformationDomain(DetailedInformationDomainId id, String info, boolean nonEditable){
		this.id = id;
		this.info = info;
		this.nonEditable = nonEditable;
	}
	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "transactionId", column = @Column(name = "TransactionID", nullable = false)),
			@AttributeOverride(name = "detailedInformationId", column = @Column(name = "DetailedInformationID", nullable = false)) })
	public DetailedInformationDomainId getId() {
		return id;
	}

	public void setId(DetailedInformationDomainId id) {
		this.id = id;
	}
	
	@Column(name = "Info", nullable = false, length = 250)
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "NonEditable")
	public boolean isNonEditable() {
		return nonEditable;
	}

	public void setNonEditable(boolean nonEditable) {
		this.nonEditable = nonEditable;
	}

	
	public void appendInformation(String information) {
		if (!this.nonEditable) {
			this.info = info + information;
		}
	}

	/**
     *
     */
	public void doFinal() {
		this.nonEditable = true;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return this.info.toString();
	}
}
