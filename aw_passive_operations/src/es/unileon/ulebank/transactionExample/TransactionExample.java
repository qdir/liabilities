
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
import es.unileon.ulebank.transaction.TransactionManager;
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
    private TransactionManager manager;

    public TransactionExample() throws MalformedHandlerException {
        bank = new Bank(new GenericHandler("1234"));
        office = new Office(new GenericHandler("1234"));
        bank.addOffice(office);
        account1 = new CommercialAccount(office, bank, "1234567890");
        account2 = new CommercialAccount(office, bank, "1234567891");
        office.addAccount(account1);
        office.addAccount(account2);
        manager = new TransactionManager();
        manager.addBank(bank);
    }

    public void run() throws MalformedHandlerException, TransactionException {
        Transaction transaction = new GenericTransaction(new GenericHandler("1234"), -100.0d, new Date(System.currentTimeMillis()), "First test", TransactionType.CHARGE, account1.getID(), account2.getID());
        manager.forwardTransaction(transaction);
        System.out.println("Account 1 " + account1.getBalance());
        System.out.println("Account 2 " + account2.getBalance());

        transaction = new GenericTransaction(new GenericHandler("1234"), 100.0d, new Date(System.currentTimeMillis()), "First test", TransactionType.CHARGE, account2.getID(), account1.getID());
        manager.forwardTransaction(transaction);
        System.out.println("Account 1 " + account1.getBalance());
        System.out.println("Account 2 " + account2.getBalance());

    }

    public static void main(String[] args) throws MalformedHandlerException, TransactionException {
        new TransactionExample().run();
    }
}
