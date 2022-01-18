package com.ghassan;
import static com.ghassan.ThreadColoring.BLUE_BOLD;
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(BLUE_BOLD+ "Hello from MyRunnable..5");
    }
}
