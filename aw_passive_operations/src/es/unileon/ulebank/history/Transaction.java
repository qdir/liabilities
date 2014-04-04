/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.history;

import es.unileon.ulebank.handler.Handler;
import java.util.Date;

/**
 *
 * @author roobre
 */
public abstract class Transaction {

    private final Handler id;
    private final double amount;
    private final Date date;
    private Date effectiveDate;
    private final String subject;
    private final Enum<TransactionType> type;
    private final Handler destination;

    public Transaction(Handler id, double amount, Date date, String subject, Enum<TransactionType> type, Handler destination) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.subject = subject;
        this.type = type;
        this.destination = destination;
    }

    /**
     * The transaction destination
     *
     * @return ( the destination )
     */
    public Handler getDestination() {
        return this.destination;
    }

    /**
     * @return the id
     */
    public Handler getId() {
        return id;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the effectiveDate
     */
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @return the type
     */
    public Enum<TransactionType> getType() {
        return type;
    }

    /**
     * Set the effective date of the transaction This date, can be set only
     * once. So, if you set the date once, you can modify it.
     *
     * @param effectiveDate ( Date to set )
     */
    public void setEffectiveDate(Date effectiveDate) {
        if (this.effectiveDate == null) {
            this.effectiveDate = date;
        }
    }

    @Override
    public String toString() {
        return "Transaction " + "id=" + id + ", amount=" + amount + ", date=" + date + ", effectiveDate=" + effectiveDate + ", subject=" + subject;
    }
}
