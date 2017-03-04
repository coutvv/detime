package ru.coutvv.detime.names.monthday;

/**
 * Дне 01 месяца
 * Осень
 * @author coutvv
 */
public enum DayOfVendemiaire {
    RAISIN,
    SAFRAN,
    CHATAIGNE,
    COLCHIQUE,
    CHEVAL,
    BALSAMINE,
    CAROTTE,
    AMARANTHE,
    PANAIS,
    CUVE,
    POMME_DE_TERRE,
    IMMORTELLE,
    POTIRON,
    RESEDA,
    ANE,
    BELLE_DE_NUIT,
    CITROUILLE,
    SARRASIN,
    TOURNESOL,
    PRESSOIR,
    CHANVRE,
    PECHE,
    NAVET,
    AMARYLLIS,
    BAUF,
    AUBERGINE,
    PIMENT,
    TOMATE,
    ORGE,
    TONNEAU;

    public static void main(String[] args) {
        DayOfVendemiaire day = DayOfVendemiaire.values()[13];
        System.out.println(day.name());
    }
}
