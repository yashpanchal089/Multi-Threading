package ExtraStuff;


//Program of performing single task by multiple threads

// using thread methods
class MultiTasking extends Thread{
    public void run(){
        System.out.println("Task One");
    }
}

//using Runnable
class MultiTasking1 implements Runnable{
    public void run(){
        System.out.println("Task One");
    }
}

class MultiTasking2 extends Thread{
    public void  run(){
        System.out.println("Task Two-2");
    }
    public void start(){
        System.out.println("Task One-1");
    }
}



public class MultitaskingDemo {
    public static  void main(String[] args) {
        MultiTasking t1 = new MultiTasking();
        MultiTasking t2 = new MultiTasking();
        MultiTasking t3 = new MultiTasking();

        t1.start();
        t2.start();
        t3.start();

        Thread R1 = new Thread(new MultiTasking1());
        Thread R2 = new Thread(new MultiTasking1());

        R1.start();
        R2.start();

        MultiTasking Y1 = new MultiTasking();
        MultiTasking2 Y2 = new MultiTasking2();

        Y1.start();
        Y2.start();

        Thread thread1 = new Thread(() -> {
           for (int i = 0; i<= 5; i++){
               System.out.println("Thread 1 - Task " + i);
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
               }
           }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i<= 5; i++){
                System.out.println("Thread 2 - Task " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException _) {

        }
        thread2.start();

    }
}

