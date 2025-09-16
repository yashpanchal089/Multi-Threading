public class LambdaExpression {
    public static void main(String[] args) {
        //Functional Interface
        // you can do with single abstract method
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Universe");
            }
        };

        //Enhanced way
        Runnable runnable1 = () -> System.out.println("Hello");
        Thread t1 = new Thread(runnable1);
        t1.start();

        //More Enhanced way
        Thread t2 = new Thread(() -> System.out.println("Lambda Expression"));
        t2.start();

        Thread t3 = new Thread(() -> {
           for (int i = 0; i <10; i++){
            System.out.println(i);
           }
        });
        t3.start();
    }
}
