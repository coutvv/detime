package ru.coutvv.detime;


/**
 * Created by coutvv on 04.03.2017.
 */
public class TestDeDate {

    public static void main(String[] args) {

        DeDate now = DeDate.now();
        print(now);
        DeDate date = new DeDate(224, 13, 3);
        print(date);
    }

    static void print(DeDate now) {

        System.out.println(now.getDay() + "." + now.getMonth() + "." + now.getYear());
        System.out.println("Month: " + now.getMonthName());
        System.out.println("Day: " + now.getDayName());
    }

}
