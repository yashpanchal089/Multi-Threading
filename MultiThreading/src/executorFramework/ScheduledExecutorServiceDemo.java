package executorFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService schedular = Executors.newScheduledThreadPool(1);
        AtomicInteger count = new AtomicInteger();
                schedular.scheduleAtFixedRate(
                () -> {
                System.out.println("Task executed after every 1 second delay!");
                    count.getAndIncrement();
                },
                1, 5, TimeUnit.SECONDS);
                ScheduledFuture<?> scheduledFuture = schedular.scheduleWithFixedDelay(
                        () -> System.out.println("Task executed after every 1 second delay"),
                1, 5, TimeUnit.SECONDS);



        schedular.schedule(()-> {
            System.out.println("Initiating Shutdown");
            System.out.println("Total Task Executed " + count.get());
            schedular.shutdown();
        }, 25, TimeUnit.SECONDS);


    }
    // Here I have done extra thing that is I have taken the count of how many times task has
    // been executed.
}
