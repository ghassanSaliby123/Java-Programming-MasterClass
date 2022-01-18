package com.ghassan;

import static com.ghassan.ThreadColoring.*;

public class Main {

    //Basically each Java application is called a process which allocated a space in
    // the memory which is not shared with other processes.
    //Each process has at least one Thread (main) and can have several Threads
    //all the Threads within the process share a memory space called Heap
    //each Thread has its own memory space which is called the Stack
    //There are 2 ways to tell the thread what a piece of code we want to run:
    //1- Creating a Thread subclass from the Thread class and override the run method.
    //2- the other way is to implement the runnable interface and implement its run method
    //Then we execute the code in the Thread through Thread.start() method
    //If we have several threads working we can't guarantee the order of the execution
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
        System.out.println(YELLOW_BOLD+"Hello again from the Main Thread..4");



    }
}