
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.account.types.CommercialAccount;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.history.GenericTransaction;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import es.unileon.ulebank.office.Office;
import java.util.Date;

/* Application developed for AW subject, belonging to passive operations
 group.*/
/**
 *
 * @author runix
 */
public class TransactionExample {

    private Bank bank;
    private Office office;
    private Account account1;
    private Account account2;

    public TransactionExample() throws MalformedHandlerException {
        System.out.println(TransactionType.CHARGE);
//        bank = new Bank(new GenericHandler("1234"));
//        office = new Office(new GenericHandler("1234"));
//        bank.addOffice(office);
//        account1 = new CommercialAccount(office, bank, "1234567890");
//        account2 = new CommercialAccount(office, bank, "1234567891");
//        office.addAccount(account1);
//        office.addAccount(account2);
    }

    public void run() throws MalformedHandlerException, TransactionException {

    }

    public static void main(String[] args) throws MalformedHandlerException, TransactionException {
        new TransactionExample().run();
    }
}
