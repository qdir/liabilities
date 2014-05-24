package es.unileon.ulebank.tasklist;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.time.Time;
import es.unileon.ulebank.time.TimeUtils;

public class TaskListTest {

	private List<MockTask> taskToDo;
	private List<MockTask> taskDone;
	private List<MockTask> taskRemoved;
	private TaskList taskList;
	private static boolean init = false;

	public TaskListTest() {
		if (!init) {
			this.taskToDo = new ArrayList<MockTask>();
			this.taskDone = new ArrayList<MockTask>();
			this.taskRemoved = new ArrayList<MockTask>();
			Time.getInstance().updateTime();
			this.taskList = TaskList.getInstance();
			for (int i = 0; i < 10; ++i) {
				MockTask c = getTask(new Date(100 * i + 120));
				this.taskToDo.add(c);
				assertTrue(this.taskList.addTask(c));
			}

			for (int i = 0; i < 10; ++i) {
				MockTask c = getTask(new Date(i));
				this.taskDone.add(c);
				assertTrue(this.taskList.addDoneTask(c));
			}
			init = true;
		}

	}

	// Doing almost all tests with a one method because
	// this class is unique (singleton pattern) and the state cannot be reset
	// so, if something is change in one test it might affect
	// the others
	@Test
	public void testTaskList() {
		List<Task> tasks = new ArrayList<Task>();
		tasks.addAll(this.taskDone);
		tasks.addAll(this.taskToDo);
		Collections.sort(tasks, new TaskDateComparator());
		Iterator<Task> it = tasks.iterator();
		this.taskList.executeTasks();
		Iterator<Task> fromTaskList = this.taskList.getTasksListDone()
				.iterator();
		while (it.hasNext() && fromTaskList.hasNext()) {
			assertEquals(it.next(), fromTaskList.next());
		}
		for (int i = 0; i < this.taskToDo.size(); ++i) {
			assertEquals(this.taskToDo.get(i).getState(),
					MockTask.STATE_EXECUTE);
		}
		assertEquals(it.hasNext(), fromTaskList.hasNext());

		assertFalse(this.taskList.addDoneTask(getTask(new Date(Time
				.getInstance().getTime() + Time.DAYS_TO_MILLIS))));
		it = tasks.iterator();
		fromTaskList = this.taskList.getTasksListDone().iterator();
		while (it.hasNext() && fromTaskList.hasNext()) {
			assertEquals(it.next(), fromTaskList.next());
		}
		assertEquals(it.hasNext(), fromTaskList.hasNext());

		Task c = getTask(new Date(System.currentTimeMillis()));
		assertTrue(this.taskList.addTask(c));
		assertFalse(this.taskList.addTask(c));
		assertFalse(this.taskList.addDoneTask(c));

		assertTrue(this.taskList.deleteTask(c.getID()));

		it = tasks.iterator();
		fromTaskList = this.taskList.getTasksListDone().iterator();
		while (it.hasNext() && fromTaskList.hasNext()) {
			assertEquals(it.next(), fromTaskList.next());
		}
		assertEquals(it.hasNext(), fromTaskList.hasNext());

		assertFalse(this.taskList.deleteTask(new GenericHandler("notFound..")));

		it = tasks.iterator();
		fromTaskList = this.taskList.getTasksListDone().iterator();
		while (it.hasNext() && fromTaskList.hasNext()) {
			assertEquals(it.next(), fromTaskList.next());
		}
		assertEquals(it.hasNext(), fromTaskList.hasNext());

		Task c1 = getTask(new Date(System.currentTimeMillis() - 3));
		assertTrue(this.taskList.addTask(c1));
		assertFalse(this.taskList.deleteTask(new GenericHandler("notFound..")));
		it = tasks.iterator();
		fromTaskList = this.taskList.getTasksListDone().iterator();
		while (it.hasNext() && fromTaskList.hasNext()) {
			assertEquals(it.next(), fromTaskList.next());
		}
		assertEquals(it.hasNext(), fromTaskList.hasNext());

		assertTrue(this.taskList.deleteTask(c1.getID()));
		Iterator<Task> deleteIt = this.taskList.getDeteledTasks().iterator();
		assertEquals(c, deleteIt.next());
		assertEquals(c1, deleteIt.next());
		assertEquals(deleteIt.hasNext(), false);

		c = getTask(new Date(10 * 10 * 10));
		c1 = getTask(new Date(10 * 10 * 11));
		this.taskList.executeTasks();
		assertTrue(this.taskList.addTask(c));
		assertTrue(this.taskList.addTask(c1));
		assertFalse(this.taskList.addTask(c));
		assertFalse(this.taskList.addTask(c1));
		Iterator<Task> task = this.taskList.getTaskList().iterator();
		assertEquals(task.next(), c);
		assertEquals(task.next(), c1);
		assertFalse(task.hasNext());

		assertTrue(this.taskList.undoTask(this.taskToDo.get(1).getID()));
		assertEquals(this.taskToDo.get(1).getState(), MockTask.STATE_UNDO);

		assertFalse(this.taskList.undoTask(new GenericHandler("invalid")));

		assertFalse(this.taskList.addTask(null));
		assertFalse(this.taskList.addDoneTask(null));
		assertFalse(this.taskList.deleteTask(null));

		c = getTask(new Date(System.currentTimeMillis() + 10));
		c1 = getTask(new Date(System.currentTimeMillis() + 9));
		assertTrue(this.taskList.addTask(c));
		assertTrue(this.taskList.addTask(c1));
		assertTrue(this.taskList.deleteTask(c.getID()));
		Time.getInstance().updateTime();
		this.taskList.executeTasks();
		Iterator<Task> todo = this.taskList.getTaskList().iterator();
		assertEquals(todo.next(), c1);

		assertFalse(this.taskList.addTask(c));
		c = getTask(new Date(10003));
		assertTrue(this.taskList.addDoneTask(c));
		assertFalse(this.taskList.addDoneTask(c));
	}

	private MockTask getTask(Date date) {
		return new MockTask(date, new GenericHandler(String.valueOf(date
				.getTime())));
	}
}
