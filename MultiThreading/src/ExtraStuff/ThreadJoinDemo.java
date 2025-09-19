package ExtraStuff;

public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {

//        Thread worker = new Thread(() -> {
//           for ( int i =0; i<=5; i++){
//               System.out.println("Worker thread: " +i);
//               try {
//                   Thread.sleep(1000);
//               } catch (InterruptedException e) {
//
//               }
//           }
//        });
//
//        worker.start();
//
//        worker.join();
//
//        System.out.println("Main thread finished after worker");

        // Ex = 2
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("Thread 1 finished");
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println("Thread 2 finished");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Main 2 thread finished after worker");

        // Ex = 3

        Thread slow = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Slow Thread");
            } catch (InterruptedException e) {

            }
        });

        slow.start();
        slow.join(2000);
        System.out.println("Main 3 thread finished after worker");






    }
}
