/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.office;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import es.unileon.ulebank.Employee;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.Handler;

/**
 *
 * @author runix
 */
public class Office {

	/**
	 * Office's logger
	 */
	private static final Logger LOG = Logger.getLogger(Account.class.getName());

	/**
	 * Max account number
	 */
	public static final long MAX_ACCOUNT_NUMBER = 1000000000L - 1;

	/**
	 * The list of accounts of this office
	 */
	private final List<Account> accounts;
	/**
	 * The list of clients of this office
	 */
	private final List<Client> clients;
	/**
	 * Office's id
	 */
	private final Handler id;
	/**
	 * Office's Bank
	 */
	private final Bank bank;
	/**
	 * Next account number
	 */
	private long nextAccountNumber;
	/**
	 * The costs of the local of the office
	 */
	private int localCost;
	/**
	 * The costs of the light, water and gas of the office
	 */
	private int utilitiesCost;
	/**
	 * The expenses in the salaries of the employees
	 */
	private int employeeCost;
	/**
	 * The total expenses or costs of the office
	 */
	private int totalExpenses;
	/**
	 * The total income of the office
	 */
	private int totalIncome;
	/**
	 * The total balance of the office
	 */
	private int balance;
	/**
	 * The list of employees of this office
	 */
	private List<Employee> employeeList;

	/**
	 * Create a new office
	 *
	 * @param id
	 *            ( the office's id )
	 *
	 * @param bank
	 */
	public Office(Handler id, Bank bank) {
		this.accounts = new ArrayList<Account>();
		this.clients = new ArrayList<Client>();
		this.id = id;
		this.bank = bank;
		this.nextAccountNumber = 0;
		this.employeeList = new ArrayList<Employee>();
	}

	/**
	 * Add a new account. The account cannot be repeated.
	 *
	 * @param account
	 *            ( Account to add)
	 * @return ( true if success, false otherwise )
	 */
	public synchronized boolean addAccount(Account account) {
		if (account != null && this.searchAccount(account.getID()) == null) {
			return this.accounts.add(account);
		}
		return false;
	}

	/**
	 * Add a new client.
	 *
	 * @param client
	 *            ( client to add )
	 * @return ( true if success, false otherwise )
	 */
	public synchronized boolean addClient(Client client) {
		if (client != null && this.searchClient(client.getId()) == null) {
			return this.clients.add(client);
		}
		return false;
	}

	/**
	 * Delete a client.
	 *
	 * @param id
	 *            ( client's id)
	 * @return (true if success, false otherwise )
	 */
	public synchronized boolean deleteClient(Handler id) {
		if (id != null && this.searchClient(id) != null) {
			return this.clients.remove(this.searchClient(id));
		}
		return false;
	}

	/**
	 * Delete a account.
	 *
	 * @param id
	 *            ( account's id )
	 * @return ( true if success, false otherwise )
	 */
	public synchronized boolean deleteAccount(Handler id) {
		if (id != null && this.searchAccount(id) != null) {
			return this.accounts.remove(this.searchAccount(id));
		}
		return false;
	}

	/**
	 * Get the list of clients
	 *
	 * @return
	 */
	public List<Client> getClients() {
		return new ArrayList<Client>(this.clients);
	}

	/**
	 * Get the office's id
	 *
	 * @return
	 */
	public Handler getIdOffice() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Account searchAccount(Handler id) {
		Account result = null;
		int i = -1;
		while (++i < accounts.size() && result == null) {
			if (accounts.get(i).getID().compareTo(id) == 0) {
				result = accounts.get(i);
			}
		}
		return result;
	}
	
	public Client searchClient(Handler id) {
		Client result = null;
		int i = -1;
		while (++i < clients.size() && result == null) {
			if (clients.get(i).getId().compareTo(id) == 0) {
				result = clients.get(i);
			}
		}
		return result;
	}

	/**
	 * Gets the next accountNumber. This number is incremental, from zero to
	 * MAX_ACCOUNT_NUMBER.
	 *
	 * @return ( The number in String format )
	 */
	public synchronized String getNewAccountNumber() {
		String accountNumber;
		if (this.nextAccountNumber == MAX_ACCOUNT_NUMBER) {
			accountNumber = "";
		} else {
			accountNumber = String.format("%010d", this.nextAccountNumber++);
		}
		return accountNumber;
	}

	/**
	 * Gets the list of accounts
	 * 
	 * @return
	 */
	public List<Account> getAccounts() {
		return this.accounts;
	}

	/**
	 * Returns the expenses of the office
	 */
	public int getExpenses() {
		return totalExpenses;
	}

	/**
	 * Sets the total expenses of the office
	 */
	public void setExpenses(int localCost, int utilitiesCost, int employeeCost) {

		this.localCost = localCost;
		this.utilitiesCost = utilitiesCost;
		this.employeeCost = employeeCost;

		this.totalExpenses = this.localCost + this.utilitiesCost
				+ this.employeeCost;
	}

	/**
	 * Returns the income of the office
	 */
	public int getTotalIncome() {
		return totalIncome;
	}

	/**
	 * Sets the total income of the office
	 */
	public void setTotalIncome(int totalIncome) {
		// Addition of the types of incomes.
		this.totalIncome = totalIncome;
	}

	/**
	 * Returns the balance of the office
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Sets the total balance of the office
	 */
	public void setBalance() {
		this.balance = this.totalIncome - this.totalExpenses;
	}

	/**
	 * Returns a copy of the list of employees of the office
	 */
	public List<Employee> getEmployeeList() {
		return new ArrayList<Employee>(employeeList);
	}

	/**
	 * Sets the list of employees of the office
	 */
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	/**
	 * Returns the list of accounts of the office
	 */
	public List<Account> getAccountList() {
		return this.accounts;
	}

	/**
	 * Adds an employee to the list of employees
	 */
	public boolean addEmployee(Employee employee) {
		return employeeList.add(employee);
	}

	/**
	 * Deletes an employee to the list of employees
	 *
	 * @param employee
	 * @return
	 */
	public boolean deleteEmployee(Employee employee) {
		return employeeList.remove(employee);
	}
}
