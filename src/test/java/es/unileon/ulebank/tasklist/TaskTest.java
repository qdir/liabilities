package es.unileon.ulebank.tasklist;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.command.Command;
import es.unileon.ulebank.command.MockCommand;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.office.Office;

public class TaskTest {

	private MockCommand command;
	private Handler id;
	private Task task;
	private Date effectiveDate;

	@Before
	public void setUp() throws Exception {
		this.id = new GenericHandler("handler");
		this.command = new MockCommand(id);
		this.effectiveDate = new Date();
		this.task = new Task(effectiveDate, command);
	}

	@Test
	public void testUndo() {
		this.task.undo();
		assertEquals(this.command.getState(), MockCommand.STATE_UNDO);
	}

	@Test
	public void testExecute() {
		this.task.execute();
		assertEquals(this.command.getState(), MockCommand.STATE_EXECUTE);
	}

	@Test
	public void testRedo() {
		this.task.redo();
		assertEquals(this.command.getState(), MockCommand.STATE_REDO);
	}

	@Test
	public void testGetId() {
		assertEquals(this.id.compareTo(this.task.getID()), 0);
	}

	@Test
	public void testCombined() {
		this.task.undo();
		assertEquals(this.command.getState(), MockCommand.STATE_UNDO);
		this.task.execute();
		assertEquals(this.command.getState(), MockCommand.STATE_EXECUTE);
		this.task.redo();
		assertEquals(this.command.getState(), MockCommand.STATE_REDO);
		this.task.undo();
		assertEquals(this.command.getState(), MockCommand.STATE_UNDO);
		this.task.execute();
		assertEquals(this.command.getState(), MockCommand.STATE_EXECUTE);
		this.task.redo();
		assertEquals(this.command.getState(), MockCommand.STATE_REDO);
	}

	@Test
	public void testGetEffectiveDate() {
		assertEquals(this.effectiveDate.getTime(), this.task.getEffectiveDate()
				.getTime());
	}
}
