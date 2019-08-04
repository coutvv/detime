package ru.coutvv.detime.app;

import ru.coutvv.detime.DeTime;
import ru.coutvv.detime.temporal.DecimalChronoUnit;

/**
 * simple terminal decimal clock
 *
 * @author coutvv    2019-08-04
 */
public class DeClock {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(DecimalChronoUnit.SECOND.getDuration().toMillis());
		for(;;) {
			DeTime now = DeTime.now();
			System.out.println(now.getHour() + ":" + now.getMinute() + ":" + now.getSeconds());
			Thread.sleep(DecimalChronoUnit.SECOND.getDuration().toMillis());
		}
	}
}
