/**
 * 
 */
package monmouth.cpm.logic;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 * @author ken
 * A simple date calculator that lacks the ability to ignore holidays between any 2 dates.
 */
public class SimpleDateCalculator implements DateCalcIF {

	/* (non-Javadoc)
	 * @see monmouth.schedule.logic.DateCalcIF#getNextWorkingDay(java.util.Date, int)
	 */
	@Override
	public Date getNextWorkingDay(Date date, int duration) {
		return getNextCalendarDay(date, duration);
	}

	/* (non-Javadoc)
	 * @see monmouth.schedule.logic.DateCalcIF#getNextCalendarDay(java.util.Date, int)
	 */
	@Override
	public Date getNextCalendarDay(Date date, int duration) {
		LocalDate lDate = (new DateTime(date)).toLocalDate();
		return lDate.plusDays(duration).toDate();
	}

	/* (non-Javadoc)
	 * @see monmouth.schedule.logic.DateCalcIF#getWorkingDays(java.util.Date, java.util.Date)
	 */
	@Override
	public int getWorkingDays(Date date1, Date date2) {
		return getCalendarDays(date1, date2);
	}

	/* (non-Javadoc)
	 * @see monmouth.schedule.logic.DateCalcIF#getCalendarDays(java.util.Date, java.util.Date)
	 */
	@Override
	public int getCalendarDays(Date date1, Date date2) {
		LocalDate lDate1 = (new DateTime(date1)).toLocalDate();
		LocalDate lDate2 = (new DateTime(date2)).toLocalDate();
		return Days.daysBetween(lDate1, lDate2).getDays();
	}

}
