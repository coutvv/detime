package ru.coutvv.detime.names.monthday;

/**
 * Дни 06 месяца
 * Зима
 * @author coutvv
 */
public enum DayOfVentose implements RepublicanDay  {
    TUSSILAGE,
    CORNOUILLER,
    VIOLIER,
    TROENE,
    BOUC,
    ASARET,
    ALATERNE,
    VIOLETTE,
    MARCEAU,
    BECHE,
    NARCISSE,
    ORME,
    FUMETERRE,
    VELAR,
    CHEVRE,
    EPINARD,
    DORONIC,
    MOURON,
    CERFEUIL,
    CORDEAU,
    MANDRAGORE,
    PERSIL,
    COCHLEARIA,
    PAQUERETTE,
    THON,
    PISSENLIT,
    SYLVIE,
    CAPILLAIRE,
    FRENE,
    PLANTOIR;

    public String getName() {
        return this.name();
    }

    public static void main(String[] args) {
        DayOfVentose.ALATERNE.name();
    }
}
