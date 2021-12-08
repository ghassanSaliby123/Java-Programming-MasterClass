package com.ghassan;

public class Main {

    //Live locks is similar to deadlock but Instead of threads been blocked they are constantly active
    //and waiting for other threads to complete their tasks
    //EX thread 1 loops till thread 2 finish its task, and thread 2 loops till thread 1 finish its task
    //In this example we create 2 worker threads sharing a resource one thread gives the other the resource
    // till it finishes and vis versa
    public static void main(String[] args) {
	    final Worker worker1 = new Worker("Worker1",true);
        final Worker worker2 = new Worker("Worker2",true);

        final SharedResource sharedResource = new SharedResource(worker1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.work(sharedResource,worker2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.work(sharedResource,worker1);
            }
        }).start();
    }
}
