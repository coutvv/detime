package ru.coutvv.detime.names.monthday;


import ru.coutvv.detime.names.DayOfOlympicWeek;
import ru.coutvv.detime.names.Months;

/**
 * @author coutvv
 */
public interface MonthDays {
    /**
     *
     * @param month
     * @param day <=30 && =>1
     * @return
     */
    static RepublicanDay getDayByMonth(Months month, int day) {
        int dayIndex = day-1;
        switch (month) {
            case VANDEMIAIRE:
                return DayOfVendemiaire.values()[dayIndex];
            case BRUMAIRE:
                return DayOfBrumaire.values()[dayIndex];
            case FRIRMAIRE:
                return DayOfFrimaire.values()[dayIndex];

            case NAVOSE:
                return DayOfNivose.values()[dayIndex];
            case PLUVIOSE:
                return DayOfPluviose.values()[dayIndex];
            case VENTOSE:
                return DayOfVentose.values()[dayIndex];

            case GERMINAL:
                return DayOfGerminal.values()[dayIndex];
            case FLOREAL:
                return DayOfFloreal.values()[dayIndex];
            case PRAIRIAL:
                return DayOfPrairial.values()[dayIndex];

            case MESSIDOR:
                return DayOfMessidor.values()[dayIndex];
            case THRMIDOR:
                return DayOfThermidor.values()[dayIndex];
            case FRUCTIDOR:
                return DayOfFructidor.values()[dayIndex];
            case OLYMPIC_WEEK:
                return DayOfOlympicWeek.values()[dayIndex];
            default:
                throw new IllegalArgumentException("Неверный параметр месяца");
        }
    }

    static RepublicanDay getDayByMonth(int month, int day) {
        if(month > 13) throw new IllegalArgumentException("Неверный номер месяца");
        int monthIndex = month - 1;
        return getDayByMonth(Months.values()[monthIndex], day);
    }

}
