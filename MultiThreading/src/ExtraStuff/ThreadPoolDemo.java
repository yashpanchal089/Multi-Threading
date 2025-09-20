package ExtraStuff;

import java.lang.classfile.constantpool.PoolEntry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class WorkerThread implements Runnable{

    private final String message;

    public WorkerThread(String message){
        this.message =message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start : " + message);
        try{
            Thread.sleep(2000);
        }catch (InterruptedException _){
        }
        System.out.println(Thread.currentThread().getName() + " End : " + message);
    }
}

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // Example 1: Fixed Thread Pool
        ExecutorService executor = Executors.newFixedThreadPool(3);

//        for(int i =0; i<=6;i++){
//            Runnable worker = new WorkerThread("task - " +i);
//            executor.execute(worker);
//        }

        executor.shutdown();
        while (!executor.isTerminated()){}

//        System.out.println("All tasks finished of example -1 ");

        //Example 2: Cached Thread Pool
        ExecutorService executor1 = Executors.newCachedThreadPool();

//        for (int i=0; i <= 5; i++){
//            final int taskId = i;
//            executor1.execute(() -> {
//                System.out.println(Thread.currentThread().getName() + " is working on task - " + taskId);
//                try {
//                    Thread.sleep(4000);
//                } catch (InterruptedException _) {
//                }
//            });
//        }
        executor1.shutdown();

        // Example 3: Single Thread Executor
        ExecutorService executor2 = Executors.newSingleThreadExecutor();

        for (int i = 1; i<= 4; i++) {
//            final int taskId = i;
//            executor2.execute(() -> {
//                System.out.println(Thread.currentThread().getName() + " running task - " + taskId);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException _) {
//                }
//            });
        }
//        executor2.shutdown();

        //Example 4: Risk of Deadlock
        ExecutorService pool = Executors.newFixedThreadPool(1);

        Future<?> future = pool.submit(() -> {
            System.out.println("Task 1 Running...");
            try {
                pool.submit(() -> System.out.println("Inner Task Running...")).get();
            } catch (ExecutionException _) {
            } catch (InterruptedException e) {
            }
        });
        try {
            future.get();
        } catch (Exception e) {
        }
        pool.shutdown();
    }
}
