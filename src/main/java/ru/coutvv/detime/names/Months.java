package ru.coutvv.detime.names;

/**
 * Месяцы
 *
 * @author coutvv
 */
public enum Months {
    //autumn
    VANDEMIAIRE,
    BRUMAIRE,
    FRIRMAIRE,
    //winter
    NAVOSE,
    PLUVIOSE,
    VENTOSE,
    //spring
    GERMINAL,
    FLOREAL,
    PRAIRIAL,
    //Summer:
    MESSIDOR,
    THRMIDOR,
    FRUCTIDOR,
    //end of year
    OLYMPIC_WEEK;

    /**
     *
     * @author coutvv
     */
    public static void main(String[] args) {
        System.out.println(FLOREAL.compareTo(NAVOSE));
    }
}
