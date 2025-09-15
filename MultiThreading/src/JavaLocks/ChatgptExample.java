package JavaLocks;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void increment(){
        lock.lock();
        try{
            count++;
            System.out.println(Thread.currentThread().getName() + " -> " + count);
        } finally {
            lock.unlock();
        }
    }
}

public class ChatgptExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Runnable task = () -> {
            for (int i = 0; i< 5; i++) {
                resource.increment();
                System.out.println("Hello : " + i);
            }
        };

        Thread t1 = new Thread();
        Thread t2 = new Thread();
        t1.start();
        t2.start();
    }
}

