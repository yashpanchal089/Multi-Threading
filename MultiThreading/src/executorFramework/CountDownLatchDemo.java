package executorFramework;

import java.util.concurrent.*;

public class CountDownLatchDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfServices = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(numberOfServices);
        for (int i =0; i< numberOfServices; i++){
            new Thread(new DependentService(latch)).start();
        }
        latch.await(5, TimeUnit.SECONDS);
        System.out.println("Main");
        for(int i = 0; i<5;i++){
            System.out.println("Checking the main method");
        }
        executorService.shutdown();





//        Future<String> future1 = executorService.submit(new DependentService());
//        Future<String> future2 = executorService.submit(new DependentService());
//        Future<String> future3 = executorService.submit(new DependentService());
//
//        future1.get();
//        future2.get();
//        future3.get();
//        System.out.println("All Dependent service finished. Staring main service ");
//
//        executorService.shutdown();

    }
}

class DependentService implements Runnable{

    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " service started.");
        } catch (Exception _){

        } finally {
            latch.countDown();
        }
    }
}