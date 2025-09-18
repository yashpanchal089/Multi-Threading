package executorFramework;

import java.util.concurrent.*;

public class FutureMethod {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(() -> {
            try {
            Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Exception Occurred : "+e);
            }
            return 42;
        });
        Integer i = null;
        try{
            i = future.get(1, TimeUnit.SECONDS);
            System.out.println(future.isDone());
            System.out.println(i);
        } catch (TimeoutException| InterruptedException | ExecutionException e){
            System.out.println("Exception Occurred: " + e);
        }


        executorService.shutdown();

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        Future<Integer> future1 = executorService1.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Exception occurred " + e);
            }
            System.out.println("Hello");
            return 42;
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Exception occurred " + e);
        }
        future1.cancel(false);
        System.out.println(future1.isCancelled());
        System.out.println(future1.isDone());

        executorService1.shutdown();


    }
}
