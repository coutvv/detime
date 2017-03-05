package ru.coutvv.detime;

import ru.coutvv.detime.temporal.DecimalChronoUnit;


/**
 * @author coutvv
 */
public class TestDeTime {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(DecimalChronoUnit.SECOND.getDuration().toMillis());
        for(;;) {
            DeTime now = DeTime.now();
            System.out.println(now.getHour() + ":" + now.getMinute() + ":" + now.getSeconds());
            Thread.sleep(DecimalChronoUnit.SECOND.getDuration().toMillis());
        }
    }

}
