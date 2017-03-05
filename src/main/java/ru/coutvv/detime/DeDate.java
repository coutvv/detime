package ru.coutvv.detime;

import ru.coutvv.detime.names.monthday.MonthDays;
import ru.coutvv.detime.names.monthday.RepublicanDay;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * Created by coutvv on 04.03.2017.
 */
public class DeDate {

    /**
     * The year.
     */
    private final int year;
    /**
     * The names-of-year.
     */
    private final short month;
    /**
     * The day-of-names.
     */
    private final short day;

    public DeDate(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = (short)month;
        this.day = (short)dayOfMonth;
    }

    public int getYear() {
        return year;
    }

    public short getMonth() {
        return month;
    }

    public short getDay() {
        return day;
    }

    public String getMonthName() {
        return Month.values()[month].name();
    }

    public String getDayName() {
        return MonthDays.getDayByMonth(month, day).getName();
    }

    public static DeDate now() {
        LocalDate now = LocalDate.now();
        int day = getDecimalDay(now);
        int month = getDecimalMonth(now);
        int year = getDecimalYear(now);
        return new DeDate(year, month, day);
    }

    public static int getDecimalDay(LocalDate gregorianDate) {
        int result;
        LocalDate startDay = getStartDateByThisYear(gregorianDate);
        long days = startDay.until(gregorianDate, ChronoUnit.DAYS);
        if(days > 360) return 0;//olympic week
        result = (int) ((days+1)%30 == 0 ? 30 : (days+1)%30);//++ так как революционный день первый
        return result;
    }


    public static int getDecimalMonth(LocalDate gregorianDate) {
        int result;
        LocalDate startDay = getStartDateByThisYear(gregorianDate);
        long days = startDay.until(gregorianDate, ChronoUnit.DAYS);
        int month = (int)days/30;

        result = days%30 == 0 ? month : month + 1;
        if(days > 360) result = 0;//olympic week

        return result;
    }

    public static int getDecimalYear(LocalDate gregorianDate) {
        int result;
        if(isOman(gregorianDate)) {
            result = gregorianDate.getYear() - 1792;
        } else {
            result = gregorianDate.getYear() - 1793;
        }
        return result;
    }

    private static boolean isOman(LocalDate gregorianDate) {
        return gregorianDate.getMonthValue() > 9 ||
                (gregorianDate.getMonthValue() == 9 && gregorianDate.getDayOfMonth() > 21);
    }



    private static LocalDate getStartDateByThisYear(LocalDate gregorianDate) {
        if(isOman(gregorianDate)){
            return LocalDate.of(gregorianDate.getYear(), Month.SEPTEMBER, 22);
        } else {
            return LocalDate.of(gregorianDate.getYear()-1, Month.SEPTEMBER, 22);
        }
    }
}
