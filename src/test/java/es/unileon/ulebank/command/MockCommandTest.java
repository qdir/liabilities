package es.unileon.ulebank.command;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;

public class MockCommandTest {

	private MockCommand command;
	private Handler id;

	@Before
	public void setUp() {
		this.id = new GenericHandler("mock");
		this.command = new MockCommand(id);
	}

	@Test
	public void testUndo() {
		this.command.undo();
		assertEquals(this.command.getState(), MockCommand.STATE_UNDO);
	}

	@Test
	public void testExecute() {
		this.command.execute();
		assertEquals(this.command.getState(), MockCommand.STATE_EXECUTE);
	}

	@Test
	public void testRedo() {
		this.command.redo();
		assertEquals(this.command.getState(), MockCommand.STATE_REDO);
	}

	@Test
	public void testGetId() {
		assertEquals(this.id.compareTo(this.command.getID()), 0);
	}

	@Test
	public void testCombined() {
		this.command.undo();
		assertEquals(this.command.getState(), MockCommand.STATE_UNDO);
		this.command.execute();
		assertEquals(this.command.getState(), MockCommand.STATE_EXECUTE);
		this.command.redo();
		assertEquals(this.command.getState(), MockCommand.STATE_REDO);
		this.command.undo();
		assertEquals(this.command.getState(), MockCommand.STATE_UNDO);
		this.command.execute();
		assertEquals(this.command.getState(), MockCommand.STATE_EXECUTE);
		this.command.redo();
		assertEquals(this.command.getState(), MockCommand.STATE_REDO);
	}
}
