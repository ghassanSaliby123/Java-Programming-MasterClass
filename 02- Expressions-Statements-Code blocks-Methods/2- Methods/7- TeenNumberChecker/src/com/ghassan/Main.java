package com.ghassan;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static boolean hasTeen(int n1, int n2, int n3){
        if((n1 <= 19 && n1 >=13) || (n2 <= 19 && n2 >=13) || (n3 <= 19 && n3 >=13)){
            return true;
        }else return false;
    }
    public static boolean isTeen(int n1){
        if(hasTeen(n1,n1,n1)){
            return true;
        }else return false;
    }
}
