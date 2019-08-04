package ru.coutvv.detime.decimal.date;

/**
 * @author coutvv    2019-07-01
 */
public class DeMonth {
	private static final int DAY_COUNT = 30;

	public final String name;
	public final int number; // from 1 to 12

	private final DayOfMonth[] days;

	public DeMonth(String name, int number) {
		this(name, number, defaultDays());
	}

	public DeMonth(String name, int number, DayOfMonth[] days) {
		this.name = name;
		this.number = number;
		this.days = days;
	}

	public DayOfMonth dayAt(int i) {
		return days[i];
	}

	private static DayOfMonth[] defaultDays() {
		DayOfMonth[] result = new DayOfMonth[DAY_COUNT];
		for (int i = 0; i < DAY_COUNT; i++) {
			result[i] = new DayOfMonth("Day " + (i + 1), i + 1);
		}
		return result;
	}
}
