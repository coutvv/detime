package ru.coutvv.detime.decimal.date;

import java.time.LocalDate;

/**
 * @author coutvv    2019-07-01
 */
public class DeDate {
	private final DeCalendar calendar;
	private final LocalDate date;

	public DeDate() {this(LocalDate.now());}

	public DeDate(LocalDate date) {
		this(new DeCalendar(), date);
	}

	public DeDate(DeCalendar calendar, LocalDate date) {
		this.calendar = calendar;
		this.date = date;
	}

	public String deName() {
		int year = calendar.year(date);

		int dayOfYear = calendar.dayOfDeYear(date);
		int monthIndex = dayOfYear / 30; // index or % for olympic
		int dayOfMonth = dayOfYear % 30; // 0 - 30th day

		DeMonth month;
		if (monthIndex == 12) {
			month = calendar.isLeapDeYear(date) ? calendar.leapOlympicWeek : calendar.olympicWeek;
		} else {
			month = calendar.months[monthIndex];
		}

		return year + " " + month.name + " " + month.dayAt(dayOfMonth).name;
	}
}
