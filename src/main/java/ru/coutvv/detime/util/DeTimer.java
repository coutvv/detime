package ru.coutvv.detime.util;

import ru.coutvv.detime.DeTime;
import ru.coutvv.detime.temporal.DecimalChronoUnit;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Таймер для отсчёта в десятичном времени
 *
 * @author coutvv
 */
public class DeTimer implements Runnable{

    private long gregMillis;

    private final Consumer<DeTime> consumer;

    /**
     *
     * @param hour
     * @param min
     * @param sec
     * @param consumer -- нужна чтобы чтото делать с тикающим временем
     */
    public DeTimer(int hour, int min, int sec, Consumer<DeTime> consumer) {
        this.consumer = consumer;
        this.gregMillis = DecimalChronoUnit.SECOND.getDuration().toMillis() * (
                    hour * 100 * 100 +
                    min  * 100 +
                    sec
                );
        consumer.accept(current());
    }

    @Override
    public void run() {
        while(gregMillis > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(DecimalChronoUnit.SECOND.getDuration().toMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gregMillis -= DecimalChronoUnit.SECOND.getDuration().toMillis();
            consumer.accept(current());
        }
    }

    /**
     * сейчашное время
     */
    private DeTime current() {
        return DeTime.convert(LocalTime.ofNanoOfDay(gregMillis * 1_000_000));
    }

}
