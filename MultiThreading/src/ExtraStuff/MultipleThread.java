package ExtraStuff;

public class MultipleThread {
    private static int totalTask = 0;
    private static synchronized void incrementTask(){
        totalTask++;
    }
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
           for (int i = 0; i <1000; i++){
               incrementTask();
           }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i <1000; i++){
                incrementTask();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Total tasks executed: " + totalTask);

    }
}
