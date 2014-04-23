/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.history.iterator;

import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.iterator.Condition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author runix
 */
public class ConditionOneDay<T extends Transaction> implements Condition<T> {

    private final int year;
    private final int month;
    private final int day;
    private final boolean isValidDay;

    public ConditionOneDay(Date date, boolean isValidDay) {
        this.year = getYear(date);
        this.month = getMonth(date);
        this.day = getDay(date);
        this.isValidDay = isValidDay;
    }

    @Override
    public boolean test(Transaction t) {
        Date effective = t.getEffectiveDate();
        final int year = getYear(effective);
        final int month = getMonth(effective);
        final int day = getDay(effective);
        if (isValidDay) {
            return (this.year == year) == (this.month == month) == (this.day == day);
        }
        if (this.year == year && this.month == month) {
            return ((this.day != day));
        }
        return true;
    }

    public static int getYear(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return Integer.parseInt(format.format(date));
    }

    public static int getMonth(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("MM");
        return Integer.parseInt(format.format(date));
    }

    public static int getDay(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd");
        return Integer.parseInt(format.format(date));
    }
}
