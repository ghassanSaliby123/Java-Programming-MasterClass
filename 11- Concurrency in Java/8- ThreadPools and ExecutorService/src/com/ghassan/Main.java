package com.ghassan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import static com.ghassan.Main.EOF;

public class Main {

    //This example discusses the Java.util.concurrent package
    //Producer and Consumers using Reentrant lock and unlock instead of Synchronized
    //We create a Reentrant object then we call the lock method to lock the code
    //then we have to unlock it with unlock method
    //In this example we use also the Executor Service interface
    //It manages the thread creation and their terminate through managing the thread pool
    //There are several types of thread pool we cover the fixed one here
    //through the pool, threads will be created and manage their turn to obtain the resources
    //instead of starting the thread we use the ExecutorService to execute the runnable object
    //through the execute method
    //then we should shut it down by the shutdown method



    public static final String EOF = "EOF";
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        //Reentrant lock
        ReentrantLock bufferLock = new ReentrantLock();
        //Executor Service interface with fixed thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        MyProducer producer = new MyProducer(buffer, ThreadColoring.BLUE_BOLD, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColoring.RED_BOLD,"Consumer 1",bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColoring.PURPLE_BOLD,"Consumer 2",bufferLock);

        //Executor Service execute
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);
        //Executor Service shutdown
        executorService.shutdown();

    }
}
class MyProducer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color,ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1","2","3","4","5"};
        for (String num : nums) {
            try {
                System.out.println(color + "Adding ..."+ num);
                bufferLock.lock();
                try {
                    buffer.add(num);
                }finally {
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println("Producer was interrupted...");
            }
        }
        System.out.println(color + " Adding EOF and exiting");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        }
        finally {
            bufferLock.unlock();
        }
    }
}


class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private String consumerName;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color,String consumerName,ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.consumerName = consumerName;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while (true){
            bufferLock.lock();
            try {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting by "+ consumerName );
                    break;
                } else {
                    System.out.println(color + buffer.remove(0)+ " Removed by "+ consumerName );
                }
            }
            finally {
                bufferLock.unlock();
            }
        }
    }
}