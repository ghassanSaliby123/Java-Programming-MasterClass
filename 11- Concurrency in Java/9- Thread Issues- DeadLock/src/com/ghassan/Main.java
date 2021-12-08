package com.ghassan;

import static com.ghassan.Main.lock1;
import static com.ghassan.Main.lock2;

public class Main {

    //So far we covered the thread interference
    //Here we discuss other threads issues such DeadLocks
    //Deadlock happens when two or more threads blocked on locks
    //Every thread wants a lock that is obtained by another thread so everyone goes to block state
    //EX: Thread 1 has lock 1 and want lock 2 ,,,, Thread 2 has lock 2 and want lock 1
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    //To solve deadlock we can modify the commented code bellow into the following:
    //Make the Threads try to have the locks in the same order...Thread 1 and  2 want lock 1 then lock 2
    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1 : Has lock 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 1: Waiting for lock 2");
                synchronized (lock2) {
                    System.out.println("Thread 1 : Has lock 1 and lock 2");
                }
                System.out.println("Thread 1: Released lock 2");
            }
            System.out.println("Thread 1 : Released lock 1...Exiting");
        }
    }

    private static class Thread2 extends Thread{
        public void run(){
            synchronized (lock1){
                System.out.println("Thread 2 : Has lock 1");
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){

                }
                System.out.println("Thread 2: Waiting for lock 2");
                synchronized (lock2){
                    System.out.println("Thread 2 : Has lock 1 and lock 2");
                }
                System.out.println("Thread 2 : Released lock 2.");
            }
            System.out.println("Thread 2 : Released lock 1. Exiting...");
        }
    }

    //Here is the deadlock situation
//    private static class Thread1 extends Thread {
//        @Override
//        public void run() {
//            synchronized (lock1) {
//                System.out.println("Thread 1 : Has lock 1");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//
//                }
//                System.out.println("Thread 1: Waiting for lock 2");
//                synchronized (lock2) {
//                    System.out.println("Thread 1 : Has lock 1 and lock 2");
//                }
//                System.out.println("Thread 1: Released lock 2");
//            }
//            System.out.println("Thread 1 : Released lock 1...Exiting");
//        }
//    }
//
//    private static class Thread2 extends Thread{
//        public void run(){
//            synchronized (lock2){
//                System.out.println("Thread 2 : Has lock 2");
//                try {
//                    Thread.sleep(2000);
//                }catch (InterruptedException e){
//
//                }
//                System.out.println("Thread 2: Waiting for lock 1");
//                synchronized (lock1){
//                    System.out.println("Thread 2 : released lock 1");
//                }
//                System.out.println("Thread 2 : Released lock 2. Exiting...");
//            }
//        }
//    }
}