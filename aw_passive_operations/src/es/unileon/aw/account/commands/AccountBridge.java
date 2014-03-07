/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.aw.account.commands;

/**
 *
 * @author runix
 */
public class AccountBridge {

    /**
     * Temporal value that represent the amount of money that has the account.
     * Modify this value don't imply that the account money change, the account
     * before change his money checks security threats and incosistencies.
     */
    private float money;

    /**
     * Create a new account bridge, that is a temporal account. You can use it
     * for avoid that other objects keeps references to the original account and
     * modify later his values.
     *
     * @param money ( The amount of money that has the account )
     */
    public AccountBridge(float money) {
        this.money = money;
    }

    /**
     * Get the amount of money that has the temporal account
     *
     * @return ( the amount of money )
     */
    public float getMoney() {
        return this.money;
    }

    /**
     * Add or substract money ( if the number is positive add, negative
     * substract). As constructor javadoc explains, modify this value don't
     * change the amount of money of the account.
     *
     * @param amount ( the money ott add (+) or substract (-))
     */
    public void addMoney(float amount) {
        this.money += amount;
    }
}
