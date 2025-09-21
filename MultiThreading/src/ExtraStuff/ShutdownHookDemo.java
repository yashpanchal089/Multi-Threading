package ExtraStuff;

class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("Shut down hook task completed");
    }
}

public class ShutdownHookDemo {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        r.addShutdownHook(new MyThread1());

        System.out.println("Now main thread sleeping ...press ctrl + c to exit");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException _) {
        }
    }
}
