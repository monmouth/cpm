package monmouth.cpm.logic;

import java.util.Date;

public interface DateCalcIF {
	/**
	 * Get the next working day after the specified date with N days later.
	 * @param date since when
	 * @param duration how many days later
	 * @return the closest next working day
	 */
	Date getNextWorkingDay(Date date, int duration);

	/**
	 * Get the next calendar day after the specified date with N days later.
	 * @param date date since when
	 * @param duraton duration how many days later
	 * @return the closest next calendar day
	 */
	Date getNextCalendarDay(Date date, int duration);

	/**
	 * Get how many working days between date1 and date2.
	 * @param date1 date 1
	 * @param date2 date 2
	 * @return working days
	 */
	int getWorkingDays(Date date1, Date date2);


	/**
	 * Get how many calendar days between date1 and date2.
	 * @param date1 date 1
	 * @param date2 date 2
	 * @return calendar days
	 */
	int getCalendarDays(Date date1, Date date2);
}
