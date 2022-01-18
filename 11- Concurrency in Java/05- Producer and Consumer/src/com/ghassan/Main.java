package com.ghassan;

public class Main {

    //This example illustrates the Syn between a massage producer and a message consumer
    //DeadLock is a situation when a thread holding the lock and
    // dont release it and another thread is waiting for that lock
    //We can overcome that by using wait, notify and notifyAll method
    public static void main(String[] args) {
	Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}
