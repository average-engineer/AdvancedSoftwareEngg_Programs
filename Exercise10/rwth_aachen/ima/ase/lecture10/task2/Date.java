package rwth_aachen.ima.ase.lecture10.task2;

import java.text.SimpleDateFormat;
import java.util.Calendar; 
import java.util.GregorianCalendar;

public class Date {

	private GregorianCalendar calendar;
	
	public Date(int year, int month, int day) {
		calendar = new GregorianCalendar(year, month - 1, day);
	}
	
	public Date() {
		calendar = new GregorianCalendar();
	}
	
	public int getDay() {
		return calendar.get(Calendar.DATE);
	}
	
	public int getMonth() {
		return calendar.get(Calendar.MONTH) +1;
	}
	
	public int getYear() {
		return calendar.get(Calendar.YEAR);
	}
	
	public int daysInMonth() {
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public int dayOfWeek() {
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	public boolean isLeapYear() {
		return calendar.isLeapYear(getYear());
	}
	
	public void addDays(int days) {
		calendar.add(Calendar.DATE, days);
	}
	
	public void nextDay() {
		addDays(1);
	}
	
	public String toString() {
		SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
	    fmt.setCalendar(calendar);
	    String dateFormatted = fmt.format(calendar.getTime());
	    return dateFormatted;
	}
	
}
