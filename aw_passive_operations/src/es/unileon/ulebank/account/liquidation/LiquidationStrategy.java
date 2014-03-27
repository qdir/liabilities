/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.account.liquidation;

import es.unileon.ulebank.history.History;

/**
 *
 * @author runix
 */
public interface LiquidationStrategy {
   
    /**
     * Perform liquitadation based on account
     * history.
     * 
     * @param history (The history of the account)
     * 
     * @return (The amount of money to pay )
     */
    public double doLiquidation(History history);
}
