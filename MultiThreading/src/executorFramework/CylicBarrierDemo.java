package executorFramework;

import java.util.concurrent.*;

public class CylicBarrierDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException{

        int numberOfService = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfService);
        CyclicBarrier barrier = new CyclicBarrier(numberOfService);
        executorService.submit(new DependentService1(barrier));
        executorService.submit(new DependentService1(barrier));
        executorService.submit(new DependentService1(barrier));
        System.out.println("Main");
        executorService.shutdown();

    }
}

class DependentService1 implements Callable<String> {

    private final CyclicBarrier barrier;

    public DependentService1(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " service started.");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " is waiting at the barrier");
        barrier.await();
        return "ok";
    }

    //Main block printed as first
}
