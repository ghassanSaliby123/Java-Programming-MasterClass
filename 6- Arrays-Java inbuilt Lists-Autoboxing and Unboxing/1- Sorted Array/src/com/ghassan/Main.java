package com.ghassan;

public class Main {
    //This example is described in the Description text file
    //This an example of sorting an Integer array with a descending order
    public static void main(String[] args) {
      int[] intArray = {1,2,4,6,2,6,10,32,45,2,6,7,8,934,3,34,1,23,4};
      int[] intSorted = sortedArray(intArray);
        for (int i = 0; i < intSorted.length; i++) {
            System.out.println(intSorted[i]);
        }
    }
    public static int[] sortedArray(int[] array){
        boolean flag = true;
        int temp = 0;
        while(flag){
            flag = false;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] < array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    flag =true;
                }
            }
        }
        return array;
    }
}
