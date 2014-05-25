package es.unileon.ulebank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.office.Office;

public class EmployeeTest {

	private Employee employee;
	private Employee employeeWithoutOffice;
	private Office office;
	private Bank bank;

	@Before
	public void setUp() throws Exception {

		bank = new Bank(new GenericHandler("1234"));
		office = new Office(new GenericHandler("1234"), bank);
		employee = new Employee("Name", "Surname", "Address", 2100f, office,
				new GenericHandler("1234"));
		employeeWithoutOffice = new Employee("Name", "Surname", "Address",
				2100f, new GenericHandler("1234"));
	}

	@Test
	public void testGetName() {

		String employeeName = employee.getName();
		assertTrue(employee.getName().equals(employeeName));
		employee.setName("Name 2");
		assertTrue(employee.getName().equals("Name 2"));
	}

	@Test
	public void testSetNullName() {

		employee.setName(null);
		assertTrue(employee.getName().equals("Name"));
	}

	@Test
	public void testSetEmptyName() {

		employee.setName("");
		assertTrue(employee.getName().equals("Name"));
	}

	@Test
	public void testGetSurname() {

		String employeeSurname = employee.getSurname();
		assertTrue(employee.getSurname().equals(employeeSurname));
		employee.setSurname("Surname 2");
		assertTrue(employee.getSurname().equals("Surname 2"));
	}

	@Test
	public void testSetNullSurname() {

		employee.setSurname(null);
		assertTrue(employee.getSurname().equals("Surname"));
	}

	@Test
	public void testSetEmptySurname() {

		employee.setSurname("");
		assertTrue(employee.getSurname().equals("Surname"));
	}

	@Test
	public void testGetAddress() {

		String employeeAddress = employee.getAddress();
		assertTrue(employee.getAddress().equals(employeeAddress));
		employee.setAddress("Address 2");
		assertTrue(employee.getAddress().equals("Address 2"));
	}

	@Test
	public void testGetSalary() {

		float employeeSalary = employee.getSalary();
		assertEquals(employeeSalary, employee.getSalary(), 0);
		employee.setSalary(1800f);
		assertEquals(1800f, employee.getSalary(), 0);
	}

	@Test
	public void testSetNegativeSalary() {

		employee.setSalary(-1800f);
		assertEquals(2100f, employee.getSalary(), 0);
	}

	@Test
	public void testGetOffice() {

		Office office2 = new Office(new GenericHandler("2345"), bank);
		assertEquals(
				0,
				employee.getOffice().getIdOffice()
						.compareTo(office.getIdOffice()), 0);
		employee.setOffice(office2);
		assertEquals(
				0,
				employee.getOffice().getIdOffice()
						.compareTo(office2.getIdOffice()), 0);
	}

	@Test
	public void testGetIdEmployee() {

		Handler idEmployee = employee.getIdEmployee();
		GenericHandler idEmployee2 = new GenericHandler("2345");
		assertEquals(0, employee.getIdEmployee().compareTo(idEmployee), 0);
		employee.setIdEmployee(idEmployee2);
		assertEquals(0, employee.getIdEmployee().compareTo(idEmployee2), 0);
	}

	@Test
	public void testSetNullIdEmployee() {

		Handler idEmployee = employee.getIdEmployee();
		employee.setIdEmployee(null);
		assertEquals(0, employee.getIdEmployee().compareTo(idEmployee), 0);
	}

	@Test
	public void testIsAdmin() {

		assertFalse(employee.isAdmin());
	}

	@Test
	public void testGetOfficeNullOffice() {

		assertNull(employeeWithoutOffice.getOffice());
	}
}
