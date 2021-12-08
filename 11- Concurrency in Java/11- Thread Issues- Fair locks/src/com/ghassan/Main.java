package com.ghassan;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    //Another alternative of using Synchronization is to use fair lock
    //We use the Reentrant locks to achieve that, the fair lock delivery should be fair as much as possible


    //apply fair lock
    private static ReentrantLock lock = new ReentrantLock(true);
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Worker(ThreadColoring.RED_BOLD),"Priority 10");
        Thread thread2 = new Thread(new Worker(ThreadColoring.BLUE_BOLD),"Priority 8");
        Thread thread3 = new Thread(new Worker(ThreadColoring.GREEN_BOLD),"Priority 6");
        Thread thread4 = new Thread(new Worker(ThreadColoring.WHITE_BOLD),"Priority 4");
        Thread thread5 = new Thread(new Worker(ThreadColoring.YELLOW_BOLD),"Priority 2");
        //Here we try to influence the priority,but we don't guarantee that
        thread1.setPriority(10);
        thread2.setPriority(8);
        thread3.setPriority(6);
        thread4.setPriority(4);
        thread5.setPriority(2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }

    private static class Worker implements Runnable{
        private int runCount =1;
        private String color;

        public Worker( String color) {

            this.color = color;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
               lock.lock();
                try {
                    System.out.format(color + "%s: runCount = %d\n",
                            Thread.currentThread().getName(), runCount++);
                }finally {
                    lock.unlock();
                }

            }
        }
    }
}
