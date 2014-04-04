/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.account.history;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.TransactionType;
import java.util.Date;

/**
 *
 * @author runix
 */
public class AccountEntry {

    private String subject;
    private Handler entryID;
    private Date creationDate;
    private Date effectiveDate;
    private DetailedInformation detailedInformation;
    private Double amount;
    private Enum<TransactionType> type;

    public AccountEntry(Enum<TransactionType> type, double amount, String subject, Handler movementID, Date creationDate, Date effectiveDate, DetailedInformation extraInfo) {
        this.subject = subject;
        this.entryID = movementID;
        this.creationDate = creationDate;
        this.effectiveDate = effectiveDate;
        this.detailedInformation = extraInfo;
        this.amount = amount;
        this.type = type;
        this.detailedInformation.doFinal();;
    }

    public AccountEntry(Enum<TransactionType> type, double amount, String subject, Handler movementID, Date creationDate, Date effectiveDate) {
        this(type, amount, subject, movementID, creationDate, effectiveDate, new DetailedInformation(""));
    }

    public String getSubject() {
        return this.subject;
    }

    public Date getEffectiveDate() {
        return this.effectiveDate;
    }

    public double getAmount() {
        return this.amount;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public Handler getMovementID() {
        return this.entryID;
    }

    public Enum<TransactionType> getType() {
        return this.type;
    }
    
    public DetailedInformation getDetailedInformation() {
        return this.detailedInformation;
    }
}
