package ExtraStuff;

class MyThread extends Thread{
    public void run(){
        System.out.println("Thread Running : " + Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Runnable Thread : " + Thread.currentThread().getName());
    }
}

class ThreadStateDemo{
    Thread t = new Thread(() -> System.out.println("Thread Running"));

}

public class HelloThread {

    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Hello thread Running :" + Thread.currentThread().getName());

        new MyThread().start();
        new Thread(new MyRunnable()).start();

        ThreadStateDemo ts = new ThreadStateDemo();
        System.out.println("Start before state: " + ts.t.getState());
        ts.t.start();
        Thread.sleep(1000);
        System.out.println("State after run : " + ts.t.getState());

    }

}
