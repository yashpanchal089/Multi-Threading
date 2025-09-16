import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        //Submit 5 tasks

        for(int i = 1; i <=5; i++){
            int taskId = i;
            executor.submit(()-> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}
