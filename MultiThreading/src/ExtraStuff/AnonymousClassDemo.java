package ExtraStuff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface Greeting{
    void sayHello();
}

class Animal{
    void sound(){
        System.out.println("Animal makes sound");
    }
}

public class AnonymousClassDemo {
    public static void main(String[] args) {
        // Anonymous Class Implementing an Interface
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello from Anonymous class");
            }
        };
         greeting.sayHello();

        // Anonymous Class Extending a Class
        Animal dog = new Animal() {
          void sound(){
              System.out.println("Dog barks");
          }
        };
        dog.sound();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread running using anonymous class");
            }
        });
        thread.start();

        JFrame frame = new JFrame("Anonymous class example");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button Clicked! Helo From anonymous class.");
            }
        });

        frame.add(button);
        frame.setVisible(true);
    }
}

