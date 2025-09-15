package Synchronization;

class Counter {
    private int count = 0;

    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}

class ExThread extends Thread{
    private final Counter counter;


    public ExThread (Counter counter) {
        this.counter= counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            counter.increment();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ExThread t1 = new ExThread(counter);
        ExThread t2 = new ExThread(counter);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch (Exception e) {

        }
        System.out.println(counter.getCount());


    }
}
