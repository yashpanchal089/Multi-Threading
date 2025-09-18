import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker");
            } catch (Exception _) {

            }
            return "ok";
        });
        String s = f1.getNow("nooo");
        System.out.println(s);
        System.out.println("Main");

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker");
            } catch (Exception _) {

            }
            return "ok";
        });

        CompletableFuture<Void> f = CompletableFuture.allOf(f1, f2);
        f.join();
        System.out.println("main");

        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker");
            } catch (Exception _) {

            }
            return "ok";
        }).thenApply(x -> x + x);
        System.out.println(f3.get());

        Executor executor = Executors.newFixedThreadPool(3);
        CompletableFuture<String> f4 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Worker");
            } catch (Exception _) {

            }
            return "ok";
        }, executor).orTimeout(1, TimeUnit.SECONDS).exceptionally(S -> "Timeout Occurred");
        System.out.println(f4.get());
        ((ExecutorService) executor).shutdown();

    }
}
