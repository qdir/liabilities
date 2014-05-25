package es.unileon.ulebank.tasklist;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.handler.Handler;

public class MockTaskTest {

	private Date effectiveDate;
	private MockTask task;
	private Handler id;

	@Before
	public void setUp() {
		this.id = new GenericHandler("mock");
		this.effectiveDate = new Date();
		this.task = new MockTask(effectiveDate, id);
	}

	@Test
	public void testUndo() {
		this.task.undo();
		assertEquals(this.task.getState(), MockTask.STATE_UNDO);
	}

	@Test
	public void testExecute() {
		this.task.execute();
		assertEquals(this.task.getState(), MockTask.STATE_EXECUTE);
	}

	@Test
	public void testRedo() {
		this.task.redo();
		assertEquals(this.task.getState(), MockTask.STATE_REDO);
	}

	@Test
	public void testGetEffectiveDate() {
		assertEquals(this.effectiveDate.getTime(), this.task.getEffectiveDate()
				.getTime());
	}

	@Test
	public void testHandler() {
		assertEquals(this.id.compareTo(this.task.getID()), 0);
	}

	@Test
	public void testCombined() {
		this.task.undo();
		assertEquals(this.task.getState(), MockTask.STATE_UNDO);
		this.task.execute();
		assertEquals(this.task.getState(), MockTask.STATE_EXECUTE);
		this.task.redo();
		assertEquals(this.task.getState(), MockTask.STATE_REDO);
		this.task.undo();
		assertEquals(this.task.getState(), MockTask.STATE_UNDO);
		this.task.execute();
		assertEquals(this.task.getState(), MockTask.STATE_EXECUTE);
		this.task.redo();
		assertEquals(this.task.getState(), MockTask.STATE_REDO);
	}
}
