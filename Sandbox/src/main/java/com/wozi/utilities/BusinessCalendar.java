package com.wozi.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BusinessCalendar extends GregorianCalendar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3382888184635084183L;

	/**
	 * 
	 */

	public static final Quarter FYQ1 = Quarter(Calendar.OCTOBER,
			Calendar.NOVEMBER, Calendar.DECEMBER);
	public static final Quarter FYQ2 = Quarter(Calendar.JANUARY,
			Calendar.FEBRUARY, Calendar.MARCH);
	public static final Quarter FYQ3 = Quarter(Calendar.JANUARY,
			Calendar.FEBRUARY, Calendar.MARCH); // Apr - Jun
	public static final Quarter FYQ4 = Quarter(Calendar.JANUARY,
			Calendar.FEBRUARY, Calendar.MARCH); // Jul - Sep

	public BusinessCalendar(int year, int month, int dayInMonth) {
		super(year, month, dayInMonth);
	}

	public int whatQuarter() {
		int month = this.get(Calendar.MONTH);
		if (month >= Calendar.JANUARY && month <= Calendar.MARCH)
			return Q1;
		if (month >= Calendar.APRIL && month <= Calendar.JUNE)
			return Q2;
		if (month >= Calendar.JULY && month <= Calendar.SEPTEMBER)
			return Q3;
		else
			return Q4;
	}

	// for given day, return a BusinessCalendar that represents this business
	// day in the month
	// i.e. what is or find a given business day in the month
	// if business day does not exist then null is returned
	static BusinessCalendar findBusinessDayinMonth(int dayInMonth, int month,
			int year) {
		BusinessCalendar day = new BusinessCalendar(year, month, 1);

		while (dayInMonth > 1) {
			if (day.isBusinessDay())
				dayInMonth--;
			day.add(Calendar.DAY_OF_MONTH, 1);
			// need to see if last of day was added - i.e. dayInMonth does not
			// exist
		}

		return day;
	}

	static BusinessCalendar findBusinessDayinQuarter(int dayInQuarter,
			int quarter, int year) {

		BusinessCalendar day = new BusinessCalendar(year, quarter, 1);

		return day;
	}

	static BusinessCalendar findBusinessDayinYear(int dayInYear, int year) {
		BusinessCalendar day = new BusinessCalendar(year, Calendar.JANUARY, 1);

		return day;
	}

	static BusinessCalendar getNextBusinessDay(BusinessCalendar today) {
		BusinessCalendar day = today;
		while (!day.isBusinessDay()) {
			day.add(Calendar.DAY_OF_MONTH, 1);
		}
		return day;
	}

	// for the current date, what is the business day in month
	// 0 equals the current date is not a business day
	public int getBusinessDayofMonth() {
		// initial current date to beginning of month
		BusinessCalendar current = new BusinessCalendar(
				this.get(Calendar.YEAR), this.get(Calendar.MONTH), 1);
		int businessDays = 1;

		// loop until the current date is equal to given date
		while (current.before(this)) {
			current.add(Calendar.DAY_OF_MONTH, 1);
			// if current day is not a weekend then increment businessDays
			if (current.isBusinessDay())
				businessDays++;
		}
		return businessDays;
	}

	public boolean isBusinessDay() {
		return !(isWeekend() || isHoliday());
	}

	public boolean isHoliday() {
		return false;
	}

	public boolean isWeekend() {
		return (this.get(DAY_OF_WEEK) == Calendar.SATURDAY || this
				.get(DAY_OF_WEEK) == Calendar.SUNDAY);

	}

	public String printDate() {
		DateFormat df = new SimpleDateFormat("EEE, MMM dd yyyy");
		return df.format(this.getTime());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BusinessCalendar app = new BusinessCalendar(2012, Calendar.MARCH, 1);
		System.out.println("Business Day of month is: "
				+ app.getBusinessDayofMonth());
		System.out.println("The 10th business day in March 2012 is: "
				+ BusinessCalendar.findBusinessDayinMonth(10, Calendar.MARCH,
						2012).printDate());

		app = new BusinessCalendar(2012, Calendar.FEBRUARY, 29);
		System.out.println("Business Day of month is: "
				+ app.getBusinessDayofMonth());
		System.out.println("The 20th business day in Febraury 2012 is: "
				+ BusinessCalendar.findBusinessDayinMonth(20,
						Calendar.FEBRUARY, 2012).printDate());

		app = new BusinessCalendar(2011, Calendar.JULY, 29);
		System.out.println("Business Day of month is: "
				+ app.getBusinessDayofMonth());
		System.out.println("The 11th business day in July 2011 is: "
				+ BusinessCalendar.findBusinessDayinMonth(11, Calendar.JULY,
						2011).printDate());
	}

}
