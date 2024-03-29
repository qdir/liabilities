/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.time;

/**
 *
 * @author runix
 */
public class Time {

	/**
	 * Singleton instance
	 */
	private static Time instance;

	/**
	 * Actual time (fictitious)
	 */
	private long actualTimestamp;

	/**
	 * Last upadte
	 */
	private long lastUpdateTimestamp;

	/**
	 * Equivalence between days and milliseconds
	 */
	public static final  long DAYS_TO_MILLIS = (long) 24L * 60L * 60L * 1000L;

	/**
	 * Equivalence between milliseconds and days
	 */
	public static final  long MILLIS_TO_DAYS = (long) 1L / DAYS_TO_MILLIS;

	/**
	 * Private constructor
	 */
	private Time() {
		this.actualTimestamp = System.currentTimeMillis();
		this.lastUpdateTimestamp = System.currentTimeMillis();
	}

	/**
	 * Get the class instance.
	 *
	 * @return (class instance)
	 */
	public static Time getInstance() {
		if (instance == null) {
			instance = new Time();
			instance.updateTime();
		}
		return instance;
	}

	/**
	 * Forward days or backwards if the amount is negative.
	 *
	 * @param amount
	 *            (amount of days)
	 */
	public void forwardDays(long amount) {
		this.updateTime();
		this.actualTimestamp += (long) amount * 24L * 60L * 60L * 1000L;
	}

	/**
	 * Forward milliseconds or backwards if the amount is negative.
	 *
	 * @param amount
	 *            (amount of milliseconds)
	 */
	public void forward(long amount) {
		this.updateTime();
		this.actualTimestamp += amount;
	}

	/**
	 * Set the actual time
	 *
	 * @param timestamp
	 *            (Time to set)
	 */
	public void setTime(long timestamp) {
		this.updateTime();
		this.actualTimestamp = timestamp;
	}

	/**
	 * Get the time.
	 *
	 * @return (actual time (fictitious))
	 */
	public long getTime() {
		return this.actualTimestamp;
	}

	/**
	 * Update the time. If you don't call updateTime method, the time will be
	 * the same always. When you call updateTime the time between the last
	 * update and now is added.
	 */
	public void updateTime() {
		long diff = System.currentTimeMillis() - this.lastUpdateTimestamp;
		this.lastUpdateTimestamp = System.currentTimeMillis();
		this.actualTimestamp += diff;
	}
}
