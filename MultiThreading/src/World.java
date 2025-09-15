public class World implements Runnable{
    @Override
    public void run() {
        for( ; ; ){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

    }
}
