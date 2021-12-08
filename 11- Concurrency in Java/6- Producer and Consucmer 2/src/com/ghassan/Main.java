package com.ghassan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.ghassan.Main.EOF;

public class Main {

    //This example discusses the Java.util.concurrent package
    //Producer and Consumers using Synchronization
    //With using Synchronization there are several disadvantages such as the Sync lock
    // the block of code for one thread and all the other threads must wait for this lock
    //incase something wrong happened during the execution the first thread might not release the lock
    //then all the rest will be waiting
    //Other disadvantage is the Syn keyword works in one method and can't be extended to another method
    //There is not priority for threads serving


    public static final String EOF = "EOF";
    public static void main(String[] args) {

        List<String> buffer = new ArrayList<>();
        MyProducer producer = new MyProducer(buffer, ThreadColoring.BLUE_BOLD);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColoring.RED_BOLD,"Consumer 1 ");
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColoring.PURPLE_BOLD,"Consumer 2");
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

    }
}
class MyProducer implements Runnable{
    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1","2","3","4","5"};
        for (String num : nums) {
          try {
              System.out.println(color + "Adding ..."+ num);
              synchronized (buffer){
                  buffer.add(num);
              }
              Thread.sleep(random.nextInt(2000));
          }catch (InterruptedException e){
              System.out.println("Producer was interrupted...");
          }
        }
        System.out.println(color + " Adding EOF and exiting");
        synchronized (buffer){
            buffer.add("EOF");
        }
    }
}


class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private String consumerName;

    public MyConsumer(List<String> buffer, String color,String consumerName) {
        this.buffer = buffer;
        this.color = color;
        this.consumerName = consumerName;
    }

    @Override
    public void run() {
        while (true){
            synchronized (buffer) {
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
        }
    }
}