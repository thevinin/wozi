package com.wozi.utilities;

import java.util.Calendar;

public enum Quarter {
	Q1(Calendar.JANUARY, Calendar.FEBRUARY, Calendar.MARCH), Q2(Calendar.APRIL,
			Calendar.MAY, Calendar.JUNE), Q3(Calendar.JULY, Calendar.AUGUST,
			Calendar.SEPTEMBER), Q4(Calendar.OCTOBER, Calendar.NOVEMBER,
			Calendar.DECEMBER);

	private final int[] month = new int[3];

	private Quarter(int mon1, int mon2, int mon3) {
		month[0] = mon1;
		month[1] = mon2;
		month[2] = mon3;
	}

	int first() {
		return month[0];
	}

	int last() {
		return month[2];
	}
}
