package executorFramework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(() -> System.out.println("Hello"));
        future.get();
        executorService.shutdown();
//        executorService.submit(() -> System.out.println("Hello"), "success");

        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        Future<Integer> submut = executorService1.submit(() -> 1 + 2);
        Integer i = submut.get();
        System.out.println("Sum is " + i);
        executorService1.shutdown();
        Thread.sleep(1);
        System.out.println(executorService1.isShutdown());
        System.out.println(executorService1.isTerminated());


        ExecutorService executorService2 = Executors.newFixedThreadPool(3);

        Callable<Integer> callable1 = () -> {
            System.out.println("Task 1");
            Thread.sleep(1000);
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            System.out.println("Task 2");
            Thread.sleep(1000);
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            System.out.println("Task 3");
            Thread.sleep(1000);
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);


        List<Future<Integer>> futures = null;
        try {
            futures = executorService2.invokeAll(list, 1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(Future<Integer> f : futures){
            System.out.println(f.get());
        }

        executorService2.invokeAny(list);

        executorService2.shutdown();
        System.out.println("Hello World"); //It will print on last after performing above all task





    }
}
