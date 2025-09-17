package executorFramework;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Callable<String> callable = () -> "Hello";
        Future<? > future = executorService.submit(() ->System.out.println("Hello"));
//        future.get();
        executorService.shutdown();
    }

}
