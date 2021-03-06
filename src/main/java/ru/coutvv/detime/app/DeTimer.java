package ru.coutvv.detime.app;

import ru.coutvv.detime.DeTime;
import ru.coutvv.detime.temporal.DecimalChronoUnit;

import java.time.LocalTime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Таймер для отсчёта в десятичном времени
 *
 * @author coutvv
 */
public class DeTimer implements Runnable {

    private long gregMillis;

    private final Consumer<DeTime> consumer;

    /**
     * Используется для остановки таймера
     */
    private volatile boolean isRun;

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
        isRun = true;
        while(gregMillis > 0 && isRun) {
            try {
                TimeUnit.MILLISECONDS.sleep(DecimalChronoUnit.SECOND.getDuration().toMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            gregMillis -= DecimalChronoUnit.SECOND.getDuration().toMillis();
            if(isRun)
                consumer.accept(current());
        }
    }

    public void stop() {
        isRun = false;
    }

    /**
     * сейчашное время
     */
    private DeTime current() {
        return DeTime.convert(LocalTime.ofNanoOfDay(gregMillis * 1_000_000));
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("wtf?");
        DeTimer dt = new DeTimer(1, 0, 0, (s) -> System.out.print("second!"));
        Executor e = Executors.newSingleThreadExecutor();
        e.execute(dt);
        System.out.println("fuk off");
        Thread.sleep(1_000);

        dt.stop();
    }
}
