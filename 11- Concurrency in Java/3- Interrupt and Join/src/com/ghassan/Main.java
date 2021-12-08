package com.ghassan;

import static com.ghassan.ThreadColoring.*;

public class Main {

   //Interrupt : is the situation that one thread is Blocked for some reason such as
   // waiting or sleeping, the interrupt method will throw an Interrupt Exception that ends the Block status
    // for this thread
    //Join: When one thread is waiting for another thread to terminate to start. the join method will make
    //the first thread waits to the second thread to terminate then it will continue working
    public static void main(String[] args) {

        System.out.println(YELLOW_BOLD+"Hello from the Main Thread..1");
        AnotherThread anotherThread = new AnotherThread();
        anotherThread.start();
        //Create a thread with anonymous class
        new Thread(){
            public void run(){
                System.out.println(GREEN_BOLD+"Hello from the Anonymous class thread..3");
            }
        }.start();
        //Within this thread there is a join to the AnotherThread
        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run(){
                System.out.println(BLUE_BOLD+"Hello from the anonymous class " +
                        "implementation for MyRunnable");
                try {
                    anotherThread.join();
                    System.out.println(BLUE_BOLD+ "AnotherThread is terminated and I ma running again");
                }catch (InterruptedException e){
                    System.out.println(BLUE_BOLD+"I am interrupted through JOIN  " +
                            "by MyRunnable");
                }
            }
        });
        myRunnableThread.start();
        //Here we make an interrupt for anotherThread
        anotherThread.interrupt();
        System.out.println(YELLOW_BOLD+"Hello again from the Main Thread..4");



    }
}