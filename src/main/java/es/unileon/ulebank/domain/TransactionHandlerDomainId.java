package es.unileon.ulebank.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TransactionHandlerDomainId implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private long transactionId;
	private long transactionHandlerId;
	
	public TransactionHandlerDomainId(){
	}
	
	public TransactionHandlerDomainId(long transactionId, long transactionHandlerId){
		this.transactionId = transactionId;
		this.transactionHandlerId = transactionHandlerId;
	}
	
	@Column(name = "TransactionID", nullable = false)
	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	@Column(name = "TransactionHandlerID", nullable = false)
	public long getTransactionHandlerId() {
		return transactionHandlerId;
	}

	public void setTransactionHandlerId(long transactionHandlerId) {
		this.transactionHandlerId = transactionHandlerId;
	}

}
