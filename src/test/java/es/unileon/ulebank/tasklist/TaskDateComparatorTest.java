package es.unileon.ulebank.tasklist;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TaskDateComparatorTest {

	private TaskDateComparator comparator;
	
	public  TaskDateComparatorTest() {
		this.comparator = new TaskDateComparator();
	}

	@Test
	public void testEquals() {
		Date time = new Date();
		Task t1 = new Task(time, null);
		Task t2 = new Task(time, null);
		assertEquals(this.comparator.compare(t1, t2), 0);
		assertEquals(this.comparator.compare(t2, t1), 0);
		Date time2 = new Date(time.getTime());
		t2 = new Task(time2, null);
		assertEquals(this.comparator.compare(t1, t2), 0);
		assertEquals(this.comparator.compare(t2, t1), 0);
	}
	
	@Test
	public void testDiferentTimes() {
		Date time = new Date();
		Task t1 = new Task(time, null);
		Task t2 = new Task(new Date(time.getTime()+1), null);
		assertEquals(this.comparator.compare(t1, t2), -1);
		assertEquals(this.comparator.compare(t2, t1), 1);
		Date time2 = new Date(time.getTime()+1000);
		t2 = new Task(time2, null);
		assertEquals(this.comparator.compare(t1, t2), -1);
		assertEquals(this.comparator.compare(t2, t1), 1);
	}

}
