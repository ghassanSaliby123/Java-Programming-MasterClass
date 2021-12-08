package com.ghassan;

public class Main {

    //One of the thread issues is the thread starvation
    //When we have several threads waiting to execute code some of them might wait long time without
    // executing anything because the system docent necessarily assign the code to the threads
    // which was waiting
    //This example we provide a worker class and a lock object

    private static Object lock = new Object();
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
                synchronized (lock){
                    System.out.format(color+ "%s: runCount = %d\n",
                            Thread.currentThread().getName(),runCount++);
                }
            }
        }
    }
}
