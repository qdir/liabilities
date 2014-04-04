package es.unileon.ulebank.transactionExample;

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
import es.unileon.ulebank.transacionManager.TransactionManager;
import java.util.Date;

/* Application developed for AW subject, belonging to passive operations
 group.*/
/**
 *
 * @author runix
 */
public class TransactionExample {

    private Bank bank;
    private Bank bank2;
    private Office office;
    private Office office2;
    private Account account1;
    private Account account2;
    private TransactionManager manager;

    public TransactionExample() throws MalformedHandlerException {
        System.out.println(TransactionType.CHARGE);
        this.manager = new TransactionManager();
        bank = new Bank(this.manager, new GenericHandler("1234"));
        bank2 = new Bank(this.manager, new GenericHandler("1235"));
        this.manager.addBank(bank);
        this.manager.addBank(bank2);
        office = new Office(new GenericHandler("1234"), this.bank);
        office2 = new Office(new GenericHandler("1235"), this.bank);
        bank.addOffice(office);
        bank2.addOffice(office2);
        account1 = new CommercialAccount(office, bank, "1234567890");
        account2 = new CommercialAccount(office, bank, "1234567891");
        office.addAccount(account1);
        office2.addAccount(account2);
    }

    public void run() throws MalformedHandlerException, TransactionException {
        Transaction transaction = new GenericTransaction(new GenericHandler("e"), 100.0d, new Date(System.currentTimeMillis()), "Emptt", TransactionType.CHARGE, this.account1.getID());
        this.bank2.doTransaction(transaction);
        transaction = new GenericTransaction(new GenericHandler("e"), 100.0d, new Date(System.currentTimeMillis()), "Emptt", TransactionType.PAYMENT, this.account1.getID());
        System.out.println(this.account1.getBalance());
        this.office2.doTransaction(transaction);
        System.out.print(this.account1.getBalance());
    }

    public static void main(String[] args) throws MalformedHandlerException, TransactionException {
        new TransactionExample().run();
    }
}
