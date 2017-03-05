package ru.coutvv.detime;


import ru.coutvv.detime.temporal.DecimalChronoUnit;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class DeTime {

	private final byte hour;
	private final byte minute;
	private final byte seconds;

	public DeTime(byte hour, byte minute, byte seconds) {
		this.hour = hour;
		this.minute = minute;
		this.seconds = seconds;
	}

	public byte getHour() {
		return hour;
	}

	public byte getMinute() {
		return minute;
	}

	public byte getSeconds() {
		return seconds;
	}

	public static DeTime now() {
		LocalTime now = LocalTime.now();
		return convert(now);
	}

	public static DeTime convert(LocalTime gregorian) {
		long nanos = gregorian.getLong(ChronoField.NANO_OF_DAY);
		long seconds = nanos / DecimalChronoUnit.SECOND.getDuration().getNano();
		byte hour = (byte) (seconds / 10000);
		seconds = seconds % 10000;
		byte minute = (byte) (seconds / 100);
		seconds = seconds % 100;
		return new DeTime(hour, minute, (byte) seconds);
	}


	public String toString() {
		String minute = getMinute() < 10 ? "0" + getMinute() : "" + getMinute();
		String seconds = getSeconds() < 10 ? "0" + getSeconds() : "" + getSeconds();
		return "0" + getHour() + ":" + minute + ":" + seconds;
	}
}
