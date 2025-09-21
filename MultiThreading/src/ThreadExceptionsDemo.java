import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadExceptionsDemo {

    public static void main(String[] args) {
        // Example 1: Normal Exception in a Thread

        Thread t = new Thread(() -> {
            System.out.println("Thread Started");
            int x = 10/0;
        });
//        t.start();
//        System.out.println("Main thread still Running");

        // Example 2: Handling Exception Inside Thread

        Thread t1 = new Thread(() -> {
            try {
                int x= 10/0;
            } catch (Exception e) {
                System.out.println("Error Caught : " + e);
            }
        });
//        t1.start();

        // Example 3: Using UncaughtExceptionHandler

        Thread t2 = new Thread(() -> {
            throw new RuntimeException("Something went wrong!");
        });

        t2.setUncaughtExceptionHandler((th, e) -> {
            System.out.println("Thread" + th.getName() + " crashed : " + e);
        });

        t2.start();

//      Example 4: In Thread Pool (ExecutorService)

        ExecutorService pool = Executors.newFixedThreadPool(1);

        Future<?> f = pool.submit(() -> {
            throw new RuntimeException("Task failed!");
        });

        try {
            f.get();  // throws ExecutionException
        } catch (Exception e) {
            System.out.println("Caught: " + e.getCause());
        }

        pool.shutdown();



    }
}
