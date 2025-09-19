package ExtraStuff;

public class ThreadPriority {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 is running " + Thread.currentThread().getPriority());
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 is running " + Thread.currentThread().getPriority());
        });

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();

        Runnable task = () -> {
            for (int i =1; i <= 5; i++){
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
        };

        Thread low = new Thread(task, "Low-Priority");
        Thread medium = new Thread(task, "Medium - Priority");
        Thread high = new Thread(task, "High-Priority");

        low.setPriority(Thread.MIN_PRIORITY);
        medium.setPriority(Thread.NORM_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);

        low.start();
        medium.start();
        high.start();
        
    }
}
