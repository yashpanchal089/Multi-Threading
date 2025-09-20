package ExtraStuff;

public class DaemonExample {
    public static void main(String[] args) {

        // Example 1: Simple Daemon Thread
        Thread daemon = new Thread(() -> {
            while (true){
                System.out.println("Hello");
                try {
                   Thread.sleep(1000);
                } catch (InterruptedException _) {
             }
            }
        });
        daemon.setDaemon(true);
        daemon.start();

        System.out.println("main thread finished");


//      Example 2: Daemon vs User Thread
        Thread userThread = new Thread(() -> {
            System.out.println("User thread started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException _) {
            }
            System.out.println("user thread finished");
        });

        Thread daemonThread = new Thread(() -> {
           while (true){
               System.out.println("Daemon Thread runnig");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException _) {
               }
           }
        });

        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();

        //Example 3: IllegalThreadStateException (Common Mistake)
        Thread t = new Thread(() -> {
            System.out.println("Thread Running");
        });

        t.start();
        t.setDaemon(true);


    }
}
