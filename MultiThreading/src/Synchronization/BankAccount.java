package Synchronization;

public class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + "Attempting to withdraw " + amount);
        if(balance >= amount){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + "Completed withdrawal. Remaining balance. " + balance);

        }else{
            System.out.println(Thread.currentThread().getName() + "Insufficient balance" );
        }
    }

}
