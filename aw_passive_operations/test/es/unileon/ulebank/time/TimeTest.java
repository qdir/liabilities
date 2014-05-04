/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.time;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author runix
 */
public class TimeTest {

    public Time time;

    @Before
    public void setUp() {
        this.time = Time.getInstance();
    }

    @Test
    public void testForwardDays() {
        this.time.updateTime();
        long time = this.time.getTime();
        int days = 2;
        this.time.forwardDays(days);
        long updatedTime = this.time.getTime();
        long diff = updatedTime - (time + days * 24l * 60l * 60l * 1000l);
        //Assume that the time between this.time.forwardDays and updatedTime is less than 5 millis
        assertTrue(diff < 5);
    }

    @Test
    public void testBackwardDays() {
        this.time.updateTime();
        long time = this.time.getTime();
        int days = -2;
        this.time.forwardDays(days);
        long updatedTime = this.time.getTime();
        long diff = updatedTime - (time + days * 24l * 60l * 60l * 1000l);
        //Assume that the time between this.time.forwardDays and updatedTime is less than 5 millis
        assertTrue(diff < 5);
    }

    @Test
    public void testForward() {
        this.time.updateTime();
        long time = this.time.getTime();
        int millis = 20000;
        this.time.forward(millis);
        long updatedTime = this.time.getTime();
        long diff = updatedTime - (time + millis * 24l * 60l * 60l * 1000l);
        //Assume that the time between this.time.forwardDays and updatedTime is less than 5 millis
        assertTrue(diff < 5);
    }

    @Test
    public void testBackward() {
        this.time.updateTime();
        long time = this.time.getTime();
        int millis = 20000;
        this.time.forward(millis);
        long updatedTime = this.time.getTime();
        long diff = updatedTime - (time + millis * 24l * 60l * 60l * 1000l);
        //Assume that the time between this.time.forwardDays and updatedTime is less than 5 millis
        assertTrue(diff < 5);
    }

    @Test
    public void testUpdate() {
        this.time.updateTime();
        long time = this.time.getTime();
        long timeToSleep = 1000;
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException ex) {
            fail("Fail when try to sleep for trying update method");
        }
        this.time.updateTime();
        long timeUpdated = this.time.getTime();
        long diff = timeUpdated - (timeToSleep + time);
        //Assume that the time between this.time.forward and updatedTime is less than 5 millis
        assertTrue(diff < 5);
    }
}
