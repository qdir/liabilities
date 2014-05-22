package es.unileon.ulebank.tasklist;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TaskListTest {
	
	private List<FakeTask> taskToDo;
	private List<FakeTask> taskDone;
	private List<FakeTask> taskRemoved;
	
	@Before
	public void setUp() {
		this.taskToDo = new ArrayList<FakeTask>();
		this.taskDone = new ArrayList<FakeTask>();
		this.taskRemoved = new ArrayList<FakeTask>();
		
		for(int i = 0; i < 10; ++i) {
			this.taskToDo.add(new FakeTask(new Date(100 * i)));
		}
		
		for(int i = 0; i < 10; ++i) {
			this.taskDone.add(new FakeTask(new Date(i)));
		}
	}
	
	
	private FakeTask getTask(Date date) {
		return new FakeTask(date);
	}
}
