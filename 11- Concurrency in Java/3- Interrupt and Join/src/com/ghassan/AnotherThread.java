package com.ghassan;

import static com.ghassan.ThreadColoring.RED_BOLD;

//The first way to create a thread
public class AnotherThread extends Thread{

    @Override
    public void run() {
        System.out.println(RED_BOLD+"Hello from Another Thread..2");
        try {
            System.out.println(RED_BOLD+ "I am going to sleep for three seconds or when another thread wakes me up");
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println(RED_BOLD + "Another thread woke me up");
            return;
        }
        System.out.println(RED_BOLD + "Hello from AnotherThread....Three seconds have passed and I am awake again");
    }
}
