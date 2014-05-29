package es.unileon.ulebank.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetailedInformationDomainId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private long transactionId;
	private long detailedInformationId;
	
	public DetailedInformationDomainId(){
	}
	
	public DetailedInformationDomainId(long transactionId, long detailedInformationId){
		this.transactionId = transactionId;
		this.detailedInformationId = transactionId;
	}
	
	@Column(name = "TransactionID", nullable = false)
	public long getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	
	@Column(name = "DetailedInformationID", nullable = false)
	public long getDetailedInformationId() {
		return detailedInformationId;
	}

	public void setDetailedInformationId(long detailedInformationId) {
		this.detailedInformationId = detailedInformationId;
	}
}
