//start run sleep join setPriority Interrupt yield setDaemon

/*
public class MyThread1 extends Thread{
    @Override
    public void run() {

        for(int i = 0;i <= 5; i++)
            System.out.println(Thread.currentThread().getName()+ " - Priority ");
//        System.out.println("Running");
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
                throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread1 t1 = new MyThread1();
        t1.start();

        t1.join();
        System.out.println("Hello");
    }
}
 */


//set Priority Example
/*
public class MyThread1 extends Thread{

    public MyThread1(String name){
        super(name);

    }

    @Override
    public void run() {
        for(int i = 0; i <= 5; i++ ){
            String a = "";
            for (int j = 0; j <= 100000; j ++ ){
                a += "a";
            }
            System.out.println(Thread.currentThread().getName() + " - Priority : " + Thread.currentThread().getPriority() + " - count : " + i) ;
            try{
                Thread.sleep(10);
            }catch (Exception e){

            }
        }
    }

    public static void main(String[] args) {

        MyThread1 l = new MyThread1("Low Priority Thread");
        MyThread1 m = new MyThread1("Medium Priority Thread");
        MyThread1 h = new MyThread1("High Priority Thread");
        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);
        l.start();
        m.start();
        h.start();

    }
}
*/

//Interrupt Example
/*
public class MyThread1 extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Thread is Running");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted " + e);
        }
    }

    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.start();
        t1.interrupt();
    }
}
*/

//Yield Example
/*
public class MyThread1 extends Thread{

    @Override
    public void run() {
        for (int i =0; i<= 5; i++){
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread1 t2 = new MyThread1();
        t1.start();
        t2.start();
    }
}
 */

//setDaemon Example
public class MyThread1 extends Thread{

    @Override
    public void run() {
        while (true){
            System.out.println("Hello World");

        }
    }

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.setDaemon(true);
        myThread1.start();
        System.out.println("Main Done");
    }
}