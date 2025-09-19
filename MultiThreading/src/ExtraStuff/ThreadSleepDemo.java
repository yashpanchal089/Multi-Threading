package ExtraStuff;

public class ThreadSleepDemo {

    public static void main(String[] args) {
//        System.out.println("Start");
//        try{
//        Thread.sleep(2000);
//        } catch ( InterruptedException _){
//        }
//        System.out.println("End after 2 seconds");


//        for (int i = 0; i <= 5; i++) {
//            System.out.println("Count of i : " + i);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

        Thread t = new Thread(() -> {
            try{
                System.out.println("Thread Sleeping");
                Thread.sleep(5000);
                System.out.println("Woke up naturally");
            } catch ( InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
        });

        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        t.interrupt();


    }


}
