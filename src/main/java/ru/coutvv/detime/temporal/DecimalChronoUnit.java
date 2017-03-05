package ru.coutvv.detime.temporal;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

/**
 * временные единицы десятичных часов
 *
 * @author coutvv
 */
public enum DecimalChronoUnit implements TemporalUnit {

    /**
     * 1 десятичная секунда == 0,864 обычной секунды
     */
    SECOND("second", Duration.ofNanos(864000000)),

    /**
     * В минуте 100 десятичных секунд
     */
    MINUTE("minute", Duration.of(100, SECOND)),

    /**
     * В часе 100 десятичных минут
     */
    HOUR("hour", Duration.of(100, MINUTE)),

    /**
     * В дне 10 десятичных часов
     */
    DAY("day", Duration.of(10, HOUR)),

    /**
     * Декада(она же неделя) состоит из 10 дней
     */
    DECADE("decade", Duration.of(10, DAY)),

    /**
     * Месяц состоит из трёх декад
     */
    MONTH("names", Duration.of(3, DECADE)),

    /**
     * Олимпийская неделя обычного года
     * Этот отрезок времени прибавляется к концу года
     */
    OLYMPIC_WEEK("olympicWeek", Duration.of(5, DAY)),

    /**
     * Олимпийская неделя високосного года
     * Этот отрезок времени прибавляется к концу года
     */
    LEAP_OLYMPIC_WEEK("leapOlympicWeek", Duration.of(6, DAY)),

    /**
     * Год такой же как и обычный по времени
     * но состоит из 12 десятичных месяцев и
     * олимпийской недели
     */
    YEAR("year", Duration.of(12, MONTH).plus(OLYMPIC_WEEK.duration)),

    /**
     * Високосный год
     */
    LEAP_YEAR("leapYear", Duration.of(1, YEAR).plus(LEAP_OLYMPIC_WEEK.duration));

    String name;
    Duration duration;

    DecimalChronoUnit(String name, Duration estimatedDuration) {
        this.name = name;
        this.duration = estimatedDuration;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }

    /**
     * TODO:
     * @return
     */
    @Override
    public boolean isDurationEstimated() {
        return false;
    }

    @Override
    public boolean isDateBased() {
        return false;
    }

    @Override
    public boolean isTimeBased() {
        return false;
    }

    /**
     * TODO:
     * @param temporal
     * @param amount
     * @param <R>
     * @return
     */
    @Override
    public <R extends Temporal> R addTo(R temporal, long amount) {
        return null;
    }

    @Override
    public long between(Temporal temporal1Inclusive, Temporal temporal2Exclusive) {
        return 0;
    }
}
