package com.ghassan;
import com.ghassan.ThreadColoring;

import static com.ghassan.ThreadColoring.RED_BOLD;

//The first way to create a thread
public class AnotherThread extends Thread{

    @Override
    public void run() {
        System.out.println(RED_BOLD+"Hello from Another Thread..2");
    }
}
