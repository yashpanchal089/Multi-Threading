package executorFramework;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> "Hello";
        Future<?> future = executorService.submit(callable);
        System.out.println(future.get());
        executorService.shutdown();

        // Using callable it can return a value.
        // It can throw a checked exception.
        // It returns a Future object → this is like a "promise" that,
        // you can use to get the result later.
    }
}
