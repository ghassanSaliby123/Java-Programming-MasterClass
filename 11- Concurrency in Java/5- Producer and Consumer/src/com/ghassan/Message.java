package com.ghassan;

import java.io.RandomAccessFile;
import java.util.Random;

public class Message {
    private String message;
    private boolean empty;

    //used by the consumer
    public synchronized String read (){
        while (empty){
            try {
                wait();
            }catch (InterruptedException e){

            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    //used by the producer
    public synchronized void write(String message){
        while (!empty){
            try {
                wait();
            }catch (InterruptedException e){

            }
        }
        empty = false;
        notifyAll();
        this.message= message;
    }
}
class Writer implements Runnable{
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    public void run(){
        String mesages[] = {"message 1", "message 2","message 3","message 4"};

        Random random = new Random();
        for (int i = 0; i < mesages.length; i++) {
            message.write(mesages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){

            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }
    public void run(){
        Random random = new Random();
        for (String latestMessage = message.read(); !latestMessage.equals("Finished");
        latestMessage = message.read()){
            try {
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){

            }
        }
    }
}
