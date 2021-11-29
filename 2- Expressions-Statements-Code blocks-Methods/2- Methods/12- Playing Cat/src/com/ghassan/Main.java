package com.ghassan;

public class Main {

    //This example is described in the Description text file
    public static void main(String[] args) {
	// write your code here
    }


    public static boolean isCatPlaying(boolean summer,int temperature){
        if(summer){
            if(temperature >= 25 && temperature <= 45){
                return true;
            }else return false;
        }else if(temperature >= 25 && temperature <= 35){
            return true;
        }else return false;

    }
}
