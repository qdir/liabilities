/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.unileon.ulebank.history;

import java.util.Date;
import java.util.logging.Handler;

/**
 *
 * @author roobre
 */
public abstract class Transaction {
    
    protected Handler id;
    protected double amount;
    protected Date date;
    protected Date effectiveDate;
    protected String subject;
    protected Enum<TransactionType> type;

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
}
