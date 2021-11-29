package com.ghassan;

public class Main {
    //The Barking Dog example is described in the description text file
    public static void main(String[] args) {
	// write your code here
    }
    //This method determine of we should wake up when the dog is barking depending on the hour
    public static boolean shouldWakeUp(boolean barking, int hourOfDay){
        if(barking){
            if(hourOfDay < 0 || hourOfDay > 23){
                return false;
            }else if(hourOfDay < 8 || hourOfDay > 22){
                return true;
            }}
        return false;
    }
}
