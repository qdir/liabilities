package es.unileon.ulebank.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import es.unileon.ulebank.handler.Handler;

@Entity
@Table(name="TransactionHandlers") 
public class TransactionHandlerDomain implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TransactionHandlerDomainId id;
	private String timestamp;
	
	public TransactionHandlerDomain(){
		
	}
	
	public TransactionHandlerDomain(TransactionHandlerDomainId id, String timestamp) {
		this.id = id;
		this.timestamp = timestamp;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "transactionId", column = @Column(name = "TransactionID", nullable = false)),
			@AttributeOverride(name = "transactionHandlerId", column = @Column(name = "TransactionHandlerID", nullable = false)) })
	public TransactionHandlerDomainId getId() {
		return id;
	}

	public void setId(TransactionHandlerDomainId id) {
		this.id = id;
	}

	@Column(name = "Timestamp", nullable = false, length = 45)
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return timestamp + "." + Long.toString(id.getTransactionId());
	}

	public int compareTo(Handler another) {
		return this.toString().compareTo(another.toString());
	}
}
