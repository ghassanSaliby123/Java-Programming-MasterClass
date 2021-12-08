package com.ghassan;

import com.sun.jdi.PrimitiveValue;

public class Main {

    //This example illustrates using multiple threads and how they rapidly alternate
    //The idea is each thread will count down and print on the console
    //We also cover the Threads variables, if we use a global variable to be used by several threads
    //this variable will be stored in the heap to be shared between the threads that is called thread interference
    //We use Synchronization to prevent that, it  simply means that a certain block of code is allowed to be
    //executed by only one thread
    //Synchronization is used only with objects, because only object can be locked and unlocked
    //it is meant to be used with shared object not local ones where the object is stored in the heap
    //otherwise the object will be stored in the thread stack and then no need to prevent thread interference
    //because stack is onl accessible by one its thread
    public static void main(String[] args) {
        CountDown countDown = new CountDown();
        CountDownThread thread1 = new CountDownThread(countDown);
        thread1.setName("Thread 1");
        CountDownThread thread2 = new CountDownThread(countDown);
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();

    }
}
    class CountDown{
    private int i;
        public void doCountDown(){
            String color;
            switch (Thread.currentThread().getName()){
                case "Thread 1":
                    color = ThreadColoring.RED_BOLD;
                    break;
                case "Thread 2":
                    color = ThreadColoring.BLUE_BOLD;
                    break;
                default:
                    color = ThreadColoring.GREEN_BOLD;
            }
            //we use this because it is a shared object
            synchronized (this){
                for ( i = 10; i > 0  ; i--) {
                    System.out.println(color+ Thread.currentThread().getName()+ ": i = "+ i);
                }
            }
        }
    }
    class CountDownThread extends Thread{
    private CountDown threadCountDown;

    public CountDownThread(CountDown countDown){
        threadCountDown = countDown;
    }
    public void run(){
        threadCountDown.doCountDown();
    }
    }

