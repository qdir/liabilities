
import es.unileon.ulebank.account.history.AccountHistory;

/* Application developed for AW subject, belonging to passive operations
 group.*/

/**
 *
 * @author runix
 */
public class Test {
    
    public static void main(String [] args) {
        AccountHistory ah = new AccountHistory();
        ah.getIterator(new String[]{"-include","10","10","-exclude","10a",""});
    }
}
