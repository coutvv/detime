package ru.coutvv.detime.names;

import ru.coutvv.detime.names.monthday.RepublicanDay;

/**
 * @author coutvv
 */
public enum DayOfOlympicWeek implements RepublicanDay {
    LA_FETE_DE_LA_VERTU,
    LA_FETE_DU_GENIE,
    LA_FETE_DU_TRAVAIL,
    LA_FETE_DE_L_OPINION,
    LA_FETE_DES_RECOMPENSES,
    LA_FETE_DE_LA_REVOLUTION;
    public String getName() {
        return name();
    }
}
