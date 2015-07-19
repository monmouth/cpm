package monmouth.cpm.logic;

import monmouth.cpm.logic.SimpleDateCalculator;
import monmouth.cpm.logic.DateCalcIF;
import static org.junit.Assert.*;

import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class SimpleDateCalculatorTest {
	private Date date1 = (new LocalDate(2015,7,25)).toDate();//2015-07-25
	private Date date2 = (new LocalDate(2015,8,4)).toDate();//2015-08-04
	private DateCalcIF calculator = new SimpleDateCalculator();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetNextWorkingDay() {
		Date expectedValue = (new LocalDate(2015,7,26)).toDate();//2015-07-26
		assertEquals(1, expectedValue.compareTo(date1));
	}

	@Test
	public void testGetNextCalendarDay() {
		Date expectedValue = (new LocalDate(2015,7,26)).toDate();//2015-07-26
		System.out.println(expectedValue);
		assertEquals(1, expectedValue.compareTo(date1));
	}

	@Test
	public void testGetWorkingDays() {
		assertEquals(10, calculator.getCalendarDays(date1, date2));
	}

	@Test
	public void testGetCalendarDaysForward() {
		assertEquals(10, calculator.getCalendarDays(date1, date2));
	}

	@Test
	public void testGetCalendarDaysBackward() {
		assertEquals(-10, calculator.getCalendarDays(date2, date1));
	}
}
