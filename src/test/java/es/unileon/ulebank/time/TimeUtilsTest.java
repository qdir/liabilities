/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.time;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

/**
 *
 * @author runix
 */
public class TimeUtilsTest {

	@Test
	public void testConstructor() {
		TimeUtils t = new TimeUtils();
	}

	@Test
	public void testGetYear() {
		assertEquals(TimeUtils.getYear(new Date(0)), 1970);
		assertEquals(
				TimeUtils.getYear(new Date(24l * 60l * 60l * 1000l * 370l)),
				1971);
	}

	@Test
	public void testGetDay() {
		assertEquals(TimeUtils.getDay(new Date(0)), 1);
		assertEquals(TimeUtils.getDay(new Date(24l * 60l * 60l * 1000l + 10)),
				2);
	}

	@Test
	public void testGetMonth() {
		assertEquals(TimeUtils.getMonth(new Date(0)), 1);
		assertEquals(
				TimeUtils.getMonth(new Date(24l * 60l * 60l * 1000l * 32)), 2);
	}

	@Test
	public void testGetTimestamp() {
		assertEquals(TimeUtils.getTimestamp(1970, 1, 1), -(60l * 60l) * 1000);
		assertEquals(TimeUtils.getTimestamp(1970, 1, 2), 82800000);
		assertEquals(TimeUtils.getTimestamp(2014, 4, 13), 1397340000000l);
	}

}
