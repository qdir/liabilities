/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.bank;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.MalformedHandlerException;
import es.unileon.ulebank.office.Office;

/**
 *
 * @author runix
 */
public class Bank {

	private static final Logger LOG = Logger.getLogger(Bank.class.getName());

	private final List<Office> offices;

	private final Handler bankID;

	/**
	 *
	 * @param bankID
	 * @throws MalformedHandlerException
	 */
	public Bank(Handler bankID) throws MalformedHandlerException {
		this.bankID = new BankHandler(bankID.toString());
		this.offices = new ArrayList<Office>();
	}

	/**
	 *
	 * @return
	 */
	public Handler getID() {
		return this.bankID;
	}

	/**
	 *
	 * @param office
	 * @return
	 */
	public boolean addOffice(Office office) {
		if (office != null && this.searchOffice(office.getIdOffice()) == null) {
			return this.offices.add(office);
		}
		return false;
	}

	/**
	 *
	 * @param office
	 * @return
	 */
	public boolean removeOffice(Handler office) {
		boolean removed = false;
		if (office != null) {
			int i = -1;
			while (++i < offices.size() && !removed) {
				if (offices.get(i).getIdOffice().compareTo(office) == 0) {
					this.offices.remove(i);
					removed = true;
				}
			}
		}
		return removed;
	}

	public Office searchOffice(Handler id) {
		Office result = null;
		int i = -1;
		while (++i < offices.size() && result == null) {
			if (offices.get(i).getIdOffice().compareTo(id) == 0) {
				result = offices.get(i);
			}
		}

		return result;
	}
}
