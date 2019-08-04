package ru.coutvv.detime.decimal.date;

import java.time.LocalDate;
import java.util.Set;

/**
 * This class similate french republican calendar
 * but with same leap years as in the Gregorian calendar
 *
 * @author coutvv    2019-07-01
 */
public class DeCalendar {
	private static final int MONTH_COUNT = 12;
	private static final LocalDate FRENCH_REVOLUTION = LocalDate.of(1792, 9, 22);
//	private static final Set<Integer> OMAR_NUMBERS = Set.of(1, 5, 9, 13, 17, 22, 26, 30);
	/**
	 * used for defining leap decimal year (Omar Hayam cycle)
	 */
	private static final Set<Integer> FRENCH_OMAR_NUMBERS = Set.of(1, 5, 9, 13, 17, 22, 26, 30);

	public final DeMonth[] months;
	public final DeMonth olympicWeek;
	public final DeMonth leapOlympicWeek;

	public final LocalDate beginDate;

	public DeCalendar() {
		this(
				defaultMonths(),
				defaultOlympicWeek(),
				leapDefaultOlympicWeek(),
				FRENCH_REVOLUTION
		);
	}

	public DeCalendar(DeMonth[] months, DeMonth olympicWeek, DeMonth leapOlympicWeek, LocalDate beginDate) {
		this.months = months;
		this.olympicWeek = olympicWeek;
		this.leapOlympicWeek = leapOlympicWeek;
		this.beginDate = beginDate;
	}

	public int year(LocalDate date) {
		int result = date.getYear() - beginDate.getYear();
		if (date.getMonth().getValue() > 9 || date.getMonth().getValue() == 9 && date.getDayOfMonth() >= 22) {
			result++;
		}
		return result;
	}

	public int dayOfDeYear(LocalDate date) {
		int dayOfYearDate = date.getDayOfYear();

		int beginDay = LocalDate.of(date.getYear(), beginDate.getMonth(), beginDate.getDayOfMonth()).getDayOfYear();
		if (dayOfYearDate >= beginDay) {
			return dayOfYearDate - beginDay;
		} else {
			int offset = date.isLeapYear() ? 366 : 365;
			return dayOfYearDate + offset - beginDay;
		}
	}

	public boolean isLeapDeYear(LocalDate date) {
		int year = year(date);
		return isLeapDeYear(year);
	}

	public boolean isLeapDeYear(int year) {
		return FRENCH_OMAR_NUMBERS.contains(year % 33);
	}

	private static DeMonth[] defaultMonths() {
		DeMonth[] result = new DeMonth[MONTH_COUNT];
		for (int i = 1; i <= MONTH_COUNT; i++) {
			result[i - 1] = new DeMonth("Month " + i, i);
		}
		return result;
	}

	private static DeMonth defaultOlympicWeek() {
		DayOfMonth[] result = new DayOfMonth[5];
		for (int i = 1; i <= 5; i++) {
			result[i - 1] = new DayOfMonth("Olympic Day " + i, i);
		}
		return new DeMonth("Olympic Week", 13, result);
	}

	private static DeMonth leapDefaultOlympicWeek() {
		DayOfMonth[] result = new DayOfMonth[6];
		for (int i = 1; i <= 6; i++) {
			result[i - 1] = new DayOfMonth("Olympic Day " + i, i);
		}
		return new DeMonth("Olympic Week", 13, result);
	}
}
